package org.fastcampus.common;

import org.fastcampus.post.application.interfaces.*;
import org.fastcampus.post.repository.*;

public class FakeObjectFactory {
    private static final PostRepository fakePostRepository = new FakePostRepository();
    private static final CommentRepository fakeCommentRepository = new FakeCommentRepository();
    private static final LikeRepository fakeLikeRepository = new FakeLikeRepository();

    private FakeObjectFactory() {
    }
}
