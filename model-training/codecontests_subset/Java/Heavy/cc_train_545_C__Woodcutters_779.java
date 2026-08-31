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
 *
 * @author MaxHeap
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastReader in = new FastReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        WoodCutters solver = new WoodCutters();
        solver.solve(1, in, out);
        out.close();
    }

    static class WoodCutters {
        int n;
        long[] x;
        long[] h;
        int[][] memo;

        int f(int i, int dir) {
            if (i == n - 1) return 1;
            if (memo[dir][i] != -1) return memo[dir][i];

            int ans = 0;

            if (i == 0) {
                ans = Math.max(ans, f(i + 1, 0) + 1);
            } else {
                switch (dir) {
                    case 0:
                        if (x[i - 1] < x[i] - h[i])
                            ans = Math.max(ans, f(i + 1, 0) + 1);
                        if (i + 1 < n && x[i] + h[i] < x[i + 1])
                            ans = Math.max(ans, f(i + 1, 1) + 1);
                        break;
                    case 1:
                        if (x[i - 1] + h[i - 1] < x[i] - h[i])
                            ans = Math.max(ans, f(i + 1, 0) + 1);
                        if (i + 1 < n && x[i] + h[i] < x[i + 1])
                            ans = Math.max(ans, f(i + 1, 1) + 1);
                        break;
                }
            }
            ans = Math.max(ans, f(i + 1, dir));
            ans = Math.max(ans, f(i + 1, 1 - dir));

            return memo[dir][i] = ans;
        }

        public void solve(int testNumber, FastReader fs, PrintWriter pw) {
            n = fs.nextInt();
            x = new long[n];
            h = new long[n];
            memo = new int[2][n];

            for (int i = 0; i < n; i++) {
                x[i] = fs.nextLong();
                h[i] = fs.nextLong();
            }

            for (int i = 0; i < 2; i++) Arrays.fill(memo[i], -1);

            int right = f(0, 0);
            int left = f(0, 1);

            pw.println(Math.max(left, right));
        }

    }

    static class FastReader {
        BufferedReader bf;
        StringTokenizer st;

        public FastReader(InputStream is) {
            bf = new BufferedReader(new InputStreamReader(is));
            st = null;
        }

        public String next() {
            try {
                while (st == null || !st.hasMoreTokens()) {
                    String line = bf.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                }
            } catch (Exception e) {
            }

            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

    }
}

