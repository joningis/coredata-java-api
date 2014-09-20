package com.bangsapabbi.api.project;

import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import com.bangsapabbi.api.CoredataClient;
import com.bangsapabbi.api.common.AbstractService;
import com.bangsapabbi.api.common.ApiIterator;
import com.bangsapabbi.api.common.ContainerImpl;
import com.bangsapabbi.api.file.File;
import com.google.common.collect.Lists;
import com.google.gson.reflect.TypeToken;

/**
 * Service to handle projects.
 */
public class ProjectService extends AbstractService<Project> {

    public ProjectService(final CoredataClient coredataClient,
                          final Client client,
                          final String baseUrl) {
        super(coredataClient, client, baseUrl, "projects", Project.class,
                new TypeToken<ContainerImpl<Project>>() {
                }.getType());
    }

    public List<? extends File> getFilesForProject(final Project project) {
        final List<File> returnValue = Lists.newArrayList();

        final ApiIterator<File> projectFileIterator
                = new ApiIterator<>(getCoredataClient().getFileService(),
                "/" + project.getUUID() + "/files", "projects");
        while (projectFileIterator.hasNext()) {
            returnValue.add(projectFileIterator.next());
        }
        return returnValue;

    }

    public String getWorkspaceUUID(final Project project) {
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
}
