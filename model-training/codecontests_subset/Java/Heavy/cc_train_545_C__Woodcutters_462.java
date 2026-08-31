import java.util.Scanner;

/**
 * Created by alex on 19.05.15.
 */
public class C {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        long x[] = new long[n];
        long h[] = new long[n];

        for (int i = 0; i < n; i++) {
            x[i] = scanner.nextLong();
            h[i] = scanner.nextLong();
        }

        int ans = Math.min(2, n);
        long max = x[0];

        for (int i = 1; i < n - 1; i++) {
            if (x[i] - h[i] > max) {
                ans++;
                max = x[i];
            } else if (x[i] + h[i] < x[i + 1]) {
                ans++;
                max = x[i] + h[i];
            } else {
                max = x[i];
            }
        }

        System.out.println(ans);
    }

}
