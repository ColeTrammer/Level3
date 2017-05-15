package intro_to_file_io;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList implements ActionListener {

	private JFrame frame;
	private JPanel panel;

	private JLabel list;
	private JButton add;
	private JButton delete;
	private JButton save;
	private JButton load;
	private ArrayList<String> labels;

	private String fp = "src/intro_to_file_io/tasks.txt";

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

		list = new JLabel();
		panel.add(list);
	}

	public static void main(String[] args) {
		new ToDoList();
	}

	private void updateLabels() {
		list.removeAll();

		String text = "<html>";
		for (int i = 0; i < labels.size(); i++) {
			text += (i + 1) + ". " + labels.get(i) + "<br>";
		}
		list.setText(text + "</html>");
		frame.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(add)) {
			String in = JOptionPane.showInputDialog(frame, "Enter a new task.");
			if (in == null) {
				return;
			}
			labels.add(in);
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

			JFileChooser jfc = new JFileChooser();
			jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			int returnVal = jfc.showOpenDialog(null);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				fp = jfc.getSelectedFile().getAbsolutePath() + "/tasks.txt";
			}

			try {
				FileWriter fw = new FileWriter(fp);

				String text = "";
				for (String item : labels) {
					text += item + "\n";
				}
				fw.write(text);
				fw.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		} else {
			JFileChooser jfc = new JFileChooser();
			int returnVal = jfc.showOpenDialog(null);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				fp = jfc.getSelectedFile().getAbsolutePath();
			}

			labels.clear();
			try {
				BufferedReader br = new BufferedReader(new FileReader(fp));

				String line = br.readLine();
				while (line != null) {
					labels.add(line);
					line = br.readLine();
				}

				br.close();
				updateLabels();
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}

	}

}
