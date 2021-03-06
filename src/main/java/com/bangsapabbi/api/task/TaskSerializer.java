package com.bangsapabbi.api.task;

import java.lang.reflect.Type;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;


public class TaskSerializer implements JsonSerializer<Task> {


    @Override
    public JsonElement serialize(final Task task,
                                 final Type typeOfSrc,
                                 final JsonSerializationContext context) {

        final JsonObject returnValue = new JsonObject();

        returnValue.addProperty("project", task.getParentUUID());
        returnValue.addProperty("title", task.getTitle());

        return returnValue;
    }
}
