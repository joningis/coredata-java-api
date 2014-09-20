package com.bangsapabbi.api.common;

import java.util.List;
import java.util.Map;

/**
 * Interface for services.
 *
 * @param <T>
 */
public interface Service<T> extends Iterable<T> {
    List<T> search(Search search);

    List<T> getWithParameters(Map<String, String> parameters);

    <S extends Insertable<T>>String add(final S value);

    T get(String uuid);

    void delete(String uuid);
}
