package com.bangsapabbi.api.common;

import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;

import com.google.common.collect.Maps;

public class QueryString {

    private final Map<String, String> parameters;

    public QueryString() {
        this.parameters = Maps.newHashMap();
    }

    public void add(final String key, final String value) {
        this.parameters.put(key, value);
    }

    private String build() {
        final StringBuilder builder = new StringBuilder();

        if (!this.parameters.isEmpty()) {
            builder.append("?");
        }

        final Iterator<Map.Entry<String, String>> iterator = this.parameters.entrySet().iterator();
        while (iterator.hasNext()) {
            final Map.Entry<String, String> entry = iterator.next();

            builder.append(URLEncoder.encode(entry.getKey()))
                    .append('=')
                    .append(URLEncoder.encode(entry.getValue()));

            if (iterator.hasNext()) {
                builder.append('&');
            }
        }
        return builder.toString();
    }

    public String toString() {
        return build();
    }

    public void addAll(final Map<String, String> parameters) {
        this.parameters.putAll(parameters);
    }
}
