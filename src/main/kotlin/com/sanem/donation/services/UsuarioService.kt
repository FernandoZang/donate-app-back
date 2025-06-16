package com.sanem.donation.services

import com.sanem.donation.domain.entity.UsuarioEntity
import com.sanem.donation.domain.repository.UsuarioRepository
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class UsuarioService(
    val usuarioRepository: UsuarioRepository
) {
    fun save(usuarioEntity: UsuarioEntity): UsuarioEntity {
        usuarioEntity.senha = BCryptPasswordEncoder().encode(usuarioEntity.senha)
        return usuarioRepository.saveAndFlush(usuarioEntity)
    }
}
