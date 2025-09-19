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

    // inner interface for event
    public interface AddListener {
        void onAdd(String input, int result);
    }

    private int callCount = 0; // track number of add() calls
    private AddListener listener; // event listener

    public void setAddListener(AddListener listener) {
        this.listener = listener;
    }

    public int add(String numbers) {
        callCount++;  // track call count

        if (numbers.isEmpty()) return 0;

        String[] parts;
        String delimitersRegex = ",|\n"; // default delimiters

        if (numbers.startsWith("//")) {
            int newlineIndex = numbers.indexOf("\n");
            String delimiterSection = numbers.substring(2, newlineIndex);

            // Check for multiple delimiters
            List<String> delimitersList = new ArrayList<>();

            if (delimiterSection.startsWith("[") && delimiterSection.endsWith("]")) {
                // Multiple delimiters
                int start = 0;
                while ((start = delimiterSection.indexOf("[", start)) != -1) {
                    int end = delimiterSection.indexOf("]", start);
                    delimitersList.add(Pattern.quote(delimiterSection.substring(start + 1, end)));
                    start = end + 1;
                }
            } else {
                // Single-character delimiter
                delimitersList.add(Pattern.quote(delimiterSection));
            }

            delimitersRegex = String.join("|", delimitersList);
            numbers = numbers.substring(newlineIndex + 1);
        }

        parts = numbers.split(delimitersRegex);

        int sum = 0;
        List<Integer> negatives = new ArrayList<>();

        for (String part : parts) {
            if (part.isEmpty()) continue;
            int num = Integer.parseInt(part);
            if (num < 0) negatives.add(num);
            if (num <= 1000) sum += num;
        }

        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("Negatives not allowed: " + negatives);
        }

        if (listener != null) {
            listener.onAdd(numbers, sum);
        }

        return sum;
    }

    public int GetCalledCount() {
        return callCount;
    }
}

