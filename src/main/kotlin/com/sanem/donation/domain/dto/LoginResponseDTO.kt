package com.sanem.donation.domain.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class LoginResponseDTO(
    @field:JsonProperty
    val token: String,
)
