package hashMapIntro;

import java.util.ArrayList;
import java.util.HashMap;

public class AnimalHipster {

	public ArrayList<String> findAnimalHipsters(HashMap<String, ArrayList<String>> network,
											    HashMap<String, String> favoriteAnimals) {
		ArrayList<String> hipsters = new ArrayList<String>();
		
		if (network.isEmpty() || favoriteAnimals.isEmpty()) {
			return hipsters;
		}
		
		for (String key : network.keySet()) {
			boolean hipster = true;
			String currentFavoriteAnimal = favoriteAnimals.get(key);
			for (String person : network.get(key)) {
				if (favoriteAnimals.get(person).equals(currentFavoriteAnimal)) {
					hipster = false;
				}
			}
			if (hipster) {
				hipsters.add(key);
			}
		}
		
		return hipsters;
	}

}
