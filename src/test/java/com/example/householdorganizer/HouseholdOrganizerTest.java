package com.example.householdorganizer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class HouseholdOrganizerTest {

    private HouseholdOrganizer testHouseholdOrganizer;

    @BeforeEach
    void setUp() {
        testHouseholdOrganizer = new HouseholdOrganizer();
    }

    @Test
    void processNormalInput() {

        // TODO: You'll need to change the paths here for the test to work locally on your machine.
        File normalInputFile = new File("C:\\Users\\bfrod\\IdeaProjects\\HouseholdOrganizer\\input_data.txt");

        try {
            testHouseholdOrganizer.ProcessInput(normalInputFile);
            assertTrue(true);
        } catch (final RuntimeException | FileNotFoundException e) {
            fail("Should have processed normal input with no exceptions");
        }
    }

    @Test
    void processBadInput() {

        // TODO: You'll need to change the paths here for the test to work locally on your machine.
        File badDataFile = new File("C:\\Users\\bfrod\\IdeaProjects\\HouseholdOrganizer\\baddata_input.txt");
        File badFormatFile = new File("C:\\Users\\bfrod\\IdeaProjects\\HouseholdOrganizer\\badformat_input.txt");
        File inconsistentFile = new File("C:\\Users\\bfrod\\IdeaProjects\\HouseholdOrganizer\\inconsistentdata_input.txt");

        try {
            testHouseholdOrganizer.ProcessInput(badDataFile);
            fail("Should have thrown an exception");
        } catch (final RuntimeException | FileNotFoundException e) {
            assertTrue(true);
        }

        try {
            testHouseholdOrganizer.ProcessInput(badFormatFile);
            fail("Should have thrown an exception");
        } catch (final RuntimeException | FileNotFoundException e) {
            assertTrue(true);
        }

        try {
            testHouseholdOrganizer.ProcessInput(inconsistentFile);
            fail("Should have thrown an exception");
        } catch (final RuntimeException | FileNotFoundException e) {
            assertTrue(true);
        }
    }
}