package introToArrayList;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

public class RandomFood {

	public static void main(String[] args) {
		ArrayList<String> foods = new ArrayList<String>();
		foods.add("tacos");
		foods.add("pizza");
		foods.add("pasta");
		foods.add("ice cream");
		foods.add("bread");
		foods.add("cereal");
		foods.add("java");
		JOptionPane.showMessageDialog(null, "You should eat " + foods.get(new Random().nextInt(foods.size())) + ".");
	}
	
}
