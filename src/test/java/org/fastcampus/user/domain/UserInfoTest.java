package org.fastcampus.user.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserInfoTest {

    @Test
    void givenNameAndProfileImage_whenCreate_thenThrowNothing() {
        //  given
        String name = "abcd";
        String profileImageUrl = "";

        //  when

        //  then
        assertDoesNotThrow(() -> new UserInfo(name, profileImageUrl));
    }

    @Test
    void givenBlandNameAndProfileImage_whenCreate_thenThrowError() {
        //  given
        String name = null;
        String profileImageUrl = "";

        //  when

        //  then
        assertThrows(IllegalArgumentException.class, () -> new UserInfo(name, profileImageUrl));
    }
}
