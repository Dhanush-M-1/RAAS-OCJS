import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int a, b;

        a = scanner.nextInt();
        b = scanner.nextInt();
        int ctr = 0, remaining = 0;

        while (a >= b) {
            ctr += a;
            remaining += a % b;
            a /= b;
            if (remaining >= b) {
                a += remaining / b;
                remaining = remaining % b;
            }
        }

        System.out.println(ctr + a + (remaining + a) / b);
    }
}