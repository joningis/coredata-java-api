package com.bangsapabbi.api.common;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.bangsapabbi.api.CoredataClient;
import com.bangsapabbi.api.file.File;
import com.bangsapabbi.api.file.FileSerializer;
import com.bangsapabbi.api.folder.Folder;
import com.bangsapabbi.api.folder.FolderSerializer;
import com.bangsapabbi.api.task.Task;
import com.bangsapabbi.api.task.TaskSerializer;
import com.bangsapabbi.api.user.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/**
 * Abstract class that handles most of web service calls.
 *
 * @param <T>
 */
public abstract class AbstractService<T extends ApiDTO> implements Service<T> {

    protected final Client client;
    protected final String baseUrl;
    protected Gson gson;
    private final String typeString;
    private Class<T> type;
    private final Type containerClass;
    private final CoredataClient coredataClient;

    public AbstractService(final CoredataClient coredataClient,
                           final Client client,
                           final String baseUrl,
                           final String typeString,
                           final Class<T> type,
                           final Type containerClass) {
        this.coredataClient = coredataClient;
        this.client = client;
        this.baseUrl = baseUrl;
        this.typeString = typeString;
        this.type = type;
        this.containerClass = containerClass;
    }


    protected Gson getGson() {
        if (gson == null) {
            this.gson = new GsonBuilder()
                    .registerTypeAdapter(Task.class, new TaskSerializer())
                    .registerTypeAdapter(File.class, new FileSerializer())
                    .registerTypeAdapter(Folder.class, new FolderSerializer())
                    .registerTypeAdapter(Date.class, new DateDeserializer()).create();
        }
        return this.gson;
    }


    /**
     * Method to get a single object.
     *
     * @param uuid The uuid of the object to get.
     * @return The object if found, null otherwise.
     */
    @Override
    public T get(final String uuid) {
        try {
            final WebTarget myResource = client.target(baseUrl + "/api/v2/" + getTypeString()
                    + "/" + uuid);
            final String response = myResource.request(MediaType.TEXT_PLAIN).get(String.class);
            return getGson().fromJson(response, getType());
        } catch (NotFoundException e) {
            return null;
        }
    }

    @Override
    public List<T> search(final Search search) {
        return this.getWithParameters(search.toParameters());
    }

    @Override
    public List<T> getWithParameters(final Map<String, String> parameters) {
        QueryString queryString = new QueryString();
        queryString.addAll(parameters);

        final WebTarget myResource = client.target(baseUrl + "/api/v2/" + getTypeString()
                + "/" + queryString.toString());

        final String response = myResource.request(MediaType.TEXT_PLAIN).get(String.class);
        Container<T> container = getGson().fromJson(response, getContainerClass());
        return container.getData();
    }

    @Override
    public String add(final T value) {
        final WebTarget target = client.target(baseUrl + "/api/v2/" + getTypeString() + "/");

        Response response = target.request(MediaType.APPLICATION_JSON_TYPE)
                .post(Entity.json(getGson().toJson(value)));

        String location = response.getHeaders().get("Location").get(0).toString();
        String[] parts = location.split("/");
        String uuid = parts[parts.length - 1];

        value.setUUID(uuid);

        System.out.println(location);
        System.out.println();
        System.out.println(getGson().toJson(value));
        System.out.println();
        System.out.println();
        System.out.println(response);
        System.out.println(response.getStatusInfo());
        System.out.println(response.getStatus());
        System.out.println(response.getEntity());
        System.out.println(new Gson().fromJson(response.readEntity(String.class), ErrorResponce.class));

        return uuid;
    }

    @Override
    public void delete(final String uuid) {
        final WebTarget myResource = client.target(baseUrl + "/api/v2/" + getTypeString()
                + "/" + uuid);
        myResource.request(MediaType.TEXT_PLAIN).delete();
    }

    public String getTypeString() {
        return this.typeString;
    }

    public final Class<T> getType() {
        return this.type;
    }

    protected final Type getContainerClass() {
        return this.containerClass; //
    }

    @Override
    public Iterator<T> iterator() {
        return new ApiIterator<>(this);
    }

    protected Client getClient() {
        return client;
    }

    protected String getBaseUrl() {
        return baseUrl;
    }

    protected CoredataClient getCoredataClient() {
        return coredataClient;
    }
}
