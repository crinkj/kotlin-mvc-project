package jpa.test.study.controller

import jpa.test.study.model.Result
import jpa.test.study.model.UserRequest
import jpa.test.study.model.UserResponse
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.validation.FieldError
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class PutApiController {

    @PutMapping("/put-mapping")
    fun putMapping(): String{
        return "put-mapping"
    }

    @RequestMapping(method = [RequestMethod.PUT], path= ["/request-mapping"])
    fun requestMapping(): String{
        return "request-mapping - put method"
    }

    // 적용하고싶은 data class 에 validation 해준 후 적용하는 컨트롤러 객체 앞에다 @Valid 적용
    @PutMapping(path = ["/put-mapping/object"])
    fun putMappingObject(@Valid @RequestBody userRequest: UserRequest, bindResult: BindingResult): ResponseEntity<String> {

        // validation error 확인하는 쉬운방법 b
        if(bindResult.hasErrors()){
            // 500 error
            var msg = StringBuffer()
            bindResult.allErrors.forEach {
                val field = it as FieldError
                val message = it.defaultMessage
                msg.append(field.field + " : " + message + "\n")
            }
            return ResponseEntity.badRequest().body(msg.toString())
        }

        return ResponseEntity.ok("")

        // 0. Response
/*
      return  UserResponse().apply {
            // 1. result
            this.result = Result().apply {
                this.resultCode = "OK"
                this.resultMessage = "성공"
            }
        }.apply {
            // 2. description
            this.decription = "~~~~~~~~~~"
        }.apply {
            // 3. user mutable list(mutableList 는 쓰기/수정이 가능한 collection 이다.
            // MutableList가 필요하지않을땐 List를 권장한다.
            val userList = mutableListOf<UserRequest>()
            userList.add(userRequest)

            userList.add(UserRequest().apply{
                this.name = "a"
                this.age = 10
                this.email = "a@gmail.com"
                this.address = "a address"
                this.phoneNumber= "010-1111-aaaa"
            })

            userList.add(UserRequest().apply{
                this.name = "b"
                this.age = 20
                this.email = "b@gmail.com"
                this.address = "b address"
                this.phoneNumber= "010-1111-bbbb"
            })

            this.userRequest = userList

        }
*/
    }

}