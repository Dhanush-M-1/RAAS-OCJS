import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        MyScanner in = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        ABC154E solver = new ABC154E();
        solver.solve(1, in, out);
        out.close();
    }

    static class ABC154E {
        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            String N = in.next();
            int K = in.Int();

            int len = N.length();
            int[][][][] dp = new int[len][10][2][K + 1];
            int c0 = N.charAt(0) - '0';
            for (int i = 0; i <= c0; i++) {
                int k = i == 0 ? 0 : 1;
                int u = i < c0 ? 1 : 0;
                dp[0][i][u][k]++;
            }
            for (int i = 1; i < len; i++) {
                int b = N.charAt(i - 1) - '0';
                int c = N.charAt(i) - '0';
                // 上限
                for (int j = 0; j <= c; j++) {
                    int l = j == c ? 0 : 1;
                    int k = j == 0 ? 0 : 1;
                    for (int n = 0; n <= K; n++) {
                        if (n + k > K) continue;
                        dp[i][j][l][n + k] += dp[i - 1][b][0][n];
                    }
                }
                // 未満
                for (int j = 0; j < 10; j++) {
                    int k = j == 0 ? 0 : 1;
                    for (int n = 0; n <= K; n++) {
                        if (n + k > K) continue;
                        for (int l = 0; l < 10; l++) {
//                        dp[i][j][1][n + k] += dp[i - 1][l][0][n];
                            dp[i][j][1][n + k] += dp[i - 1][l][1][n];
                        }
                    }
                }
            }

            int ans = 0;
            for (int i = 0; i < 10; i++) {
                ans += dp[len - 1][i][0][K];
                ans += dp[len - 1][i][1][K];
            }
            out.println(ans);
        }

    }

    static class MyScanner {
        private BufferedReader in;
        private StringTokenizer st;

        public MyScanner(InputStream stream) {
            in = new BufferedReader(new InputStreamReader(stream));
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    String rl = in.readLine();
                    if (rl == null) {
                        return null;
                    }
                    st = new StringTokenizer(rl);
                } catch (IOException e) {
                    return null;
                }
            }
            return st.nextToken();
        }

        public int Int() {
            return Integer.parseInt(next());
        }

    }
}

