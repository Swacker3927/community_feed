package org.fastcampus.post.application.dto;

import org.fastcampus.post.domain.*;

public record CreatePostRequestDto(Long userId, String content, PostPublicationState state) {

}
