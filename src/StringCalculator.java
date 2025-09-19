/*	Input:		comma seperated numbers
	Output:		(int)(sum of all numbers)
		-can take any number of arguments(numbers)
		-new lines between numbers is allowed instead of commas, now 2 delimeters => 	[',','\n']
			eg.	"1,3,2\n4,5\n6,7,9"
		-To change the delimiter, the beginning of the string will contain a separate line : "//[delimiter]\n[numbers…]"
			eg.	"//;\n1;2" 	; as delimeter.
				"//[***]\n1***2***3"	*** as the delimeter	
		-Calling add with a negative number will throw an exception: "negative numbers not allowed <negative_number>".
			If there are multiple negative numbers, show all of them in the exception message, separated by commas.
*/
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    private int callCount = 0; // track number of add() calls

    public int add(String numbers) {
        callCount++; // increment counter

        if (numbers.isEmpty()) return 0;

        String delimiter = ","; // default
        if (numbers.startsWith("//")) {
            delimiter = String.valueOf(numbers.charAt(2));
            numbers = numbers.substring(4);
        }

        numbers = numbers.replace("\n", delimiter);

        String[] parts = numbers.split(Pattern.quote(delimiter));
        int sum = 0;
        List<Integer> negatives = new ArrayList<>();

        for (String part : parts) {
	    int num = Integer.parseInt(part);
	    if (num < 0) {
		negatives.add(num);
	    }
	    if (num <= 1000) {   // Ignore numbers >1000
		sum += num;
	    }
	}

        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("Negatives not allowed: " + negatives);
        }

        return sum;
    }

    public int GetCalledCount() {
        return callCount;
    }
}


