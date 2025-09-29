package org.fastcampus.user.application.interfaces;

import org.fastcampus.user.domain.*;

public interface UserRepository {
    User findById(Long id);
    User save(User user);
}
