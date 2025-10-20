package calculator;

public class StringCalculator {

    public int calculate(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String delimiter = "[,:]";
        String numbersString = input;

        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\n");
            String customDelimiter = input.substring(2, delimiterEndIndex);
            delimiter = escapeRegex(customDelimiter);
            numbersString = input.substring(delimiterEndIndex + 1);
        }

        String[] numbers = numbersString.split(delimiter);
        return sum(numbers);
    }

    private String escapeRegex(String delimiter) {
        return delimiter.replaceAll("[\\[\\]{}()*+?.\\\\^$|]", "\\\\$0");
    }

    private int sum(String[] numbers) {
        int total = 0;
        for (String number : numbers) {
            int value = Integer.parseInt(number);
            if (value < 0) {
                throw new IllegalArgumentException();
            }
            total += value;
        }
        return total;
    }
}
