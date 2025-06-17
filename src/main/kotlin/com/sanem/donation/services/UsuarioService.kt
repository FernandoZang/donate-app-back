package com.sanem.donation.services

import com.sanem.donation.domain.entity.RegraAcesso
import com.sanem.donation.domain.entity.UsuarioEntity
import com.sanem.donation.domain.repository.UsuarioRepository
import com.sanem.donation.exceptions.ForbiddenException
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.web.client.HttpClientErrorException

@Service
class UsuarioService(
    val usuarioRepository: UsuarioRepository
) {
    @Throws(ForbiddenException::class)
    fun save(usuarioEntity: UsuarioEntity): UsuarioEntity? {
        usuarioEntity.senha = BCryptPasswordEncoder().encode(usuarioEntity.senha)
        val rules = usuarioEntity.regrasAcesso
        if (
            rules.contains(RegraAcesso(nome = "MASTER")) ||
            rules.contains(RegraAcesso(nome = "SYS")) ||
            rules.contains(RegraAcesso(nome = "ADMIN")))
        {
            throw ForbiddenException(
                message = "Sem premissão para cadastrar esse tipo de usuário"
            )
        }
        else {
            return usuarioRepository.saveAndFlush(usuarioEntity)
        }
    }
}
