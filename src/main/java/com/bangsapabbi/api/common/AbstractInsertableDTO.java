package com.bangsapabbi.api.common;

import java.util.Date;

import com.bangsapabbi.api.common.validation.UUID;
import com.bangsapabbi.api.common.validation.UUIDValidator;
import com.google.gson.annotations.SerializedName;

public abstract class AbstractInsertableDTO<T> extends AbstractValidateableDTO<T> implements Insertable<T> {

    @SerializedName("id")
    private String uuid;

    @UUID(message = "Invalid parent ID, must match " + UUIDValidator.UUID_REGEX)
    private String parentUUID;

    private String description;

    private String type;

    private String version;

    @SerializedName("resource_uri")
    private String resourceUri;


    @SerializedName("created_by")
    private String createdBy;

    @SerializedName("modified_by")
    private String modifiedBy;

    /**
     * Date in strange format.
     */
    private Date created;

    /**
     * Date in strange format.
     */
    private Date modified;


    public String getUUID() {
        return uuid;
    }

    public void setUUID(final String uuid) {
        this.uuid = uuid;
    }

    public String getParentUUID() {
        return parentUUID;
    }


    public void setParentUUID(final String parentUUID) {
        this.parentUUID = parentUUID;
    }


    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(final String createdBy) {
        this.createdBy = createdBy;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(final String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(final Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(final Date modified) {
        this.modified = modified;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(final String version) {
        this.version = version;
    }

    public String getResourceUri() {
        return resourceUri;
    }

    public void setResourceUri(final String resourceUri) {
        this.resourceUri = resourceUri;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }
}
