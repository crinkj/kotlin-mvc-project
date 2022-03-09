package jpa.test.study.controller

import jpa.test.study.model.UserRequest
import org.springframework.web.bind.annotation.*

@RestController // 해당 컨트롤러를 REST API로 동작한다고 명시하는 어노테이션
@RequestMapping("/api") // http://localhost:8080/api
class GetApiController {

    // 현재방식
    // mapping이 1개일때
    @GetMapping("/hello")   // GET http://localhost:8080/api/hello
    fun hello():String{
        return "hello kotlin"
    }
    // mapping이 2개 이상일때
    @GetMapping(path=["/hello2","/abcd"])   // GET http://localhost:8080/api/hello
    fun hello2():String{
        return "hello kotlin2"
    }

    // 예전방식
    @RequestMapping(method = [RequestMethod.GET], path = ["/request-mapping"])
    fun requestMapping(): String{
        return "request-mapping"
    }

    // path-variable로 받는방법
    @GetMapping("/get-mapping/path-variable/{name}/{age}") // GET http://localhost:8080/api/get-mapping/path-variable/yohan/28
    fun pathVariable(@PathVariable name: String, @PathVariable age:Int): String{
        return name + " " + age
    }

    // query-param으로 받는방법
    @GetMapping("/get-mapping/query-param") // GET http://localhost:8080/api/get-mapping/path-variable/${name}/${age}
    fun queryParam(@RequestParam name: String,
                     @RequestParam age:Int): String{
        return name + " " + age
    }

    // model로 받는방법
    // Spring에서는 @RestController을 선언해주면 return type이 object면 json 형태로 바뀐다.
    // param에는 최대한 대문자를 사용하면 안된다  예) phoneNumber (x)  -> phonenumber, phone-number
    @GetMapping("/get-mapping/model") // GET http://localhost:8080/api/get-mapping/model
    fun queryParam(user:UserRequest): UserRequest{
        return user
    }
}