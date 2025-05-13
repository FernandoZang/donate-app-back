package com.sanem.donation.domain.repository

import com.sanem.donation.domain.entity.CidadeEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CidadeRepository : JpaRepository<CidadeEntity, Long>
