package jpa.test.domain

import jpa.test.config.BaseTIme
import lombok.Getter
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import javax.persistence.*

// Data Class 를 사용하면 lombok이 필요없다.
// hashcode(), copy(),euqlas(),toString(), componentsN() 등 Data Class 사용시 같이 만들어진다.
// Spring security를 사용하기위해 UserDetails를 상속받아야한다.
@Entity
@Table(name = "user")
class User(
    name: String,
    email: String,
    m_password: String
):BaseTIme(), UserDetails{

    @Id
    @GeneratedValue
    var id: Long? = null // 들어오는 아이디값이 null이여도 괜찮다.

    var name: String ?=null

    @Column(nullable = false, unique = true)
    var email: String = email

    @Column(nullable = false)
    var m_password: String = m_password

    override fun getAuthorities(): MutableCollection<out GrantedAuthority>? {
        return null
    }

    override fun getPassword(): String {
        return m_password
    }

    override fun getUsername(): String {
        return email
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }
}

enum class Type() {
    super_admin, admin, user
}