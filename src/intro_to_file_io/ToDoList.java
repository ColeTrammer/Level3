package intro_to_file_io;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList implements ActionListener {

	private JFrame frame;
	private JPanel panel;
	private JPanel list;
	
	private JButton add;
	private JButton delete;
	private JButton save;
	private JButton load;
	private ArrayList<JLabel> labels;
	
	public ToDoList() {
		
		labels = new ArrayList<>();
		
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(800, 800));
		frame.add(panel);
		frame.pack();
		
		add = new JButton("Add");
		delete = new JButton("Delete");
		save = new JButton("Save");
		load = new JButton("Load");
		
		add.addActionListener(this);
		delete.addActionListener(this);
		save.addActionListener(this);
		load.addActionListener(this);
		
		panel.add(add);
		panel.add(delete);
		panel.add(save);
		panel.add(load);
		
		list = new JPanel();
		panel.add(list);
	}
	
	public static void main(String[] args) {
		new ToDoList();
	}

	private void updateLabels() {
		list.removeAll();
		
		for (JLabel label : labels) {
			list.add(label);
		}
		frame.pack();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(add)) {
			String in = JOptionPane.showInputDialog(frame, "Enter a new task.");
			if (in == null) {
				return;
			}
			labels.add(new JLabel((labels.size() + 1) + ". " + in));
			updateLabels();
		} else if (e.getSource().equals(delete)) {
			String in = JOptionPane.showInputDialog(frame, "Enter a index to remove a task.");
			if (in == null) {
				return;
			}
			try {
				labels.remove(Integer.parseInt(in) - 1);
				updateLabels();
			} catch (Exception e1) {
				actionPerformed(e);
			}			
		} else if (e.getSource().equals(save)) {
			
		} else {
			
		}
		
	}
	
}
