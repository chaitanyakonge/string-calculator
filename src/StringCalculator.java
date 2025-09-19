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

public class StringCalculator {
    public int add(String numbers) {
    if (numbers.isEmpty()) return 0;

    String[] parts = numbers.split(","); // works for single or multiple numbers
    int sum = 0;
    for (String part : parts) {
        sum += Integer.parseInt(part);
    }
    return sum;
}

}


