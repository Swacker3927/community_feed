package org.fastcampus.user.application.Interfaces;

import java.util.Optional;
import org.fastcampus.user.domain.*;

public interface UserRepository {
    User save(User user);
    Optional<User> findById(Long id);
}
