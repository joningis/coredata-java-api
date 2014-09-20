package com.bangsapabbi.api.common;

import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;

import com.google.common.collect.Maps;

public class QueryString {

    private Map<String, String> parameters;

    public QueryString() {
        this.parameters = Maps.newHashMap();
    }

    public void add(String key, String value) {
        this.parameters.put(key, value);
    }

    private String build() {
        StringBuilder builder = new StringBuilder();

        if (!this.parameters.isEmpty()) {
            builder.append("?");
        }

        Iterator<Map.Entry<String, String>> it = this.parameters.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> entry = it.next();

            builder.append(URLEncoder.encode(entry.getKey()))
                    .append('=')
                    .append(URLEncoder.encode(entry.getValue()));

            if (it.hasNext()) {
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
