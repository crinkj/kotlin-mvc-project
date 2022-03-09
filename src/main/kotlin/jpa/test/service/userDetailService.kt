package jpa.test.service

import jpa.test.domain.User
import jpa.test.repository.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UserDetailService(private val userRepository: UserRepository): UserDetailsService {
    override fun loadUserByUsername(username: String): User? {
        return userRepository.findByEmail(username)}
    }
