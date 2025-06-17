package com.sanem.donation.resources

import com.sanem.donation.domain.dto.UsuarioDTO
import com.sanem.donation.domain.dto.toEntity
import com.sanem.donation.domain.entity.toDTO
import com.sanem.donation.domain.repository.UsuarioRepository
import com.sanem.donation.exceptions.ForbiddenException
import com.sanem.donation.services.UsuarioService
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
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

    @PreAuthorize("hasRole('ATENDENTE')")
    @GetMapping()
    fun findAll(): Any {
        return ResponseEntity.ok(usuarioRepository.findAll().stream().map { it -> it.toDTO() })
    }

    @PreAuthorize("hasRole('GERENTE')")
    @PostMapping()
    fun insert(
        @RequestBody usuarioDTO: UsuarioDTO
    ): ResponseEntity<Any?> {
        return try {
            ResponseEntity.ok(usuarioService.save(usuarioDTO.toEntity())!!.toDTO())
        } catch (ex: ForbiddenException) {
            ResponseEntity.status(403).build()
        }
    }
}
