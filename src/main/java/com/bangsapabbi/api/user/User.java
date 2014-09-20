package com.bangsapabbi.api.user;

import com.bangsapabbi.api.common.ApiDTO;
import com.google.gson.annotations.SerializedName;

public class User implements ApiDTO {

    @SerializedName("first_name")
    private String firstName;

    @SerializedName("last_name")
    private String lastName;

    @SerializedName("resource_uri")
    private String resourceUri;

    private String username;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getResourceUri() {
        return resourceUri;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", resourceUri='" + resourceUri + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

    @Override
    public void setUUID(final String uuid) {
        // The user does not have a uuid in the api so we do nothing here.
    }
}
