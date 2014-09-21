package com.bangsapabbi.api.contact;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

import com.bangsapabbi.api.common.AbstractInsertableDTO;
import com.bangsapabbi.api.common.ApiDTO;
import com.bangsapabbi.api.valuelist.lists.ContactStatus;
import com.google.gson.annotations.SerializedName;

/**
 * DTO for contact.
 */
public class Contact extends AbstractInsertableDTO<Contact> {


    private String identifier;
    private String title;

    private List<Phone> phones;
    private List<Email> emails;

    private List<Url> urls;

    private Contact organization;

    @SerializedName("contact_addresses")
    private List<Address> contactAddresses;


    private List<String> tags;

    private ContactStatus status;

    public Contact() {
        // set this id to pass validation. Contacts are the only one not
        // to have parent.
        this.setParentUUID("5cc68cd4-8ce6-11e3-a69a-6003088b5c52");
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

    public List<Phone> getPhones() {
        return phones;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "uuid='" + getUUID() + '\'' +
                ", identifier='" + identifier + '\'' +
                ", title='" + title + '\'' +
                ", description='" + getDescription() + '\'' +
                ", phones=" + phones +
                ", emails=" + emails +
                ", urls=" + urls +
                ", organization=" + organization +
                ", contactAddresses=" + contactAddresses +
                ", resourceUri='" + getResourceUri() + '\'' +
                ", createdBy='" + getCreatedBy() + '\'' +
                ", modifiedBy='" + getModifiedBy() + '\'' +
                ", created=" + getCreated() +
                ", modified=" + getModified() +
                ", tags=" + tags +
                ", status=" + status +
                ", type='" + getType() + '\'' +
                ", version='" + getVersion() + '\'' +
                '}';
    }

    @Override
    public Set<ConstraintViolation<Contact>> getConstraintViolations() {
        return null;
    }
}
