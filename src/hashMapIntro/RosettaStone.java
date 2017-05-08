//Copyright © 2017 by Cole Trammer
package hashMapIntro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;

public class RosettaStone implements ActionListener {

	private JFrame frame;
	private JButton button;
	private HashMap<String, String> map;
	private boolean spanish = true;
	
	public RosettaStone() {
		
		map = new HashMap<String, String>();
		
		map.put("comer", "to eat");
		map.put("beber", "to drink");
		map.put("agua", "water");
		map.put("pluma", "pen");
		map.put("gato", "cat");
		map.put("perro", "dog");
		map.put("bebida", "drink");
		map.put("camino", "road");
		map.put("avenida", "avenue");
		map.put("computadora", "computer");
		map.put("poner", "to put");
		map.put("escribir", "to write");
		map.put("leer", "to read");
		map.put("hablar", "to talk");
		map.put("hola", "hi");
		
		frame = new JFrame();
		frame.setVisible(true);
		frame.setSize(200, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		button = new JButton();
		frame.add(button);
		
		button.addActionListener(this);
		button.setText(getRandomKey());
		
	}
	
	private String getRandomKey() {
		String[] keysAsArray = map.keySet().toArray(new String[0]);
		int randomness = new Random().nextInt(map.size());
		return keysAsArray[randomness];		
	}
	
	public static void main(String args[]) {
		new RosettaStone();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (spanish) {
			String key = button.getText();
			button.setText(map.get(key));
		} else {
			button.setText(getRandomKey());
		}
		spanish = !spanish;
	}
}
