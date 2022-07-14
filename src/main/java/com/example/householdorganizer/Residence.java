package com.example.householdorganizer;
import org.apache.commons.text.WordUtils;


public class Residence {

    private String address;
    private String city;
    private String state;
    private String fullAddress;

    public Residence(String address, String city, String state) {

        this.address = standardizeResidentInput(address);
        this.city = standardizeResidentInput(city);

        // I'm making the assumption that state input will always be two letters with no punctuation.
        this.state = state.toUpperCase();

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

    // This function standardizes resident fields so that comparison
    // between full addresses can be done later.
    private String standardizeResidentInput(String location) {

        // First, the location string is put in lowercase, and then
        // WordUtils capitalizes the first character in each word.
        WordUtils.capitalize(location.toLowerCase());

        // Punctuation is removed. The regex used means something like
        // "anything that is not an uppercase or lowercase letter."
        return location.replaceAll("[^a-zA-Z ]", "");
    }

}
