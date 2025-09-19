import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class StringCalculatorTest {
	@Test
    	void testEmptyStringReturnsZero() {
        	StringCalculator calc = new StringCalculator();
        	assertEquals(0, calc.add(""), "Empty string should return 0");
    	}
}

