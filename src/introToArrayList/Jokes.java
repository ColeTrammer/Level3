//Copyright © 2017 by Cole Trammer
package introToArrayList;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

public class Jokes {
	
	public static void main(String[] args) {
		ArrayList<String> jokes = new ArrayList<String>();
		ArrayList<String> punchlines = new ArrayList<String>();
		
		jokes.add("Why did the cat go to Minnesota?");
		punchlines.add("To get a mini soda!");
		jokes.add("Where do orcas hear music?");
		punchlines.add("Orca-stras!");
		jokes.add("Why did the cow cross the road?");
		punchlines.add("Orca-stras!");
		jokes.add("What do you call a fish without an eye?");
		punchlines.add("Fsh!");
		jokes.add("What do you do if your dog chews a dictionary?");
		punchlines.add("Take the words out of his mouth!");
		jokes.add("What do you call a cold dog sitting on a bunny?");
		punchlines.add("A chili dog on a bun.");
		jokes.add("Why do fish live in salt water?");
		punchlines.add("Because pepper makes them sneeze!");
		jokes.add("Where do mice park their boats?");
		punchlines.add("At the hickory dickory dock.");

		int index = new Random().nextInt(jokes.size());
		JOptionPane.showMessageDialog(null, jokes.get(index));
		JOptionPane.showMessageDialog(null, punchlines.get(index));
	}
}
