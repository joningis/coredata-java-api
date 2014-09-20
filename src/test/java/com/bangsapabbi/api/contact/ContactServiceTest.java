/*
 * Copyright 2014 Azazo
 *
 */
package com.bangsapabbi.api.contact;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.MediaType;

/**
 * Unit tests for ContactService.
 */
public class ContactServiceTest {

    @Test
    public void testAdd() {
        /*
        Client client = mock(Client.class);
        String baseUrl = "http://localhost:42";
        WebTarget target = mock(WebTarget.class);
        Invocation.Builder builder = mock(Invocation.Builder.class);
        when(client.target(anyString())).thenReturn(target);
        when(target.request(any(MediaType.class))).thenReturn(builder);


        ContactService service = new ContactService(null, client, baseUrl);

        Contact contact = new Contact();
        contact.setName("John");


        ArgumentCaptor<Entity> argument = ArgumentCaptor.forClass(Entity.class);

        service.add(contact);

        verify(builder, times(1)).post(argument.capture());

        assertThat(argument.getAllValues().get(0).getEntity().toString(),
                is("{\"title\":\"John\"}"));
                */
    }
}
