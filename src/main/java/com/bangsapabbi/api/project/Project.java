package com.bangsapabbi.api.project;

import java.util.Date;
import java.util.List;

import com.bangsapabbi.api.common.ApiDTO;
import com.bangsapabbi.api.space.Space;
import com.bangsapabbi.api.user.User;
import com.bangsapabbi.api.valuelist.lists.ProjectStatus;
import com.google.gson.annotations.SerializedName;

/**
 * DTO for project.
 * <p/>
 * This could be the case if we get a task then we only get basic info about project.
 * Hugsanlega hægt að skoða hvort type sé tómt og ef svo er loada, það ætti alltaf að koma í standard get
 */
public class Project implements ApiDTO {

    @SerializedName("id")
    private String uuid;
    private ProjectStatus status;
    private String title;

    private String identifier;

    /**
     * Usernames of connected users.
     */
    @SerializedName("connected_users")
    private List<String> connectedUsers;

    @SerializedName("associated_users")
    private List<User> associatedUsers;

    /**
     * UUID's of contacts.
     */
    private List<String> contacts;

    private String description;

    @SerializedName("created_by")
    private String createdBy;

    @SerializedName("modified_by")
    private String modifiedBy;

    private Date created;

    private Date modified;

    @SerializedName("due_date")
    private Date dueDate;

    @SerializedName("responsible_users")
    private List<User> responsibleUsers;

    @SerializedName("resource_uri")
    private String resourceUri;

    private Space space;

    @SerializedName("status_message")
    private String statusMessage;

    private List<String> tags;

    private String type;

    private String version;
    private String workspaceUUID;

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }


    public String getUUID() {
        return this.uuid;
    }

    public void setUUID(final String value) {
        this.uuid = value;
    }

    @Override
    public String toString() {
        return "Project{" +
                "uuid='" + uuid + '\'' +
                ", status=" + status +
                ", title='" + title + '\'' +
                ", identifier='" + identifier + '\'' +
                ", connectedUsers=" + connectedUsers +
                ", associatedUsers=" + associatedUsers +
                ", contacts=" + contacts +
                ", description='" + description + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", modifiedBy='" + modifiedBy + '\'' +
                ", created=" + created +
                ", modified=" + modified +
                ", dueDate=" + dueDate +
                ", responsibleUsers=" + responsibleUsers +
                ", resourceUri='" + resourceUri + '\'' +
                ", space=" + space +
                ", statusMessage='" + statusMessage + '\'' +
                ", tags=" + tags +
                ", type='" + type + '\'' +
                ", version='" + version + '\'' +
                '}';
    }

    public void setWorkspaceUUID(final String workspaceUUID) {
        this.workspaceUUID = workspaceUUID;
    }

    public String getWorkspaceUUID() {
        return workspaceUUID;
    }
}
