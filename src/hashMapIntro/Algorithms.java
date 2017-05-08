//Copyright © 2017 by Cole Trammer
package hashMapIntro;

import java.util.List;

public class Algorithms {

	public static int findBrokenEgg(List<String> eggs) {
		
		for (int i = 0; i < eggs.size(); i++) {
			if (eggs.get(i).equals("cracked")) {
				return i;
			}
		}
		return -1;
	}

	public static int countPearls(List<Boolean> oysters) {
		
		int ans = 0;
		for (boolean b : oysters) {
			if (b) ans++;
		}
		
		return ans;
	}

	public static double findTallest(List<Double> peeps) {
		
		double max = 0;
		
		for (double d : peeps) {
			if (d > max) max = d;
		}
		
		return max;
	}

	public static String findLongestWord(List<String> words) {
		
		int longestIndex = 0;
		
		for (int i = 1; i < words.size(); i++) {
			if (words.get(i).length() > words.get(longestIndex).length()) longestIndex = i;
		}
		
		return words.get(longestIndex);
	}

	public static boolean containsSOS(List<String> message) {
		String sos = "... --- ...";
		
		for (String s : message) {
			if (s.contains(sos)) {
				return true;
			}
		}
		return false;
	}

	public static List<Double> sortScores(List<Double> results) {
		for (int i = 0; i < results.size(); i++) {
			for (int j = 0; j < results.size(); j++) {
				if (results.get(i) < results.get(j)) {
					double tmp = results.get(j);
					results.set(j, results.get(i));
					results.set(i, tmp);
				}
			}
		}
		return results;
	}

	public static List<String> sortDNA(List<String> results) {
		for (int i = 0; i < results.size(); i++) {
			for (int j = 0; j < results.size(); j++) {
				if (results.get(i).length() < results.get(j).length()) {
					String tmp = results.get(j);
					results.set(j, results.get(i));
					results.set(i, tmp);
				}
			}
		}
		return results;
	}

	public static List<String> sortWords(List<String> results) {
		for (int i = 0; i < results.size(); i++) {
			for (int j = 0; j < results.size(); j++) {
				if (results.get(i).compareTo(results.get(j)) < 0) {
					String tmp = results.get(j);
					results.set(j, results.get(i));
					results.set(i, tmp);
				}
			}
		}
		return results;
	}

}
