package org.fastcampus.post.domain;

import org.fastcampus.post.domain.content.*;
import org.fastcampus.user.domain.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostTest {
    private final UserInfo info = new UserInfo("name", "URL");
    private final User user = new User(1L, info);
    private final User otherUser = new User(2L, info);

    private final Post post = Post.createDefaultPost(1L, user, "content");

    @Test
    void givenPost_whenLike_thenIncreaseLikeCount() {
        //  given
        int likeCount = post.getLikeCount();

        //  when
        post.like(otherUser);

        //  then
        assertEquals(likeCount + 1, post.getLikeCount());
    }

    @Test
    void givenPostCreated_whenLikeByUser_thenThrowError() {
        //  when, then
        assertThrows(IllegalArgumentException.class, () -> post.like(user));
    }

    @Test
    void givenPost_whenUnlike_thenDecreaseLikeCount() {
        //  given
        post.like(otherUser);
        int likeCount = post.getLikeCount();

        //  when
        post.unlike();

        //  then
        assertEquals(likeCount - 1, post.getLikeCount());
    }

    @Test
    void givenPostCreated_whenUnlike_thenLikeCountIsZero() {
        //  when
        post.unlike();

        //  then
        assertEquals(0, post.getLikeCount());
    }

    @Test
    void givenPostCreated_whenUpdatePost_thenContentAndStateAreUpdated() {
        //  given
        String updateContent = "updated content";

        //  when
        post.updatePost(user, updateContent, PostPublicationState.PUBLIC);

        //  then
        assertEquals(updateContent, post.getContent());
    }

    @Test
    void givenPostCreated_whenUpdatePostByOtherUser_thenThrowError() {
        //  when, then
        assertThrows(IllegalArgumentException.class, () -> post.updatePost(otherUser, "updated content", PostPublicationState.PUBLIC));
    }
}
