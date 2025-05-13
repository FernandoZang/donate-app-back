package com.sanem.donation.domain.repository

import com.sanem.donation.domain.entity.UsuarioEntity
import org.springframework.data.jpa.repository.JpaRepository

interface UsuarioRepository : JpaRepository<UsuarioEntity, Long>
