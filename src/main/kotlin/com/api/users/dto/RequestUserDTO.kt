package com.api.users.dto

import com.fasterxml.jackson.annotation.JsonProperty


data class RequestUserDTO(var name: String, @JsonProperty("last_name") var lastName: String)