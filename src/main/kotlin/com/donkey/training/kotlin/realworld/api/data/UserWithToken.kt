package com.donkey.training.kotlin.realworld.api.data

data class UserWithToken(
        var email: String,
        var token: String? = null)