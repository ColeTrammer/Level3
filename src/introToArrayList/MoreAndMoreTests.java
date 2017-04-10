package introToArrayList;

import static org.junit.Assert.*;

import org.junit.Test;

public class MoreAndMoreTests {

	@Test
	  public void MultTest() {

	    assertTrue("10 x 0 = 0".equals(multiply(10, 0)));
	    assertTrue("10 x 10 = 100".equals(multiply(10, 10)));
	    assertTrue("8 x 11 = 88".equals(multiply(8, 11)));
	  }

	private String multiply(int i, int j) {
		return i + " x " + j + " = " + i*j;
	}

	@Test
	  public void PrimeTest() {

	    assertTrue(isPrime(3));
	    assertTrue(isPrime(5));
	    assertTrue(isPrime(541));
	    assertFalse(isPrime(4));
	    assertFalse(isPrime(12));
	    assertFalse(isPrime(527));

	  }

	private boolean isPrime(int n) {
		if (n % 2 == 0) {
			return false;
		}
		for (int i = 3; i < n / 2; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	@Test
	  public void SquareTest() {

	    assertTrue(isSquare(4));
	    assertTrue(isSquare(144));
	    assertTrue(isSquare(64));
	    assertTrue(isSquare(10201));
	    assertTrue(isSquare(1));
	    assertFalse(isSquare(3));
	    assertFalse(isSquare(22));
	    assertFalse(isSquare(143));

	  }

	private boolean isSquare(int i) {
		// TODO Auto-generated method stub
		double sqrt = Math.sqrt(i);
		return sqrt == Math.round(sqrt);
	}

	@Test
	  public void CubeTest() {

	    assertFalse(isCube(9));
	    assertTrue(isCube(27));
	    assertTrue(isCube(216));
	    assertTrue(isCube(729));
	    assertTrue(isCube(1));
	    assertFalse(isCube(3));
	    assertFalse(isCube(22));
	    assertFalse(isCube(143));

	  }

	private boolean isCube(int i) {
		double cbrt = Math.cbrt(i);
		System.out.println(cbrt);
		return cbrt == Math.round(cbrt);
	}
}
