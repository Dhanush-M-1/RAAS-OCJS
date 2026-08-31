import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Khater
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        CAddOne solver = new CAddOne();
        solver.solve(1, in, out);
        out.close();
    }

    static class CAddOne {
        long mod;
        long[][] dp;

        public void solve(int testNumber, Scanner sc, PrintWriter pw) {
            int t = 1;
            t = sc.nextInt();
            mod = (long) (1e9 + 7);
            dp = new long[10][(int) (2e5 + 5)];
            for (long[] x : dp) Arrays.fill(x, -1);
            while (t-- > 0) {
                char[] tmp = sc.next().toCharArray();
                int n = tmp.length;
                int k = sc.nextInt();
                int[] arr = new int[n];
                for (int i = 0; i < n; i++) arr[i] = tmp[i] - '0';
                long ans = 0;
                for (int i = 0; i < n; i++) ans = (ans + solve(arr[i], k)) % mod;
                pw.println(ans);
            }

        }

        long solve(int i, int m) {
            if (m == 0) return 1;
            if (dp[i][m] != -1) return dp[i][m];
            if (i < 9) return dp[i][m] = solve(i + 1, m - 1) % mod;
            else {
                return dp[i][m] = (solve(0, m - 1) + solve(1, m - 1)) % mod;
            }
        }

    }

    static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(FileReader r) {
            br = new BufferedReader(r);
        }

        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

