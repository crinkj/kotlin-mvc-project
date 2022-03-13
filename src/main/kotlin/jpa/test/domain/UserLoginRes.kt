package jpa.test.domain

import jpa.test.config.BaseTIme
import lombok.Getter
import org.springframework.http.HttpStatus
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import javax.persistence.*


data class UserLoginRes(
    var jwtToken:String?=null,
    var httpstatus:HttpStatus?=null
)