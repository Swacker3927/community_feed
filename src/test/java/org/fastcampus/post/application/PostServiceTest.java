package org.fastcampus.post.application;

import org.fastcampus.post.application.dto.LikeRequestDto;
import org.fastcampus.post.application.dto.UpdatePostRequestDto;
import org.fastcampus.post.domain.*;
import org.fastcampus.post.domain.content.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostServiceTest extends PostApplicationTestTemplate {
    @Test
    void givenPostRequestDto_whenCreatePost_thenPostIsCreated() {
        // when
        Post savePost = postService.createPost(postRequestDto);

        // then
        Post post = postService.getPost(savePost.getId());
        assertEquals(savePost, post);
    }

    @Test
    void givenCreatePost_whenUpdate_thenReturnUpdatedPost() {
        //  given
        Post savedPost = postService.createPost(postRequestDto);

        //  when
        UpdatePostRequestDto updateDto = new UpdatePostRequestDto(savedPost.getId(), user.getId(), "updated-content", PostPublicationState.PRIVATE);
        Post updatedPost = postService.updatePost(updateDto);

        //  then
        assertEquals(savedPost.getId(), updatedPost.getId());
        assertEquals(savedPost.getContent(), updatedPost.getContent());
        assertEquals(savedPost.getAuthor(), updatedPost.getAuthor());
    }

    @Test
    void givenPostRequestDto_whenLikePost_thenPostIsLiked() {
        // given
        Post savedPost = postService.createPost(postRequestDto);

        // when
        LikeRequestDto likeDto = new LikeRequestDto(savedPost.getId(), otherUser.getId());
        postService.likePost(likeDto);

        // then
        assertEquals(1, savedPost.getLikeCount());
    }

    @Test
    void givenPostRequestDto_whenUnlikePost_thenPostIsUnliked() {
        // given
        Post savedPost = postService.createPost(postRequestDto);
        LikeRequestDto likeDto = new LikeRequestDto(savedPost.getId(), otherUser.getId());
        postService.likePost(likeDto);

        // when
        postService.unlikePost(likeDto);

        // then
        assertEquals(0, savedPost.getLikeCount());
    }

    @Test
    void givenPostRequestDto_whenUnlikePost_thenPostIsNotUnliked() {
        // given
        Post savedPost = postService.createPost(postRequestDto);

        // when
        LikeRequestDto likeDto = new LikeRequestDto(savedPost.getId(), otherUser.getId());
        postService.unlikePost(likeDto);

        // then
        assertEquals(0, savedPost.getLikeCount());
    }
}
