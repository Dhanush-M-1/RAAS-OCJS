import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastReader in = new FastReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        DRestorePermutation solver = new DRestorePermutation();
        solver.solve(1, in, out);
        out.close();
    }

    static class DRestorePermutation {
        public void solve(int testNumber, FastReader s, PrintWriter out) {
            int n = s.nextInt();
            long[] arr = s.nextLongArray(n);
            int[] ans = new int[n];


            DRestorePermutation.SegmentTree st = new DRestorePermutation.SegmentTree(n);
            for (int i = 0; i < n; i++) {
                st.increment(i, i, arr[i]);
            }

            for (int i = 1; i <= n; i++) {
                st.minimum(0, n - 1);
                int ans1 = (int) st.ans[1];
                ans[ans1] = i;
                st.increment(ans1 + 1, n - 1, i * -1);
                st.increment(ans1, ans1, Long.MAX_VALUE - 1);
            }
            out.println(DRestorePermutation.arrays.printArr(ans));

        }

        private static class arrays {
            static StringBuilder printArr(int[] arr) {
                StringBuilder ans = new StringBuilder();
                for (int i = 0; i < arr.length; i++) {
                    ans.append(arr[i] + " ");
                }
                return ans;
            }

        }

        private static class SegmentTree {
            long[] lo;
            long[] hi;
            long[] min;
            long[] delta;
            long[] ans;
            int n;

            public SegmentTree(int n) {
                this.n = n;
                this.hi = new long[4 * n + 1];
                this.lo = new long[4 * n + 1];
                this.min = new long[4 * n + 1];
                this.delta = new long[4 * n + 1];
                this.ans = new long[4 * n + 1];
                init(1, 0, n - 1);
            }

            void prop(int i) {
                delta[2 * i] += delta[i];
                delta[2 * i + 1] += delta[i];
                delta[i] = 0;
            }

            void update(int i) {
                if (min[2 * i + 1] + delta[2 * i + 1] <= min[2 * i] + delta[2 * i]) {
                    min[i] = min[2 * i + 1] + delta[2 * i + 1];
                    ans[i] = ans[2 * i + 1];
                } else {
                    min[i] = min[2 * i] + delta[2 * i];
                    ans[i] = ans[2 * i];
                }
//        min[i] = Math.min(min[2 * i + 1] + delta[2 * i + 1], min[2 * i] + delta[2 * i]);
            }

            void increment(int a, int b, long val) {
                increment(1, a, b, val);
            }

            private void increment(int i, int a, int b, long val) {
                if (a > hi[i] || b < lo[i]) {
                    return;
                }

                //Fully overlap case.
                if (a <= lo[i] && hi[i] <= b) {
                    delta[i] += val;
                    return;
                }

                //Partial overlap case.
                prop(i);

                increment(2 * i, a, b, val);
                increment(2 * i + 1, a, b, val);

                update(i);
            }

            private long minimum(int a, int b) {
                return minimum(1, a, b);
            }

            private long minimum(int i, int a, int b) {
                if (a > hi[i] || b < lo[i]) {
                    return Long.MAX_VALUE;
                }

                if (a <= lo[i] && hi[i] <= b) {
                    return min[i] + delta[i];
                }

                prop(i);

                long minLeft = minimum(2 * i, a, b);
                long minRight = minimum(2 * i + 1, a, b);

                update(i);

                return Math.min(minLeft, minRight);

            }

            private void init(int i, int from, int to) {
                lo[i] = from;
                hi[i] = to;

                if (from == to) {
                    ans[i] = from;
                    return;
                }

                int mid = (from + to) / 2;
                init(2 * i, from, mid);
                init(2 * i + 1, mid + 1, to);
            }

        }

    }

    static class FastReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private FastReader.SpaceCharFilter filter;

        public FastReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public int nextInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public long nextLong() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return isWhitespace(c);
        }

        public static boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public long[] nextLongArray(int n) {
            long[] array = new long[n];
            for (int i = 0; i < n; ++i) array[i] = nextLong();
            return array;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

        }

    }
}

