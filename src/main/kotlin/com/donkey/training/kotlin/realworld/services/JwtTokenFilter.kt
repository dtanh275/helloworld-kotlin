package com.donkey.training.kotlin.realworld.services

import com.donkey.training.kotlin.realworld.repositories.UserRepository
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.stereotype.Service
import org.springframework.util.StringUtils
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Service
class JwtTokenFilter(private val jwtService: JwtService,
                     private val userRepository: UserRepository)
    : OncePerRequestFilter() {

    private val AUTHORIZATION_HEADER = "Authorization"

    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, filterChain: FilterChain) {
        try {
            val token = getTokenString(request.getHeader(AUTHORIZATION_HEADER)) ?: ""

            if (!token.isEmpty()) {
                val email = jwtService.getSubFromToken(token)
                if (!email.isBlank() && SecurityContextHolder.getContext().authentication == null) {
                    val user = userRepository.findByEmail(email)
                            ?: throw UsernameNotFoundException("$email not found")
                    val usernamePasswordAuthenticationToken = UsernamePasswordAuthenticationToken(user.email, user.password, emptyList())
                    usernamePasswordAuthenticationToken.details = WebAuthenticationDetailsSource().buildDetails(request)

                    SecurityContextHolder.getContext().authentication = usernamePasswordAuthenticationToken
                }
            }

        } catch (e: Exception) {}

        filterChain.doFilter(request, response)

    }

    private fun getTokenString(authenHeader: String): String {
        if (StringUtils.isEmpty(authenHeader)) {
            return ""
        }

        val (prefix, token) = authenHeader.split(" ")
        return token ?: ""
    }
}