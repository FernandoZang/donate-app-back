package com.sanem.donation.domain.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "REGRA_ACESSO")
class RegraAcesso(
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var nome: String,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is RegraAcesso) return false

        if (nome != other.nome) return false

        return true
    }

    override fun hashCode(): Int {
        return nome.hashCode()
    }
}
