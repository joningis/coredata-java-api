/*
 * Copyright 2014 Azazo
 *
 */
package com.bangsapabbi.api.project;

import java.lang.reflect.Type;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class ProjectSerializer implements JsonSerializer<Project> {
    @Override
    public JsonElement serialize(final Project project,
                                 final Type typeOfSrc,
                                 final JsonSerializationContext context) {
        final JsonObject returnValue = new JsonObject();

        returnValue.addProperty("title", project.getTitle());
        returnValue.addProperty("type", "Project");
        returnValue.addProperty("space", project.getParentUUID());

        return returnValue;
    }
}
