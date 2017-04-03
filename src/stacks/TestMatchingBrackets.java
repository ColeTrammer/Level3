package stacks;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Stack;

import org.junit.Test;

public class TestMatchingBrackets {

	@Test
	public void testMatchingBrackets() {
		assertTrue(doBracketsMatch("{}"));
		assertTrue(doBracketsMatch("{{}}"));
		assertTrue(doBracketsMatch("{}{}{{}}"));
		assertFalse(doBracketsMatch("{{}"));
		assertFalse(doBracketsMatch("}{"));
	}

	private boolean doBracketsMatch(String b) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < b.length(); i++) 
			if (b.charAt(i) == '{') 
				stack.push('{');
			else 
				if (!stack.empty())
					stack.pop();
				 else 
					return false;
		
		return stack.empty();
	}

}