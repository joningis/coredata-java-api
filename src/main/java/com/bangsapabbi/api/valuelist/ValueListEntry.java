package com.bangsapabbi.api.valuelist;

import java.util.Map;

public class ValueListEntry {

    private String name;
    private Map<String, String> translations;

    public Map<String, String> getTranslations() {
        return translations;
    }

    public String getName() {
        return name;
    }
}
