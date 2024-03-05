package com.coherentsolutions.training.automation.web.sirbu;

public class Address {
    private String streetLine1;
    private String streetLine2;
    private String streetLine3;
    private String city;
    private String province;
    private String postalCode;
    private String country;
    private String phoneNumber;

    public Address(String streetLine1, String streetLine2, String streetLine3, String city, String province, String postalCode, String country, String phoneNumber) {
        this.streetLine1 = streetLine1;
        this.streetLine2 = streetLine2;
        this.streetLine3 = streetLine3;
        this.city = city;
        this.province = province;
        this.postalCode = postalCode;
        this.country = country;
        this.phoneNumber = phoneNumber;
    }

    public String getStreetLine1() {
        return streetLine1;
    }

    public void setStreetLine1(String streetLine1) {
        this.streetLine1 = streetLine1;
    }

    public String getStreetLine2() {
        return streetLine2;
    }

    public void setStreetLine2(String streetLine2) {
        this.streetLine2 = streetLine2;
    }

    public String getStreetLine3() {
        return streetLine3;
    }

    public void setStreetLine3(String streetLine3) {
        this.streetLine3 = streetLine3;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }


    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
