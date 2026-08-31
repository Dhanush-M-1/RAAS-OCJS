import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        CADDi_C solver = new CADDi_C();
        solver.solve(1, in, out);
        out.close();
    }

    static class CADDi_C {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            long n = in.nextLong();
            long p = in.nextLong();
            long copy = p;
            long ans = 1;
            long cnt = 0;

            for (long i = 2; i < Math.sqrt((double) copy) + 2; i++) {
                if (p == 1) break;
                while (p % i == 0) {
                    cnt++;
                    p /= i;
                }
                if (cnt >= n) {
                    ans *= (long) Math.pow(i, (cnt / n));
                }
                cnt = 0;
            }

            if (p != 1) {
                if (1 >= n) {
                    ans *= p * (1 / n);
                }
            }

            out.print(ans);

        }

    }
}

