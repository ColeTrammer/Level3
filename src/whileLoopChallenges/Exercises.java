package whileLoopChallenges;

import java.util.ArrayList;
import java.util.Collections;

public class Exercises {
	
	public static void main(String[] args) {
		
		//1
		printSequence(22);
		//2
		printSequence(31);
		//3 Binary
		//4 
		operatorsBackwards(50);
	}
	
	public static void operatorsBackwards(int n) {
		
		while(n > 1) {
			if (n % 2 == 0) {
				System.out.print("A");
			} else {
				System.out.print("B");
			}
			n /= 2;
		}
		System.out.println("B");
		
	} 
	
	public static void printSequence(int n) {
		ArrayList<Integer> series = new ArrayList<>();
		while (n > 1) {
			series.add(n);
			n /= 2;
		}
		series.add(1);
		series.add(0);
		Collections.reverse(series);
		for (int i : series) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

}
