package org.fastcampus.post.repository.entity.like;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.fastcampus.common.repository.entity.*;
import org.fastcampus.post.domain.Post;
import org.fastcampus.post.domain.comment.*;
import org.fastcampus.user.domain.User;

@Entity
@Table(name = "community_like")
@NoArgsConstructor
@Getter
public class LikeEntity extends TimeBaseEntity {
    @EmbeddedId
    private LikeIdEntity id;

    public LikeEntity(Post post, User linkeedUser) {
        this.id = new LikeIdEntity(post.getId(), linkeedUser.getId(), LikeTarget.POST.name());
    }

    public LikeEntity(Comment comment, User linkeedUser) {
        this.id = new LikeIdEntity(comment.getId(), linkeedUser.getId(), LikeTarget.COMMENT.name());
    }
}
