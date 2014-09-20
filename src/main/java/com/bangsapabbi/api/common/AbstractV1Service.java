package com.bangsapabbi.api.common;

import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.bangsapabbi.api.CoredataClient;

public abstract class AbstractV1Service<T extends ApiDTO> extends AbstractService<T> {
    public AbstractV1Service(final CoredataClient coredataClient,
                             final Client client,
                             final String baseUrl,
                             final String typeString,
                             final Class<T> type,
                             final Type containerClass) {
        super(coredataClient, client, baseUrl, typeString, type, containerClass);
    }

    @Override
    public List<T> search(final Search search) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<T> getWithParameters(final Map<String, String> parameters) {
        throw new UnsupportedOperationException();
    }


    @Override
    public <S extends Insertable<T>> String add(final S value) {
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

    @Override
    public void delete(final String uuid) {

    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }
}
