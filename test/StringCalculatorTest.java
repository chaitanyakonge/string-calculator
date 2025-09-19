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

}

