package org.fastcampus.post.application.interfaces;

import org.fastcampus.post.domain.comment.*;

public interface CommentRepository {
    Comment findById(Long id);
    Comment save(Comment comment);
}