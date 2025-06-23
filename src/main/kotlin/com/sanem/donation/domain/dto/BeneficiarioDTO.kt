package com.sanem.donation.domain.dto

import com.fasterxml.jackson.annotation.JsonProperty
import com.sanem.donation.domain.entity.BeneficiarioEntity
import com.sanem.donation.domain.enum.StatusEnum
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated

data class BeneficiarioDTO(
    @field:JsonProperty
    var nome: String,
    @field:JsonProperty
    var CPF: String? = null,
    @field:JsonProperty
    var email: String? = null,
    @field:JsonProperty
    var fone: String? = null,
    @field:JsonProperty
    var tipo: String,
    @field:JsonProperty
    var UF: String,
    @field:JsonProperty
    var bairro: String? = null,
    @field:JsonProperty
    var logradouro: String? = null,
    @field:JsonProperty
    var logradouro_tipo: String? = null,
    @field:JsonProperty
    var numero: String? = null,
    @field:JsonProperty
    var complemento: String? = null,
    @field:JsonProperty
    @Enumerated(EnumType.STRING)
    var status: StatusEnum,
    @field:JsonProperty
    var active: Boolean,
    @field:JsonProperty
    var cidade: CidadeDTO,
    @field:JsonProperty
    var observacao: String? = null
)

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
