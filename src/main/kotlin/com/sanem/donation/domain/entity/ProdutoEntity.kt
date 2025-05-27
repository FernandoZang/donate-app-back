package com.sanem.donation.domain.entity

import com.sanem.donation.domain.enum.ProdutoType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "PRODUTO")
class ProdutoEntity(
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,
    var descricao: String,
    var quantidade: String,
    @Enumerated(EnumType.STRING)
    var tipo: ProdutoType,
    var tamanho: String

)