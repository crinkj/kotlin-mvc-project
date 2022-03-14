package jpa.test.crm

import java.time.Instant
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Category(
        @Id @GeneratedValue
        val id:Long,
        val categoryDepth:Int,
        val parent:Int,
        val title:String,
        val createdAt:Instant,
        val updatedAt:Instant
)