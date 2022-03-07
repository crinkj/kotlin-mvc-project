package jpa.test.config

import org.hibernate.annotations.CreationTimestamp
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.EntityListeners
import javax.persistence.MappedSuperclass


@MappedSuperclass // Entity가 BaseTime을 상속받을때 밑에 createdDate 과 modifedDate을 인식하게해준다.
@EntityListeners(AuditingEntityListener::class)
abstract class BaseTIme {

    // updatable = false 를 설정해서 수정시 생성일 변경 못하게 처리
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    val createdDate : LocalDateTime ? = null

    @CreationTimestamp
    @Column(nullable = false)
    val updatedDate : LocalDateTime ? = null
}