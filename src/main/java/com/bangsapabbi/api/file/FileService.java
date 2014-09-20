package com.bangsapabbi.api.file;

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

        Response response = target.request(MediaType.APPLICATION_JSON_TYPE)
                .post(Entity.json(getGson().toJson(value)));

        String location = response.getHeaders().get("Location").get(0).toString();
        String[] parts = location.split("/");

        String uuid = parts[parts.length - 1];
        value.setUUID(uuid);

        return uuid;
    }

    public void download(File file) {
        try {
            final WebTarget myResource = client.target(baseUrl + "/api/v2/" + getTypeString()
                    + "/" + file.getUUID() + "/content");
            Response response = myResource.request(MediaType.APPLICATION_OCTET_STREAM).get();

            InputStream inputStream = (InputStream) response.getEntity();

            OutputStream outputStream =
                    new FileOutputStream(new java.io.File(file.getFilename()));

            int read;
            byte[] bytes = new byte[1024];

            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void upload(File file) {

        this.add(file);

        final WebTarget myResource = client.target(baseUrl + "/api/v2/" + getTypeString()
                + "/" + file.getUUID() + "/content");

        java.io.File uploadFile = new java.io.File("/tmp/hoff.png");

        Response response = myResource.request(MediaType.APPLICATION_OCTET_STREAM)
                .put(Entity.entity(uploadFile, MediaType.APPLICATION_OCTET_STREAM));

    }
}
