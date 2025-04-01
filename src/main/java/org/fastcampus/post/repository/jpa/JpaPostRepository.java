package org.fastcampus.post.repository.jpa;

import java.util.List;
import org.fastcampus.post.repository.entity.post.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface JpaPostRepository extends JpaRepository<PostEntity, Long> {
    @Query("SELECT p.id FROM PostEntity p WHERE p.author.id = :authorId")
    List<Long> findAllPostIdByAuthorId(Long authorId);

    @Modifying
    @Query(value = "UPDATE PostEntity p"
            + " SET p.content = :#{#post.getContent()},"
            + " p.state = :#{#post.getState()},"
            + " p.updDt = now()"
            + " WHERE p.id = :#{#post.getId()}")
    void updatePostEntity(PostEntity post);

    @Modifying
    @Query(value = "UPDATE PostEntity p"
            + " SET p.likeCount = :#{#post.getLikeCount()},"
            + " p.updDt = now()"
            + " WHERE p.id = :#{#post.getId()}")
    void updatePostLikeCount(PostEntity post);

    @Modifying
    @Query(value ="UPDATE PostEntity p"
            + " SET p.commentCount = p.commentCount + 1,"
            + " p.updDt = now()"
            + " WHERE p.id = :id")
    void increaseCommentCount(Long id);
}
