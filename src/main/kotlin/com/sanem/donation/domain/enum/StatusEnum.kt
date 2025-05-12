package com.sanem.donation.domain.enum

enum class StatusEnum(val id: Int) {
    ATIVO(1),
    CRIADO(2),
    AGUARDANDO_ANALISE(3),
    APROVADO(4),
    REPROVADO(5),
    DESATIVADO(6),
}
