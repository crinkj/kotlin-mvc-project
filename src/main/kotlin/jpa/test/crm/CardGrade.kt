package jpa.test.crm

import java.time.Instant
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class CardGrade(
       @Id @GeneratedValue
       var id:Long,

       var gradeName:String,

       val createdAt:Instant,
       val updatedAt:Instant
)