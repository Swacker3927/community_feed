package org.fastcampus.user.application;

import org.fastcampus.fake.*;
import org.fastcampus.user.application.dto.*;
import org.fastcampus.user.domain.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {
    private final UserService userService = FakeObjectFactory.getUserService();

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
