package jpa.test.domain

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToMany
import javax.persistence.OneToOne
import javax.persistence.Table

@Entity
@Table(name = "employee")
class Employee() {

    @Id
    @GeneratedValue
    val id: Long? = 0
    var name: String? = null

    @ManyToOne
    @JoinColumn(name = "department_id")
    var department: Department? = null

    var createdAt:LocalDateTime?=null


}