package com.bangsapabbi.api.common;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract class for all containers.
 * Most other Containers only need to extend this class
 * and nothing else.
 *
 * @param <T>
 */
public class ContainerImpl<T> implements Container<T> {
    private Meta meta;

    private List<T> objects;

    @Override
    public Meta getMeta() {
        return meta;
    }

    @Override
    public T get(final int index) {
        return objects.get(index);
    }

    @Override
    public List<T> getData() {
        return objects;
    }
}

