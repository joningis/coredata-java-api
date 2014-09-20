package com.bangsapabbi.api.file;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.bangsapabbi.api.CoredataClient;
import com.bangsapabbi.api.common.AbstractService;
import com.bangsapabbi.api.common.ContainerImpl;
import com.google.gson.reflect.TypeToken;

public class FileService extends AbstractService<File> {

    public FileService(final CoredataClient coredataClient,
                       final Client client,
                       final String baseUrl) {

        super(coredataClient, client, baseUrl, "files", File.class,
                new TypeToken<ContainerImpl<File>>() {
                }.getType());
    }


    /**
     * We overwrite this to be able to use the v1 api to insert files at all locations.
     * This includes projects, file spaces, tasks and folders.
     *
     * @param value
     * @return
     */
    @Override
    public String add(final File value) {
        final WebTarget target = client.target(baseUrl + "/api/document/"
                + value.getParent() + "/children/");

        final Response response = target.request(MediaType.APPLICATION_JSON_TYPE)
                .post(Entity.json(getGson().toJson(value)));

        final String location = response.getHeaders().get("Location").get(0).toString();
        final String[] parts = location.split("/");

        final String uuid = parts[parts.length - 1];
        value.setUUID(uuid);

        return uuid;
    }

    public void download(final File file) {
        try {
            final WebTarget myResource = client.target(baseUrl + "/api/v2/" + getTypeString()
                    + "/" + file.getUUID() + "/content");
            final Response response = myResource.request(MediaType.APPLICATION_OCTET_STREAM).get();

            try (InputStream inputStream = (InputStream) response.getEntity()) {

                try (OutputStream outputStream =
                             new FileOutputStream(new java.io.File(file.getFilename()))) {

                    int read;
                    final byte[] bytes = new byte[1024];

                    while ((read = inputStream.read(bytes)) != -1) {
                        outputStream.write(bytes, 0, read);
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * First uploads the metadata and then the content of the file.
     * @param file
     * @throws java.io.FileNotFoundException if the local path of the input file does not exist.
     */
    public void upload(final File file) throws FileNotFoundException{

        this.add(file);

        final WebTarget myResource = client.target(baseUrl + "/api/v2/" + getTypeString()
                + "/" + file.getUUID() + "/content");

        final java.io.File uploadFile = new java.io.File(file.getLocalPath());

            final Response response = myResource.request(MediaType.APPLICATION_OCTET_STREAM)
                    .put(Entity.entity(uploadFile, MediaType.APPLICATION_OCTET_STREAM));

    }
}
