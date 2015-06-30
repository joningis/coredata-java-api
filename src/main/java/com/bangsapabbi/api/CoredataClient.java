/*
 * Copyright 2015 Azazo
 *
 */
package com.bangsapabbi.api;

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

public interface CoredataClient {
    ContactService getContactService();

    ProjectService getProjectService();

    SpaceService getSpaceService();

    FileService getFileService();

    TaskService getTaskService();

    ValueListService getValueListService();

    UserService getUserService();

    FolderService getFolderService();

    CommentService getCommentService();

    NavService getNavService();
}
