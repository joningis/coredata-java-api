/*
 * Copyright 2015 Azazo
 *
 */
package com.bangsapabbi.api.nav;

import java.util.List;
import javax.ws.rs.client.Client;

import com.bangsapabbi.api.CoredataClient;
import com.bangsapabbi.api.common.AbstractService;
import com.bangsapabbi.api.common.ApiIterator;
import com.bangsapabbi.api.common.ContainerImpl;
import com.bangsapabbi.api.common.Insertable;
import com.bangsapabbi.api.user.User;
import com.google.common.collect.Lists;
import com.google.gson.reflect.TypeToken;

public class NavService extends AbstractService<Nav> {
    public NavService(final CoredataClient coredataClient,
                      final Client client,
                      final String baseUrl) {
        super(coredataClient, client, baseUrl, "nav", Nav.class,
                new TypeToken<ContainerImpl<Nav>>() {
                }.getType());
    }


    /**
     * Deleting a nav element is not supported using the v2 API.
     *
     * @param uuid
     */
    @Override
    public void delete(final String uuid) {
        throw new UnsupportedOperationException();
    }

    /**
     * Adding a nav element is not supported using the v2 API.
     *
     * @param value
     * @return
     */
    @Override
    public <S extends Insertable<Nav>> String add(final S value) {
        throw new UnsupportedOperationException();
    }

    /**
     * Override to increase readability.
     *
     * @param name The nav name to get.
     * @return Nav object.
     */
    public synchronized List<Nav> getAll(final String name) {
        return Lists.newArrayList(new ApiIterator<>(getCoredataClient().getNavService(),
                "/" + name, "nav"));
    }

    public synchronized Nav get(final String name) {
        return super.get(name);
    }

}
