
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final int OO = (int) 1e9;

    public static void main(String[] args) {
        int n = scanner.nextInt(), r = 0, l = 0;
        int[] x = new int[n], h = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = scanner.nextInt();
            h[i] = scanner.nextInt();
        }
        if (n == 1) {
            System.out.println(1);
        } else {
            l = x[0];
            for (int i = 1; i < n - 1; i++) {
                if (l < x[i] - h[i]) {
                    r += 1;
                    l = x[i];
                } else if (x[i + 1] > x[i] + h[i]) {
                    r += 1;
                    l = x[i] + h[i];
                } else {
                    l = x[i];
                }
            }
            System.out.println(r + 2);
        }
    }
}

