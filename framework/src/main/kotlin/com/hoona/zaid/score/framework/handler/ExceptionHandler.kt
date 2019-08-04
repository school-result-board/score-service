package com.hoona.zaid.score.framework.handler

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(Exception::class)
    fun handleException(exception: Exception): SimpleErrorMessage {
        return SimpleErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, exception.message)
    }
}
