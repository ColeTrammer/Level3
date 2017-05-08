//Copyright © 2017 by Cole Trammer
package hashMapIntro;

import java.util.ArrayList;

public class OncogeneDetector {

	public boolean isOncogene(ArrayList<String> healthy, ArrayList<String> cancer, String gene) {
		if (gene.equals("")) {
			return false;
		}
			
		if (cancer.isEmpty()) {
			throw new IllegalArgumentException("cancerSequences must contain at least one element");
		}
		
		if (healthy.isEmpty()) {
			throw new IllegalArgumentException("healthySequences must contain at least one element");
		}
		
		for (int i = 0; i < gene.length(); i++) {
			if (!isValid(gene.charAt(i))) {
				throw new IllegalArgumentException("candidate must contain only the letters A, C, G or T");
			}
		}

		int healthyOccurences = 0;
		for (String s : healthy) {
			for (int i = 0; i < s.length(); i++) {
				if (!isValid(s.charAt(i))) {
					throw new IllegalArgumentException();
				}
			}
			if (s.contains(gene)) {
				healthyOccurences++;
			}
		}
		int cancerOccurences = 0;
		for (String s : cancer) {
			for (int i = 0; i < s.length(); i++) {
				if (!isValid(s.charAt(i))) {
					throw new IllegalArgumentException();
				}
			}
			if (s.contains(gene)) {
				cancerOccurences++;
			}
		}
		return cancerOccurences > healthyOccurences;
	}

	private boolean isValid(char c) {
		return c == 'A' || c == 'G' || c == 'C' || c == 'T';
	}
	
}
