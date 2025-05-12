package com.sanem.donation.domain.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "CIDADE")
class CidadeEntity(
    @Id
    @Column(name = "ID", nullable = false)
    var id: Long,
    @Column(name = "NOME", nullable = false)
    var nome: String
)