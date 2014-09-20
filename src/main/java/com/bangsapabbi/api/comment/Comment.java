package com.bangsapabbi.api.comment;

import java.util.Date;

import com.bangsapabbi.api.common.ApiDTO;
import com.google.gson.annotations.SerializedName;

public class Comment implements ApiDTO {

    private String author;

    @SerializedName("doc_id")
    private String parentUUID;

    @SerializedName("id")
    private String uuid;

    @SerializedName("resource_uri")
    private String resourceUri;

    private String text;

    private Date time;

    @Override
    public void setUUID(final String uuid) {
        this.uuid = uuid;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(final String author) {
        this.author = author;
    }

    public String getParentUUID() {
        return parentUUID;
    }

    public void setParentUUID(final String parentUUID) {
        this.parentUUID = parentUUID;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(final String uuid) {
        this.uuid = uuid;
    }

    public String getResourceUri() {
        return resourceUri;
    }

    public void setResourceUri(final String resourceUri) {
        this.resourceUri = resourceUri;
    }

    public String getText() {
        return text;
    }

    public void setText(final String text) {
        this.text = text;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(final Date time) {
        this.time = time;
    }
}
