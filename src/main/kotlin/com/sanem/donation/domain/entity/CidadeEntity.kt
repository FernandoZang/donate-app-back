package com.sanem.donation.domain.entity

import com.sanem.donation.domain.dto.CidadeDTO
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "CIDADE")
class CidadeEntity(
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    @Column(name = "NOME", nullable = false)
    var nome: String? = null
)

fun CidadeEntity.toDTO(): CidadeDTO {
    var cidade = CidadeDTO(
        id = id.toString(),
        nome = nome,
    )
    return cidade
}
