package org.fastcampus.post.domain.comment;

import org.fastcampus.post.domain.*;
import org.fastcampus.post.domain.content.*;
import org.fastcampus.user.domain.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommentTest {
    private final UserInfo info = new UserInfo("name", "URL");
    private final User user = new User(1L, info);
    private final User otherUser = new User(2L, info);

    private final Post post = new Post(1L, user, new PostContent("content"));
    private final Comment comment = new Comment(1L, post, user, new CommentContent("content"));

    @Test
    void givenCommentCreated_whenLike_thenIncreaseLikeCount() {
        //  given
        int likeCount = comment.getLikeCount();

        //  when
        comment.like(otherUser);

        //  then
        assertEquals(likeCount + 1, comment.getLikeCount());
    }

    @Test
    void givenCommentCreated_whenLikeByUser_thenThrowError() {
        //  when, then
        assertThrows(IllegalArgumentException.class, () -> comment.like(user));
    }

    @Test
    void givenCommentCreated_whenUnlike_thenDecreaseLikeCount() {
        //  given
        comment.like(otherUser);
        int likeCount = comment.getLikeCount();

        //  when
        comment.unlike(otherUser);

        //  then
        assertEquals(likeCount - 1, comment.getLikeCount());
    }

    @Test
    void givenCommentCreated_whenUnlike_thenLikeCountIsZero() {
        //  when
        comment.unlike(otherUser);

        //  then
        assertEquals(0, comment.getLikeCount());
    }

    @Test
    void givenCommentCreated_whenUpdateComment_thenContentIsUpdated() {
        //  given
        String updateContent = "updated content";

        //  when
        comment.updateComment(user, updateContent);

        //  then
        assertEquals(updateContent, comment.getContent());
    }

    @Test
    void givenComment_whenUpdateContentLengthIsOver_thenThrowError() {
        //  given
        String content = "This is a test";
        CommentContent commentContent = new CommentContent(content);
        String updatedContent = "a".repeat(101);

        //  when, then
        assertThrows(IllegalArgumentException.class, () -> commentContent.updateContent(updatedContent));
    }
}
