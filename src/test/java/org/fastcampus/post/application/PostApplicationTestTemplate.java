package org.fastcampus.post.application;

import org.fastcampus.fake.*;
import org.fastcampus.post.application.dto.*;
import org.fastcampus.post.domain.*;
import org.fastcampus.post.domain.content.*;
import org.fastcampus.user.application.UserService;
import org.fastcampus.user.application.dto.CreateUserRequestDto;
import org.fastcampus.user.domain.User;

public class PostApplicationTestTemplate {
    static final UserService userService = FakeObjectFactory.getUserService();
    static final PostService postService = FakeObjectFactory.getPostService();
    static final CommentService commentService = FakeObjectFactory.getCommentService();

    static final User user = userService.createUser(new CreateUserRequestDto("user1", null));
    static final User otherUser = userService.createUser(new CreateUserRequestDto("user2", null));

    static final CreatePostRequestDto postRequestDto = new CreatePostRequestDto(user.getId(), "test-content", PostPublicationState.PUBLIC);
    static final Post post = postService.createPost(postRequestDto);

    static final CreateCommentRequestDto commentRequestDto = new CreateCommentRequestDto(post.getId(), user.getId(), "test-comment");
}
