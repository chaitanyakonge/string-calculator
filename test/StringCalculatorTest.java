import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class StringCalculatorTest {
	@Test
    	void testEmptyStringReturnsZero() {
        	StringCalculator calc = new StringCalculator();
        	assertEquals(0, calc.add(""), "Empty string should return 0");
    	}
    	
    	@Test
    	void testSingleNumberReturnsValue() {
        	StringCalculator calc = new StringCalculator();
        	assertEquals(1, calc.add("1"), "Single number should return itself");
    	}
    	
	@Test
	void testTwoNumbersReturnSum() {
	    StringCalculator calc = new StringCalculator();
	    assertEquals(3, calc.add("1,2"), "Two numbers should return their sum");
	}
	
	@Test
	void testMultipleNumbersReturnSum() {
	    StringCalculator calc = new StringCalculator();
	    assertEquals(6, calc.add("1,2,3"), "Multiple numbers should return their sum");
	    assertEquals(10, calc.add("1,2,3,4"), "Four numbers should return their sum");
	}
	
	@Test
	void testNumbersWithNewlines() {
	    StringCalculator calc = new StringCalculator();
	    assertEquals(6, calc.add("1\n2,3"), "Numbers separated by newlines and commas should sum correctly");
	    assertEquals(10, calc.add("1\n2\n3,4"), "Multiple numbers with newlines and commas should sum correctly");
	}
	
	@Test
	void testCustomDelimiter() {
	    StringCalculator calc = new StringCalculator();
	    assertEquals(3, calc.add("//;\n1;2"), "Custom single-character delimiter ';' should work");
	    assertEquals(6, calc.add("//|\n1|2|3"), "Custom single-character delimiter '|' should work");
	}
	
	@Test
	void testNegativeNumbersThrowException() {
	    StringCalculator calc = new StringCalculator();

	    Exception exception = assertThrows(
		IllegalArgumentException.class,
		() -> calc.add("-1,2,-3"),
		"Adding negative numbers should throw an exception"
	    );

	    assertTrue(exception.getMessage().contains("-1"));
	    assertTrue(exception.getMessage().contains("-3"));
	}
	
	@Test
	void testGetCalledCount() {
	    StringCalculator calc = new StringCalculator();

	    // Initially, add() hasn't been called
	    assertEquals(0, calc.GetCalledCount(), "GetCalledCount should be 0 initially");

	    // Call add() multiple times
	    calc.add("1,2");
	    assertEquals(1, calc.GetCalledCount(), "GetCalledCount should be 1 after first call");

	    calc.add("3,4,5");
	    assertEquals(2, calc.GetCalledCount(), "GetCalledCount should be 2 after second call");
	}
	
	@Test
	void testNumbersGreaterThan1000AreIgnored() {
	    StringCalculator calc = new StringCalculator();

	    assertEquals(2, calc.add("2,1001"), "Numbers greater than 1000 should be ignored");
	    assertEquals(1002, calc.add("2,1000"), "1000 should be included");
	    assertEquals(0, calc.add("1001,2000"), "All numbers >1000 should be ignored");
	}

}

