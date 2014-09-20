package com.bangsapabbi.api.common;

import com.google.gson.annotations.SerializedName;

public class ErrorResponce {

    @SerializedName("error_message")
    private String errorMessage;

    private String traceback;

    @Override
    public String toString() {
        return "ErrorResponce{" +
                "errorMessage='" + errorMessage + '\'' +
                ", traceback='" + traceback + '\'' +
                '}';
    }
}
