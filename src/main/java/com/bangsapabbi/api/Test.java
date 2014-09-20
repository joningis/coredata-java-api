/*
 * Copyright 2014 Azazo
 *
 */
package com.bangsapabbi.api;

import java.io.FileNotFoundException;
import java.util.List;

import com.bangsapabbi.api.comment.Comment;
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
import com.google.common.collect.Lists;

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

        List<Project> projects = Lists.newArrayList(projectService.iterator());

        File file = new File();
        if (!projects.isEmpty()) {

            file.setTitle("hoff.png");
            file.setFilename("hoff.png");
            file.setLocalPath("/tmp/hoff.png");
            // File can not have parent as Project, it has to be the workspace of project.
            file.setParent(projectService.getWorkspaceUUID(projects.get(0)));

            try {
                fileService.upload(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        if(file.getUUID() != null) {
            Comment comment = new Comment();

            comment.setText("Test comment");
            comment.setParentUUID(file.getUUID());
            commentService.add(comment);
        }
    }
}
