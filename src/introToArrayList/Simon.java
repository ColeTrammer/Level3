package introToArrayList;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

public class Simon implements ActionListener {

	private JFrame frame;
	private JPanel panel;
	private ArrayList<JButton> buttons;
	private static ArrayList<Integer> sequence = new ArrayList<Integer>();
	private Random r = new Random();
	private Color colors[] = {Color.yellow, Color.red, Color.green, Color.blue};
	private Color defaultColor;
	private int userInputIndex = 0;
	
	public Simon()  {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);
		panel = new JPanel();
		frame.add(panel);
		
		buttons = new ArrayList<JButton>();
		
		buttons.add(new JButton("1"));
		buttons.add(new JButton("2"));
		buttons.add(new JButton("3"));
		buttons.add(new JButton("4"));
		for (int i = 0; i < buttons.size(); i++) {
			buttons.get(i).setOpaque(true);
			buttons.get(i).addActionListener(this);
			panel.add(buttons.get(i));
		}
		defaultColor = buttons.get(0).getBackground();
		generateNextSequence();
		displaySequence();
	}
	
	private void generateNextSequence() {
		sequence.add(r.nextInt(4));
	}
	
	private void displaySequence() {
		for (int i = 0; i < sequence.size(); i++) {
			try {
				frame.repaint();
				panel.repaint();
				Thread.sleep(200);
				buttons.get(sequence.get(i)).setBackground(colors[sequence.get(i)]);
				Thread.sleep(1000);
				buttons.get(sequence.get(i)).setBackground(defaultColor);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		new Simon();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(buttons.get(sequence.get(userInputIndex)))) {
			userInputIndex++;
			if (userInputIndex == sequence.size()) {
			    SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
			        @Override
			        public Void doInBackground() {
			            // Call complicated code here
						generateNextSequence();
						displaySequence();
						return null;
			            // If you want to return something other than null, change
			            // the generic type to something other than Void.
			            // This method's return value will be available via get() once the
			            // operation has completed.
			        }

			        @Override
			        protected void done() {
			            // get() would be available here if you want to use it

			        }
			    };

			}
		} else {
			userInputIndex = 0;
		}
	}
	
}
