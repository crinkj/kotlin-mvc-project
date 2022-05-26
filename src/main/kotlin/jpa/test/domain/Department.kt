package jpa.test.domain

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name="department")
class Department {
    @Id @GeneratedValue
    val id:Long?=0

    var name:String?=null

    @OneToMany(mappedBy = "department")
    var employeeList:MutableList<Employee>?= mutableListOf()

    var createdDate:LocalDateTime?=null
}