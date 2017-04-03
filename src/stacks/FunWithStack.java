package stacks;

import java.util.Stack;

public class FunWithStack {

	public static String reverseString(String str) {
		Stack<Character> stack = new Stack<Character>();
		String reverse = "";
		for (int i = 0; i < str.length(); i++) {
			stack.push(str.charAt(i));
		}
		while(!stack.empty()) {
			reverse += stack.pop();
		}
		return reverse;
	}
	
	public static void main(String[] args) {
		
		Stack<String> stack = new Stack<String>();
		stack.push("A");
		stack.push("B");
		stack.push("C");
		stack.push("D");
		stack.push("E");	
		while(!stack.empty()) {
			System.out.println(stack.pop());
		}
		System.out.println(reverseString("ABC DEF"));
	}
}
