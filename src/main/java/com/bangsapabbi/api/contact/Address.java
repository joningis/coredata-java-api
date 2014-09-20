package com.bangsapabbi.api.contact;

import com.bangsapabbi.api.valuelist.lists.Country;

/**
 * DTO for address.
 * <p/>
 * The json includes label that is not available in the web interface so it will not be included
 * here at the moment.
 */
public class Address {

    private String city;
    private String code;

    private Country country;

    private String state;

    private String street;

    public String getCity() {
        return city;
    }

    public void setCity(final String city) {
        this.city = city;
    }

    public String getCode() {
        return code;
    }

    public void setCode(final String code) {
        this.code = code;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(final Country country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(final String state) {
        this.state = state;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(final String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", code='" + code + '\'' +
                ", country=" + country +
                ", state='" + state + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
}
