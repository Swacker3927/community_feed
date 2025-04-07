package org.fastcampus.post.repository;

import java.util.ArrayList;
import java.util.List;
import org.fastcampus.post.application.dto.*;
import org.fastcampus.post.repository.entity.post.*;
import org.fastcampus.post.repository.post_queue.*;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Profile("test")
public class FakeUserPostQueryRepository implements UserPostQueueQueryRepository {
    private final FakeUserQueueRedisRepository fakeUserQueueRedisRepository;

    public FakeUserPostQueryRepository(FakeUserQueueRedisRepository fakeUserQueueRedisRepository) {
        this.fakeUserQueueRedisRepository = fakeUserQueueRedisRepository;
    }

    @Override
    public List<GetPostContentResponseDto> getContentResponse(Long userId, Long lastContentId) {
        List<PostEntity> postEntities = fakeUserQueueRedisRepository.getPostListByUserId(userId);
        List<GetPostContentResponseDto> result = new ArrayList<>();

        for (PostEntity postEntity: postEntities) {
            GetPostContentResponseDto res = GetPostContentResponseDto.builder()
                    .id(postEntity.getId())
                    .build();
            result.add(res);
        }
        return result;
    }
}
