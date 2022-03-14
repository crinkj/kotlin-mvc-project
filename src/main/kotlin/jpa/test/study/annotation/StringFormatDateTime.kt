package jpa.test.study.annotation

import jpa.test.study.validator.StringFormatDateTimeValidator
import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

@Constraint(validatedBy = [StringFormatDateTimeValidator::class]) // 해당 어노테이션이 붙은 클래스는 validator를 사용해서 validate을 하겠다 지정
@Target(
    AnnotationTarget.FIELD, // Field에 적용
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)

@Retention(AnnotationRetention.RUNTIME)  // 어노테이션을 Runtime시에까지 사용가능하게 설정
@MustBeDocumented  // @MustBeDocumented : 애노테이션이 공개 API에 속하는지와 생성한 API문서의 클래스나 메서드 시그니처에 포함되어야 하는지를 지정한다.
annotation class StringFormatDateTime (
    val pattern: String = "yyyy-MM-dd HH:mm:ss",
    val message: String = "시간 형식이 유효하지 않습니다",
    val groups: Array<KClass<*>> = [], // 어노테이션 생성시 default로 있어야하는 값
    val payload: Array<KClass<out Payload>> = [] // 어노테이션 생성시 default로 있어야하는 값
)

