package com.sanem.donation.resources

import com.sanem.donation.domain.dto.AuthDTO
import com.sanem.donation.domain.dto.LoginResponseDTO
import com.sanem.donation.domain.entity.UsuarioEntity
import com.sanem.donation.services.TokenService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthResource {

    @Autowired
    lateinit var tokenService: TokenService

    @Autowired
    lateinit var authenticationManager: AuthenticationManager

    @PostMapping("/login")
    fun login(@RequestBody authDto: AuthDTO): ResponseEntity<LoginResponseDTO> {
        val usernamePassword = UsernamePasswordAuthenticationToken(authDto.login, authDto.password)
        val auth = authenticationManager.authenticate(usernamePassword)

        val token = tokenService.generateToken(auth.principal as UsuarioEntity)

        return ResponseEntity.ok(LoginResponseDTO(token = token))
    }
}
