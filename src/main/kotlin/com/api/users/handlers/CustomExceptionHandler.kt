package com.api.users.handlers

import com.api.users.exceptions.UserNotFoundException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class CustomExceptionHandler {

    @ExceptionHandler(UserNotFoundException::class)
    fun handleHttpException(exception: HttpException): ResponseEntity<ApiError> {
        val message = exception.getErrorMessage()
        val httpStatus = exception.getHttpStatus()

        val apiError = ApiError.of(httpStatus, message, message)

        return ResponseEntity.status(httpStatus).body(apiError)
    }

}
