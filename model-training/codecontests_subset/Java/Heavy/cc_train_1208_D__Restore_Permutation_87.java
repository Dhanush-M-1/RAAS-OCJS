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
        TaskD solver = new TaskD();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskD {
        long[] add;
        long[] min;
        boolean[] fixed;

        public void solve(int testNumber, FastScanner in, PrintWriter out) {
            int n = in.nextInt();
            long[] s = new long[n];
            for (int i = 0; i < n; i++) {
                s[i] = in.nextLong();
            }

            initTree(n, s);
            int[] p = new int[n];
            for (int i = 1; i <= n; i++) {
                int pos = rightmostZero(0, 0, n);
                add(0, 0, n, pos, pos + 1, (long) n * n);
                add(0, 0, n, pos + 1, n, -i);
                p[pos] = i;
            }

            for (int i = 0; i < n; i++) {
                if (i > 0) {
                    out.print(" ");
                }
                out.print(p[i]);
            }
            out.println();
        }

        void initTree(int n, long[] s) {
            add = new long[4 * n];
            min = new long[4 * n];
            fixed = new boolean[4 * n];
            recInit(0, 0, n, s);
        }

        private void recInit(int root, int rl, int rr, long[] s) {
            if (rr - rl == 1) {
                add[root] = s[rl];
                min[root] = s[rl];
                return;
            }
            int rm = (rl + rr) / 2;
            recInit(2 * root + 1, rl, rm, s);
            recInit(2 * root + 2, rm, rr, s);
            pull(root);
        }

        void add(int root, int rl, int rr, int l, int r, long val) {
            if (l < rl) {
                l = rl;
            }
            if (r > rr) {
                r = rr;
            }
            if (l >= r) {
                return;
            }
            if (l == rl && r == rr) {
                add[root] += val;
                min[root] += val;
                return;
            }
            int rm = (rl + rr) / 2;
            push(root);
            add(2 * root + 1, rl, rm, l, r, val);
            add(2 * root + 2, rm, rr, l, r, val);
            pull(root);
        }

        void push(int root) {
            add[2 * root + 1] += add[root];
            add[2 * root + 2] += add[root];
            min[2 * root + 1] += add[root];
            min[2 * root + 2] += add[root];
            add[root] = 0;
        }

        void pull(int root) {
            min[root] = add[root] + Math.min(min[2 * root + 1], min[2 * root + 2]);
        }

        int rightmostZero(int root, int rl, int rr) {
            if (rr - rl == 1) {
                return rl;
            }
            int rm = (rl + rr) / 2;
            push(root);
            if (min[2 * root + 2] == 0) {
                return rightmostZero(2 * root + 2, rm, rr);
            }
            return rightmostZero(2 * root + 1, rl, rm);
        }

    }

    static class FastScanner {
        private BufferedReader in;
        private StringTokenizer st;

        public FastScanner(InputStream stream) {
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
                    throw new RuntimeException(e);
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

