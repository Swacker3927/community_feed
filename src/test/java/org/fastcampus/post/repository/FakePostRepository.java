package org.fastcampus.post.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.fastcampus.post.application.Interfaces.PostRepository;
import org.fastcampus.post.domain.*;

public class FakePostRepository implements PostRepository {
    private final Map<Long, Post> store = new HashMap<>();

    @Override
    public Post save(Post post) {
        if (post.getId() != null) {
            store.put(post.getId(), post);
            return post;
        }
        Long id = store.size() + 1L;
        Post newPost = Post.createDefaultPost(id, post.getAuthor(), post.getContent());
        store.put(id, newPost);
        return newPost;
    }

    @Override
    public Optional<Post> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }
}
