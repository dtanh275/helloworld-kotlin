package com.donkey.training.kotlin.realworld.api.controllers

import com.donkey.training.kotlin.realworld.api.data.LoginParam
import com.donkey.training.kotlin.realworld.api.data.UserWithToken
import com.donkey.training.kotlin.realworld.api.services.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.ok
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/user")
@Validated
class UserController(val userService: UserService) {

    @GetMapping("/")
    fun list() = userService.findAllUser()

    @PostMapping("/authen")
    fun login(@Valid @RequestBody loginParam: LoginParam) =
            try {
                ok<UserWithToken?>(userService.authen(loginParam))
            } catch (e: Exception) {
                ResponseEntity("invalid email or password", HttpStatus.UNAUTHORIZED)
            }
}