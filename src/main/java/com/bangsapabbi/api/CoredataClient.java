package com.bangsapabbi.api;

import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;

import javax.ws.rs.client.Client;

import com.bangsapabbi.api.comment.CommentService;
import com.bangsapabbi.api.contact.ContactService;
import com.bangsapabbi.api.file.FileService;
import com.bangsapabbi.api.folder.FolderService;
import com.bangsapabbi.api.project.ProjectService;
import com.bangsapabbi.api.space.SpaceService;
import com.bangsapabbi.api.task.TaskService;
import com.bangsapabbi.api.user.UserService;
import com.bangsapabbi.api.valuelist.ValueListService;

/**
 * The main entry point to the api.
 */
public class CoredataClient {

    private final String baseUrl;
    private final Client client;
    private ContactService contactService;
    private ProjectService projectService;
    private SpaceService spaceService;
    private FileService fileService;
    private TaskService taskService;
    private ValueListService valueListService;
    private UserService userService;
    private FolderService folderService;
    private CommentService commentService;

    protected CoredataClient(final String baseUrl,
                             final String username,
                             final String password) {
        this.baseUrl = baseUrl;
        this.client = javax.ws.rs.client.ClientBuilder.newClient();

        final HttpAuthenticationFeature feature = HttpAuthenticationFeature.basicBuilder()
                .nonPreemptive().credentials(username, password).build();
        client.register(feature);
    }


    public ContactService getContactService() {
        if (this.contactService == null) {
            this.contactService = new ContactService(this, this.client, this.baseUrl);
        }
        return this.contactService;
    }

    public ProjectService getProjectService() {
        if (this.projectService == null) {
            this.projectService = new ProjectService(this, this.client, this.baseUrl);
        }
        return this.projectService;
    }

    public SpaceService getSpaceService() {
        if (this.spaceService == null) {
            this.spaceService = new SpaceService(this, this.client, this.baseUrl);
        }
        return this.spaceService;
    }

    public FileService getFileService() {
        if (this.fileService == null) {
            this.fileService = new FileService(this, this.client, this.baseUrl);
        }
        return this.fileService;
    }

    public TaskService getTaskService() {
        if (this.taskService == null) {
            this.taskService = new TaskService(this, this.client, this.baseUrl);
        }
        return taskService;
    }

    public ValueListService getValueListService() {
        if (this.valueListService == null) {
            this.valueListService = new ValueListService(this, this.client, this.baseUrl);
        }
        return valueListService;
    }

    public UserService getUserService() {
        if (this.userService == null) {
            this.userService = new UserService(this, this.client, this.baseUrl);
        }
        return userService;
    }

    public FolderService getFolderService() {
        if (this.folderService == null) {
            this.folderService = new FolderService(this, this.client, this.baseUrl);
        }
        return folderService;
    }

    public CommentService getCommentService() {
        if (this.commentService == null) {
            this.commentService = new CommentService(this, this.client, this.baseUrl);
        }
        return this.commentService;
    }
}
