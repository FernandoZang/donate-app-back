package com.sanem.donation.resources

import com.sanem.donation.domain.dto.BeneficiarioDTO
import com.sanem.donation.domain.dto.toEntity
import com.sanem.donation.domain.entity.toDTO
import com.sanem.donation.domain.repository.BeneficiarioRepository
import com.sanem.donation.exceptions.ForbiddenException
import com.sanem.donation.services.BeneficiarioService
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/beneficiarios")
class BeneficiarioResource(
    var beneficiarioRepository: BeneficiarioRepository,
    var beneficiarioService: BeneficiarioService
) {

    @PreAuthorize("hasRole('ATENDENTE')")
    @GetMapping()
    fun findAll(): ResponseEntity<Any> {
        return ResponseEntity.ok(beneficiarioRepository.findAll().stream().map { it -> it.toDTO() })
    }

    @PreAuthorize("hasRole('ATENDENTE')")
    @PostMapping()
    fun insert(
        @RequestBody beneficiarioDTO: BeneficiarioDTO
    ): ResponseEntity<Any?> {
        return try {
            ResponseEntity.ok(beneficiarioService.insert(beneficiarioDTO.toEntity())!!.toDTO())
        } catch (ex: ForbiddenException) {
            ResponseEntity.status(403).build()
        }
    }
}
