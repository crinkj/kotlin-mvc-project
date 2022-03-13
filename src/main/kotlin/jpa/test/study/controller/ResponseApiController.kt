package jpa.test.study.controller

import jpa.test.study.model.UserRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/response")
class ResponseApiController {
    constructor()


    // 1. get 4xx
    // GET http://localhost:8080/api/response?age=10
    @GetMapping("")
    fun getMapping(@RequestParam age: Int?): ResponseEntity<String> {

        return age?.let{
                if(age < 20 ){
                    return ResponseEntity.status(400).body("age값은 20보다 커야합니다")
                }
            return ResponseEntity.status(200).body("OK")
        }?:kotlin.run {
            return ResponseEntity.status(400).body("age 값이 누락되었습니다.")
        }

        /*  JAVA에 가까운 형식
                // 1. age == null -> 400 error
                if(age == null){
                    return ResponseEntity.status(400).body("age 값이 누락되었습니다.")
                }

                // 2.age < 20 -> 400 error
                if(age < 20){
                    return ResponseEntity.status(400).body("age값은 20보다 커야합니다")
                }

                return ResponseEntity.ok("OK")
         */
    }

    // 2. post 200
    @PostMapping("")
    fun postMapping(@RequestBody userRequest: UserRequest?):ResponseEntity<Any>{
        return ResponseEntity.status(200).body(userRequest)  // object mapper -> object -> json
    }

    // 3. put 201
    @PutMapping("")
    fun putMapping(@RequestBody userRequest: UserRequest?): ResponseEntity<UserRequest> {
        // 1. 기존 데이터가 없어서 새로 생성했다.
        return ResponseEntity.status(HttpStatus.CREATED).body(userRequest)
    }

    // 4. delete 500
    @DeleteMapping("/{id}")
    fun deleteMapping(@PathVariable id:Int):ResponseEntity<Any>{
        return ResponseEntity.status(500).body(null)
    }

}