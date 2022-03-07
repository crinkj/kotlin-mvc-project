package jpa.test

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

// JPA auditing 활성화
// sping data jpa 에서 audit은 시간을 자동생성하게 넣어주는 기능이다.
@EnableJpaAuditing
@SpringBootApplication
class TestApplication

fun main(args: Array<String>) {
	runApplication<TestApplication>(*args)
}
