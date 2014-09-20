package com.bangsapabbi.api.folder;

import com.bangsapabbi.api.common.ApiDTO;
import com.bangsapabbi.api.project.Project;
import com.google.gson.annotations.SerializedName;

/**
 * DTO for Folder.
 * At the moment a lot of stuff related to folders is done using api v1
 */
public class Folder implements ApiDTO {

    @SerializedName("id")
    private String uuid;

    private String title;

    private String filename;

    private String description;

    private String type = "Folder";

    @SerializedName("created_by")
    private String createdBy;

    @SerializedName("modified_by")
    private String modifiedBy;

    /**
     * Date in strange format.
     */
    private String created;

    /**
     * Date in strange format.
     */
    private String modified;


    private String version;

    @SerializedName("resource_uri")
    private String resourceUri;
    private String parent;
    private Project projectParent;


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

    public String getFilename() {
        return filename;
    }

    public void setFilename(final String filename) {
        this.filename = filename;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
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

    public String getCreated() {
        return created;
    }

    public void setCreated(final String created) {
        this.created = created;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(final String modified) {
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

    public String getParent() {
        return parent;
    }


    public void setParent(final String parent) {
        this.parent = parent;
        if (this.projectParent != null) {
            this.projectParent = null;
        }
    }

    public void setParent(final Project project) {
        this.projectParent = project;
        if (this.parent != null) {
            this.parent = null;
        }
    }

    public Project getParentProject() {
        return projectParent;
    }
}
