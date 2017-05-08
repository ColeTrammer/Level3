//Copyright © 2017 by Cole Trammer
package hashMapIntro;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class LogSearch implements ActionListener {

	HashMap<Integer, String> map;
	
	JFrame frame;
	JPanel panel;
	JButton add;
	JButton search;
	JButton view;
	JButton delete;
	
	public LogSearch() {
		map = new HashMap<Integer, String>();
		
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(800, 800));
		
		add = new JButton("Add");
		add.addActionListener(this);
		
		search = new JButton("Search");
		search.addActionListener(this);
		
		view = new JButton("View");
		view.addActionListener(this);
		
		delete = new JButton("Delete");
		delete.addActionListener(this);
		
		panel.add(add);
		panel.add(search);
		panel.add(view);
		panel.add(delete);
		
		frame.add(panel);
		frame.pack();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton pressed = (JButton) e.getSource();
		
		if (pressed.equals(add)) {
			int key;
			try {
				String in = JOptionPane.showInputDialog(frame, "Enter an ID.");
				if (in == null) {
					return;
				}
				key = Integer.parseInt(in);
			} catch (Exception e1) {
				actionPerformed(e);
				return;
			}
			String val = JOptionPane.showInputDialog(frame, "Enter a name.");
			map.put(key, val);
		} else if (pressed.equals(search)) {
			int key;
			try {
				String in = JOptionPane.showInputDialog(frame, "Enter an ID.");
				if (in == null) {
					return;
				}
				key = Integer.parseInt(in);
			} catch (Exception e1) {
				actionPerformed(e);
				return;
			}
			if (map.get(key) != null) {
				JOptionPane.showMessageDialog(frame, "The name is " + map.get(key) + ".");
			} else {
				JOptionPane.showMessageDialog(frame, "The id does not exist.");
			}
		} else if (pressed.equals(view)) {
			String s = "";
			for (int i : map.keySet()) {
				s += "ID: " + i + " Name: " + map.get(i) + "\n";
			}
			JOptionPane.showMessageDialog(frame, s);
		} else {
			int key;
			try {
				String in = JOptionPane.showInputDialog(frame, "Enter an ID.");
				if (in == null) {
					return;
				}
				key = Integer.parseInt(in);
			} catch (Exception e1) {
				actionPerformed(e);
				return;
			}
			if (map.remove(key) == null) {
				JOptionPane.showMessageDialog(frame, "The ID does not exist.");
			}
		}
	}
	
	public static void main(String[] args) {
		new LogSearch();
	}
	
	 /*
		 * Crate a HashMap of Integers for the keys and Strings for the values.
		 * Create a GUI with three buttons.
		 * Button 1: Add Entry
		 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
		 * 				After an ID is entered, use another input dialog to ask the user to enter a name.
		 * 				Add this information as a new entry to your HashMap.
		 *
		 * Button 2: Search by ID
		 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
		 * 				If that ID exists, display that name to the user.
		 * 				Otherwise, tell the user that that entry does not exist.
		 *
		 * Button 3: View List
		 * 				When this button is clicked, display the entire list in a message dialog in the following format:
		 * 				ID: 123  Name: Harry Howard
		 * 				ID: 245  Name: Polly Powers
		 * 				ID: 433  Name: Oliver Ortega
		 * 				etc...
		 *
		 * When this is complete, add a fourth button to your window.
		 * Button 4: Remove Entry
		 * 				When this button is clicked, prompt the user to enter an ID using an input dialog.
		 * 				If this ID exists in the HashMap, remove it. Otherwise, notify the user that the ID
		 * 				is not in the list.
		 *
		 * */

}
