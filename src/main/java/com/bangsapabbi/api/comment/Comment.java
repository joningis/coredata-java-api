package com.bangsapabbi.api.comment;

import java.util.Date;

import com.bangsapabbi.api.common.ApiDTO;
import com.google.gson.annotations.SerializedName;

public class Comment implements ApiDTO {

    private String author;

    @SerializedName("doc_id")
    private String docId;

    @SerializedName("id")
    private String uuid;

    @SerializedName("resource_uri")
    private String resourceUri;

    private String text;

    private Date time;

    @Override
    public void setUUID(final String uuid) {
        this.uuid = uuid;
    }
}
