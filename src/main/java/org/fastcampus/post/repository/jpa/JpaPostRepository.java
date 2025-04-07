package org.fastcampus.post.repository.jpa;

import java.util.List;
import org.fastcampus.post.repository.entity.post.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface JpaPostRepository extends JpaRepository<PostEntity, Long> {
    @Query("SELECT p FROM PostEntity p WHERE p.author.id = :authorId")
    List<PostEntity> findAllPostIdsByAuthorId(Long authorId);

    @Modifying
    @Query(value = "UPDATE PostEntity p"
            + " SET p.content = :#{#post.getContent()},"
            + " p.state = :#{#post.getState()},"
            + " p.updDt = now()"
            + " WHERE p.id = :#{#post.id}")
    void updatePostEntity(PostEntity post);

    @Modifying
    @Query(value = "UPDATE PostEntity p"
            + " SET p.likeCount = p.likeCount + :likeCount,"
            + " p.updDt = now()"
            + " WHERE p.id = :postId")
    void updatePostLikeCount(Long postId, Integer likeCount);

    @Modifying
    @Query(value ="UPDATE PostEntity p"
            + " SET p.commentCount = p.commentCount + 1,"
            + " p.updDt = now()"
            + " WHERE p.id = :id")
    void increaseCommentCount(Long id);
}
