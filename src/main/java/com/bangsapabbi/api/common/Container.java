package com.bangsapabbi.api.common;

import java.util.List;

/**
 * Interface for data containers.
 *
 * @param <T>
 */
public interface Container<T> {

    public Meta getMeta();

    T get(int index);

    List<T> getData();
}
