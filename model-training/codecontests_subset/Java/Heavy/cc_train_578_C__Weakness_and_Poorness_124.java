
import java.util.Scanner;

public class WeaknessPoorness3 {

    public static final double ERR = 1e-7;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        double result = goldSearch(a);
        System.out.println(result);
    }

    private static double ternarySearch(int[] a) {
        double min = -10000;
        double max = 10000;
        double w1 = 0;
        double w2 = 0;

        while (Math.abs(max - min) > ERR || Math.abs(w1 - w2) > ERR) {
            double m1 = min + (max - min) / 3;
            double m2 = min + 2 * (max - min) / 3;
            w1 = weakness(a, m1);
            w2 = weakness(a, m2);
            if (w1 < w2) {
                max = m2;
            } else {
                min = m1;
            }
        }

        return weakness(a, (max + min) / 2);
    }


    private static double goldSearch(int[] arr) {
        double r1 = (Math.sqrt(5) - 1.0) / 2;
        double r2 = r1 * r1;

        double a = -10000;
        double b = 10000;
        double c = a + r2 * (b - a);
        double d = a + r1 * (b - a);
        double fc = weakness(arr, c);
        double fd = weakness(arr, d);


        while (Math.abs(c - d) > ERR || Math.abs(fc - fd) > ERR) {
            if (fc < fd) {
                b = d;
                d = c;
                fd = fc;
                c = a + r2 * (b - a);
                fc = weakness(arr, c);
            } else {
                a = c;
                c = d;
                fc = fd;
                d = a + r1 * (b - a);
                fd = weakness(arr, d);
            }
        }

        return weakness(arr, (c + d) / 2);
    }

    private static double weakness(int[] a, double x) {
        double maxSum = Integer.MIN_VALUE;
        double minSum = Integer.MAX_VALUE;

        double curMax = 0;
        double curMin = 0;
        for (int anA : a) {
            curMax += (anA - x);
            curMin += (anA - x);
            if (curMax > maxSum) {
                maxSum = curMax;
            }
            if (curMin < minSum) {
                minSum = curMin;
            }
            if (curMax < 0) {
                curMax = 0;
            }
            if (curMin > 0) {
                curMin = 0;
            }
        }
        return Math.max(Math.abs(minSum), Math.abs(maxSum));
    }
}