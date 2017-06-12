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
		//5 SKIP
		//6
		operatorsForwards(50);
		//7 SKIP
		//8
		System.out.println(multiply(21, 29));
	}
	
	public static int multiply(int m, int n) {
		// 0 <= a && a < b
		// a + b * c == n
		int a = n; int b = 1; int c = 0; int product = 0;
		
		while(b < n) {
			b *= 2;
		}
		
		while (b != 1) {
			b /= 2;
			if (b <= a) {
				a = a - b;
				c *= 2;
				c++;
				product <<= 1;
				product += m;
			} else {
				c *= 2;
				product <<= 1;
			}
		}
		assert a == 0 && b == 1 && c == n;
		return product;
	}
	
	public static void operatorsForwards(int n) {
		// 0 <= a && a < b
		// a + b * c == n
		int a = n; int b = 1; int c = 0;
		
		while(b < n) {
			b *= 2;
		}
		
		while (b != 1) {
			b /= 2;
			if (b <= a) {
				a = a - b;
				System.out.println("B");
				c *= 2;
				c++;
			} else {
				System.out.println("A");
				c *= 2;
			}
		}
		assert a == 0 && b ==1 && c == n;	
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
