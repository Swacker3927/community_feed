package org.fastcampus.user.application.Interfaces;

import org.fastcampus.user.domain.*;

public interface UserRepository {
    User save(User user);
    User findById(Long id);
}
