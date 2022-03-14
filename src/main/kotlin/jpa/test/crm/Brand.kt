package jpa.test.crm

import java.time.Instant
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne


@Entity
class Brand(
        @Id @GeneratedValue
        val id:Long,

        @ManyToOne
        @JoinColumn(name="organization_id")
        val organization:Organization,
        var name: String,
        var number: String,
        var type: brandType,
        var address: String,
        var detailAddress: String,
        var phone: String,
        val createdAt:Instant,
        val updatedAt:Instant
)

enum class brandType{
    OFFLINE,ONLINE
}