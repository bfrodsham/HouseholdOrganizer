package com.example.householdorganizer;

import org.apache.commons.text.WordUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class HouseholdOrganizer {

    private Map<String, Household> households;

    public HouseholdOrganizer() {
        this.households = new HashMap<>();
    }

    public Collection<Household> getHouseholds() {
        return households.values();
    }

    // Parses the input and formats the string fields for comparison later on.
    public void ProcessInput(File file) throws FileNotFoundException {

        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {

            // Tokenizing each line.
            String line = scanner.nextLine();
            line = line.substring(1, line.length()-1);
            String[] tokens = line.split("\",\"");

            // Decided to encapsulate the rest of the process in a different
            // function to separate parsing from object instantiation.
            TokensToHouseholds(tokens);
        }
    }

    // Takes the parsed tokens, instantiates the residence, occupant,
    // and household objects, and then maps the household data.
    private void TokensToHouseholds(String[] tokens) {

        // This is a pretty major assumption, which is that I can
        // rely on every value being the same column and format in
        // the input file.

        String address = StandardizeResidentInput(tokens[2]);
        String city = StandardizeResidentInput(tokens[3]);
        String state = tokens[4].toUpperCase();
        Residence resident = new Residence(address, city, state);

        String firstName = WordUtils.capitalize(tokens[0]);
        String lastName = WordUtils.capitalize(tokens[1]);
        int age = Integer.parseInt(tokens[5]);
        Occupant occupant = new Occupant(firstName, lastName, age);

        // Map households to their standardized addresses, and
        // add occupants to pre-existing addresses
        if (households.containsKey(resident.getFullAddress())) {
            households.get(resident.getFullAddress()).addOccupant(occupant);
        }
        else {
            households.put(resident.getFullAddress(), new Household(resident, occupant));
        }
    }

    // Calls the printHousehold() function on every current household.
    public void PrintHouseholds() {

        for (Household household : households.values()) {
            household.printHousehold();
            System.out.println();
        }
    }

    // Standardizes resident fields for comparing against other resident objects.
    // The location is trimmed, put into lower case, and punctuation is removed.
    private String StandardizeResidentInput(String location) {

        String formattedLocation = WordUtils.capitalize(location.toLowerCase());
        formattedLocation = formattedLocation.replaceAll("[^a-zA-Z0-9 ]", "");
        return formattedLocation.trim();
    }
}
