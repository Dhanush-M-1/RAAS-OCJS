import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class C {

    public static void main(String[] args) {
        C solver = new C();
        solver.solve();
    }

    private void solve() {
        Scanner sc = new Scanner(System.in);
//        sc = new Scanner("3\n" +
//                "3 2 2\n");
//        sc = new Scanner("4\n" +
//                "2 2 2 2\n");

        int n = sc.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
        }

        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i];
        }
        long max = a[0];
        for (int i = 1; i < n; i++) {
            max = Math.max(max, a[i]);
        }

        long left = 0;
        long right = 1000000000000L;
        while (left < right) {
            long mid = (left + right) / 2;
            if ((n-1)*mid >= sum && mid >= max) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(right);
    }

}
