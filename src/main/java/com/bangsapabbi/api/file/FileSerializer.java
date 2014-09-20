package com.bangsapabbi.api.file;

import java.lang.reflect.Type;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class FileSerializer implements JsonSerializer<File> {
    @Override
    public JsonElement serialize(final File file,
                                 final Type typeOfSrc,
                                 final JsonSerializationContext context) {
        final JsonObject returnValue = new JsonObject();

        returnValue.addProperty("title", file.getTitle());
        returnValue.addProperty("filename", file.getFilename());
        returnValue.addProperty("type", "File");

        return returnValue;
    }
}
