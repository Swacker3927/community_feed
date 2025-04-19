package org.fastcampus.auth.application.Interfaces;

import org.fastcampus.auth.domain.UserAuth;
import org.fastcampus.user.domain.User;

public interface UserAuthRepository {
    UserAuth registerUser(UserAuth auth, User user);
    UserAuth loggingUser(String email, String password);
}
