package com.sanem.donation.domain.dto

import com.fasterxml.jackson.annotation.JsonProperty
import com.sanem.donation.domain.entity.CidadeEntity
import com.sanem.donation.domain.entity.RegraAcesso
import com.sanem.donation.domain.entity.UsuarioEntity
import com.sanem.donation.domain.enum.StatusEnum
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated

data class UsuarioDTO(
    @field:JsonProperty
    var nome: String,
    @field:JsonProperty
    var login: String,
    @field:JsonProperty
    var senha: String? = null,
    @field:JsonProperty
    var CPF: String,
    @field:JsonProperty
    var email: String,
    @field:JsonProperty
    var fone: String,
    @field:JsonProperty
    var UF: String,
    @field:JsonProperty
    var bairro: String,
    @field:JsonProperty
    var logradouro: String,
    @field:JsonProperty
    var logradouro_tipo: String,
    @field:JsonProperty
    var numero: String,
    @field:JsonProperty
    var complemento: String,
    @field:JsonProperty
    @Enumerated(EnumType.STRING)
    var status: StatusEnum,
    @field:JsonProperty
    var active: String,
    @field:JsonProperty
    var cidade: CidadeEntity,
    @field:JsonProperty
    var regrasAcesso: Set<RegraAcesso> = setOf()
)

fun UsuarioDTO.toEntity(): UsuarioEntity {
    var usuario = UsuarioEntity(
        nome = nome,
        login = CPF,
        senha = senha!!,
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
