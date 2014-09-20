package com.bangsapabbi.api.contact;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

import com.bangsapabbi.api.common.ApiDTO;
import com.bangsapabbi.api.valuelist.lists.ContactStatus;
import com.google.gson.annotations.SerializedName;

/**
 * DTO for contact.
 */
public class Contact implements ApiDTO {

    @SerializedName("id")
    private String uuid;
    private String identifier;
    private String title;
    private String description;
    private List<Phone> phones;
    private List<Email> emails;

    private List<Url> urls;

    private Contact organization;

    @SerializedName("contact_addresses")
    private List<Address> contactAddresses;

    @SerializedName("resource_uri")
    private String resourceUri;

    @SerializedName("created_by")
    private String createdBy;

    @SerializedName("modified_by")
    private String modifiedBy;

    private Date created;

    private Date modified;

    private List<String> tags;

    private ContactStatus status;

    private String type;

    private String version;

    public String getUUID() {
        return this.uuid;
    }

    public void setUUID(final String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return this.title;
    }

    public void setName(final String title) {
        this.title = title;
    }

    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(final List<Email> emails) {
        this.emails = emails;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(final List<Phone> phones) {
        this.phones = phones;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "uuid='" + uuid + '\'' +
                ", identifier='" + identifier + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", phones=" + phones +
                ", emails=" + emails +
                ", urls=" + urls +
                ", organization=" + organization +
                ", contactAddresses=" + contactAddresses +
                ", resourceUri='" + resourceUri + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", modifiedBy='" + modifiedBy + '\'' +
                ", created=" + created +
                ", modified=" + modified +
                ", tags=" + tags +
                ", status=" + status +
                ", type='" + type + '\'' +
                ", version='" + version + '\'' +
                '}';
    }
}
