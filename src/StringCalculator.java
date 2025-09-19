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
        callCount++;  // increment call count each time add() is called

        if (numbers.isEmpty()) return 0;

        String delimiter = ","; // default delimiter
        String[] parts;

        if (numbers.startsWith("//")) {
            // Custom delimiter specified
            if (numbers.charAt(2) == '[') {
                // Multi-character delimiter
                int end = numbers.indexOf(']');
                delimiter = numbers.substring(3, end);
                numbers = numbers.substring(end + 2); // remove "//[***]\n"
            } else {
                // Single-character delimiter
                delimiter = String.valueOf(numbers.charAt(2));
                numbers = numbers.substring(4); // remove "//;\n"
            }
            // Split ONLY by the custom delimiter (newlines and commas are ignored)
            parts = numbers.split(Pattern.quote(delimiter));
        } else {
            // Default delimiters: comma and newline
            parts = numbers.split(",|\n");
        }

        int sum = 0;
        List<Integer> negatives = new ArrayList<>();

        for (String part : parts) {
            if (part.isEmpty()) continue; // skip empty parts
            int num = Integer.parseInt(part);
            if (num < 0) negatives.add(num);
            if (num <= 1000) sum += num; // ignore numbers >1000
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



