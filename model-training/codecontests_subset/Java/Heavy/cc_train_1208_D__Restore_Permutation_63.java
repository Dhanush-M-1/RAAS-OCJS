import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.IOException;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Aman Kumar Singh
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        DRestorePermutation solver = new DRestorePermutation();
        solver.solve(1, in, out);
        out.close();
    }

    static class DRestorePermutation {
        long INF = (long) 1e18 + 1;
        int MAXN = 200005;
        PrintWriter out;
        InputReader in;
        int n;

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            this.out = out;
            this.in = in;
            n = ni();
            long[] arr = new long[n];
            int i = 0;
            Segment_Tree st = new Segment_Tree();
            st.init();
            for (i = 0; i < n; i++) {
                arr[i] = nl();
                st.update_tree(1, 0, n - 1, i, i, arr[i]);
            }
            int[] ans = new int[n];
            int curr = 1;
            for (i = 0; i < n; i++) {
                int lo = 0, hi = n - 1;
                while (lo <= hi) {
                    int mid = (lo + hi) >> 1;
                    if (st.query_tree(1, 0, n - 1, mid, n - 1) == 0)
                        lo = mid + 1;
                    else
                        hi = mid - 1;
                }
                lo--;
                ans[lo] = curr;
                st.update_tree(1, 0, n - 1, lo, lo, (long) 1e18);
                st.update_tree(1, 0, n - 1, lo + 1, n - 1, -curr);
                curr++;
            }
            for (i = 0; i < n; i++)
                p(ans[i] + " ");

        }

        int ni() {
            return in.nextInt();
        }

        long nl() {
            return in.nextLong();
        }

        void p(Object o) {
            out.print(o);
        }

        class Segment_Tree {
            long[] tree = new long[4 * MAXN];
            long[] lazy = new long[4 * MAXN];

            void init() {
                Arrays.fill(tree, INF);
                Arrays.fill(lazy, INF);
            }

            void update_tree(int node, int a, int b, int i, int j, long value) {
                if (lazy[node] != INF) {
                    if (tree[node] == INF)
                        tree[node] = 0;
                    tree[node] += lazy[node];
                    if (a != b) {
                        if (lazy[node * 2] == INF)
                            lazy[node * 2] = 0;
                        if (lazy[node * 2 + 1] == INF)
                            lazy[node * 2 + 1] = 0;
                        lazy[node * 2] += lazy[node];
                        lazy[node * 2 + 1] += lazy[node];
                    }
                    lazy[node] = INF;
                }
                if (a > b || a > j || b < i)
                    return;
                if (a >= i && b <= j) {
                    if (tree[node] == INF)
                        tree[node] = 0;
                    tree[node] += value;
                    if (a != b) {
                        if (lazy[node * 2] == INF)
                            lazy[node * 2] = 0;
                        if (lazy[node * 2 + 1] == INF)
                            lazy[node * 2 + 1] = 0;
                        lazy[node * 2] += value;
                        lazy[node * 2 + 1] += value;
                    }
                    return;
                }
                update_tree(node * 2, a, (a + b) / 2, i, j, value);
                update_tree(1 + node * 2, 1 + (a + b) / 2, b, i, j, value);
                tree[node] = Math.min(tree[node * 2], tree[node * 2 + 1]);
            }

            long query_tree(int node, int a, int b, int i, int j) {
                if (a > b || a > j || b < i) return INF;
                if (lazy[node] != INF) {
                    if (tree[node] == INF)
                        tree[node] = 0;
                    tree[node] += lazy[node];
                    if (a != b) {
                        if (lazy[node * 2] == INF)
                            lazy[node * 2] = 0;
                        if (lazy[node * 2 + 1] == INF)
                            lazy[node * 2 + 1] = 0;
                        lazy[node * 2] += lazy[node];
                        lazy[node * 2 + 1] += lazy[node];
                    }
                    lazy[node] = INF;
                }
                if (a >= i && b <= j)
                    return tree[node];

                long q1 = query_tree(node * 2, a, (a + b) / 2, i, j);
                long q2 = query_tree(1 + node * 2, 1 + (a + b) / 2, b, i, j);
                long res = Math.min(q1, q2);
                return res;
            }

        }

    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1) {
                throw new UnknownError();
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new UnknownError();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public String next() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuffer res = new StringBuffer();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));

            return res.toString();
        }

        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

    }
}

