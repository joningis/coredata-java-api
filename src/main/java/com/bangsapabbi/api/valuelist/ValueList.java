package com.bangsapabbi.api.valuelist;

import java.util.List;

import com.bangsapabbi.api.common.ApiDTO;

public class ValueList implements ApiDTO {

    private String name;
    private List<ValueListEntry> entries;


    public String getName() {
        return name;
    }

    public List<ValueListEntry> getEntries() {
        return entries;
    }

    @Override
    public void setUUID(final String uuid) {
        // The value list does not have a uuid in the api so we do nothing here.
    }
}
