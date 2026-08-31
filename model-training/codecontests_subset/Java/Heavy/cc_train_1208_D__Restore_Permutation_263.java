import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.BufferedWriter;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author sarthakmanna
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastReader in = new FastReader(inputStream);
        FastWriter out = new FastWriter(outputStream);
        DRestorePermutation solver = new DRestorePermutation();
        solver.solve(1, in, out);
        out.close();
    }

    static class DRestorePermutation {
        int N;
        long[] S;
        SegmentTree segT;

        public void solve(int testNumber, FastReader in, FastWriter out) {
            int i, j, k;

            N = in.nextInt();
            S = new long[N];
            for (i = 0; i < N; ++i) S[i] = in.nextLong();

            segT = new SegmentTree(N + 7);

            long[] A = new long[N];
            for (i = N - 1; i >= 0; --i) {
                A[i] = calc(i);
                segT.update((int) A[i], A[i]);

                //System.err.println(Arrays.toString(A));
            }

            for (long itr : A) out.printsp(itr);
            out.println();

            out.flush();
        }

        long calc(int ind) {
            long sum = S[ind];
            int L = 1, R = N;
            while (true) {
                //System.err.println(L + " " + R);

                int mid = L + R >> 1;
                if (L + 1 >= R) {
                    if (sum + segT.query(0, R) == nsum(R)) return R;
                    else if (sum + segT.query(0, L) == nsum(L)) return L;
                    else return 7 / 0;
                } else if (sum + segT.query(0, mid) >= nsum(mid)) L = mid;
                else R = mid;
            }
        }

        long nsum(long v) {
            return v * (v - 1) >> 1;
        }

    }

    static class FastWriter {
        static private BufferedWriter bw;

        public FastWriter(OutputStream os) {
            bw = new BufferedWriter(new OutputStreamWriter(os));
        }

        public FastWriter(Writer w) {
            bw = new BufferedWriter(w);
        }

        public void print(Object a) {
            try {
                bw.write(a.toString());
            } catch (Exception e) {
            }
        }

        public void println() {
            print("\n");
        }

        public void printsp(Object a) {
            print(a);
            print(" ");
        }

        public void flush() {
            try {
                bw.flush();
            } catch (Exception e) {
            }
        }

        public void close() {
            try {
                bw.close();
            } catch (Exception e) {
            }
        }

    }

    static class FastReader {
        static private byte[] buf = new byte[2048];
        static private int index;
        static private int total;
        static private InputStream in;

        public FastReader(InputStream is) {
            try {
                in = is;
            } catch (Exception e) {
            }
        }

        private int scan() {
            try {
                if (index >= total) {
                    index = 0;
                    total = in.read(buf);
                    if (total <= 0)
                        return -1;
                }
                return buf[index++];
            } catch (Exception e) {
                return 7 / 0;
            }
        }

        public int nextInt() {
            int c, val = 0;
            for (c = scan(); c <= 32; c = scan()) ;
            boolean neg = c == '-';
            if (c == '-' || c == '+')
                c = scan();
            for (; c >= '0' && c <= '9'; c = scan())
                val = (val << 3) + (val << 1) + (c & 15);
            return neg ? -val : val;
        }

        public long nextLong() {
            int c;
            long val = 0;
            for (c = scan(); c <= 32; c = scan()) ;
            boolean neg = c == '-';
            if (c == '-' || c == '+')
                c = scan();
            for (; c >= '0' && c <= '9'; c = scan())
                val = (val << 3) + (val << 1) + (c & 15);
            return neg ? -val : val;
        }

    }

    static class SegmentTree {
        int N;
        long[] tree;

        SegmentTree(int n) {
            N = 1;
            while (N < n) N <<= 1;
            tree = new long[N * 2 - 1];
        }

        void update(int i, long v) {
            i += N - 1;
            while (i >= 0) {
                tree[i] += v;
                i = i - 1 >> 1;
            }
        }

        long query(int i, int l, int r, int ql, int qr) {
            int mid = l + r >> 1, i2 = i << 1;
            if (l > qr || r < ql) return 0;
            else if (l >= ql && r <= qr) return tree[i];
            else return query(i2 + 1, l, mid, ql, qr) + query(i2 + 2, mid + 1, r, ql, qr);
        }

        long query(int l, int r) {
            if (l >= r) return 0;
            return query(0, 0, N - 1, l, r - 1);
        }

    }
}

