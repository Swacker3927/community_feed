package org.fastcampus.auth.application;

import lombok.RequiredArgsConstructor;
import org.fastcampus.auth.application.Interfaces.EmailVerificationRepository;
import org.fastcampus.auth.application.Interfaces.UserAuthRepository;
import org.fastcampus.auth.application.dto.CreateUserAuthRequestDto;
import org.fastcampus.auth.application.dto.LoginRequestDto;
import org.fastcampus.auth.application.dto.UserAccessTokenResponseDto;
import org.fastcampus.auth.domain.Email;
import org.fastcampus.auth.domain.TokenProvider;
import org.fastcampus.auth.domain.UserAuth;
import org.fastcampus.user.domain.User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserAuthRepository userAuthRepository;
    private final EmailVerificationRepository verificationRepository;
    private final TokenProvider tokenProvider;

    public Long registerUser(CreateUserAuthRequestDto dto) {
        Email email = Email.createEmail(dto.email());

        if (!verificationRepository.isEmailVerified(email)) {
            throw new IllegalStateException("Email is not verified");
        }

        UserAuth userAuth = new UserAuth(dto.email(), dto.password(), dto.role());
        User user = new User(dto.name(), dto.profileUrl());
        userAuth = userAuthRepository.registerUser(userAuth, user);

        return userAuth.getUserId();
    }

    public UserAccessTokenResponseDto login(LoginRequestDto dto) {
        UserAuth userAuth = userAuthRepository.loggingUser(dto.email(), dto.password());
        String token = tokenProvider.createToken(userAuth.getUserId(), userAuth.getUserRole());
        return new UserAccessTokenResponseDto(token);
    }
}
