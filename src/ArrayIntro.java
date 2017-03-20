import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ArrayIntro {

	public static void main(String[] args) {
		
		int arr[] = new int[3];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(JOptionPane.showInputDialog("Input a number."));
		}
		System.out.println(Math.min(Math.min(arr[0], arr[1]), arr[2]));
		System.out.println(Math.min(Math.max(arr[0], arr[1]), arr[2]));
		System.out.println(Math.max(Math.max(arr[0], arr[1]), arr[2]));
	}	
}

/*
for (int j = 0; j < arr.length - 1; j++) {
	for (int i = 0; i < arr.length - 1; i++) {
		if (arr[i] > arr[i + 1]) {
			int tmp = arr[i];
			arr[i] = arr[i + 1];
			arr[i + 1] = tmp;
		}
	}
} 
for (int num : arr) {
	System.out.println(num);
} */