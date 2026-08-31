import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author yittg
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
        long[][] dp = new long[1005][2005];

        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int n = in.nextInt();
            int k = in.nextInt();
            long pos = in.nextLong();
            long[] a = new long[n];
            long[] b = new long[k];
            for (int i = 0; i < n; ++i) {
                a[i] = in.nextLong();
            }
            Arrays.sort(a);
            for (int i = 0; i < k; ++i) {
                b[i] = in.nextLong();
            }
            Arrays.sort(b);
            for (long[] x : dp) {
                Arrays.fill(x, -1);
            }
            dp[0][0] = Math.abs(a[0] - b[0]) + Math.abs(b[0] - pos);
            for (int j = 1; j + n <= k; ++j) {
                dp[0][j] = Math.min(dp[0][j - 1], Math.abs(a[0] - b[j]) + Math.abs(b[j] - pos));
            }

            for (int i = 1; i < n; ++i) {
                dp[i][i] = Math.max(dp[i - 1][i - 1], Math.abs(a[i] - b[i]) + Math.abs(b[i] - pos));
                for (int j = i + 1; j + n - i <= k; ++j) {
                    dp[i][j] = Math.min(dp[i][j - 1],
                            Math.max(dp[i - 1][j - 1], Math.abs(a[i] - b[j]) + Math.abs(b[j] - pos)));
                }
            }
            long ans = Long.MAX_VALUE;
            for (int j = 0; j < k; ++j) {
                if (dp[n - 1][j] >= 0) {
                    ans = Math.min(ans, dp[n - 1][j]);
                }
            }
            out.println(ans);
        }

    }
}

