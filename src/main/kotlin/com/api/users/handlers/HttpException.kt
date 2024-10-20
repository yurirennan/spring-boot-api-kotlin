package com.api.users.handlers

import org.springframework.http.HttpStatus

interface HttpException {

    fun getErrorMessage() : String
    fun getHttpStatus(): HttpStatus
    fun getErrorMessageParams(): Array<Any>?

}