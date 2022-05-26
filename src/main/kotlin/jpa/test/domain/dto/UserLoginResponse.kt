package jpa.test.domain.dto

import org.springframework.http.HttpStatus


data class UserLoginResponse(
    val jwtToken:String?=null,
)