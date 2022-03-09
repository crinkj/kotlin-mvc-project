package jpa.test.controller

import jpa.test.domain.User
import jpa.test.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/user")
class UserController(val userService: UserService, val passwordEncoder: PasswordEncoder) {

    @PostMapping("/join")
    fun join(@RequestBody user: User):ResponseEntity<User>{

        val check:Long = 0;
        if(userService.saveUser(user) == check){

        }
        return ResponseEntity.ok(user)
    }

}