package com.sanem.donation.resources

import com.sanem.donation.domain.entity.UsuarioEntity
import com.sanem.donation.domain.repository.UsuarioRepository
import com.sanem.donation.services.UsuarioService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/usuarios")
class UsuarioResource(
    var usuarioService: UsuarioService,
    var usuarioRepository: UsuarioRepository
) {

    @GetMapping()
    fun findAll(): ResponseEntity<List<UsuarioEntity?>?> {
        return ResponseEntity.ok(usuarioRepository.findAll())
    }

    @PostMapping()
    fun insert(
        @RequestBody usuarioEntity: UsuarioEntity
    ): ResponseEntity<UsuarioEntity?> {
        return ResponseEntity.ok(usuarioService.save(usuarioEntity))
    }
}
