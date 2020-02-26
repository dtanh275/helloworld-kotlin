package com.donkey.training.kotlin.realworld.api.exceptions

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(InvalidRequestException::class)
    fun invalidRequest(e: InvalidRequestException) = ResponseEntity.badRequest().body(e.message)

}