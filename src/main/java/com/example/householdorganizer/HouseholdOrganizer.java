package com.example.householdorganizer;

import org.apache.commons.text.WordUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseholdOrganizer {

    private List<Household> households;

    public HouseholdOrganizer() {
        this.households = new ArrayList<>();
    }

    public void ProcessInput(File file) throws FileNotFoundException {

        Scanner scanner = new Scanner(file);


    }

    public void PrintHouseholds() {
    }

    // I'm making the assumption that state input will always be two letters with no punctuation.
    //TODO: Don't forget to put the states in all uppercase when you put it in the Resident constructor!

    // This function standardizes resident fields for comparisons.
    private String standardizeResidentInput(String location) {

        // Capitalizes the first character in each lowercase word.
        WordUtils.capitalize(location.toLowerCase());
        // Punctuation is removed.
        return location.replaceAll("[^a-zA-Z ]", "");
    }
}
