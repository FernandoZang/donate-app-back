package com.sanem.donation.domain.dto

import com.fasterxml.jackson.annotation.JsonProperty
import com.sanem.donation.domain.entity.CidadeEntity

data class CidadeDTO(
    @field:JsonProperty
    var id: String? = null,
    @field:JsonProperty
    var nome: String? = null
)

fun CidadeDTO.toEntity(): CidadeEntity {
    var cidadeEntity = CidadeEntity(
        nome = nome,
        id = id!!.toLong()
    )
    return cidadeEntity
}
