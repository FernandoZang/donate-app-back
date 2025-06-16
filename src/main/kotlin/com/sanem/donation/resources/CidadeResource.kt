package com.sanem.donation.resources

import com.sanem.donation.domain.entity.CidadeEntity
import com.sanem.donation.domain.repository.CidadeRepository
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/cidades")
class CidadeResource(
    val cidadeRepository: CidadeRepository
) {

    @PreAuthorize("hasRole('ATENDENTE')")
    @GetMapping()
    fun findAll(): ResponseEntity<List<CidadeEntity?>?> {
        return ResponseEntity.ok(cidadeRepository.findAll())
    }

    @PreAuthorize("hasRole('GERENTE')")
    @PostMapping()
    fun insert(
        @RequestBody cidadeEntity: CidadeEntity
    ): ResponseEntity<CidadeEntity?> {
        return ResponseEntity.ok(cidadeRepository.save(cidadeEntity))
    }
}
