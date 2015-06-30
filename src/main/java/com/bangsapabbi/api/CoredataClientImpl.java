package com.bangsapabbi.api;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import org.glassfish.jersey.client.spi.Connector;

import javax.ws.rs.client.Client;

import com.bangsapabbi.api.comment.CommentService;
import com.bangsapabbi.api.contact.ContactService;
import com.bangsapabbi.api.file.FileService;
import com.bangsapabbi.api.folder.FolderService;
import com.bangsapabbi.api.nav.NavService;
import com.bangsapabbi.api.project.ProjectService;
import com.bangsapabbi.api.space.SpaceService;
import com.bangsapabbi.api.task.TaskService;
import com.bangsapabbi.api.user.UserService;
import com.bangsapabbi.api.valuelist.ValueListService;

/**
 * The main entry point to the api.
 */
public class CoredataClientImpl implements CoredataClient {

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
    private NavService navService;

    protected CoredataClientImpl(final String baseUrl,
                                 final String username,
                                 final String password) {
        this.baseUrl = baseUrl;

        this.client = javax.ws.rs.client.ClientBuilder.newClient();

        final HttpAuthenticationFeature feature =
                HttpAuthenticationFeature.basic(username, password);

        client.register(feature);
    }


    @Override
    public ContactService getContactService() {
        if (this.contactService == null) {
            this.contactService = new ContactService(this, this.client, this.baseUrl);
        }
        return this.contactService;
    }

    @Override
    public ProjectService getProjectService() {
        if (this.projectService == null) {
            this.projectService = new ProjectService(this, this.client, this.baseUrl);
        }
        return this.projectService;
    }

    @Override
    public SpaceService getSpaceService() {
        if (this.spaceService == null) {
            this.spaceService = new SpaceService(this, this.client, this.baseUrl);
        }
        return this.spaceService;
    }

    @Override
    public FileService getFileService() {
        if (this.fileService == null) {
            this.fileService = new FileService(this, this.client, this.baseUrl);
        }
        return this.fileService;
    }

    @Override
    public TaskService getTaskService() {
        if (this.taskService == null) {
            this.taskService = new TaskService(this, this.client, this.baseUrl);
        }
        return taskService;
    }

    @Override
    public ValueListService getValueListService() {
        if (this.valueListService == null) {
            this.valueListService = new ValueListService(this, this.client, this.baseUrl);
        }
        return valueListService;
    }

    @Override
    public UserService getUserService() {
        if (this.userService == null) {
            this.userService = new UserService(this, this.client, this.baseUrl);
        }
        return userService;
    }

    @Override
    public FolderService getFolderService() {
        if (this.folderService == null) {
            this.folderService = new FolderService(this, this.client, this.baseUrl);
        }
        return folderService;
    }

    @Override
    public CommentService getCommentService() {
        if (this.commentService == null) {
            this.commentService = new CommentService(this, this.client, this.baseUrl);
        }
        return this.commentService;
    }

    @Override
    public NavService getNavService() {
        if(this.navService == null) {
            this.navService = new NavService(this, this.client, this.baseUrl);
        }
        return this.navService;
    }
}
