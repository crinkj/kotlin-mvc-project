package jpa.test.controller

import jpa.test.domain.User
import jpa.test.domain.dto.CommonResponse
import jpa.test.domain.dto.UserLoginResponse
import jpa.test.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/users")
class UserController(
    val userService: UserService,
    val passwordEncoder: PasswordEncoder,
) {

    @PostMapping("/join")
    fun join(@RequestBody user: User): ResponseEntity<CommonResponse<Any,String>> {
        return ResponseEntity.ok(userService.saveUser(user))
    }

    @PostMapping("/login")
    fun login(@RequestBody userReq: User): ResponseEntity<Any>? {
       return userService.login(userReq)?.let {
            ResponseEntity.ok(this)
        }?:run {
           ResponseEntity.badRequest().body("존재하지않는 회원입니다.")
       }

    }

}