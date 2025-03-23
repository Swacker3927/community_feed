package org.fastcampus.post.domain;

import org.fastcampus.common.domain.*;
import org.fastcampus.post.domain.content.*;
import org.fastcampus.user.domain.User;

public class Post {
    private final Long id;
    private final User author;
    private final Content content;
    private PostPublicationState state;
    private final PositiveIntegerCounter likeCount;

    public static Post createPost(Long id, User author, String content, PostPublicationState state) {
        return new Post(id, author, new PostContent(content), state);
    }

    public static Post createDefaultPost(Long id, User author, String content) {
        return new Post(id, author, new PostContent(content), PostPublicationState.PUBLIC);
    }

    public Post(Long id, User author, Content content, PostPublicationState state) {
        if (author == null) {
            throw new IllegalArgumentException("author should not be null");
        }

        if (content == null) {
            throw new IllegalArgumentException("content should not be null or empty");
        }

        this.id = id;
        this.author = author;
        this.content = content;
        this.state = state;
        this.likeCount = new PositiveIntegerCounter();
    }

    public void updatePost(User user, String updateContent, PostPublicationState state) {
        if (!this.author.equals(user)) {
            throw new IllegalArgumentException("only author can update content");
        }

        this.content.updateContent(updateContent);
        this.state = state;
    }

    public void like(User user) {
        if (this.author.equals(user)) {
            throw new IllegalArgumentException();
        }
        likeCount.increase();
    }

    public void unlike() {
        likeCount.decrease();
    }

    public Long getId() {
        return id;
    }

    public User getAuthor() {
        return author;
    }

    public String getContent() {
        return content.getContentText();
    }

    public int getLikeCount() {
        return likeCount.getCount();
    }
}
