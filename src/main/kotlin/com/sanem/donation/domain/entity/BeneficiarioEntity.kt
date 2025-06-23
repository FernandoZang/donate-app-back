package com.sanem.donation.domain.entity

import com.sanem.donation.domain.dto.BeneficiarioDTO
import com.sanem.donation.domain.dto.toEntity
import com.sanem.donation.domain.enum.StatusEnum
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "BENEFICIARIO")
class BeneficiarioEntity(
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var nome: String,
    @Column(unique = true)
    var CPF: String? = null,
    var email: String? = null,
    var fone: String? = null,
    var tipo: String,
    var UF: String,
    var bairro: String? = null,
    var logradouro: String? = null,
    var logradouro_tipo: String? = null,
    var numero: String? = null,
    var complemento: String? = null,
    @Enumerated(EnumType.STRING)
    var status: StatusEnum,
    var active: Boolean,
    @JoinColumn(name = "cod_cidade")
    @ManyToOne()
    var cidade: CidadeEntity,
    var observacao: String? = null
)

fun BeneficiarioEntity.toDTO(): BeneficiarioDTO {
    var beneficiario = BeneficiarioDTO(
        nome = nome,
        CPF = CPF,
        email = email,
        fone = fone,
        tipo = tipo,
        UF = UF,
        bairro = bairro,
        logradouro = logradouro,
        logradouro_tipo = logradouro_tipo,
        numero = numero,
        complemento = complemento,
        status = status,
        active = active,
        cidade = cidade.toDTO(),
    )
    return beneficiario
}

fun BeneficiarioDTO.toEntity(): BeneficiarioEntity {
    var beneficiarioEntity = BeneficiarioEntity(
        nome = nome,
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
        cidade = cidade.toEntity(),
        tipo = tipo,
        observacao = observacao
    )
    return beneficiarioEntity
}
