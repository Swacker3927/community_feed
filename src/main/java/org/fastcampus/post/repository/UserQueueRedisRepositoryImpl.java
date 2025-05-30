package org.fastcampus.post.repository;

import java.util.List;
import org.fastcampus.post.repository.entity.post.PostEntity;
import org.fastcampus.post.repository.post_queue.UserQueueRedisRepository;
import org.springframework.stereotype.Repository;

@Repository
public class UserQueueRedisRepositoryImpl implements UserQueueRedisRepository {

    @Override
    public void publishPostToFollowingUserList(PostEntity postEntity, List<Long> userIdList) {

    }

    @Override
    public void publishPostListToFollowerUser(List<PostEntity> postEntities, Long userId) {

    }

    @Override
    public void deletePostToUserQueue(Long userId, Long targetUserId) {

    }
}
