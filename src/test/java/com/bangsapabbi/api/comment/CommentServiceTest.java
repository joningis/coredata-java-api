package com.bangsapabbi.api.comment;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CommentServiceTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testDeleteComment() {
        CommentService service = new CommentService(null, null, null);

        expectedException.expect(UnsupportedOperationException.class);
        expectedException.expectMessage("Deletion of comments is not supported");

        service.delete("035-24-sff");
    }
/*
    @Test
    public void testAddComment() {
        CommentService service = new CommentService(null, null, null);


        Comment comment = Comment.Builder().text("add comment").parentUUID("42-561").build();

        service.add(comment);


    }
*/
}