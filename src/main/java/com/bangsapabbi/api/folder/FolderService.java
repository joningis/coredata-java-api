package com.bangsapabbi.api.folder;

import javax.ws.rs.client.Client;

import com.bangsapabbi.api.CoredataClient;
import com.bangsapabbi.api.common.AbstractV1Service;
import com.bangsapabbi.api.common.Insertable;

public class FolderService extends AbstractV1Service<Folder> {
    public FolderService(final CoredataClient coredataClient,
                         final Client client,
                         final String baseUrl) {
        super(coredataClient, client, baseUrl, "docs", Folder.class, null);
    }


    @Override
    public Folder get(final String uuid) {
        final Folder value = super.get(uuid);
        if (value.getType().equals("Folder")) {
            return value;
        } else {
            return null;
        }

    }
}
