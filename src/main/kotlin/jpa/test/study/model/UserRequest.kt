package jpa.test.study.model

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming
import jpa.test.study.annotation.StringFormatDateTime
import java.lang.Exception
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.validation.constraints.*

// JSON Naming 포맷을 정할 수 있다.
//@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)

data class UserRequest(
    // Server-side: camelCase
    // Client-side: snake-case
    @field:NotEmpty         // data class 일때는 @field:검증   NotEmpty: not null
    @field:Size(min = 2, max = 8)   //  2 <= x <= 8
    var name: String? = null,

    @field:PositiveOrZero   // 0 < 숫자를 검증 0도 포함 (양수)
    var age: Int? = null,

    @field:Email  // email 양식
    var email: String? = null,

    @field:NotBlank  // 공백 검사
    var address: String? = null,

    // Object Mapper가 동작할때 JSON에 들어갈 이름을 JsonProperty에 넣어줄 수 있다.
//    @JsonProperty("phone_number")
    @field:Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}\$")
    var phoneNumber:String? = null, // phone_number

    @field:StringFormatDateTime(pattern= "yyy-MM-dd HH:mm:ss", message="패턴이 올바르지 않습니다.")
    var createdAt:String?=null // yyyy-MM-dd HH:mm:ss ex) 2020-10-02 13:00:00
){
    // customized한 method로 검증하기 위해 @AssertTrue 사용 class 방법
    // 공통적일때는 어노테이션 만드는게 효율적
/*    @AssertTrue(message="생성일자의 패턴은 yyyy-MM-dd HH:mm:ss 여야 합니다.")
    private fun isValidCreatedAt():Boolean{ // 정상 true, 비정상 false
        return try{
            LocalDateTime.parse(this.createdAt, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            true
        }catch (e:Exception){
            false
        }
    }*/
}
