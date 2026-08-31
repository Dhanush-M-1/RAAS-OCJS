import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
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
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        CAddOne solver = new CAddOne();
        solver.solve(1, in, out);
        out.close();
    }

    static class CAddOne {
        int mod = (int) 1e9 + 7;
        int n;
        int m;
        long[][] memo;

        public void readInput(Scanner sc) {
            n = sc.nextInt();
            m = sc.nextInt();
        }

        public void solve(int testNumber, Scanner sc, PrintWriter pw) {
            int q = sc.nextInt();
            memo = new long[10][(int) 2e5 + 1];
            for (long[] x : memo)
                Arrays.fill(x, -1);
            while (q-- > 0) {
                readInput(sc);
                long sum = 0;
                while (n != 0) {
                    int cur = n % 10;
                    n /= 10;
                    sum += dp(cur, m);
                    sum %= mod;
                }
                pw.println(sum);
            }
        }

        private long dp(int cur, int steps) {
            if (steps == 0)
                return 1;
            if (memo[cur][steps] != -1)
                return memo[cur][steps];
            if (cur == 9)
                return memo[cur][steps] = (dp(0, steps - 1) % mod + dp(1, steps - 1) % mod) % mod;
            return memo[cur][steps] = dp(cur + 1, steps - 1) % mod;
        }

    }

    static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        public String next() {
            try {
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(br.readLine());
                return st.nextToken();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

