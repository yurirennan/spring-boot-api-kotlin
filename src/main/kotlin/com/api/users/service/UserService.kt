package com.api.users.service

import com.api.users.dto.RequestUserDTO
import com.api.users.dto.ResponseUserDTO
import com.api.users.dto.UpdateRequestUserDTO
import com.api.users.exceptions.UserNotFoundException
import com.api.users.mapper.impl.RequestUserDTOMapper
import com.api.users.mapper.impl.ResponseUserDTOMapper
import com.api.users.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
    private val requestUserDTOMapper: RequestUserDTOMapper,
    private val responseUserDTOMapper: ResponseUserDTOMapper
) {

    fun saveUser(userDTO: RequestUserDTO): ResponseUserDTO {
        val user = this.requestUserDTOMapper.toEntity(userDTO)
        val userCreated = this.userRepository.save(user)

        return this.responseUserDTOMapper.fromEntity(userCreated)
    }

    fun getUsers(): List<ResponseUserDTO> {
        return this.userRepository.findAll().map { user -> responseUserDTOMapper.fromEntity(user) }
    }

    fun getUser(id: Long): ResponseUserDTO {
        val userOptional = this.userRepository.findById(id)

        if (userOptional.isEmpty) {
            throw UserNotFoundException(id)
        }

        val user = userOptional.get()

        return this.responseUserDTOMapper.fromEntity(user)
    }

    fun updateUser(id: Long, updateRequestUserDTO: UpdateRequestUserDTO): ResponseUserDTO {
        val userOptional = this.userRepository.findById(id)

        if (userOptional.isEmpty) {
            throw UserNotFoundException(id)
        }

        val user = userOptional.get()

        user.name = updateRequestUserDTO.name
        user.lastName = updateRequestUserDTO.lastName

        val userUpdated = this.userRepository.save(user)

        return this.responseUserDTOMapper.fromEntity(userUpdated)
    }

    fun deleteUser(id: Long) {
        val userOptional = this.userRepository.findById(id)

        if (userOptional.isEmpty) {
            throw UserNotFoundException(id)
        }

        this.userRepository.deleteById(id)
    }

}