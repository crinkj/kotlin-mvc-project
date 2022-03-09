package jpa.test.service

import jpa.test.config.Jwt.JwtTokenProvider
import jpa.test.config.exceptionHandler.BaseResponseCode
import jpa.test.domain.User
import jpa.test.repository.UserRepository
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
@Transactional
class UserService(val userRepository: UserRepository, private val jwtTokenProvider: JwtTokenProvider){

    fun saveUser(user: User):Long?{

        if(!checkDuplicateUser(user.email)){
            userRepository.save(user)
            return user.id
        }
        return 0

    }

    fun checkDuplicateUser(email:String):Boolean{
        return userRepository.findByEmail(email) != null
    }

}