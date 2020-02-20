package com.donkey.training.kotlin.realworld.api.services

import com.donkey.training.kotlin.realworld.api.data.UserData
import com.donkey.training.kotlin.realworld.repositories.UserRepository
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class UserService(val userRepository: UserRepository) {

    fun findAllUser(): Collection<UserData> = userRepository.findAll().stream()
            .map { u -> UserData(u.id!!,
                        u.email,
                        u.userName,
                        u.bio,
                        u.avatar)
            }
            .collect(Collectors.toList())
}