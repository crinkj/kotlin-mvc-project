package jpa.test.study.controller

import jpa.test.study.model.UserRequest
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class PostApiController {

    @PostMapping("/post-mapping")
    fun postMapping(): String{
        return "post-mapping"
    }

    @RequestMapping(method = [RequestMethod.POST], path= ["/request-mapping"])
    fun requestMapping(): String{
        return "request-mapping"
    }

    // object mapper 는 밑에처럼 데이터 타입을 변환시켜주는 라이브러리다.
    // 스프링에서 @RestController가 처리한다
    // json -> object
    // object - json
    @PostMapping("/post-mapping/object")
    fun postMappingObject(@RequestBody userRequest: UserRequest): UserRequest{
        println(userRequest)
        return userRequest
    }

}