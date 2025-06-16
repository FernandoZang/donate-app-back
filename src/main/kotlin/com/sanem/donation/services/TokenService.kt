package com.sanem.donation.services

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.auth0.jwt.exceptions.JWTCreationException
import com.auth0.jwt.exceptions.JWTVerificationException
import com.sanem.donation.domain.entity.UsuarioEntity
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneOffset

@Service
class TokenService {

    @Value("\${api.security.token.secret}")
    private lateinit var secret: String

    fun generateToken(usuario: UsuarioEntity): String {
        try {
            val algorithm: Algorithm = Algorithm.HMAC256(secret)
            return JWT.create()
                .withIssuer("donation-app")
                .withSubject(usuario.login)
                .withExpiresAt(getExpirationDate())
                .sign(algorithm)
        } catch (ex: JWTCreationException) {
            throw RuntimeException("Erro ao criar o token", ex)
        }
    }

    fun validatetoken(token: String): String {
        try {
            val algorithm: Algorithm = Algorithm.HMAC256(secret)
            return JWT.require(algorithm)
                .withIssuer("donation-app")
                .build()
                .verify(token)
                .subject
        } catch (ex: JWTVerificationException) {
            throw RuntimeException("", ex)
        }
    }

    fun getExpirationDate(): Instant? {
        return LocalDateTime.now().plusHours(24).toInstant(ZoneOffset.of("-03:00"))
    }
}
