package com.donkey.training.kotlin.realworld.repositories

import com.donkey.training.kotlin.realworld.entities.User
import org.springframework.data.repository.Repository

interface UserRepository : Repository<User, Long> {

    fun findAll(): Collection<User>

    fun findByEmail(email: String): User?
}