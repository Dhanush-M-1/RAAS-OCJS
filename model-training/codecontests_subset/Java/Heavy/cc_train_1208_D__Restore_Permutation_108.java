import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Solve3 {

    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(System.out);
        new Solve3().solve(pw);
        pw.flush();
        pw.close();
    }

    public void solve(PrintWriter pw) throws IOException {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        long[] s = new long[n];
        TreeSet<Integer> ts = new TreeSet();
        for (int i = 0; i < n; i++) {
            s[i] = sc.nextLong();
            ts.add(i + 1);
        }
        SegmentTree st = new SegmentTree(n);
        int[] p = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int l = 1, h = n;
            while (l <= h) {
                int mid = (l + h) >> 1;
                long sum = st.query(1, n, 1, 1, mid);
                if (sum > s[i]) {
                    h = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            int x = ts.ceiling(l);
            ts.remove(x);
            p[i] = x;
            st.update(1, n, 1, x);
        }
        pw.print(p[0]);
        for (int i = 1; i < n; i++) {
            pw.print(" " + p[i]);
        }
        pw.println();
    }

    class SegmentTree {

        long[] t;

        public SegmentTree(int n) {
            t = new long[n << 2];
            build(1, n, 1);
        }

        public void build(int l, int r, int node) {
            if (l == r) {
                t[node] = l;
                return;
            }
            int mid = (l + r) >> 1;
            build(l, mid, node * 2);
            build(mid + 1, r, node * 2 + 1);
            t[node] = t[node * 2] + t[node * 2 + 1];
        }

        public long query(int left, int right, int node, int l, int r) {
            if (l <= left && right <= r) {
                return t[node];
            }
            if (l > right || r < left) {
                return 0;
            }
            int mid = (left + right) >> 1;
            long x = query(left, mid, node * 2, l, r);
            long y = query(mid + 1, right, node * 2 + 1, l, r);
            return x + y;
        }

        public void update(int left, int right, int node, int index) {
            if (left == right && left == index) {
                t[node] = 0;
                return;
            }
            int mid = (left + right) >> 1;
            if (index <= mid) {
                update(left, mid, node * 2, index);
            } else {
                update(mid + 1, right, node * 2 + 1, index);
            }
            t[node] = t[node * 2] + t[node * 2 + 1];
        }
    }

    static public class FastReader {

        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() throws IOException {
            if (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        public String nextLine() throws IOException {
            return br.readLine();
        }
    }
}
