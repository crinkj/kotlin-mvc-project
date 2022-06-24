package jpa.test.controller

import jpa.test.domain.User
import jpa.test.domain.UserLoginRes
import jpa.test.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/user")
class UserController(val userService: UserService, val passwordEncoder: PasswordEncoder) {

    @PostMapping("/join")
    fun join(@RequestBody user: User): ResponseEntity<Any> {

        val check: Long = 0;
        if (userService.checkDuplicateUser(user.email)) {
            return ResponseEntity.ok("이미 등록된 이메일입니다")
        }
            userService.saveUser(user)

        return ResponseEntity.ok(user)
    }

    @PostMapping("/login")
    fun login(@RequestBody userReq: User): ResponseEntity<UserLoginRes> {
        if (!userService.checkDuplicateUser(userReq.email)) {
        } else {
            val user: User? = userService.findUser(userReq.email)
            if (user != null) {
                if (!passwordEncoder.matches(userReq.password, user.password)) {
                    ResponseEntity.ok(user)
                }
            }
        }
        return ResponseEntity.ok(userService.login(userReq))
    }

}