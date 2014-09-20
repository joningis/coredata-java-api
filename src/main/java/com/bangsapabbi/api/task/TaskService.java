package com.bangsapabbi.api.task;

import javax.ws.rs.client.Client;

import com.bangsapabbi.api.CoredataClient;
import com.bangsapabbi.api.common.ContainerImpl;
import com.bangsapabbi.api.common.AbstractService;
import com.google.gson.reflect.TypeToken;

public class TaskService extends AbstractService<Task> {

    public TaskService(final CoredataClient coredataClient,
                       final Client client,
                       final String baseUrl) {
        super(coredataClient, client, baseUrl, "tasks", Task.class,
                new TypeToken<ContainerImpl<Task>>() {}.getType());
    }
}
