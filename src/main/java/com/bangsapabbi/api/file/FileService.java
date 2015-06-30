package com.bangsapabbi.api.file;


import org.glassfish.jersey.internal.util.Base64;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.bangsapabbi.api.CoredataClient;
import com.bangsapabbi.api.common.AbstractService;
import com.bangsapabbi.api.common.ContainerImpl;
import com.bangsapabbi.api.common.Insertable;
import com.google.common.base.Preconditions;
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
    public <S extends Insertable<File>> String add(final S value) {
        final WebTarget target = client.target(baseUrl + "/api/document/"
                + value.getParentUUID() + "/children/");

        final Response response = target.request(MediaType.APPLICATION_JSON_TYPE)
                .post(Entity.json(getGson().toJson(value)));

        final String location = response.getHeaders().get("Location").get(0).toString();
        final String[] parts = location.split("/");

        final String uuid = parts[parts.length - 1];
        value.setUUID(uuid);

        return uuid;
    }


    /**
     * Method to download file from coredata api.
     *
     * @param file       The file to download.
     * @param outputFile The file to download to.
     * @param overwrite  true if the outputFile should be overwritten if it exists
     *                   false otherwise
     * @return true if the download was successful, false otherwise.
     */
    public boolean download(final File file, final java.io.File outputFile, boolean overwrite)
            throws IOException {

        Preconditions.checkArgument(!outputFile.isDirectory(),
                "The outputfile cannot be a directory");

        if (outputFile.exists() && !overwrite) {
            return false;
        }

        final WebTarget myResource = client.target(baseUrl + "/api/v2/" + getTypeString()
                + "/" + file.getUUID() + "/content");
        final Response response = myResource.request(MediaType.APPLICATION_OCTET_STREAM).get();

        try (InputStream inputStream = (InputStream) response.getEntity()) {

            try (OutputStream outputStream =
                         new FileOutputStream(outputFile)) {

                int read;
                final byte[] bytes = new byte[1024];

                while ((read = inputStream.read(bytes)) != -1) {
                    outputStream.write(bytes, 0, read);
                }
            }
        }

        return true;
    }

    /**
     * First uploads the metadata and then the content of the file.
     *
     * @param file
     * @throws java.io.FileNotFoundException if the local path of the input file does not exist.
     */
    public void upload(final File file) throws FileNotFoundException {

        // We only want to add the file object if we have a new file, otherwise we just
        // want to update the content.
        if (file.getUUID() == null) {
            this.add(file);
        }

        final WebTarget myResource = client.target(baseUrl + "/api/v2/" + getTypeString()
                + "/" + file.getUUID() + "/content/");

        final java.io.File uploadFile = new java.io.File(file.getLocalPath());

       final Response response = myResource.request("text/plain")
                .put( Entity.entity(uploadFile, MediaType.APPLICATION_OCTET_STREAM));

        //   InputStream bigFileContentInputStream = new FileInputStream(uploadFile);
        // Response response = myResource.request().put(Entity.entity(bigFileContentInputStream, MediaType.APPLICATION_OCTET_STREAM));

/*
        try {
            URL url = new URL(baseUrl + "/api/v2/" + getTypeString()
                    + "/" + file.getUUID() + "/content/");
            HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
            String encoded = new String(Base64.encode("Administrator:Administrator".getBytes()));
            httpCon.setRequestProperty("Authorization", "Basic " + encoded);

            httpCon.setDoOutput(true);
            httpCon.setDoInput(true);
            httpCon.setRequestMethod("PUT");
            httpCon.setRequestProperty("Content-type", "application/octet-stream");
            httpCon.setRequestProperty("Content-length", Long.toString(uploadFile.length()+10000));


          //  OutputStreamWriter out = new OutputStreamWriter(httpCon.getOutputStream());

            BufferedOutputStream bos = new BufferedOutputStream(httpCon.getOutputStream());
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(uploadFile));

            // read byte by byte until end of stream
            byte[] buf = new byte[512];
            int r = 1;
            while((r = bis.read(buf)) > 0) {
                bos.write(buf, 0, r);
            }
            bos.flush();
            bos.close();

            try {

                InputStream inputStream;
                int responseCode=((HttpURLConnection)httpCon).getResponseCode();
                if ((responseCode>= 200) &&(responseCode<=202) ) {
                    inputStream = ((HttpURLConnection)httpCon).getInputStream();
                    int j;
                    while ((j = inputStream.read()) >0) {
                        System.out.println(j);
                    }

                } else {
                    inputStream = ((HttpURLConnection)httpCon).getErrorStream();
                }
                ((HttpURLConnection)httpCon).disconnect();

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            bos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
*/

//TODO(joningi): Return repsonse to user
    }
}
