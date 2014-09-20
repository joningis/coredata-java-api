package com.bangsapabbi.api.common;

import com.google.gson.annotations.SerializedName;

/**
 * Metadata used in every web service call.
 */
public class Meta {
    private int limit;
    private String next;
    private int offset;
    private String previous;

    @SerializedName("total_count")
    private int totalCount;


    public int getLimit() {
        return limit;
    }

    public String getNext() {
        return this.next;
    }

    public int getOffset() {
        return this.offset;
    }

    public String getPrevious() {
        return this.previous;
    }

    public int getTotalCount() {
        return this.totalCount;
    }
}
