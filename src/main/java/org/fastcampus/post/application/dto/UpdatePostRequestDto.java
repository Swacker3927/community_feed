package org.fastcampus.post.application.dto;

import org.fastcampus.post.domain.*;

public record UpdatePostRequestDto(Long postId, Long userId, String content, PostPublicationState state) {

}
