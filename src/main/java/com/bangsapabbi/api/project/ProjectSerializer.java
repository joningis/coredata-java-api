package com.bangsapabbi.api.project;

import java.lang.reflect.Type;

import com.bangsapabbi.api.common.DateUtil;
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
        returnValue.add("status", context.serialize(project.getStatus()));
        if(project.getDueDate() != null) {
            returnValue.addProperty("due_date",
                    DateUtil.getFromDate(project.getDueDate(), "yyyy-MM-dd"));
        }
        returnValue.addProperty("description", project.getDescription());
        returnValue.add("tags", context.serialize(project.getTags()));


        return returnValue;
    }
}
