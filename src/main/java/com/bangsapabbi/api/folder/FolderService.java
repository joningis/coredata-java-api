package com.bangsapabbi.api.folder;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import com.bangsapabbi.api.CoredataClient;
import com.bangsapabbi.api.common.AbstractV1Service;
import com.bangsapabbi.api.project.Project;

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

    @Override
    public String add(final Folder value) {
        if (value.getParentProject() != null) {
            value.setParent(findProjectWorkspace(value.getParentProject()));
        }
        return super.add(value);
    }

    private String findProjectWorkspace(final Project project) {
        if (project.getWorkspaceUUID() == null) {
            final WebTarget myResource = client.target(baseUrl + "/api/document/"
                    + project.getUUID() + "/children/");
            final String response = myResource.request(MediaType.TEXT_PLAIN).get(String.class);

            final String workspaceId = response.split("\"type\": \"Workspace\"")[1].split("}")[0]
                    .split("\"id\": \"")[1].split("\"")[0];
            project.setWorkspaceUUID(workspaceId);
        }
        return project.getWorkspaceUUID();

    }

    @Override
    protected String getParent(final Folder value) {
        return value.getParent();
    }
}
