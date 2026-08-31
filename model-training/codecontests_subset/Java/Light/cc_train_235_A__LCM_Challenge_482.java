import java.util.Scanner;

public class n235A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        if (n <= 2)
            System.out.println(n);
        else {
            if (n % 2 == 0) {
                if (n % 3 == 0)
                    System.out.println(Math.max(n * (n - 1) * (n - 2) / 2, (n - 1) * (n - 2) * (n - 3)));
                else
                    System.out.println(n * (n - 1) * (n - 3));
            } else
                System.out.println(n * (n - 1) * (n - 2));
        }
    }
}
