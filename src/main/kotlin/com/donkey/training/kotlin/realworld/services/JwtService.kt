package com.donkey.training.kotlin.realworld.services

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Service
import java.util.*

@Service
class JwtService {

    @Value("\${jwt.secret}")
    lateinit var secret: String

    @Value("\${jwt.sessionTime}")
    var sessionTime: Long = 0

    fun toToken(user: UserDetails) = Jwts.builder()
            .setSubject(user.username)
            .setExpiration(expire())
            .signWith(SignatureAlgorithm.HS512, secret)
            .compact()

    fun getSubFromToken(token: String) = Jwts.parser()
            .setSigningKey(secret)
            .parseClaimsJws(token)
            .body.subject

    private fun expire() = Date(System.currentTimeMillis() + sessionTime * 1000)
}