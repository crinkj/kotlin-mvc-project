package jpa.test.config.Jwt

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Component
import java.util.*
import javax.annotation.PostConstruct
import javax.servlet.http.HttpServletRequest


// 세션 방식보다 보안이 약하지만
// 서버에 확장성이 있고 토큰이 유효한지만 확인하면 되서 서버의 자원이 절약된다.
// JWT 는 세파트가있다
//  * Header : JWT 를 어떻게 검증하는지 내용이 들어가있다(타입, 암호화 알고리즘)
//  * payload : 토근에 담아서 보내고자하는 데이터가 담겨있다
//  * signature: Header와 payload를 합친 문자열을 서명한 값이다.
@Component
class JwtTokenProvider(private val userDetailsService: UserDetailsService){

    private var  secretKey = "springsecurityjwt"

    // 토큰 유효시간 30분
    private val tokenValidTime = 30 * 60 * 1000L

    // 객체 초기화, secretKey를 Base64로 인코딩한다.
    @PostConstruct
    protected fun init(){
        secretKey = Base64.getEncoder().encodeToString((secretKey.toByteArray()))
    }

    // JWT 토큰 생성
    fun createToken(userPk: String): String{
        val claims: Claims = Jwts.claims().setSubject(userPk) // JWT payload 에 저장되는 정보단위
        claims["userPk"] = userPk // 정보는 key / value 형식으로 저장된다
        val now = Date()
        return Jwts.builder()
            .setHeaderParam("type","JWT")
            .setClaims(claims) // 정보 저장
            .setIssuedAt(now)
            .setExpiration(Date(now.time + tokenValidTime)) // 만료 시간 작성
            .signWith(SignatureAlgorithm.HS256, secretKey) // 사용할 암호와 알고리즘과 signature에 들어갈 secretKey값 세팅
            .compact()
    }

    // JWT 토큰에서 인증 정보 조회
    fun getAuthentication(token: String): UsernamePasswordAuthenticationToken {
        val userDetails = userDetailsService.loadUserByUsername(getUserPk(token))
        return UsernamePasswordAuthenticationToken(userDetails, "", userDetails.authorities)
    }

    // 토큰에서 회원 정보 추출
    fun getUserPk(token: String) : String{
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).body.subject
    }

    // Request의 Header에서 token 값을 가져옵니다. "X-AUTH-TOKEN" : "TOKEN값"
    fun resolveToken(request: HttpServletRequest): String?{
        return request.getHeader("Authorization")
    }

    // 토큰의 유효성/만료일자 검사
    fun validateToken(jwtToken: String): Boolean{
        return try{
                val claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jwtToken)
            !claims.body.expiration.before(Date())
        } catch (e : java.lang.Exception){
            false
        }
    }
}