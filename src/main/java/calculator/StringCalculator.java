package calculator;

public class StringCalculator {

    public int calculate(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String[] numbers = input.split(",");
        return sum(numbers);
    }

    private int sum(String[] numbers) {
        int total = 0;
        for (String number : numbers) {
            total += Integer.parseInt(number);
        }
        return total;
    }
}
