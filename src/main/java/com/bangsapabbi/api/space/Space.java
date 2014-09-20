package com.bangsapabbi.api.space;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

import com.bangsapabbi.api.common.ApiDTO;
import com.bangsapabbi.api.valuelist.lists.SpaceStatus;
import com.google.gson.annotations.SerializedName;

/**
 * DTO for space.
 */
public class Space implements ApiDTO {

    @SerializedName("id")
    private String uuid;
    private String title;
    private String description;

    @SerializedName("resource_uri")
    private String resourceUri;

    private String type;

    private String version;

    private List<String> tags;

    @SerializedName("created_by")
    private String createdBy;

    @SerializedName("modified_by")
    private String modifiedBy;

    private Date created;

    private Date modified;

    private SpaceStatus status;

    public String getUUID() {
        return uuid;
    }

    public void setUUID(final String uuid) {
        this.uuid = uuid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public String getResourceUri() {
        return resourceUri;
    }

    public void setResourceUri(final String resourceUri) {
        this.resourceUri = resourceUri;
    }

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(final String version) {
        this.version = version;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(final List<String> tags) {
        this.tags = tags;
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

    public SpaceStatus getStatus() {
        return status;
    }

    public void setStatus(final SpaceStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Space{" +
                "uuid='" + uuid + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
