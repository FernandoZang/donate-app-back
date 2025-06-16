package com.sanem.donation.domain.repository

import com.sanem.donation.domain.entity.ProdutoEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProdutoRepository : JpaRepository<ProdutoEntity, Long>
