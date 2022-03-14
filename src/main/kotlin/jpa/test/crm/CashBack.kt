package jpa.test.crm

import java.time.Instant
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
class CashBack(
    @Id @GeneratedValue
    val id:Long,

    @OneToMany(mappedBy = "cardGrade")
    val cardGradeId:CardGrade,

    var rate:Int,
    val createdAt:Instant,
    val updatedAt:Instant
    )