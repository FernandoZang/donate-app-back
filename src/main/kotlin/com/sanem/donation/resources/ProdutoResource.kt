package com.sanem.donation.resources

import com.sanem.donation.domain.entity.CidadeEntity
import com.sanem.donation.domain.entity.ProdutoEntity
import com.sanem.donation.domain.repository.CidadeRepository
import com.sanem.donation.domain.repository.ProdutoRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/produtos")
class ProdutoResource(
    val produtoRepository: ProdutoRepository
) {

    @GetMapping()
    fun findAll(): ResponseEntity<List<ProdutoEntity?>?> {
        return ResponseEntity.ok(produtoRepository.findAll())
    }

    @PostMapping()
    fun insert(
        produtoEntity: ProdutoEntity
    ): ResponseEntity<ProdutoEntity?> {
        return ResponseEntity.ok(produtoRepository.save(produtoEntity))
    }
}
