import java.util.Arrays;
import java.util.Scanner;

public class Foo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] numbers = s.split("\\+");
        Arrays.sort(numbers);
        System.out.println(String.join("+", numbers));
    }
}
