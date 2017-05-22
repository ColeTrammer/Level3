package hangman;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Hangman implements KeyListener {

	private static final Dimension dimension = new Dimension(800, 800);

	private JFrame frame;
	private JPanel panel;
	private JLabel display;
	private JLabel picture;
	
	private int wordsSolved = 0;
	private int lives = 6;

	private Stack<HashMap<String, ArrayList<Boolean>>> words;
	private ArrayList<ImageIcon> icons;
	private HashSet<Character> used;
	
	private String fp = "src/words.txt";

	public Hangman() {

		words = createWords();
		icons = new ArrayList<>();
		used = new HashSet<>();
		
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setTitle("Hangman");
		frame.setPreferredSize(dimension);
		frame.addKeyListener(this);

		for (int i = 0; i <= lives; i++) {
			icons.add(new ImageIcon("src/hangman/Hangman-" + i + ".png"));
		}
		Collections.reverse(icons);
		System.out.println(String.copyValueOf("a".toCharArray()));
		panel = new JPanel();
		display = new JLabel();
		picture = new JLabel(icons.get(lives));
		panel.add(display);
		panel.add(picture);
		frame.add(panel);
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
		Collections.shuffle(words);
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
		text += "<h2>Already guessed: ";
		for (char c : used) {
			text += c + ", ";
		}
		if (used.isEmpty()) {
			text = text.substring(0, text.length() - "<h2>Already guessed: ".length());
		} else {
			text = text.substring(0, text.length() - 2) + "</h2>";
		}
		display.setText(text + "</html>");
		
		picture.setIcon(icons.get(lives));
		frame.pack();
	}

	public static void main(String[] args) {
		new Hangman();
	}

	@Override
	public void keyTyped(KeyEvent e) {

		char c = e.getKeyChar();
		used.add(c);
		
		boolean correct = false;
		for (String word : words.peek().keySet()) {
			for (int i = 0; i < words.peek().get(word).size(); i++) {
				if (c == word.charAt(i)) {
					words.peek().get(word).set(i, true);
					correct = true;
				}
			}
		}
		if (!correct) {
			lives--;
			if (lives <= 0) {
				updateDisplay();
				JOptionPane.showMessageDialog(frame,
						"You guessed " + wordsSolved + " word" + (wordsSolved != 1 ? "s" : "") + " correctly.");
				System.exit(0);
			}
		}

		boolean fullyCorrect = true;
		for (String word : words.peek().keySet()) {
			for (boolean b : words.peek().get(word)) {
				if (!b) {
					fullyCorrect = false;
				}
			}
		}
		if (fullyCorrect) {
			updateDisplay();
			JOptionPane.showMessageDialog(frame, "You solved it!");
			lives = 6;
			wordsSolved++;
			words.pop();
			used.clear();
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
