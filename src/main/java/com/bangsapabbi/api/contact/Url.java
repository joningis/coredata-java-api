package com.bangsapabbi.api.contact;

import com.bangsapabbi.api.valuelist.lists.UrlLabel;

public class Url {

    private String url;
    private UrlLabel label;

    public String getUrl() {
        return url;
    }

    public void setUrl(final String url) {
        this.url = url;
    }

    public UrlLabel getLabel() {
        return label;
    }

    public void setLabel(final UrlLabel label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "Url{" +
                "url='" + url + '\'' +
                ", label=" + label +
                '}';
    }
}
