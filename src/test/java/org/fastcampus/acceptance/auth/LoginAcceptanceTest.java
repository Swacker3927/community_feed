package org.fastcampus.acceptance.auth;

import org.fastcampus.acceptance.utils.*;
import org.fastcampus.auth.application.dto.LoginRequestDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.fastcampus.acceptance.steps.LoginAcceptanceSteps.*;
import static org.junit.jupiter.api.Assertions.*;

class LoginAcceptanceTest extends AcceptanceTestTemplate {
    private final String email = "email@email.com";

    @BeforeEach
    void setUp() {
        this.cleanUp();
        this.createUser(email);
    }

    @Test
    void givenEmailAndPassword_whenLogin_thenReturnToken() {
        // given
        LoginRequestDto dto = new LoginRequestDto(email, "password");

        // when
        String token = requestLoginGetToken(dto);

        // then
        assertNotNull(token);
    }

    @Test
    void givenEmailAndWrongPassword_whenLogin_thenReturnCodeNot200() {
        // given
        LoginRequestDto dto = new LoginRequestDto(email, "wrong-password");

        // when
        Integer code = requestLoginGetResponseCode(dto);

        // then
        assertEquals(400, code);
    }
}
