import java.util.Arrays;
import java.util.Scanner;

public class HelpfulMaths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final String input = scanner.nextLine();
    
        System.out.println(Arrays.stream(input.split(""))
                                   .filter(s -> !s.equals("+"))
                                   .map(Integer::valueOf)
                                   .sorted()
                                   .map(String::valueOf)
                                   .reduce("", (a, b) -> a = a + b + "+")
                                   .replaceAll("\\+$", ""));
    }
}
