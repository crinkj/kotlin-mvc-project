package jpa.test.study.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/exception")
class ExceptionApiController {

    @GetMapping("/hello")
    fun hello(){

        val list = mutableListOf<String>()

        // out of index 발생
        val temp = list[0]

        if(true){
            throw RuntimeException("강제 exception 발생")
        }
    }
}