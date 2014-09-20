package com.bangsapabbi.api.project;

import java.util.List;
import javax.ws.rs.client.Client;

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
        List<File> returnValue = Lists.newArrayList();

        ApiIterator<File> projectFileIterator
                = new ApiIterator<>(getCoredataClient().getFileService(),
                "/" + project.getUUID() + "/files", "projects");
        while (projectFileIterator.hasNext()) {
            returnValue.add(projectFileIterator.next());
        }
        return returnValue;

    }
}
