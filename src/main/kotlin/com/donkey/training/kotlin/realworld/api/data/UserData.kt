package com.donkey.training.kotlin.realworld.api.data

data class UserData(
        var id: Long,
        var email: String,
        var userName: String? = null,
        var bio: String? = null,
        var avatar: String? = null)
