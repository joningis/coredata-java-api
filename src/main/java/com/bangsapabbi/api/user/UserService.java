package com.bangsapabbi.api.user;

import java.util.List;
import javax.ws.rs.client.Client;

import com.bangsapabbi.api.CoredataClient;
import com.bangsapabbi.api.common.ApiDTO;
import com.bangsapabbi.api.common.ContainerImpl;
import com.bangsapabbi.api.common.AbstractService;
import com.bangsapabbi.api.common.ApiIterator;
import com.bangsapabbi.api.common.Insertable;
import com.bangsapabbi.api.file.File;
import com.bangsapabbi.api.project.Project;
import com.bangsapabbi.api.task.Task;
import com.google.common.collect.Lists;
import com.google.gson.reflect.TypeToken;

public class UserService extends AbstractService<User> {


    public UserService(final CoredataClient coredataClient,
                       final Client client,
                       final String baseUrl) {
        super(coredataClient, client, baseUrl, "user", User.class,
                new TypeToken<ContainerImpl<User>>() {}.getType());
    }

    /**
     * Deleting a user is not supported using the v2 API.
     *
     * @param uuid
     */
    @Override
    public void delete(final String uuid) {
        throw new UnsupportedOperationException();
    }

    /**
     * Adding a user is not supported using the v2 API.
     *
     * @param value
     * @return
     */
    @Override
    public <S extends Insertable<User>> String add(final S value) {
        throw new UnsupportedOperationException();
    }

    /**
     * Override to increase readability.
     *
     * @param username The username to get user object for.
     * @return User object.
     */
    @Override
    public User get(final String username) {
        return super.get(username);
    }

    public List<File> getFilesForUser(final User user) {
        return Lists.newArrayList(new ApiIterator<>(getCoredataClient().getFileService(),
                "/" + user.getUsername() + "/files", "user"));
    }

    public List<Task> getTasksForUser(final User user) {
        return Lists.newArrayList(new ApiIterator<>(getCoredataClient().getTaskService(),
                "/" + user.getUsername() + "/tasks", "user"));
    }


    public List<Project> getProjectsForUser(final User user) {
        return Lists.newArrayList(new ApiIterator<>(getCoredataClient().getProjectService(),
                "/" + user.getUsername() + "/projects", "user"));
    }


}
