package org.fastcampus.post.repository;

import java.util.List;
import org.fastcampus.post.application.dto.GetPostContentResponseDto;
import org.fastcampus.post.repository.post_queue.UserPostQueueQueryRepository;
import org.springframework.stereotype.Repository;

@Repository
public class UserPostQueueQueryRepositoryImpl implements UserPostQueueQueryRepository {

    @Override
    public List<GetPostContentResponseDto> getContentResponse(Long userId, Long lastContentId) {
        return List.of();
    }
}
