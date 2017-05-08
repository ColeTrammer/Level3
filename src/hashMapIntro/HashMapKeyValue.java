//Copyright © 2017 by Cole Trammer
package hashMapIntro;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

public class HashMapKeyValue {

	@Test
	public void testCommonPairs() {
		HashMap<String, String> h1 = new HashMap<String, String>();
		HashMap<String, String> h2 = new HashMap<String, String>();
		
		h1.put("Turkey", "Istanbul");
		h1.put("France", "Paris");
		h1.put("Japan", "Tokyo");
		h2.put("France", "Paris");
		h2.put("Canada", "Toronto");
		h2.put("Iran", "Tehran");
		h2.put("Turkey", "Istanbul");
		
		assertEquals(2, getMatchingPairs(h1, h2));
		
	}

	private int getMatchingPairs(HashMap<String, String> h1, HashMap<String, String> h2) {

		int matching = 0;
		for (String key : h1.keySet()) {
			for (String key2 : h2.keySet()) {
				if (key.equals(key2) && h1.get(key).equals(h2.get(key2))) {
					matching++;
				}
			}
		}
		return matching;
	}

}
