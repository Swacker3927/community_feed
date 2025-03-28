package org.fastcampus.user.application;

import org.fastcampus.user.application.Interfaces.UserRelationRepository;
import org.fastcampus.user.application.dto.FollowUserRequestDto;
import org.fastcampus.user.domain.*;
import org.springframework.stereotype.Service;

@Service
public class UserRelationService {
    private final UserService userService;
    private final UserRelationRepository userRelationRepository;

    public UserRelationService(UserService userService, UserRelationRepository userRelationRepository) {
        this.userService = userService;
        this.userRelationRepository = userRelationRepository;
    }

    public void follow(FollowUserRequestDto dto) {
        User user = userService.getUser(dto.userId());
        User targetUser = userService.getUser(dto.targetUserId());

        if (userRelationRepository.isAlreadyFollow(user, targetUser)) {
            throw new IllegalArgumentException("Already followed.");
        }

        user.follow(targetUser);
        userRelationRepository.save(user, targetUser);
    }

    public void unfollow(FollowUserRequestDto dto) {
        User user = userService.getUser(dto.userId());
        User targetUser = userService.getUser(dto.targetUserId());

        if (!userRelationRepository.isAlreadyFollow(user, targetUser)) {
            throw new IllegalArgumentException("Not followed yet.");
        }

        user.unfollow(targetUser);
        userRelationRepository.delete(user, targetUser);
    }
}
