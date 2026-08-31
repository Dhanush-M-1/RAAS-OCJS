import java.util.*;

public class P150916_578E {

    public static double calc(long[] a, double x) {
        double bestMax = -1e12;
        double bestMin = 1e12;
        double current = 0;
        for(int i = 0; i < a.length; i++) {
            current = Math.max(current + a[i] - x, 0);
            bestMax = Math.max(bestMax, current);
        }
        current = 0;
        for(int i = 0; i < a.length; i++) {
            current = Math.min(current + a[i] - x, 0);
            bestMin = Math.min(bestMin, current);
        }

        return Math.max(Math.abs(bestMin), bestMax);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        long[] a = new long[N];
        for(int i = 0; i < N; i++) a[i] = scanner.nextLong();

        double l = -1e5;
        double r = 1e5;
        for(int k = 0; k < 100; k++) {
            double mid1 = l + (r - l) / 3;
            double mid2 = l + ((r - l) / 3) * 2;

            if (calc(a, mid1) < calc(a, mid2)) r = mid2; else l = mid1;
        }

        System.out.println(calc(a, (l + r) / 2));

    }

}