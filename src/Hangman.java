import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Hangman implements KeyListener {

	private static final Dimension dimension = new Dimension(800, 800);

	private JFrame frame;
	private JPanel panel;
	private JLabel display;

	private int wordsSolved = 0;
	private int lives = 9;

	private Stack<HashMap<String, ArrayList<Boolean>>> words;

	private String fp = "src/words.txt";

	public Hangman() {

		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setTitle("Hangman");
		frame.setPreferredSize(dimension);
		frame.addKeyListener(this);

		panel = new JPanel();
		display = new JLabel("");
		panel.add(display);
		frame.add(panel);

		words = createWords();

		updateDisplay();
	}

	private Stack<HashMap<String, ArrayList<Boolean>>> createWords() {
		Stack<HashMap<String, ArrayList<Boolean>>> words = new Stack<>();

		try {

			BufferedReader br = new BufferedReader(new FileReader(fp));

			String line = br.readLine();

			while (line != null) {
				HashMap<String, ArrayList<Boolean>> word = new HashMap<>();
				ArrayList<Boolean> allFalse = new ArrayList<>();
				for (int i = 0; i < line.length(); i++) {
					allFalse.add(false);
				}
				word.put(line, allFalse);
				words.add(word);
				line = br.readLine();
			}

			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Collections.shuffle(words);
		return words;
	}

	private void updateDisplay() {
		String text = "<html><h2>Guess a letter.</h2><br>";

		String wordDisplay = "<h2>";

		for (String word : words.peek().keySet()) {
			for (int i = 0; i < words.peek().get(word).size(); i++) {
				if (words.peek().get(word).get(i)) {
					wordDisplay += word.charAt(i) + " ";
				} else {
					wordDisplay += "_ ";
				}
			}
		}
		wordDisplay += "</h2><br>";

		text += wordDisplay;
		text += "<h2>You have " + lives + " lives.</h2><br>";
		text += "<h2>You've solved " + wordsSolved + " word" + (wordsSolved != 1 ? "s" : "") + ".</h2><br>";

		display.setText(text + "</html>");
		frame.pack();
	}

	public static void main(String[] args) {
		new Hangman();
	}

	@Override
	public void keyTyped(KeyEvent e) {

		char c = e.getKeyChar();

		boolean correct = false;
		for (String word : words.peek().keySet()) {
			for (int i = 0; i < words.peek().get(word).size(); i++) {
				if (c == word.charAt(i)) {
					words.peek().get(word).set(i, true);
					correct = true;
				}
				System.out.print(word.charAt(i));
			}
		}
		System.out.println();
		if (!correct) {
			lives--;
			if (lives <= 0) {
				JOptionPane.showMessageDialog(frame,
						"You guessed " + wordsSolved + " word" + (wordsSolved != 1 ? "s" : "") + " correctly.");
				System.exit(0);
			}
		}

		boolean fullyCorrect = true;
		for (String word : words.peek().keySet()) {
			for (boolean b : words.peek().get(word)) {
				fullyCorrect = b;
			}
		}
		if (fullyCorrect) {
			lives = 9;
			wordsSolved++;
			words.pop();
			JOptionPane.showMessageDialog(frame, "You solved it!");
		}
		updateDisplay();
	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

}
