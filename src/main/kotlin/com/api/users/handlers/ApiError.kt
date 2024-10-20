package com.api.users.handlers

import org.springframework.http.HttpStatus

data class ApiError(
    val status: HttpStatus,
    val message: String,
    val errors: List<String>,
    ) {

    companion object {
        fun of(status: HttpStatus, errorMessage: String, error: String): ApiError {
            return ApiError(status, errorMessage, arrayListOf(error))
        }

        fun of(status: HttpStatus, errorMessage: String, errors: List<String>): ApiError {
            return ApiError(status, errorMessage, errors)
        }
    }

}