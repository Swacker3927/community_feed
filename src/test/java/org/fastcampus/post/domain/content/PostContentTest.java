package org.fastcampus.post.domain.content;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class PostContentTest {
    @Test
    void givenContentLengthIsOK_whenCreated_thenReturnTextContent() {
        //  given
        String text = "This is a test";

        //  when
        PostContent content = new PostContent(text);

        //  then
        assertEquals(text, content.contentText);
    }

    @Test
    void givenContentLengthIsOver_whenCreated_thenThrowError() {
        //  given
        String content = "a".repeat(501);

        //  when, then
        assertThrows(IllegalArgumentException.class, () -> new PostContent(content));
    }

    @ParameterizedTest
    @ValueSource(strings = {"닭", "삵"})
    void givenContentLengthIsOverAndKorean_whenCreated_thenThrowError(String koreanWord) {
        //  given
        String content = koreanWord.repeat(501);

        //  when, then
        assertThrows(IllegalArgumentException.class, () -> new PostContent(content));
    }

    @Test
    void givenContentLengthIsUnder_whenCreated_thenThrowError() {
        //  given
        String content = "a".repeat(4);

        //  when, then
        assertThrows(IllegalArgumentException.class, () -> new PostContent(content));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void givenContentIsEmpty_whenCreated_thenThrowError(String value) {
        //  when, then
        assertThrows(IllegalArgumentException.class, () -> new PostContent(value));
    }

    @Test
    void givenContent_whenUpdateContent_thenReturnUpdatedContent() {
        //  given
        String content = "This is a test";
        PostContent postContent = new PostContent(content);
        String updatedContent = "This is an updated test";

        //  when
        postContent.updateContent(updatedContent);

        //  then
        assertEquals(updatedContent, postContent.contentText);
    }

    @Test
    void givenContent_whenUpdateContentLengthIsOver_thenThrowError() {
        //  given
        String content = "This is a test";
        PostContent postContent = new PostContent(content);
        String updatedContent = "a".repeat(501);

        //  when, then
        assertThrows(IllegalArgumentException.class, () -> postContent.updateContent(updatedContent));
    }

    @Test
    void givenContent_whenUpdateContentLengthIsUnder_thenThrowError() {
        //  given
        String content = "This is a test";
        PostContent postContent = new PostContent(content);
        String updatedContent = "a".repeat(4);

        //  when, then
        assertThrows(IllegalArgumentException.class, () -> postContent.updateContent(updatedContent));
    }
}
