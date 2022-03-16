package jpa.test.advice

import org.springframework.web.bind.annotation.RestControllerAdvice

// RestController에서 발생하는 exception은 다 여기로 통하게 설정하는 annotation
@RestControllerAdvice
class GlobalControllerAdvice {
}