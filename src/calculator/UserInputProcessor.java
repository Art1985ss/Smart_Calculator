package calculator;

import java.util.Arrays;
import java.util.Scanner;

public class UserInputProcessor {
    private final Scanner scanner = new Scanner(System.in);

    public String inputLine() {
        return scanner.nextLine();
    }

    public int[] parseInts(String input) throws CalculatorException {
        try {
            return Arrays.stream(input.split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        } catch (Exception e) {
            throw new CalculatorException("Could not parse input : |" + input + "|");
        }
    }

    public boolean isParsable(String[] str) {
        return Arrays.stream(str).allMatch(this::isParsable);
    }

    public boolean isParsable(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
