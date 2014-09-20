package com.bangsapabbi.api.comment;

import java.util.Date;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.constraints.NotNull;

import com.bangsapabbi.api.common.AbstractValidateableDTO;
import com.bangsapabbi.api.common.ApiDTO;
import com.bangsapabbi.api.common.Insertable;
import com.bangsapabbi.api.common.validation.UUID;
import com.bangsapabbi.api.common.validation.UUIDValidator;
import com.google.gson.annotations.SerializedName;

public class Comment extends AbstractValidateableDTO<Comment> implements Insertable<Comment> {

    private String author;

    @SerializedName("doc_id")
    @UUID(message = "Invalid parent ID, must match " + UUIDValidator.UUID_REGEX)
    private String parentUUID;

    @SerializedName("id")
    private String uuid;

    @SerializedName("resource_uri")
    private String resourceUri;

    @NotNull
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

    @Override
    public Set<ConstraintViolation<Comment>> getConstraintViolations() {
        return this.getConstraintViolations(this);
    }

}
