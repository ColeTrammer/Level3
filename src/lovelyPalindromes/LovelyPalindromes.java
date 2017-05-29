package lovelyPalindromes;

import java.io.BufferedReader;
import java.io.FileReader;

public class LovelyPalindromes {

	public LovelyPalindromes() {
	}
	
	public void listAll() {
		try {
			
			BufferedReader br = new BufferedReader(new FileReader("src/lovelyPalindromes/words.txt"));
			
			String line = br.readLine();
			while (line != null) {
				if (isPalindrome(line)) {
					System.out.println(line);
				}
				line = br.readLine();
			}
			br.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {

		new LovelyPalindromes().listAll();
		
	}

	public boolean isPalindrome(String s) {
		String filtered = s.toLowerCase().replaceAll("[^a-z]", "");
		
		return filtered.equals(new StringBuilder(filtered).reverse().toString());
	}
	
}
