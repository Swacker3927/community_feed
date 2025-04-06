package org.fastcampus.acceptance;

import java.util.List;
import org.fastcampus.acceptance.utils.*;
import org.fastcampus.post.application.dto.CreatePostRequestDto;
import org.fastcampus.post.domain.content.PostPublicationState;
import org.fastcampus.post.application.dto.GetPostContentResponseDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.fastcampus.acceptance.steps.FeedAcceptanceSteps.*;
import static org.junit.jupiter.api.Assertions.*;

class FeedAcceptanceTest extends AcceptanceTestTemplate {
    /**
     * User 1 --- follows ---> User 2
     * User 1 --- follows ---> User 3
     */
    @BeforeEach
    void setUp() {
        super.init();
    }
    /**
     * User 2 create Post 1
     * User 1 Get Post 1 From Feed
     */
    @Test
    void givenUserHasFollowerAndCreatePost_whenFollowerUserRequestFeed_thenFollowerCanGetPostFromFeed() {
        // given
        CreatePostRequestDto dto = new CreatePostRequestDto(2L, "user 1 can get this post", PostPublicationState.PUBLIC);
        Long createdPostId = requestCreatePost(dto);

        // when
        List<GetPostContentResponseDto> result = requestFeed(1L);

        // then
        assertEquals(1, result.size());
        assertEquals(createdPostId, result.get(0).getId());
    }
}
