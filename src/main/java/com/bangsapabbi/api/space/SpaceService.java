package com.bangsapabbi.api.space;

import javax.ws.rs.client.Client;

import com.bangsapabbi.api.CoredataClient;
import com.bangsapabbi.api.common.AbstractService;
import com.bangsapabbi.api.common.ContainerImpl;
import com.google.gson.reflect.TypeToken;

/**
 * Service to handle spaces.
 */
public class SpaceService extends AbstractService<Space> {

    public SpaceService(final CoredataClient coredataClient,
                        final Client client,
                        final String baseUrl) {

        super(coredataClient, client, baseUrl, "spaces", Space.class,
                new TypeToken<ContainerImpl<Space>>() {
                }.getType());
    }
}
