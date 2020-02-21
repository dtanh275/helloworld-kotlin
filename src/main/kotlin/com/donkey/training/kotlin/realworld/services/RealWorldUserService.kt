package com.donkey.training.kotlin.realworld.services

import com.donkey.training.kotlin.realworld.repositories.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class RealWorldUserService(val repository: UserRepository) : UserDetailsService {

    override fun loadUserByUsername(email: String?): UserDetails {
        var user = repository.findByEmail(email!!) ?: throw UsernameNotFoundException("$email not found")
        return org.springframework.security.core.userdetails.User(user.email,
                user.password, emptyList())
    }
}