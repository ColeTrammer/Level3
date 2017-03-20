package introToArrayList;

import java.util.ArrayList;

public class CrashArrayLists {

	public static void main(String[] args) {
		ArrayList<Integer> broken = new ArrayList<Integer>();
		broken.add(0);
		while(true) {
			broken.addAll(broken);
			System.out.println(broken.size());
		}
	}
	
}
