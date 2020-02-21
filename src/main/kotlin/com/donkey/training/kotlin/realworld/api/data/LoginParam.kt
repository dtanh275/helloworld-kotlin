package com.donkey.training.kotlin.realworld.api.data

import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty

class LoginParam {

    @NotBlank(message = "can't be empty")
    @Email(message = "should be an email")
    var email : String = ""

    @NotBlank(message = "can't be empty")
    var password : String = ""
}