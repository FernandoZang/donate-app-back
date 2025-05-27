package com.sanem.donation.domain.enum

enum class ProdutoType(val id: Int) {
    CALCADO(1),
    ROUPA(2),
    MESA(3),
    BANHO(4),
    CAMA(id = 5)
}
