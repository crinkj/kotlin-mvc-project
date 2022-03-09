package jpa.test.config.exceptionHandler

class BaseException(baseResponseCode: BaseResponseCode): RuntimeException() {
    public val baseResponseCode: BaseResponseCode = baseResponseCode
}