package snakesOnAPlane;

import java.util.Random;

public class Randomness {

	public static boolean randomBoolean() {
		return new Random().nextBoolean();
	}
	
	public static int randomNumber() {
		return new Random().nextInt(10) + 1;
	}
	
}

/*
Snakes on a Plane.	//maybe move into ArrayList exercises
Create a Randomness class with two static methods;
Write a method that randomly returns true or false.
Write a method that randomly returns a number between 1 and 10.
Create a Snake class with member variables int viciousness & boolean venomous. Also create a Snake constructor and getters for the member variables.
Create a Plane class with member variable int numberOfPassengers and an ArrayList to hold the Snakes
In the Plane class, create 100 snakes with random viscousness, that are randomly venomous.
Calculate the probability of death based on the following …
Total venom = sum of viciousness of venomous snakes (if they aren’t venomous, it might not be pretty, but it won’t kill you!). This will give a value between 0 - 1000.
% chance of death = (total venom *10)/ number of passengers
Make sure it can’t be higher than 100%

Make a chart on the whiteboard to document the output of each student’s program.
*/