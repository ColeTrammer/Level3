//Copyright © 2017 by Cole Trammer
package intro_to_file_io;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyRight {

	public static void main(String[] args) {
		
		File src = new File("src");
		File[] list = src.listFiles();
		
		modifyAll(list);
	}
	
	public static void modifyAll(File[] list) {
		for (int i = 0; i < list.length; i++) {
			if (list[i].isFile()) {
				System.out.println(list[i].getAbsolutePath());
				if (list[i].getAbsolutePath().contains(".java")) {
					try {		
						String file = "";
						FileReader r = new FileReader(list[i]);	
						int c = r.read();
						while(c != -1){
							file += (char)c;
							c = r.read();
						}
						r.close();
						
						if (!file.contains("//Copyright © 2017 by Cole Trammer")) {
							FileWriter w = new FileWriter(list[i]);		
							w.write("//Copyright © 2017 by Cole Trammer\n" + file);
							w.close();
						}
						
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			} else if (list[i].isDirectory()) {
				modifyAll(list[i].listFiles());
			}
		}
	}
	
}
