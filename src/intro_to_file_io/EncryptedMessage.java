//Copyright © 2017 by Cole Trammer
package intro_to_file_io;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class EncryptedMessage {

	public static final int offset = 15;
	
	public static void main(String[] args) {
		
		String message = JOptionPane.showInputDialog("Enter a message.");

		try {
			FileWriter fw = new FileWriter("src/intro_to_file_io/test3.txt", true);
			String encrtypted = "";
			for (int i = 0; i < message.length(); i++) {
				encrtypted += Character.toString((char)((int)message.charAt(i) + offset));
			}
			fw.write(encrtypted + "\n");
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
}
