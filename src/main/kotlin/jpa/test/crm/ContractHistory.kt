package jpa.test.crm

import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToOne

@Entity
class ContractHistory (
    @Id @GeneratedValue
    val id:Long,

    @ManyToOne
    @JoinColumn(name="organization_id")
    val organizationId:Organization,

    @ManyToOne
    @JoinColumn(name="contract_id")
    val contractId:Contract,

    val adminId:Long,

    val operationManger:Long,

    val salesManager:Long,

    val paymentMethod:String,

    val endedAt:LocalDateTime,

    val startedAt:LocalDateTime,

    val createdAt:Instant,

    val contractedAt:LocalDate,

    val updatedAt:Instant,

    val recruitedAt:LocalDateTime
)
