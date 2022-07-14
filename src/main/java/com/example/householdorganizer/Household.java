package com.example.householdorganizer;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Household {

    private final int MIN_OCCUPANT_AGE = 18;

    private Residence residence;
    private List<Occupant> occupants;
    private String householdName;

    public Household(Residence residence, Occupant occupant) {
        this.residence = residence;
        this.occupants = new ArrayList<>();
        this.occupants.add(occupant);
    }

    public void addOccupant(Occupant occupant) {
        this.occupants.add(occupant);
        updateHouseholdName();
    }

    public void printHousehold() {
        System.out.println("The " + householdName + " Household - Occupancy: " + occupants.size());

        for (Occupant occupant : occupants) {

            if (occupant.getAge() >= 18) {

                System.out.println();
            }
        }
    }
}
