package jpa.test.config.exceptionHandler

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

/*
@RestControllerAdvice
class ExceptionHandler {
    @ExceptionHandler(BaseException::class)
    protected fun handleBaseException(e: BaseException): ResponseEntity<BaseResponseCode> {
        return ResponseEntity.status(e.baseResponseCode.status)
            .body(BaseResponseCode())
    }
}*/
