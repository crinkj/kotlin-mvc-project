package jpa.test.service

import jpa.test.config.jwt.JwtTokenProvider
import jpa.test.domain.User
import jpa.test.domain.dto.CommonResponse
import jpa.test.domain.dto.UserLoginResponse
import jpa.test.repository.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class UserService(
    val userRepository: UserRepository,
    private val jwtTokenProvider: JwtTokenProvider,
) {
    @Transactional
    fun saveUser(user: User): CommonResponse<Any, String> {
        if (checkDuplicateUser(user.email) != null) {
            return CommonResponse("fail", "이미 가입된 회원입니다.")
        } else {
            userRepository.save(user).run {
                return CommonResponse("success", "회원가입 되었습니다.")
            }
        }
    }

    @Transactional
    fun checkDuplicateUser(email: String): User? {
        return userRepository.findByEmail(email)
    }

    @Transactional
    fun login(user: User): UserLoginResponse? {
        if(checkDuplicateUser(user.email) != null){
            return UserLoginResponse(
                jwtToken = jwtTokenProvider.createToken(user.email)
            )
        }
        return null
    }

}