//Copyright © 2017 by Cole Trammer
package introToArrayList;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

public class BandNames {

	public static void main(String[] args) {
	
		ArrayList<String> nouns = new ArrayList<String>();
		ArrayList<String> adjectives = new ArrayList<String>();
		
		nouns.add("Dragons");
		nouns.add("Cats");
		nouns.add("Schools");
		nouns.add("Programs");
		nouns.add("Instruments");
		nouns.add("People");
		nouns.add("Words");
		
		adjectives.add("Happy");
		adjectives.add("Good");
		adjectives.add("Interesting");
		adjectives.add("Cool");
		adjectives.add("Depressed");
		adjectives.add("Long");
		adjectives.add("Skilled");
		adjectives.add("Secret");
		
		Random r = new Random();
		JOptionPane.showMessageDialog(null, adjectives.get(r.nextInt(adjectives.size())) + " " + nouns.get(r.nextInt(nouns.size())));
		
	}
}
