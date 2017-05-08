//Copyright © 2017 by Cole Trammer
import java.util.ArrayList;

public class Fibonacci {

	public static void main(String[] args) {
		ArrayList<Integer> fibs = fibs(100000);
		
		for (int n : fibs) {
			System.out.println(n);
		}
	}
	
	public static ArrayList<Integer> fibs(int n) {
		
		ArrayList<Integer> fibs = new ArrayList<Integer>();
		if (n > 0)
			fibs.add(1);
		
		int nextFib = 1;
		while (nextFib <= n) {
			fibs.add(nextFib);
			nextFib = fibs.get(fibs.size() - 1) + fibs.get(fibs.size() - 2);
		}
		
		return fibs;
	}
	
}
