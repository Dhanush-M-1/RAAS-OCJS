import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author mikit
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        BRng10s solver = new BRng10s();
        solver.solve(1, in, out);
        out.close();
    }

    static class BRng10s {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int t = in.nextInt();
            outer:
            for (int i = 0; i < t; i++) {
                long a = in.nextLong(), b = in.nextLong(),
                        c = in.nextLong(), d = in.nextLong();
                if (a < b || b > d) {
                    out.println("No");
                    continue;
                } else if (b - c <= 1) {
                    out.println("Yes");
                    continue;
                }
                long mod = gcd(b, d);
                if (b - c > mod + 1) {
                    out.println("No");
                    continue;
                }
                long lb = (c + 1) % mod;
                long ub = (b - 1) % mod;
                a %= mod;
                if (lb <= ub) {
                    if (lb <= a && a <= ub) {
                        out.println("No");
                        continue;
                    }
                } else {
                    if (a <= ub || lb <= a) {
                        out.println("No");
                        continue;
                    }
                }
                out.println("Yes");//高須クリニック?
            }
        }

        private static long gcd(long u, long v) {
            long k, t;
            k = 0;
            while ((0 == (u & 1)) && (0 == (v & 1))) {
                k++;
                u /= 2;
                v /= 2;
            }
            if ((u & 1) == 0) {
                t = u / 2;
            } else {
                t = -v;
            }

            do {
                while ((t & 1) == 0) t /= 2;

                if (t > 0) {
                    u = t;
                } else {
                    v = -t;
                }

                t = u - v;
            } while (0 != t);
            return u * (1 << k);
        }

    }
}

