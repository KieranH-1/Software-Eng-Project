package src;

public class ComputeEngineImpl implements ComputeEngine {

	private static final String[] ONES = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    private static final String[] TEENS = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", 
                                           "seventeen", "eighteen", "nineteen"};
    private static final String[] TENS = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    private static final String[] HUNDREDS = {"", "one-hundred", "two-hundred", "three-hundred", "four-hundred", 
                                              "five-hundred", "six-hundred", "seven-hundred", "eight-hundred", 
                                              "nine-hundred"};

	 @Override
    public String compute(int value) {
        if (value < 0 || value > 999) {
            throw new IllegalArgumentException("Invalid number, please choose between 0-999.");
        }

        StringBuilder valueAsWord = new StringBuilder();

        if (value == 0) {
            return "zero";
        }

        if (value >= 100) {
            int hundreds = value / 100;
            valueAsWord.append(HUNDREDS[hundreds]).append(" ");
            value %= 100;
        }

        if (value >= 20) {
            int tens = value / 10;
            int ones = value % 10;
            valueAsWord.append(TENS[tens]);
            if (ones != 0) {
                valueAsWord.append("-").append(ONES[ones]);
            }
        } else if (value >= 10) {
            valueAsWord.append(TEENS[value - 10]);
        } else {
            valueAsWord.append(ONES[value]);
        }

        return valueAsWord.toString().trim();
    }
}