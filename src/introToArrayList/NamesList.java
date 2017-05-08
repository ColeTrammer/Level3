//Copyright © 2017 by Cole Trammer
package introToArrayList;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class NamesList implements ActionListener {
	
	private JFrame frame;
	private JPanel panel;
	private JButton add;
	private JButton view;
	private JButton delete;
	private ArrayList<String> names;
	
	public NamesList() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setSize(800, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel();
		frame.add(panel);
		add = new JButton("Add");
		view = new JButton("View");
		delete = new JButton("Delete");
		panel.add(add);
		panel.add(view);
		panel.add(delete);
		names = new ArrayList<String>();
		add.addActionListener(this);
		view.addActionListener(this);
		delete.addActionListener(this);
	}
	
	public static void main(String[] args) {
		new NamesList();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(add)) {
			names.add(JOptionPane.showInputDialog("Input a name."));
			
		} else if (e.getSource().equals(view)) {
			String namesS = "Names: ";
			for (int i = 0; i < names.size(); i++) {
				if (i != names.size() - 1) {
					namesS += names.get(i) + ", ";
				} else {
					namesS += names.get(1);
				}
			}
			JOptionPane.showMessageDialog(frame, namesS);
		} else {
			String name = JOptionPane.showInputDialog("Type a name to delete.");
			if (names.contains(name)) {
				names.remove(name);
			}
		}
		
	}
	
}
