package com.example.householdorganizer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HouseholdTest {

    private Household testHousehold;
    private Occupant occupantA;
    private Residence testResidence;

    @BeforeEach
    void setUp() {

        testResidence = new Residence("123 Fjord Dr", "Cedar Falls", "IA");
        occupantA = new Occupant("Franklin", "Ford", 28);
        testHousehold = new Household(testResidence, occupantA);
    }

    @Test
    void addOccupantNormalInput() {

        assertEquals(1, testHousehold.getOccupants().size());
        assertEquals(this.occupantA, testHousehold.getOccupants().get(0));
        assertEquals(this.testResidence, testHousehold.getResidence());

        Occupant occupantB = new Occupant("Jean", "Goodwin", 71);
        testHousehold.addOccupant(occupantB);

        assertEquals(2, testHousehold.getOccupants().size());
        assertEquals(this.occupantA, testHousehold.getOccupants().get(0));
        assertEquals(occupantB, testHousehold.getOccupants().get(1));
        assertEquals(this.testResidence, testHousehold.getResidence());
    }

    // This test doesn't seem very insightful. Not sure what other tests I could do for addOccupant()
    @Test
    void addOccupantUnexpectedInput() {

        assertEquals(1, testHousehold.getOccupants().size());
        assertEquals(this.occupantA, testHousehold.getOccupants().get(0));
        assertEquals(this.testResidence, testHousehold.getResidence());

        Occupant occupantB = new Occupant("128LKJH371-!?./", "IDUJMW827**(", 529842097);
        testHousehold.addOccupant(occupantB);

        assertEquals(2, testHousehold.getOccupants().size());
        assertEquals(this.occupantA, testHousehold.getOccupants().get(0));
        assertEquals(occupantB, testHousehold.getOccupants().get(1));
        assertEquals(this.testResidence, testHousehold.getResidence());
    }

}