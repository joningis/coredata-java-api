package com.bangsapabbi.api.comment;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

import com.google.gson.JsonElement;

public class CommentSerializerTest {

    @Test
    public void testSerialize() throws Exception {
        CommentSerializer commentSerializer = new CommentSerializer();
        Comment comment = Comment.Builder().text("Testtext").parentUUID("0984").build();

        JsonElement element = commentSerializer.serialize(comment, null, null);

        assertThat(element.toString(), is("{\"text\":\"Testtext\",\"doc_id\":\"0984\"}"));
    }
}