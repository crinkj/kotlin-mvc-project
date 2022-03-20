package jpa.test.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name="department")
class Department {
    @Id @GeneratedValue
    val id:Long?=0

    var name:String?=null
}