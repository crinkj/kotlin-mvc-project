package jpa.test.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import jpa.test.config.jwt.JwtTokenProvider;
import jpa.test.domain.User;
import jpa.test.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("userTest")
class testControllerTest {

    @Autowired
    private MockMvc mockMvc;


    private final User user = new User("test","test@gmail.com","123");

    ObjectMapper mapper = new ObjectMapper();

    @Test
    @DisplayName("회원가입 테스트")
    public void memberSaveTest() throws Exception {
        mockMvc.perform(
            MockMvcRequestBuilders
                .post("/users/join")
                .content(mapper.writeValueAsString(user))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
        ).andDo(print());
    }

}
