package org.fastcampus.post.application.Interfaces;

import java.util.Optional;
import org.fastcampus.post.domain.*;

public interface PostRepository {
    Post save(Post post);
    Optional<Post> findById(Long id);
}
