
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static int OO = (int) 1e5;
    private static int n;
    private static int[] x = new int[OO], h = new int[OO], r = new int[OO];

    public static void main(String[] args) {
        n = scanner.nextInt();
        r[0] = 1;
        for (int i = 0; i < n; i++) {
            x[i] = scanner.nextInt();
            h[i] = scanner.nextInt();
        }
        System.out.println(r[0] + dp(1));
    }

    private static int dp(int k) {
        if (k == n) {
            return 0;
        }
        if (k == n - 1) {
            return r[k] = 1;
        }
        if (x[k - 1] < x[k] - h[k]) {
            r[k] = 1 + dp(k + 1);
            return r[k];
        }
        if (x[k + 1] > x[k] + h[k]) {
            x[k] += h[k];
            r[k] = 1 + dp(k + 1);
            return r[k];
        }
        r[k] = dp(k + 1);
        return r[k];
    }
}

