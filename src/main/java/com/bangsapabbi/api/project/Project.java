package com.bangsapabbi.api.project;

import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.constraints.NotNull;

import com.bangsapabbi.api.common.AbstractInsertableDTO;
import com.bangsapabbi.api.space.Space;
import com.bangsapabbi.api.user.User;
import com.bangsapabbi.api.valuelist.lists.ProjectStatus;
import com.google.common.collect.Lists;
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

    public Project() {
        this.tags = Lists.newArrayList();
    }

    public ProjectStatus getStatus() {
        return status;
    }

    public void setStatus(final ProjectStatus status) {
        this.status = status;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(final Date dueDate) {
        this.dueDate = dueDate;
    }

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

    public List<String> getTags() {
        return tags;
    }

    public void addTag(final String tag) {
        this.tags.add(tag);
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

    public static Builder Builder() {
        return new Builder();
    }


    public static class Builder {
        private final Project project;

        private Builder() {
            project = new Project();
        }

        public Builder status(ProjectStatus status) {
            project.setStatus(status);
            return this;
        }

        public Builder title(String title) {
            project.setTitle(title);
            return this;
        }

        public Builder dueDate(Date dueDate) {
            project.setDueDate(dueDate);
            return this;
        }

        public Builder workspaceUUID(String workspaceUUID) {
            project.setWorkspaceUUID(workspaceUUID);
            return this;
        }

        public Builder parentUUID(String parentUUID) {
            project.setParentUUID(parentUUID);
            return this;
        }

        public Builder description(String description) {
            project.setDescription(description);
            return this;
        }

        public Project build() {
            return project;
        }
    }
}
