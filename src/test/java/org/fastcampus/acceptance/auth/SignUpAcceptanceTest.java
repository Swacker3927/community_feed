package org.fastcampus.acceptance.auth;

import org.fastcampus.acceptance.utils.*;
import org.fastcampus.auth.application.dto.SendEmailRequestDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.fastcampus.acceptance.steps.SignUpAcceptanceSteps.*;
import static org.junit.jupiter.api.Assertions.*;

class SignUpAcceptanceTest extends AcceptanceTestTemplate {
    private final String email = "email@email.com";

    @BeforeEach
    void setUp() {
        this.cleanUp();
    }

    @Test
    void givenEmail_whenSendEmail_thenVerificationTokenSaved() {
        // given
        SendEmailRequestDto dto = new SendEmailRequestDto(email);

        // when
        Integer code = requestSendEmail(dto);

        // then
        String token = this.getEmailToken(email);
        assertNotNull(token);
        assertEquals(200, code);
    }

    @Test
    void givenInvalidEmail_whenSendEmail_thenVerificationTokenNotSaved() {
        // given
        SendEmailRequestDto dto = new SendEmailRequestDto("invalid-email");

        // when
        Integer code = requestSendEmail(dto);

        // then
        assertEquals(400, code);
    }
}
