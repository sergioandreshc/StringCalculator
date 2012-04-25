package app;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringCalculatorTest {

	@Test
	public void testAdd() {
		
		assertEquals("Result", 50, StringCalculator.add("50"));

		/////// Tests of version one
		assertException("null value must throw an exception  and it doesn´t.", null);
		assertEquals("Empty string must return 0", 0, StringCalculator.add(""));
		assertEquals("A lone decimal must return the same one", 2, StringCalculator.add("2"));
		assertException("Spaces on the string are supposed  to make the method throw an exception", "1 2");
		assertException("The characters that are not decimal or separator  are supposed  to make the method throw an exception", "i2");
		assertEquals("The sum of two numbers is not correct", 15, StringCalculator.add("13,2"));
		assertException("The characters that are not decimal or separator  are supposed to make the method throw an exception", "2 f3,20i");

		/////// Test of version two
		assertEquals("The sum of three numbers is not correct", 10, StringCalculator.add("3,2,5"));
		assertEquals("The sum of three numbers is not correct", 10, StringCalculator.add("03,002,005"));
		assertException("The characters that are not decimal or separator  are supposed to make the method throw an exception", "3,2,y5");
		
		/////// Test of version tree
		assertEquals("The use of new lines and coma isn't working", 6, StringCalculator.add("1,2\n3"));
		assertEquals("The use of new lines and coma isn't working", 6, StringCalculator.add("1,2,3"));
		assertEquals("The use of new lines and coma isn't working", 6, StringCalculator.add("1\n2\n3"));
		assertException("Consecutive separators  are supposed to make the method throw an exception", "23,\n204");
		assertException("Consecutive separators  are supposed to make the method throw an exception", "23\n,204");
		assertException("Consecutive separators  are supposed to make the method throw an exception", "23,\n204");
		assertException("Consecutive separators  are supposed to make the method throw an exception", "23\n\n204");
		assertException("Consecutive separators  are supposed to make the method throw an exception", "23,,,,,,,,,,,,,,,,204");
		assertException("Consecutive separators  are supposed to make the method throw an exception", "23\n\n\n\n\n\n\n\n204");
		assertException("Consecutive separators  are supposed to make the method throw an exception", "23,,,,\n\n,,\n\n\n204");
		assertException("Consecutive separators  are supposed to make the method throw an exception", "23,,,,\n  ,,\n\n\n204");
		
		/////// Test of version four 
		assertEquals("The definition of s as a delimiter doesn't works", 50, StringCalculator.add("//s\n23s20s2s5"));
		assertEquals("The definition of t as a delimiter doesn't works", 50, StringCalculator.add("//t\n23t20t2t5"));
		assertException("Consecutive separators  are supposed to make the method throw an exception", "//t\n23tt204");
		assertException("Separators  without the other value are supposed to make the method throw an exception", "//t\n23t204t");
		assertException("Separators  without the other value are supposed to make the method throw an exception", "//t\nt23t204");
		assertException("Non delimiter characters are supposed to make the method throw an exception", "//,\n23,2f04");
		assertException("Non delimiter characters are supposed to make the method throw an exception", "//t\n23,204,45");
		assertEquals("The definition of t as a delimiter doesn't works", 20, StringCalculator.add("//t\n2t4t6t8"));

		/////// Test of version five 
		assertException("Negative values are supposed to be validated", "//t\n2t4t-6t8");
		assertException("Negative values and non delimiter characters are supposed to be validated", "//t\n2t4cct-6t8");
		assertException("Negative values and non delimiter characters are supposed to be validated", "//t\n-2t-4t-6t-8");

		
	}
	
	/**
	 * This method test if the method throws an exception for the given argument
	 * as expected to do, if It’s not the case it fails.
	 * @param errorMessage the message to show if the method doesn´t throw the exception
	 * as expected
	 * @param argument the argument for wish the method is supposed to throw an exception 
	 */
	private void assertException(String errorMessage, String argument){
		try{
			assertEquals("", StringCalculator.add(argument), StringCalculator.add(argument));
			fail(errorMessage);
		}catch (Exception e) {}
	}

}
