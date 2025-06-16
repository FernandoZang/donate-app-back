package com.sanem.donation.config

import com.sanem.donation.domain.repository.UsuarioRepository
import com.sanem.donation.services.TokenService
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

@Component
class SecurityFilter() : OncePerRequestFilter() {

    @Autowired
    lateinit var tokenService: TokenService

    @Autowired
    lateinit var repository: UsuarioRepository

    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, filterChain: FilterChain) {
        val token = this.recoverToken(request)
        if (token != null) {
            val login = tokenService.validatetoken(token)
            val usuario = repository.findByLogin(login)

            val authentication = UsernamePasswordAuthenticationToken(usuario, null, usuario.authorities)
            SecurityContextHolder.getContext().authentication = authentication
        }
        filterChain.doFilter(request, response)
    }
}

fun SecurityFilter.recoverToken(request: HttpServletRequest): String? {
    val authHeader = request.getHeader("Authorization")
    if (authHeader == null) return null
    return authHeader.replace("Bearer ", "")
}
