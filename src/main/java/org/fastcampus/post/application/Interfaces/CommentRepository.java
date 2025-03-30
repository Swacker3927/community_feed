package org.fastcampus.post.application.Interfaces;

import org.fastcampus.post.domain.comment.*;

public interface CommentRepository {
    Comment save(Comment comment);
    Comment findById(Long id);
}
