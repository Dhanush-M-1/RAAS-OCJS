import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author ZYCSwing
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskD solver = new TaskD();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskD {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int n = in.nextInt(), d = in.nextInt();

            int[] a = new int[n + 1];
            for (int i = 1; i <= n; ++i) {
                a[i] = in.nextInt();
            }

            // after day i's night the upper bound of account
            long[] upper = new long[n + 1];
            // after day i's night the lower bound of account
            long[] lower = new long[n + 1];

            long tmp = d;
            for (int i = n; i >= 1; --i) {
                upper[i] = tmp;
                if (tmp < 0 && a[i] == 0) {
                    out.println(-1);
                    return;
                }
                tmp -= a[i];
                tmp = Math.min(tmp, d);
            }

            lower[0] = 0;
            for (int i = 1; i <= n; ++i) {
                lower[i] = lower[i - 1] + a[i];
                if (a[i] == 0) {
                    lower[i] = Math.max(0, lower[i]);
                }
                if (lower[i] > upper[i]) {
                    out.println(-1);
                    return;
                }
            }

            int cnt = 0;
            long cur = 0;
            for (int i = 1; i <= n; ++i) {
                cur += a[i];
                if (cur < lower[i]) {
                    ++cnt;
                    cur = upper[i];
                }
            }

            out.println(cnt);
        }

    }
}

