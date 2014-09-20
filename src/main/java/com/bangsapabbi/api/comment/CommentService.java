package com.bangsapabbi.api.comment;

import javax.ws.rs.client.Client;

import com.bangsapabbi.api.CoredataClient;
import com.bangsapabbi.api.common.AbstractService;
import com.bangsapabbi.api.common.ContainerImpl;
import com.google.gson.reflect.TypeToken;

public class CommentService extends AbstractService<Comment> {
    public CommentService(final CoredataClient coredataClient,
                          final Client client,
                          final String baseUrl) {
        super(coredataClient, client, baseUrl, "comment", Comment.class,
                new TypeToken<ContainerImpl<Comment>>() {
                }.getType());
    }
}
