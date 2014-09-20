package com.bangsapabbi.api.contact;

import javax.ws.rs.client.Client;

import com.bangsapabbi.api.CoredataClient;
import com.bangsapabbi.api.common.AbstractService;
import com.bangsapabbi.api.common.ContainerImpl;
import com.google.gson.reflect.TypeToken;

/**
 * Service to handle contacts.
 */
public class ContactService extends AbstractService<Contact> {

    public ContactService(final CoredataClient coredataClient,
                          final Client client,
                          final String baseUrl) {
        super(coredataClient, client, baseUrl, "contacts", Contact.class,
                new TypeToken<ContainerImpl<Contact>>() {
                }.getType());
    }
}
