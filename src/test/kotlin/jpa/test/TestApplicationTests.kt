package jpa.test

import jpa.test.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class TestApplicationTests(
    @Autowired val userService: UserService
) {


}
