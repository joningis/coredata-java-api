package com.bangsapabbi.api.comment;

import java.util.Date;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.constraints.NotNull;

import com.bangsapabbi.api.common.AbstractValidateableDTO;
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

    private Comment() {

    }

    @Override
    public void setUUID(final String uuid) {
        this.uuid = uuid;
    }

    @Override
    public String getUUID() {
        return this.uuid;
    }

    public String getAuthor() {
        return author;
    }

    public String getParentUUID() {
        return parentUUID;
    }

    private void setParentUUID(final String parentUUID) {
        this.parentUUID = parentUUID;
    }

    public String getResourceUri() {
        return resourceUri;
    }

    public String getText() {
        return text;
    }

    private void setText(final String text) {
        this.text = text;
    }

    public Date getTime() {
        return (Date)time.clone();
    }

    @Override
    public Set<ConstraintViolation<Comment>> getConstraintViolations() {
        return this.getConstraintViolations(this);
    }

    public static Builder Builder() {
        return new Builder();
    }


    public static class Builder {
        private final Comment comment;

        private Builder() {
            this.comment = new Comment();
        }

        public Builder text(String text) {
            this.comment.setText(text);
            return this;
        }

        public Builder parentUUID(String docId) {
            this.comment.setParentUUID(docId);
            return this;
        }

        public Comment build() {
            return comment;
        }
    }

}
