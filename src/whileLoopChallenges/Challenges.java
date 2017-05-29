package whileLoopChallenges;

import org.teachingextensions.logo.Tortoise;

public class Challenges {

	public static void main(String[] args) {
		
		int dollars = 1;
		int count = 0;
		while (dollars <= 1000000) {
			count++;
			dollars += dollars;
		}
		System.out.println("1. " + count);
		
//		boolean black = true;
//		while (true) {
//			black = !black;
//			System.out.println(black ? "black" : "white");
//		}
		
		int slices = 1046;
		count = 0;
		while (slices > 1) {
			slices /= 2;
			count++;
		}
		System.out.println("3. " + count);
		
		// 1. Set the X position of the Tortoise so that it starts on the left. You also need to show the Tortoise to see the result of this line.
		Tortoise.setX(5);
		Tortoise.show();
		// 2. Make the Tortoise draw a star shape. Hint: 144.
		
		// 3. Set the size of the star to 30.
 
		/** THE CHALLENGE: **/
		/*
		 * Make the Tortoise draw a line of stars like this:
		 * http://bit.ly/walk-of-fame
		 * 
		 * Hint: The distance between stars is 50.
		 */
		
	}
	
}
/*
1. you have 1 dollar. if you double your money every year, how long will it take for you to become a millionaire?
 
2. zebra: using only one variable, print “black”, “white”, “black”, “white”, etc. for infinity.
 
3. giant pizza: Imagine a pizza with 1046 slices. How many times can you remove half of the slices until you have only 1 slice left?
 
4. Tortoise Walk of Fame challenge
 
Optional: Advanced loops
* A test suite is at https://github.com/ecolban/Loops Import the project and add a Loops class containing the code to be tested.

*/