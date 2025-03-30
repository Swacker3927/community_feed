package org.fastcampus.post.application.Interfaces;

import org.fastcampus.post.domain.*;

public interface PostRepository {
    Post save(Post post);
    Post findById(Long id);
}
