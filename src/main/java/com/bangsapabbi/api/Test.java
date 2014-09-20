/*
 * Copyright 2014 Azazo
 *
 */
package com.bangsapabbi.api;

import com.bangsapabbi.api.comment.CommentService;
import com.bangsapabbi.api.common.Service;
import com.bangsapabbi.api.contact.Contact;
import com.bangsapabbi.api.file.File;
import com.bangsapabbi.api.file.FileService;
import com.bangsapabbi.api.folder.FolderService;
import com.bangsapabbi.api.project.Project;
import com.bangsapabbi.api.project.ProjectService;
import com.bangsapabbi.api.task.Task;
import com.bangsapabbi.api.task.TaskService;
import com.bangsapabbi.api.user.User;
import com.bangsapabbi.api.user.UserService;
import com.bangsapabbi.api.valuelist.ValueListService;

public class Test {
    public static void main(String[] args) {
        String username = "";
        String password = "";
        final CoredataClient client = ClientBuilder.newClient(
                "http://localhost:8100", username, password);


        final ProjectService projectService = client.getProjectService();
        final FileService fileService = client.getFileService();
        final TaskService taskService = client.getTaskService();
        final ValueListService valueListService = client.getValueListService();
        final UserService userService = client.getUserService();
        final FolderService folderService = client.getFolderService();
        final Service<Contact> contactService = client.getContactService();
        final CommentService commentService = client.getCommentService();

        for (User user : userService) {
            System.out.println(user);

            System.out.println("=======");
            for (File file : userService.getFilesForUser(user)) {
                System.out.println(file);
            }
            System.out.println("----");
            for (Task task : userService.getTasksForUser(user)) {
                System.out.println(task);
            }
            System.out.println("----");
            for (Project project : userService.getProjectsForUser(user)) {
                System.out.println(project);
            }
            System.out.println("----");

        }
    }
}
