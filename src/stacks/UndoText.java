package stacks;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class UndoText implements KeyListener {

	private JFrame frame;
	private JLabel label;
	private Stack<Character> stack = new Stack<Character>();
	
	public UndoText() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);
		label = new JLabel();
		frame.add(label);
		frame.addKeyListener(this);
	}
	
	public static void main(String[] args) {
		new UndoText();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		String currentText = label.getText();
		if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			if (currentText.length() != 0) {
				stack.push(currentText.charAt(currentText.length() - 1));
				label.setText(currentText.substring(0, currentText.length() - 1));
			}
		} else if (e.getKeyCode() == KeyEvent.VK_DELETE) {
			if (!stack.empty())
				label.setText(currentText + stack.pop());
		} else {
			label.setText(currentText + e.getKeyChar());
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
