package jpa.test.service

import jpa.test.domain.User
import jpa.test.repository.UserRepository
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
@Transactional
class UserService(val userRepository: UserRepository){

}