package com.example.householdorganizer;

import java.util.*;

public class Household {

    private final int MIN_OCCUPANT_AGE = 18;

    private final Residence residence;
    private final List<Occupant> occupants;
    private final Set<String> familyNames;

    public Household(Residence residence, Occupant occupant) {

        this.residence = residence;
        this.occupants = new ArrayList<>();
        this.familyNames = new HashSet<>();

        this.occupants.add(occupant);
        this.familyNames.add(occupant.getLastName());
    }

    public Residence getResidence() {
        return residence;
    }

    public List<Occupant> getOccupants() {
        return occupants;
    }

    // Adds an occupant to the household and tracks last name.
    public void addOccupant(Occupant occupant) {

        this.occupants.add(occupant);
        this.familyNames.add(occupant.getLastName());
    }

    // Prints the household information as required in the specs.
    public void printHousehold() {

        System.out.println("The " + getFamilyNamesString() + " Household - Occupancy: " + occupants.size());

        occupants.sort(Comparator.comparing(Occupant::getLastFirst));
        for (Occupant occupant : occupants) {

            if (occupant.getAge() >= MIN_OCCUPANT_AGE) {

                System.out.println('\t' + occupant.getFirstName() + " "
                                + occupant.getLastName() + ", "
                                + residence.getFullAddress() + ", "
                                + "Age: " + occupant.getAge());
            }
        }
    }

    // Formats a string that can be used to refer to everyone in the household.
    private String getFamilyNamesString() {

        StringBuilder surnames = new StringBuilder();
        for (String name : familyNames) {
            surnames.append(name).append("/");
        }
        surnames.deleteCharAt(surnames.length()-1);

        return surnames.toString();
    }
}
