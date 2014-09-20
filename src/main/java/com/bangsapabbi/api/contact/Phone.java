package com.bangsapabbi.api.contact;

import com.bangsapabbi.api.valuelist.lists.PhoneLabel;

/**
 * DTO for phones.
 */
public class Phone {
    private String number;
    private PhoneLabel label;

    public Phone(final String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(final String number) {
        this.number = number;
    }

    public PhoneLabel getLabel() {
        return label;
    }

    public void setLabel(final PhoneLabel label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "number='" + number + '\'' +
                ", label=" + label +
                '}';
    }
}
