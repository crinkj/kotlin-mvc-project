package jpa.test.study.validator

import jpa.test.study.annotation.StringFormatDateTime
import java.lang.Exception
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class StringFormatDateTimeValidator : ConstraintValidator<StringFormatDateTime, String>{

    private var pattern : String?=null

    override fun initialize(constraintAnnotation: StringFormatDateTime?) {
        this.pattern = constraintAnnotation?.pattern
    }

    // 정상이면 true 비정상이면 false
    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
       return  try{
            LocalDateTime.parse(value, DateTimeFormatter.ofPattern(pattern))
            true
        }catch (e: Exception){
            false
        }
    }


}