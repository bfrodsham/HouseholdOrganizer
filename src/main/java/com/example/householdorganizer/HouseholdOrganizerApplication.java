package com.example.householdorganizer;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileNotFoundException;

@SpringBootApplication
public class HouseholdOrganizerApplication {

	public static void main(String[] args) {

		File file = new File(args[1]);
		HouseholdOrganizer householdOrganizer = new HouseholdOrganizer();

		try {
			householdOrganizer.ProcessInput(file);
			householdOrganizer.PrintHouseholds();
		}
		catch (FileNotFoundException e) {

			System.out.println("The input file does not exist.");
			e.printStackTrace();
		}
	}
}
