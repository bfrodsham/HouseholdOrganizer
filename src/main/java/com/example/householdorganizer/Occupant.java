package com.example.householdorganizer;

public class Occupant {

    private final String firstName;
    private final String lastName;
    private final String lastFirst;
    private final int age;

    public Occupant(String firstName, String lastName, int age) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.lastFirst = lastName + ", " + firstName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getLastFirst() {
        return lastFirst;
    }

    public int getAge() {
        return age;
    }
}
