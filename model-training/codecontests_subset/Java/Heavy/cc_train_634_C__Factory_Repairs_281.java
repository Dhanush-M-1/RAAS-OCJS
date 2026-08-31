import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;
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
        TaskB solver = new TaskB();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskB {
        public void solve(int testNumber, FastScanner in, PrintWriter out) {
            int n = in.nextInt();
            int k = in.nextInt();
            long a = in.nextLong();
            long b = in.nextLong();
            int q = in.nextInt();

            FT at = new FT(n);
            FT bt = new FT(n);

            long[] cc = new long[n];

            for (int i = 0; i < q; i++) {
                int t = in.nextInt();
                if (t == 1) {
                    int d = in.nextInt() - 1;
                    long v = in.nextLong();
                    long da = Math.max(0, Math.min(v, a - cc[d]));
                    long db = Math.max(0, Math.min(v, b - cc[d]));
                    cc[d] += v;
                    at.add(d, da);
                    bt.add(d, db);
                } else {
                    int p = in.nextInt() - 1;
                    long ans = bt.sum(p - 1) + at.sum(n - 1) - at.sum(p + k - 1);
                    out.println(ans);
                }
            }
        }

        class FT {
            int n;
            long[] s;

            public FT(int n) {
                this.n = n;
                s = new long[n];
            }

            void add(int v, long c) {
                while (v < n) {
                    s[v] += c;
                    v = v | (v + 1);
                }
            }

            long sum(int v) {
                long res = 0;
                while (v >= 0) {
                    res += s[v];
                    v = (v & (v + 1)) - 1;
                }
                return res;
            }

        }

    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
        }

        public FastScanner(String file) {
            try {
                br = new BufferedReader(new FileReader(file));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
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

