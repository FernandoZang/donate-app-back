package com.sanem.donation.domain.repository

import com.sanem.donation.domain.entity.BeneficiarioEntity
import org.springframework.data.jpa.repository.JpaRepository

interface BeneficiarioRepository : JpaRepository<BeneficiarioEntity, Long> {
    fun findByCPF(cpf: String): BeneficiarioEntity?

    fun findByNome(nome: String): BeneficiarioEntity?
}
