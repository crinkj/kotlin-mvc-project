package jpa.test.domain.dto


data class CommonResponse<T, M>(
    val type: Any,
    val message: M,
)
