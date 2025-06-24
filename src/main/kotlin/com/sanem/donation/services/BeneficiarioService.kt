package com.sanem.donation.services

import com.sanem.donation.domain.entity.BeneficiarioEntity
import com.sanem.donation.domain.enum.StatusEnum
import com.sanem.donation.domain.repository.BeneficiarioRepository
import org.springframework.stereotype.Service

@Service
class BeneficiarioService(
    val beneficiarioRepository: BeneficiarioRepository
) {
    fun insert(beneficiarioEntity: BeneficiarioEntity): BeneficiarioEntity? {
        beneficiarioEntity.status = StatusEnum.AGUARDANDO_ANALISE
        beneficiarioEntity.active = true
        return beneficiarioRepository.saveAndFlush(beneficiarioEntity)
    }
}
