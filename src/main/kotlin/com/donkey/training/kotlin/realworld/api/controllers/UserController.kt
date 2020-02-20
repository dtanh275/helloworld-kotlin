package com.donkey.training.kotlin.realworld.api.controllers

import com.donkey.training.kotlin.realworld.api.services.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/user")
class UserController(val userService: UserService) {

    @GetMapping("/")
    fun list() = userService.findAllUser()

}