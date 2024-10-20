package com.api.users.controller

import com.api.users.dto.RequestUserDTO
import com.api.users.dto.ResponseUserDTO
import com.api.users.dto.UpdateRequestUserDTO
import com.api.users.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController(
    private val userService: UserService
) {

    @GetMapping("/hello")
    fun getText() = "Texto escrito"

    @GetMapping()
    fun getUsers(): List<ResponseUserDTO>{
        return userService.getUsers()
    }

    @PostMapping()
    fun saveUser(@RequestBody userDTO: RequestUserDTO): ResponseUserDTO {
        return userService.saveUser(userDTO)
    }

    @GetMapping("/{id}")
    fun getUser(@PathVariable("id") id: Long): ResponseUserDTO {
        return userService.getUser(id)
    }

    @PutMapping("/{id}")
    fun updateUser(@PathVariable("id") id: Long,
                   @RequestBody updateRequestUserDTO: UpdateRequestUserDTO): ResponseUserDTO {
        return userService.updateUser(id, updateRequestUserDTO)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteUser(@PathVariable("id") id: Long) {
        return userService.deleteUser(id)
    }

}