import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HelpfulMaths {

    private static final Scanner scanner = new Scanner(System.in);
    private static String input;

    public static void main(String[] args) {
        readInput();
        System.out.println(helpfulMaths(input));
    }

    private static void readInput() {
        input = scanner.nextLine();
    }

    private static String helpfulMaths(String input) {

        List<Integer> numbers = new ArrayList<>();

        for (char c : input.toCharArray()) {

            if (c != '+') {
                String numAsStr = String.valueOf(c);
                Integer num = Integer.parseInt(numAsStr);
                numbers.add(num);
            }
        }

        Collections.sort(numbers);

        return numbers.stream()
                      .map(String::valueOf)
                      .collect(Collectors.joining("+"));
    }

}
