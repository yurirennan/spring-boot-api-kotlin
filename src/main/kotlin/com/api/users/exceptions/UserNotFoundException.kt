package com.api.users.exceptions

import com.api.users.handlers.HttpException
import org.springframework.http.HttpStatus

class UserNotFoundException(val userId: Long) : RuntimeException(), HttpException {

    override fun getErrorMessage() = "User with id: $userId Not Found"

    override fun getHttpStatus() = HttpStatus.NOT_FOUND

    override fun getErrorMessageParams(): Array<Any> = arrayOf(userId)

}