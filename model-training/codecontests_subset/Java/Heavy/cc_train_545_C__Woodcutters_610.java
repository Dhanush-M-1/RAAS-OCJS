import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author Don Li
 */
public class Woodcutters {
    void solve() {
        int n = in.nextInt();
        int[] x = new int[n], h = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = in.nextInt();
            h[i] = in.nextInt();
        }

        int[][] dp = new int[n + 1][3];

        dp[1][0] = 0;
        dp[1][1] = 1;
        dp[1][2] = (n < 2 || x[0] + h[0] < x[1]) ? 1 : 0;

        int ans = 1;
        for (int i = 1; i < n; i++) {
            dp[i + 1][0] = Math.max(dp[i][0], dp[i][1]);
            if (x[i - 1] + h[i - 1] < x[i]) dp[i + 1][0] = Math.max(dp[i + 1][0], dp[i][2]);

            if (x[i] - h[i] <= x[i - 1]) {
                dp[i + 1][1] = 0;
            } else {
                dp[i + 1][1] = Math.max(dp[i][0] + 1, dp[i][1] + 1);
                if (h[i - 1] + h[i] < x[i] - x[i - 1]) dp[i + 1][1] = Math.max(dp[i + 1][1], dp[i][2] + 1);
            }

            if (i == n - 1 || i + 1 < n && x[i] + h[i] < x[i + 1]) {
                dp[i + 1][2] = Math.max(dp[i][0] + 1, dp[i][1] + 1);
                dp[i + 1][2] = Math.max(dp[i + 1][2], dp[i][2] + 1);
            } else {
                dp[i + 1][2] = 0;
            }

            for (int j = 0; j < 3; j++) ans = Math.max(ans, dp[i + 1][j]);
        }

        out.println(ans);
    }

    public static void main(String[] args) {
        in = new FastScanner(new BufferedReader(new InputStreamReader(System.in)));
        out = new PrintWriter(System.out);
        new Woodcutters().solve();
        out.close();
    }

    static FastScanner in;
    static PrintWriter out;

    static class FastScanner {
        BufferedReader in;
        StringTokenizer st;

        public FastScanner(BufferedReader in) {
            this.in = in;
        }

        public String nextToken() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(in.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(nextToken());
        }

        public long nextLong() {
            return Long.parseLong(nextToken());
        }

        public double nextDouble() {
            return Double.parseDouble(nextToken());
        }
    }
}
