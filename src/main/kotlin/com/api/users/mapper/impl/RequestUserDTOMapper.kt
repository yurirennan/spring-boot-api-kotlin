package com.api.users.mapper.impl

import com.api.users.dto.RequestUserDTO
import com.api.users.mapper.Mapper
import com.api.users.model.User
import org.springframework.stereotype.Component

@Component
class RequestUserDTOMapper: Mapper<RequestUserDTO, User> {

    override fun fromEntity(entity: User): RequestUserDTO {
        return RequestUserDTO(
            name = entity.name,
            lastName = entity.lastName
        )
    }

    override fun toEntity(domain: RequestUserDTO): User {
        return User(
            id = null,
            name = domain.name,
            lastName = domain.lastName
        )
    }

}