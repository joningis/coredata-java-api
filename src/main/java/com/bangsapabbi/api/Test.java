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
import com.bangsapabbi.api.folder.Folder;
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
        String username = "Administrator";
        String password = "Administrator";
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

        Contact contact = new Contact();
        contact.setName("Jón Jónsson");
        contactService.add(contact);

        List<Project> projects = Lists.newArrayList(projectService.iterator());

        if (!projects.isEmpty()) {

            System.out.println("$$$$$$$$$$$$$$$$$$$");
            Folder folder = new Folder();
            if (!folder.isValidForPost()) {
                System.out.println(folder.getViolationsAsString());
            }
            folder.setTitle("hoff2");
            folder.setFilename("hoff2");
            folder.setParentUUID(projectService.getWorkspaceUUID(projects.get(0)));
            if (folder.isValidForPost()) {
                folderService.add(folder);
                System.out.println("Added folder");
            }
            System.out.println("$$$$$$$$$$$$$$$$$$$");


            File file = new File();

            file.setTitle("hoff2.png");
            file.setFilename("hoff2.png");
            file.setLocalPath("/tmp/hoff.png");
            // File can not have parent as Project, it has to be the workspace of project.
            file.setParent(folder.getUUID());

            try {
                fileService.upload(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }


            if (file.getUUID() != null) {
                Comment comment = new Comment();

                comment.setText("Test comment");
                comment.setParentUUID(file.getUUID());
                commentService.add(comment);
            }
        }
    }
}
