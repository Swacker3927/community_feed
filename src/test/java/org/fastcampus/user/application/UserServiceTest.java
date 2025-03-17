package org.fastcampus.user.application;

import org.fastcampus.user.application.Interfaces.*;
import org.fastcampus.user.application.dto.*;
import org.fastcampus.user.domain.*;
import org.fastcampus.user.repository.FakeUserRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {
    private final UserRepository userRepository = new FakeUserRepository();
    private final UserService userService = new UserService(userRepository);

    @Test
    void givenUserInfoDto_whenCreateUser_thenCanFindUser() {
        //  given
        CreateUserRequestDto dto = new CreateUserRequestDto("John", "www.naver.com");

        //  when
        User savedUser = userService.createUser(dto);

        //  then
        User foundUser = userService.getUser(savedUser.getId());
        UserInfo userInfo = foundUser.getInfo();
        assertEquals(foundUser.getId(), savedUser.getId());
        assertEquals("John", userInfo.getName());
    }
}
