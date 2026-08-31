import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        sc.nextLine();
        String input = sc.nextLine();

        int zeros = 0;
        int ones = 0;
        for (int i = 0; i < input.length(); ++i) {
            char c = input.charAt(i);
            if (c == '0') {
                zeros++;
            } else {
                ones++;
            }
        }

        if (zeros == ones) {
            System.out.println("2");
            System.out.println(input.charAt(0) + " " + input.substring(1));
        } else {
            System.out.println("1");
            System.out.println(input);
        }
    }
}