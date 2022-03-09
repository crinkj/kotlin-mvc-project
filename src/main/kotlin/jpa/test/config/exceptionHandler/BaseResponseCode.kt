package jpa.test.config.exceptionHandler

import org.springframework.http.HttpStatus

enum class BaseResponseCode(status: HttpStatus, message: String) {
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "잘못된 요청입니다."),
    INVALID_PASSWORD(HttpStatus.BAD_REQUEST, "잘못된 비밀번호입니다. 다시 입력해주세요."),
    DUPLICATE_EMAIL(HttpStatus.BAD_REQUEST, "중복된 이메일입니다. 다시 입력해주세요."),

    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "사용자를 찾을 수 없습니다."),
    FAILED_TO_SAVE_USER(HttpStatus.NOT_FOUND, "사용자를 등록에 실패했습니다."),
    GUEST_BOOK_NOT_FOUND(HttpStatus.NOT_FOUND, "방명록을 찾을 수 없습니다."),
    OK(HttpStatus.OK, "요청 성공");

    public val status: HttpStatus = status
    public val message: String = message
}

