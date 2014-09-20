/*
 * Copyright 2014 Azazo
 *
 */
package com.bangsapabbi.api.folder;

import java.lang.reflect.Type;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class FolderSerializer implements JsonSerializer<Folder> {
    @Override
    public JsonElement serialize(final Folder folder,
                                 final Type typeOfSrc,
                                 final JsonSerializationContext context) {

        JsonObject returnValue = new JsonObject();

        returnValue.addProperty("filename", folder.getFilename());
        returnValue.addProperty("title", folder.getTitle());
        returnValue.addProperty("description", folder.getDescription());
        returnValue.addProperty("type", folder.getType());

        return returnValue;
    }
}
