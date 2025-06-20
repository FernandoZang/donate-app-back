package com.sanem.donation.domain.entity

import com.sanem.donation.domain.dto.UsuarioDTO
import com.sanem.donation.domain.enum.StatusEnum
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToMany
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

@Entity
@Table(name = "USUARIO")
class UsuarioEntity(
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var nome: String,
    @Column(unique = true)
    var login: String,
    var senha: String = "",
    var CPF: String,
    var email: String,
    var fone: String,
    var UF: String,
    var bairro: String,
    var logradouro: String,
    var logradouro_tipo: String,
    var numero: String,
    var complemento: String,
    @Enumerated(EnumType.STRING)
    var status: StatusEnum,
    var active: String,
    @JoinColumn(name = "cod_cidade")
    @ManyToOne()
    var cidade: CidadeEntity,
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "USUARIO_REGRA_ACESSO",
        joinColumns = [JoinColumn(name = "USUARIO_ID")],
        inverseJoinColumns = [JoinColumn(name = "REGRA_ID")]
    )
    val regrasAcesso: Set<RegraAcesso> = setOf()

) : UserDetails {

    override fun getAuthorities(): Collection<GrantedAuthority> =
        regrasAcesso.map { SimpleGrantedAuthority("ROLE_${it.nome}") }

    override fun getPassword(): String? {
        return senha
    }

    override fun getUsername(): String? {
        return login
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }
}

fun UsuarioEntity.toDTO(): UsuarioDTO {
    var usuario = UsuarioDTO(
        nome = nome,
        login = login,
        CPF = CPF,
        email = email,
        fone = fone,
        UF = UF,
        bairro = bairro,
        logradouro = logradouro,
        logradouro_tipo = logradouro_tipo,
        numero = numero,
        complemento = complemento,
        status = status,
        active = active,
        cidade = cidade,
        regrasAcesso = regrasAcesso
    )
    return usuario
}
