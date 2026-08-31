import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FastScanner in = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        new Main().run(in, out);
        out.close();
    }

    public static long mod = 17352642619633L;

    void run(FastScanner in, PrintWriter out) {

        // dp[i][overflow]

        int N = in.nextInt();
        int[] a = new int[N];
        int[] b = new int[N];

        int[][] dp = new int[N+1][20_002];
        int[][] dpTime = new int[N+1][20_002];
        for (int[] d : dp) Arrays.fill(d, Integer.MAX_VALUE);
        for (int[] d : dpTime) Arrays.fill(d, Integer.MAX_VALUE);
        int d = 10_000;
        dp[0][d] = 0;
        dpTime[0][d] = 0;

        for (int i = 0; i < N; i++) a[i] = in.nextInt();
        for (int i = 0; i < N; i++) b[i] = in.nextInt();

        for (int i = 0; i < N; i++) {

            for (int overflow = 0; overflow < dp[0].length; overflow++) {
                if (dp[i][overflow] == Integer.MAX_VALUE) continue;

                // sink
                if (dp[i][overflow] + 1 < dp[i+1][overflow-(b[i]-a[i])]) {
                    dp[i+1][overflow-(b[i]-a[i])] = dp[i][overflow] + 1;
                    dpTime[i+1][overflow-(b[i]-a[i])] = dpTime[i][overflow];
                } else if (dp[i][overflow] + 1 == dp[i+1][overflow-(b[i]-a[i])]) {
                    dpTime[i+1][overflow-(b[i]-a[i])] =
                        Math.min(dpTime[i+1][overflow-(b[i]-a[i])], dpTime[i][overflow]);
                }

                // source
                if (dp[i][overflow] < dp[i+1][overflow+a[i]]) {
                    dp[i+1][overflow+a[i]] = dp[i][overflow];
                    dpTime[i+1][overflow+a[i]] = dpTime[i][overflow] + a[i];

                } else if (dp[i][overflow] == dp[i+1][overflow+a[i]]) {
                    dpTime[i+1][overflow+a[i]] =
                        Math.min(dpTime[i+1][overflow+a[i]], dpTime[i][overflow]+a[i]);
                }

            }
        }

        int min = Integer.MAX_VALUE;
        int minTime = Integer.MAX_VALUE;
        for (int i = d; i >= 0; i--) {
            if (dp[N][i] < min) {
                min = dp[N][i];
                minTime = dpTime[N][i];
            } else if (dp[N][i] == min) {
                minTime = Math.min(minTime, dpTime[N][i]);
            }
        }

        out.println(min + " " + minTime);

    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(InputStream in) {
            br = new BufferedReader(new InputStreamReader(in));
            st = null;
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
