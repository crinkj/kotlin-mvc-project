package jpa.test.study.model

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming

// JSON Naming 포맷을 정할 수 있다.
//@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
data class UserRequest(
    // Server-side: camelCase
    // Client-side: snake-case
    var name: String? = null,
    var age: Int? = null,
    var email: String? = null,
    var address: String? = null,

    // Object Mapper가 동작할때 JSON에 들어갈 이름을 JsonProperty에 넣어줄 수 있다.
//    @JsonProperty("phone_number")
    var phoneNumber:String? = null // phone_number
)
