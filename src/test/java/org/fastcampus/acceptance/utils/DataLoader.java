package org.fastcampus.acceptance.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.fastcampus.auth.application.dto.*;
import org.fastcampus.user.application.dto.*;
import org.springframework.stereotype.Component;

import static org.fastcampus.acceptance.steps.SignUpAcceptanceSteps.*;
import static org.fastcampus.acceptance.steps.UserAcceptanceSteps.*;

@Component
public class DataLoader {
    @PersistenceContext
    private EntityManager entityManager;

    public void loadData() {
        for (int i = 1; i <= 3; i++) {
            createUser("user" + i + "@test.com");
        }


        followUser(new FollowUserRequestDto(1L, 2L));
        followUser(new FollowUserRequestDto(1L, 3L));
    }

    public String getEmailToken(String email) {
        return entityManager.createNativeQuery("SELECT token FROM community_email_verification WHERE email = ?", String.class)
                .setParameter(1, email)
                .getSingleResult()
                .toString();
    }

    public boolean isEmailVerified(String email) {
        return entityManager.createQuery("SELECT isVerified FROM EmailVerificationEntity WHERE email = :email", Boolean.class)
                .setParameter("email", email)
                .getSingleResult();
    }

    public Long getUserId(String email) {
        return entityManager.createQuery("SELECT userId FROM UserAuthEntity WHERE email = :email", Long.class)
                .setParameter("email", email)
                .getSingleResult();
    }

    public void createUser(String email) {
        requestSendEmail(new SendEmailRequestDto(email));
        String token = this.getEmailToken(email);
        requestVerifyEmail(email, token);
        registerUser(new CreateUserAuthRequestDto(email, "password", "name", "USER", null));
    }
}
