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
        FastScanner in = new FastScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        D solver = new D();
        solver.solve(1, in, out);
        out.close();
    }

    static class D {
        public void solve(int testNumber, FastScanner in, PrintWriter out) {
            int n = in.ni(), lim = in.ni();
            int[] a = in.na(n);
            long[] money = new long[n];
            long MIN = -1_0000_000_000L;
            long cur = 0;
            for (int i = 0; i < n; i++) {
                cur += a[i];
                money[i] = cur;
                if (cur > lim) {
                    out.println(-1);
                    return;
                }
            }
            cur = MIN;
            long[] max = new long[n];
            for (int i = n - 1; i >= 0; i--) {
                cur = Math.max(cur, money[i]);
                max[i] = cur;
            }
            long add = 0;
            int ans = 0;
            for (int i = 0; i < n; i++) {
                if (a[i] == 0 && money[i] + add < 0) {
                    ans++;
                    long diff = lim - max[i] - add;
                    if (money[i] + add + diff < 0) {
                        out.println(-1);
                        return;
                    }
                    add += diff;
                }
                if (money[i] + add > lim)
                    throw new RuntimeException();
            }
            out.println(ans);
        }

    }

    static class FastScanner {
        private BufferedReader in;
        private StringTokenizer st;

        public FastScanner(InputStream stream) {
            in = new BufferedReader(new InputStreamReader(stream));
        }

        public String ns() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    String rl = in.readLine();
                    if (rl == null) {
                        return null;
                    }
                    st = new StringTokenizer(rl);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

        public int ni() {
            return Integer.parseInt(ns());
        }

        public int[] na(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = ni();
            return a;
        }

    }
}

