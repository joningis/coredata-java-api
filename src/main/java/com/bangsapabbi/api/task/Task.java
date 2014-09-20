package com.bangsapabbi.api.task;

import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.validation.ConstraintViolation;

import com.bangsapabbi.api.common.AbstractInsertableDTO;
import com.bangsapabbi.api.project.Project;
import com.bangsapabbi.api.space.Space;
import com.bangsapabbi.api.user.User;
import com.bangsapabbi.api.valuelist.lists.TaskStatus;
import com.google.common.collect.Lists;
import com.google.gson.annotations.SerializedName;

/**
 * DTO for tasks.
 * The following fields are not implemented (not sure if useful)
 * <p/>
 * {
 * "aspects": {},
 * "associated_contacts_id": [],
 * "dynatype": {
 * "caption_plural": "dynatypes_labels:Task_plural:",
 * "caption_singular": "dynatypes_labels:Task_singular:",
 * "id": "21625558-38fb-11e4-9725-6003088b5c52"
 * },
 * }
 * This could include tests if uuid's are like they should be
 * Could have separate validation for just a valid object and if object is valid for add
 * or update.
 */
public class Task extends AbstractInsertableDTO<Task> {

    @SerializedName("associated_users")
    private List<User> associatedUsers;

    /**
     * UUID's of contacts.
     */
    private List<String> contacts;

    @SerializedName("due_date")
    private Date dueDate;


    private Space space;

    private Project project;

    private String title;

    /**
     * Usernames of connected users.
     */
    @SerializedName("connected_users")
    private List<String> connectedUsers;

    @SerializedName("responsible_users")
    private List<User> responsibleUsers;

    private TaskStatus status;

    @SerializedName("status_message")
    private String statusMessage;

    private List<String> tags;

    public Task() {
        this.associatedUsers = Lists.newArrayList();
        this.contacts = Lists.newArrayList();
        this.connectedUsers = Lists.newArrayList();
    }

    public List<User> getAssociatedUsers() {
        return associatedUsers;
    }

    public void setAssociatedUsers(final List<User> associatedUsers) {
        this.associatedUsers = associatedUsers;
    }


    public List<String> getContacts() {
        return contacts;
    }

    public void setContacts(final List<String> contacts) {
        this.contacts = contacts;
    }


    @Override
    public Set<ConstraintViolation<Task>> getConstraintViolations() {
        return this.getConstraintViolations(this);
    }


    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(final Date dueDate) {
        this.dueDate = dueDate;
    }

    public Space getSpace() {
        return space;
    }

    public void setSpace(final Space space) {
        this.space = space;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(final Project project) {
        this.project = project;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public List<String> getConnectedUsers() {
        return connectedUsers;
    }

    public void setConnectedUsers(final List<String> connectedUsers) {
        this.connectedUsers = connectedUsers;
    }

    public List<User> getResponsibleUsers() {
        return responsibleUsers;
    }

    public void setResponsibleUsers(final List<User> responsibleUsers) {
        this.responsibleUsers = responsibleUsers;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(final TaskStatus status) {
        this.status = status;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(final String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(final List<String> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Task{" +
                "associatedUsers=" + associatedUsers +
                ", uuid='" + getUUID() + '\'' +
                ", contacts=" + contacts +
                ", description='" + getDescription() + '\'' +
                ", createdBy='" + getCreatedBy() + '\'' +
                ", modifiedBy='" + getModifiedBy() + '\'' +
                ", created=" + getCreated() +
                ", modified=" + getModified() +
                ", dueDate=" + dueDate +
                ", space=" + space +
                ", project=" + project +
                ", resourceUri='" + getResourceUri() + '\'' +
                ", title='" + title + '\'' +
                ", connectedUsers=" + connectedUsers +
                ", responsibleUsers=" + responsibleUsers +
                ", status=" + status +
                ", statusMessage='" + statusMessage + '\'' +
                ", tags=" + tags +
                ", type='" + getType() + '\'' +
                ", version='" + getVersion() + '\'' +
                '}';
    }
}
