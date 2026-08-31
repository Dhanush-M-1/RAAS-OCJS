import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            int d = scanner.nextInt();

            if (d < l || r < d) {
                System.out.println(d);
            } else {
                if (r % d == 0) {
                    System.out.println(d * ((r / d) + 1));
                } else {
                    System.out.println(Math.round(d * Math.ceil(1.0 * r / d)));
                }
            }
        }
    }
}
