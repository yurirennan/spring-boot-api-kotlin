package com.api.users.mapper.impl

import com.api.users.dto.ResponseUserDTO
import com.api.users.mapper.Mapper
import com.api.users.model.User
import org.springframework.stereotype.Component

@Component
class ResponseUserDTOMapper: Mapper<ResponseUserDTO, User> {

    override fun fromEntity(entity: User): ResponseUserDTO {
        return ResponseUserDTO(
            id = entity.id,
            name = entity.name,
            lastName = entity.lastName
        )
    }

    override fun toEntity(domain: ResponseUserDTO): User {
        return User(
            id = domain.id,
            name = domain.name,
            lastName = domain.lastName
        )
    }

}