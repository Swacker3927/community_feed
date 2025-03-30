package org.fastcampus.post.repository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.fastcampus.post.application.Interfaces.CommentRepository;
import org.fastcampus.post.domain.comment.*;
import org.fastcampus.post.repository.entity.comment.*;
import org.fastcampus.post.repository.jpa.JpaCommentRepository;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CommentRepositoryImpl implements CommentRepository {
    private final JpaCommentRepository jpaCommentRepository;

    @Override
    @Transactional
    public Comment save(Comment comment) {
        CommentEntity commentEntity = new CommentEntity(comment);
        if (comment.getId() != null) {
            jpaCommentRepository.updateCommentEntity(commentEntity);
            return comment;
        }
        commentEntity = jpaCommentRepository.save(commentEntity);
        return commentEntity.toComment();
    }

    @Override
    public Comment findById(Long id) {
        CommentEntity commentEntity = jpaCommentRepository.findById(id).orElseThrow();
        return commentEntity.toComment();
    }
}
