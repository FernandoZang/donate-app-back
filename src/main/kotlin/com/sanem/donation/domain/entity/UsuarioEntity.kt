package com.sanem.donation.domain.entity

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
@Table(name = "USUARIO")
class UsuarioEntity(
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,
    var nome: String,
    var CPF: String,
    var email: String,
    var fone: String,
    var UF: String,
    var bairro: String,
    var logradouro: String,
    var logradouro_tipo: String,
    var numero: Int,
    var complemento: String,
    @Enumerated(EnumType.STRING)
    var status: StatusEnum,
    @JoinColumn(name = "cod_cidade")
    @ManyToOne()
    var cidade: CidadeEntity
)