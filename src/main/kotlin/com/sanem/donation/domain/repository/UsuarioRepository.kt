package com.sanem.donation.domain.repository

import com.sanem.donation.domain.entity.UsuarioEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.security.core.userdetails.UserDetails

interface UsuarioRepository : JpaRepository<UsuarioEntity, Long> {
    fun findByCPF(cpf: String): UsuarioEntity?

    fun findByNome(nome: String): UsuarioEntity?

    fun findByLogin(login: String): UserDetails
}
