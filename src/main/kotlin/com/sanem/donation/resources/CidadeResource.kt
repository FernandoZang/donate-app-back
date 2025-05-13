package com.sanem.donation.resources

import com.sanem.donation.domain.entity.CidadeEntity
import com.sanem.donation.domain.repository.CidadeRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/cidades")
class CidadeResource(
    val cidadeRepository: CidadeRepository
) {

    @GetMapping()
    fun findAll(): ResponseEntity<List<CidadeEntity?>?> {
        return ResponseEntity.ok(cidadeRepository.findAll())
    }

    @PostMapping()
    fun insert(
        cidadeEntity: CidadeEntity
    ): ResponseEntity<CidadeEntity?> {
        return ResponseEntity.ok(cidadeRepository.save(cidadeEntity))
    }
}
