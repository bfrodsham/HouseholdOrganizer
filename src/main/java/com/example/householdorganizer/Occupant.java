package com.example.householdorganizer;

import org.apache.commons.text.WordUtils;

public class Occupant {

    private String firstName;
    private String lastName;
    private int age;

    public Occupant(String firstName, String lastName, int age) {

        // Making sure that the first and last names have the first
        // letter capitalized.
        this.firstName = WordUtils.capitalize(firstName);
        this.lastName = WordUtils.capitalize(lastName);
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }
}
