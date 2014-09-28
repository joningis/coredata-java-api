/*
 * Copyright 2014 Azazo
 *
 */
package com.bangsapabbi.api;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import com.bangsapabbi.api.comment.Comment;
import com.bangsapabbi.api.comment.CommentService;
import com.bangsapabbi.api.common.Search;
import com.bangsapabbi.api.common.SearchBuilder;
import com.bangsapabbi.api.common.Service;
import com.bangsapabbi.api.contact.Contact;
import com.bangsapabbi.api.file.File;
import com.bangsapabbi.api.file.FileService;
import com.bangsapabbi.api.folder.Folder;
import com.bangsapabbi.api.folder.FolderService;
import com.bangsapabbi.api.project.Project;
import com.bangsapabbi.api.project.ProjectService;
import com.bangsapabbi.api.space.Space;
import com.bangsapabbi.api.space.SpaceService;
import com.bangsapabbi.api.task.Task;
import com.bangsapabbi.api.task.TaskService;
import com.bangsapabbi.api.user.User;
import com.bangsapabbi.api.user.UserService;
import com.bangsapabbi.api.valuelist.ValueListService;
import com.bangsapabbi.api.valuelist.lists.ProjectStatus;
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
        final SpaceService spaceService = client.getSpaceService();


        //
        // Create projects
        // The first one with validation and comment on it.
        // The second one with builder.
        //
        createProjects(projectService, commentService, spaceService);


        //
        // Search for projects
        //
        searchForProjects(projectService);


        //
        // Iterate projects and print out tasks and files for each
        //
        iterateProjects(projectService);


        //
        // Iterate all users and print out files, tasks and projects for each.
        iterateUsers(userService);


        createFolderFileAndComment(projectService, fileService, folderService, commentService);


        updateEnums(valueListService);

    }

    private static void updateEnums(final ValueListService valueListService) {
        try {
            // Update existing
            valueListService.generateEnumForValuelist("phone_label");

            // Create new
            valueListService.generateEnumForValuelist("continent");
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private static void createFolderFileAndComment(final ProjectService projectService,
                                                   final FileService fileService,
                                                   final FolderService folderService,
                                                   final CommentService commentService) {
        List<Project> projects = Lists.newArrayList(projectService.iterator());

        if (!projects.isEmpty()) {
            Folder folder = new Folder();
            if (!folder.isValidForPost()) {
                System.out.println(folder.getViolationsAsString());
            }
            folder.setTitle("hoff folder");
            folder.setFilename("hoff folder");

            // Folders have to live under projects workspace.
            folder.setParentUUID(projectService.getWorkspaceUUID(projects.get(0)));

            if (folder.isValidForPost()) {
                folderService.add(folder);
                System.out.println("Added folder");
            }

            File file = new File();

            file.setTitle("hoff2.png");
            file.setFilename("hoff2.png");
            file.setLocalPath("/tmp/hoff.png");
            file.setParent(folder.getUUID());

            try {
                fileService.upload(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }


            if (file.getUUID() != null) {
                Comment comment = new Comment();

                comment.setText("I just love to make random comments on files");
                comment.setParentUUID(file.getUUID());
                commentService.add(comment);
            }
        }
    }

    private static void iterateProjects(final ProjectService projectService) {
        for (Project project : projectService) {
            System.out.println(project);

            for (File file : projectService.getFilesForProject(project)) {
                System.out.println(file);
            }
            for (Task task : projectService.getTaksForProject(project)) {
                System.out.println(task);
            }
        }
    }

    private static void iterateUsers(final UserService userService) {
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

    private static void searchForProjects(final ProjectService projectService) {
        Search search = SearchBuilder.newSearch()
                .titleStartsWith("Test")
                .createdGreaterThan(new Date(114, 1, 1))
                .limit(10)
                .create();

        List<Project> projects = projectService.search(search);

        for (Project project : projects) {

            System.out.println(project);
        }
    }

    private static void createProjects(final ProjectService projectService,
                                       final CommentService commentService,
                                       final SpaceService spaceService) {
        List<Space> spaces = Lists.newArrayList(spaceService.iterator());

        if (!spaces.isEmpty()) {
            Project project = new Project();
            project.setTitle("Test project");
            project.setParentUUID(spaces.get(0).getUUID());
            project.setStatus(ProjectStatus.ON_HOLD);
            project.setDueDate(new Date(2014 - 1900, 4, 20));
            project.setDescription("Project description");
            project.addTag("Party");
            project.addTag("Time");

            if (project.isValidForPost()) {
                projectService.add(project);
            } else {
                System.out.println(project.getViolationsAsString());
            }
            Comment comment = new Comment();
            comment.setText("Party time comment !!!");
            comment.setParentUUID(project.getUUID());
            commentService.add(comment);


            Project projectWithBuilder = Project.Builder()
                    .title("Test builder")
                    .parentUUID(spaces.get(0).getUUID())
                    .status(ProjectStatus.CLOSED)
                    .tags("Party", "Time")
                    .build();
            projectService.add(projectWithBuilder);
        }
        System.out.println();
    }
}
