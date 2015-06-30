/*
 * Copyright 2014 Azazo
 *
 */
package com.bangsapabbi.api.comment;

import java.lang.reflect.Type;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class CommentSerializer implements JsonSerializer<Comment> {
    @Override
    public JsonElement serialize(final Comment comment,
                                 final Type typeOfSrc,
                                 final JsonSerializationContext context) {

        final JsonObject returnValue = new JsonObject();

        returnValue.addProperty("text", comment.getText());
        returnValue.addProperty("doc_id", comment.getParentUUID());

        return returnValue;
    }
}