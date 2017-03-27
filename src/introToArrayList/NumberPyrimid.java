package introToArrayList;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

public class NumberPyrimid {
	
	public NumberPyrimid(int numOfRows) {
		
		ArrayList<Integer> nums = new ArrayList<Integer>();
		Random r = new Random();
		
		for (int i = 0; i < numOfRows; i++) {
			nums.add(r.nextInt(10));
			System.out.print(i + 1 + ". ");
			for (Integer num : nums) {
				System.out.print(num);
			}
			System.out.print('\n');
		}
		
		
	}

	public static void main(String[] args) {
		new NumberPyrimid(Integer.parseInt(JOptionPane.showInputDialog("Input a number.")));
	}
	
}
