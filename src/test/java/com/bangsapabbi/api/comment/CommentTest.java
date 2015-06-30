package com.bangsapabbi.api.comment;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class CommentTest {

    @Test
    public void testSetAndGetUUID() throws Exception {
        final String UUID = "080982424";
        Comment comment = Comment.Builder().build();
        comment.setUUID(UUID);
        assertThat(comment.getUUID(), is(UUID));
    }

    @Test
    public void testSetAndGetText() throws Exception {
        final String text = "Text here";
        Comment comment = Comment.Builder().text(text).build();
        assertThat(comment.getText(), is(text));
    }
}