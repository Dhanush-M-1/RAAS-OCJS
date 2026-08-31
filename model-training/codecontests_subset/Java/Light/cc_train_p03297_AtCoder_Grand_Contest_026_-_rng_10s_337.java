import java.util.*;

public class Main {
    public static long gcd(long x, long y) {
        if (y == 0) {
            return x;
        } else {
            return gcd(y, x - (x / y) * y);
        }
    }

    public static long quotient(long n, long k) {
        return n >= 0 ? n / k : n / k - 1;
    }

    public static void main(String[] args) {
        // read inputs
        Scanner in = new Scanner(System.in);
        final int N = in.nextInt();
        long[] as = new long[N], bs = new long[N], cs = new long[N], ds = new long[N];
        for (int i = 0; i < N; i++) {
            as[i] = in.nextLong();
            bs[i] = in.nextLong();
            cs[i] = in.nextLong();
            ds[i] = in.nextLong();
        }

        // solve
        for (int i = 0; i < N; i++) {
            final long a = as[i], b = bs[i], c = cs[i], d = ds[i];
            if (b > d) {
                System.out.printf("No\n");
            } else {
                if (Math.min(a, c) >= b) {
                    System.out.printf("Yes\n");
                } else if (a < b) {
                    System.out.printf("No\n");
                } else { // a >= b && c < b
                    final long gcdBD = gcd(b, d);
                    final long a0 = a % b;
                    final long num = a0 + (quotient(c - a0, gcdBD) + 1) * gcdBD;
                    if (num < b) {
                        System.out.printf("No\n");
                    } else {
                        System.out.printf("Yes\n");
                    }
                }
            }
        }
    }
}
