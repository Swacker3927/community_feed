package org.fastcampus.user.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    private final UserInfo userInfo = new UserInfo("test", "");
    private User user1;
    private User user2;

    @BeforeEach
    void init() {
        user1 = new User(1L, userInfo);
        user2 = new User(2L, userInfo);
    }

    @Test
    void givenTwoUser_whenEqual_thenReturnFalse() {
        //  given

        //  when
        boolean isSame = user1.equals(user2);

        //  then
        assertEquals(false, isSame);
    }

    @Test
    void givenTwoSameUser_whenEqual_thenReturnTrue() {
        //  given
        User sameuser = new User(1L, userInfo);

        //  when
        boolean isSame = user1.equals(sameuser);

        //  then
        assertTrue(isSame);
    }

    @Test
    void givenTwoSameUser_whenHashCode_thenNotEqual() {
        //  given

        //  when
        int hashCode1 = user1.hashCode();
        int hashCode2 = user2.hashCode();

        //  then
        assertNotEquals(hashCode1, hashCode2);
    }

    @Test
    void givenTwoUser_whenUser1FollowUser2_thenIncreaseUserCount() {
        //  given

        //  when
        user1.follow(user2);

        //  then
        assertEquals(1, user1.followingCount());
        assertEquals(0, user1.followerCount());
        assertEquals(0, user2.followingCount());
        assertEquals(1, user2.followerCount());
    }

    @Test
    void givenUser1FollowUser2_whenUser1UnFollowUser2_thenDecreaseUserCount() {
        //  given
        user1.follow(user2);

        //  when
        user1.unfollow(user2);

        //  then
        assertEquals(0, user1.followingCount());
        assertEquals(0, user1.followerCount());
        assertEquals(0, user2.followingCount());
        assertEquals(0, user2.followerCount());
    }

    @Test
    void givenTwoUser_whenUser1UnFollowUser2_thenNotDecreaseUserCount() {
        //  given

        //  when
        user1.unfollow(user2);

        //  then
        assertEquals(0, user1.followingCount());
        assertEquals(0, user1.followerCount());
        assertEquals(0, user2.followingCount());
        assertEquals(0, user2.followerCount());
    }
}
