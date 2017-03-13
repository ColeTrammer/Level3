import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.*;

public class VisualArraySorter {

	static int width = 800;
	static int height = 800;
	static int arr[] = new int[width];

	public static void main(String[] args) {

		initArray();
		JFrame frame = new JFrame();
		frame.setSize(width, height + 22);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel() {
			@Override
			public void paint(Graphics g) {
				g.setColor(new Color(200, 50, 50));
				g.fillRect(0, 0, width, height);
				g.setColor(new Color(100, 100, 100));
				for (int i = 0; i < arr.length; i++) {
					g.fillRect(i, 0, 1, arr[i]);
				}
				for (int i = 0; i < arr.length - 1; i++) {
					if (arr[i] < arr[i + 1]) {
						int tmp = arr[i];
						arr[i] = arr[i + 1];
						arr[i + 1] = tmp;
					}
				} 
			}
		};
		panel.setSize(new Dimension(width, height));
		frame.add(panel);

		while (true) {
			panel.repaint();
			try {
				Thread.sleep(1000 / 60);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private static void initArray() {
		Random r = new Random();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = r.nextInt(height);
		}
	}
	
}
