package com.example.householdorganizer;
import org.apache.commons.text.WordUtils;


public class Residence {

    private final String address;
    private final String city;
    private final String state;
    private final String fullAddress;

    public Residence(String address, String city, String state) {

        this.address = address;
        this.city = city;
        this.state = state;
        this.fullAddress = this.address + ", " + this.city + ", " + this.state;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getFullAddress() {
        return fullAddress;
    }

}
