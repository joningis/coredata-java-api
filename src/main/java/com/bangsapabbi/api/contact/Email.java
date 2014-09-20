package com.bangsapabbi.api.contact;

import com.bangsapabbi.api.valuelist.lists.EmailLabel;

/**
 * DTO for E-mails.
 */
public class Email {

    private String email;

    private EmailLabel label;

    public Email(final String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public EmailLabel getLabel() {
        return label;
    }

    public void setLabel(final EmailLabel label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "Email{" +
                "email='" + email + '\'' +
                ", label=" + label +
                '}';
    }
}
