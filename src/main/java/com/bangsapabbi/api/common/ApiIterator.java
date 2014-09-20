package com.bangsapabbi.api.common;

import java.util.Iterator;
import java.util.NoSuchElementException;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class ApiIterator<T extends ApiDTO> implements Iterator<T> {

    private final AbstractService<T> service;
    private final String pathExtra;
    private final String typeString;
    private Container<T> container;
    private int currentLocation = 0;
    private int totalCount;
    private int totalProcessed = 0;

    public <S extends AbstractService<T>> ApiIterator(final S service) {
        this(service, null);
    }

    public <S extends AbstractService<T>> ApiIterator(final S service, final String pathExtra) {
        this(service, pathExtra, service.getTypeString());
    }

    public <S extends AbstractService<T>> ApiIterator(final S service,
                                                      final String pathExtra,
                                                      final String typeString) {
        this.service = service;
        this.pathExtra = pathExtra;
        this.typeString = typeString;
    }

    @Override
    public boolean hasNext() {
        initializeContainer();

        checkIfNeedToFetch();
        return totalProcessed < totalCount;
    }

    private void checkIfNeedToFetch() {
        if (currentLocation == container.getMeta().getLimit()) {
            updateContainer();
        }
    }

    private void updateContainer() {
        final WebTarget myResource = service.getClient().target(service.getBaseUrl() + container.getMeta().getNext());
        final String response = myResource.request(MediaType.TEXT_PLAIN).get(String.class);
        container = service.getGson().fromJson(response, service.getContainerClass());
        currentLocation = 0;
    }


    @Override
    public T next() {
        if (hasNext()) {
            totalProcessed++;
            return container.get(currentLocation++);
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }


    private void initializeContainer() {
        if (container == null) {
            String url;
            if (this.pathExtra == null) {
                url = service.getBaseUrl() + "/api/v2/" + this.typeString + "/?limit=0";
            } else {
                url = service.getBaseUrl() + "/api/v2/"
                        + this.typeString + this.pathExtra + "/?limit=0";
            }
            final WebTarget myResource = service.getClient().target(url);
            final String response = myResource.request(MediaType.TEXT_PLAIN).get(String.class);
            container = service.getGson().fromJson(response, service.getContainerClass());
            this.totalCount = container.getMeta().getTotalCount();
        }
    }
}