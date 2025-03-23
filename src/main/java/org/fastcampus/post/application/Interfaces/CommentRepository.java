package org.fastcampus.post.application.Interfaces;

import java.util.Optional;
import org.fastcampus.post.domain.comment.*;

public interface CommentRepository {
    Comment save(Comment comment);
    Optional<Comment> findById(Long id);
}
