package com.bangsapabbi.api.project;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.constraints.NotNull;

import com.bangsapabbi.api.common.AbstractInsertableDTO;
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
public class Project extends AbstractInsertableDTO<Project> {

    private ProjectStatus status;

    @NotNull
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


    @SerializedName("due_date")
    private Date dueDate;

    @SerializedName("responsible_users")
    private List<User> responsibleUsers;

    private Space space;

    @SerializedName("status_message")
    private String statusMessage;

    private List<String> tags;

    private String workspaceUUID;

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public void setWorkspaceUUID(final String workspaceUUID) {
        this.workspaceUUID = workspaceUUID;
    }

    public String getWorkspaceUUID() {
        return workspaceUUID;
    }

    @Override
    public Set<ConstraintViolation<Project>> getConstraintViolations() {
        return this.getConstraintViolations(this);
    }

    @Override
    public String toString() {
        return "Project{" +
                "uuid='" + getUUID() + '\'' +
                ", status=" + status +
                ", title='" + title + '\'' +
                ", identifier='" + identifier + '\'' +
                ", connectedUsers=" + connectedUsers +
                ", associatedUsers=" + associatedUsers +
                ", contacts=" + contacts +
                ", description='" + getDescription() + '\'' +
                ", createdBy='" + getCreatedBy() + '\'' +
                ", modifiedBy='" + getModifiedBy() + '\'' +
                ", created=" + getCreated() +
                ", modified=" + getModified() +
                ", dueDate=" + dueDate +
                ", responsibleUsers=" + responsibleUsers +
                ", resourceUri='" + getResourceUri() + '\'' +
                ", space=" + space +
                ", statusMessage='" + statusMessage + '\'' +
                ", tags=" + tags +
                ", type='" + getType() + '\'' +
                ", version='" + getVersion() + '\'' +
                '}';
    }
}
