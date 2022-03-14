package jpa.test.study.controller

import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull

@RestController
@RequestMapping("/api")
@Validated    // 하위에있는 validation들이 동작한다. 왜냐면 @validated함을 선언함으로써 bean으로 wrapping해준다.
class DeleteApiController {

    // 1. path variable
    // 2. request param
    @DeleteMapping(path = ["/delete-mapping"])
    fun deleteMapping(
        @RequestParam(value = "name") _name: String,

        @NotNull(message = "age 값이 누락되었습니다.")
        @Min(value = 20, message = "age는 20보다 커야 합니다.")
        @RequestParam(name = "age") _age: Int
    ): String {
        return _name + " " + _age
    }

    @DeleteMapping(path = ["/delete-mapping/name/{name}/age/{age}"])
    fun deleteMappingPath(
        @PathVariable(value = "name") _name: String,
        @PathVariable(name = "age") _age: String
    ): String {
        return _name + " " + _age
    }
}