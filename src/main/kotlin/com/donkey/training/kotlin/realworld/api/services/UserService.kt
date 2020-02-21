package com.donkey.training.kotlin.realworld.api.services

import com.donkey.training.kotlin.realworld.api.data.LoginParam
import com.donkey.training.kotlin.realworld.api.data.UserData
import com.donkey.training.kotlin.realworld.api.data.UserWithToken
import com.donkey.training.kotlin.realworld.repositories.UserRepository
import com.donkey.training.kotlin.realworld.services.JwtService
import com.donkey.training.kotlin.realworld.services.RealWorldUserService
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class UserService(val userRepository: UserRepository,
                  val userDetailsService: RealWorldUserService,
                  val authenManager: AuthenticationManager,
                  val jwtService: JwtService) {

    fun findAllUser(): Collection<UserData> = userRepository.findAll().stream()
            .map { u -> UserData(u.id!!,
                        u.email,
                        u.userName,
                        u.bio,
                        u.avatar)
            }
            .collect(Collectors.toList())

    fun authen(loginParam: LoginParam) : UserWithToken {
        authenManager.authenticate(UsernamePasswordAuthenticationToken(loginParam.email, loginParam.password))

        return UserWithToken(loginParam.email, jwtService.toToken(userDetailsService.loadUserByUsername(loginParam.email)))
    }
}