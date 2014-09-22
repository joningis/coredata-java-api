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

    public void setUUID(final String uuid) {
        this.uuid = uuid;
    }

    public String getUUID() {
        return uuid;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getResourceUri() {
        return resourceUri;
    }

    public String getType() {
        return type;
    }

    public String getVersion() {
        return version;
    }

    public List<String> getTags() {
        return tags;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public Date getCreated() {
        return created;
    }

    public Date getModified() {
        return modified;
    }

    public SpaceStatus getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Space{" +
                "uuid='" + uuid + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", resourceUri='" + resourceUri + '\'' +
                ", type='" + type + '\'' +
                ", version='" + version + '\'' +
                ", tags=" + tags +
                ", createdBy='" + createdBy + '\'' +
                ", modifiedBy='" + modifiedBy + '\'' +
                ", created=" + created +
                ", modified=" + modified +
                ", status=" + status +
                '}';
    }
}
