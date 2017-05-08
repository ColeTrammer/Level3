//Copyright © 2017 by Cole Trammer
package intro_to_file_io;

import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.JFileChooser;

public class DecryptMessage {

	public static void main(String[] args) {
		
		try {
			String fp = "";
			JFileChooser jfc = new JFileChooser();
			int returnVal = jfc.showOpenDialog(null);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				fp = jfc.getSelectedFile().getAbsolutePath();
			}

			BufferedReader br = new BufferedReader(new FileReader(fp));
			
			String line = br.readLine();
			
			while(line != null){
				
				String s = "";
				
				for (int i = 0; i < line.length(); i++) {
					s += Character.toString((char)((int)line.charAt(i) - EncryptedMessage.offset));
				}
				
				System.out.println(s);
				line = br.readLine();
			}
			
			br.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
