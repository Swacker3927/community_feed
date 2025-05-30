package org.fastcampus.user.application.Interfaces;

import org.fastcampus.user.domain.*;

public interface UserRelationRepository {
    boolean isAlreadyFollow(User user, User targetUser);
    void save(User user, User targetUser);
    void delete(User user, User targetUser);
}
