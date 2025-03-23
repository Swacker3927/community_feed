package org.fastcampus.post.application;

import org.fastcampus.post.application.dto.LikeRequestDto;
import org.fastcampus.post.application.dto.UpdateCommentRequestDto;
import org.fastcampus.post.domain.comment.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommentServiceTest extends PostApplicationTestTemplate {
    @Test
    void givenCommentRequestDto_whenCreateComment_thenCommentIsCreated() {
        // when
        Comment savedComment = commentService.createComment(commentRequestDto);

        // then
        Comment comment = commentService.getComment(savedComment.getId());
        assertEquals(savedComment, comment);
    }

    @Test
    void givenCommentRequestDto_whenUpdateComment_thenCommentIsUpdated() {
        //  given
        Comment savedComment = commentService.createComment(commentRequestDto);

        //  when
        UpdateCommentRequestDto updateDto = new UpdateCommentRequestDto(savedComment.getId(), user.getId(), "updated-comment");
        Comment updatedComment = commentService.updateComment(updateDto);

        //  then
        assertEquals(savedComment.getId(), updatedComment.getId());
        assertEquals(savedComment.getContent(), updatedComment.getContent());
        assertEquals(savedComment.getAuthor(), updatedComment.getAuthor());
    }

    @Test
    void givenCommentRequestDto_whenLikeComment_thenCommentIsLiked() {
        // given
        Comment savedComment = commentService.createComment(commentRequestDto);

        // when
        LikeRequestDto likeDto = new LikeRequestDto(savedComment.getId(), otherUser.getId());
        commentService.likeComment(likeDto);

        // then
        assertEquals(1, savedComment.getLikeCount());
    }

    @Test
    void givenCommentRequestDto_whenUnlikeComment_thenCommentIsUnliked() {
        // given
        Comment savedComment = commentService.createComment(commentRequestDto);
        LikeRequestDto likeDto = new LikeRequestDto(savedComment.getId(), otherUser.getId());
        commentService.likeComment(likeDto);

        // when
        commentService.unlikeComment(likeDto);

        // then
        assertEquals(0, savedComment.getLikeCount());
    }
}
