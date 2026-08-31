import java.util.Scanner;

public class D {

    private static Scanner in;

    private static int n;
    private static long[] p, d1, d2, d3;

    private static void solve() {
        n = in.nextInt();
        p = new long[n + 1];
        d1 = new long[n];
        d2 = new long[n];
        d3 = new long[n];
        for (int i = 1; i <= n; i++) {
            p[i] = in.nextLong();
        }
        for (int i = 1; i <= n; i++) {
            if (i < p[i]) {
                d1[(int)(p[i] - i - 1)] += 2;
                d1[((n - i - 1) + n) % n] += (Math.abs(p[i] - 1) - Math.abs(n - p[i])) - 1;
                d1[n - i] += -1 - (Math.abs(p[i] - 1) - Math.abs(n - p[i]));
            } else {
                d1[((n - i - 1) + n) % n] += (Math.abs(p[i] - 1) - Math.abs(n - p[i])) - 1;
                d1[n - i] += -1 - (Math.abs(p[i] - 1) - Math.abs(n - p[i]));
                d1[(int) (p[i] - i + n - 1)] += 2;
            }
            d2[0] += Math.abs((i % n + 1) - p[i]) - Math.abs(i - p[i]);
        }
        for (int i = 1; i < n; i++)
            d2[i] = d2[i - 1] + d1[i - 1];
        for (int i = 1; i <= n; i++)
            d3[0] += Math.abs(p[i] - i);
        for (int i = 1; i < n; i++)
            d3[i] = d3[i - 1] + d2[i - 1];

        long min = d3[0];
        int minI = 0;
        for (int i = 0; i < n; i++) {
            if (d3[i] < min) {
                min = d3[i];
                minI = i;
            }
        }
        System.out.println(min + " " + minI);
    }

    public static void main(String[] args) {
        in = new Scanner(System.in);
        solve();
        System.exit(0);
    }

}
