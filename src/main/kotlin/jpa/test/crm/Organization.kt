package jpa.test.crm

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Organization (
    @Id @GeneratedValue
    val id:Long
    )