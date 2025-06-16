package com.sanem.donation.services

import com.sanem.donation.domain.repository.UsuarioRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service

class AuthorizationService : UserDetailsService {

    @Autowired
    lateinit var repository: UsuarioRepository

    override fun loadUserByUsername(username: String?): UserDetails? {
        return repository.findByLogin(username!!)
    }
}
