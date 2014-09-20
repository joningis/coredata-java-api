package com.bangsapabbi.api.common;

import java.util.Map;

import com.google.common.collect.Maps;

public class Search {

    private final Map<String, String> parameters;

    public Search() {
        this.parameters = Maps.newHashMap();
    }

    public Map<String, String> toParameters() {
        return this.parameters;
    }

    public void put(final String key, final String value) {
        this.parameters.put(key, value);
    }
}
