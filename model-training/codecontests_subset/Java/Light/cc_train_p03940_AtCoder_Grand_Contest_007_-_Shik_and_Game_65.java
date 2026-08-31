import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.io.Closeable;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.InputStream;

/**
 * Built using CHelper plug-in Actual solution is at the top
 * 
 * @author daltao
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Thread thread = new Thread(null, new TaskAdapter(), "daltao", 1 << 27);
        thread.start();
        thread.join();
    }

    static class TaskAdapter implements Runnable {
        @Override
        public void run() {
            InputStream inputStream = System.in;
            OutputStream outputStream = System.out;
            FastInput in = new FastInput(inputStream);
            FastOutput out = new FastOutput(outputStream);
            TaskD solver = new TaskD();
            solver.solve(1, in, out);
            out.close();
        }
    }
    static class TaskD {
        public void solve(int testNumber, FastInput in, FastOutput out) {
            int n = in.readInt();
            int e = in.readInt();
            int t = in.readInt();

            long[] bears = new long[n + 2];
            for (int i = 1; i <= n; i++) {
                bears[i] = in.readInt();
            }
            bears[n + 1] = e;

            Segment seg1 = new Segment(0, n);
            Segment seg2 = new Segment(0, n);

            long[] dp = new long[n + 1];
            seg1.update(0, 0, 0, n, dp[0] + bears[1] - bears[0] - 3 * bears[1] + 2 * bears[1]);
            seg2.update(0, 0, 0, n, dp[0] + bears[1] - bears[0] - 3 * bears[1]);

            int j = -1;
            for (int i = 1; i <= n; i++) {
                while (j + 1 < n && bears[j + 2] * 2 <= bears[i] * 2 - t) {
                    j++;
                }
                long ans1 = seg1.query(j + 1, i - 1, 0, n) + bears[i] + t;
                long ans2 = seg2.query(0, j, 0, n) + 3 * bears[i];
                dp[i] = Math.min(ans1, ans2);

                seg1.update(i, i, 0, n, dp[i] + bears[i + 1] - bears[i] - 3 * bears[i + 1] + 2 * bears[i + 1]);
                seg2.update(i, i, 0, n, dp[i] + bears[i + 1] - bears[i] - 3 * bears[i + 1]);
            }

            long ans = e - bears[n] + dp[n];
            out.println(ans);
        }

    }
    static class Segment implements Cloneable {
        private Segment left;
        private Segment right;
        private long min = (long) 1e18;

        public void set(long x) {
            min = x;
        }

        public void pushUp() {
            min = Math.min(left.min, right.min);
        }

        public void pushDown() {}

        public Segment(int l, int r) {
            if (l < r) {
                int m = (l + r) >> 1;
                left = new Segment(l, m);
                right = new Segment(m + 1, r);
                pushUp();
            } else {

            }
        }

        private boolean covered(int ll, int rr, int l, int r) {
            return ll <= l && rr >= r;
        }

        private boolean noIntersection(int ll, int rr, int l, int r) {
            return ll > r || rr < l;
        }

        public void update(int ll, int rr, int l, int r, long x) {
            if (noIntersection(ll, rr, l, r)) {
                return;
            }
            if (covered(ll, rr, l, r)) {
                set(x);
                return;
            }
            pushDown();
            int m = (l + r) >> 1;
            left.update(ll, rr, l, m, x);
            right.update(ll, rr, m + 1, r, x);
            pushUp();
        }

        public long query(int ll, int rr, int l, int r) {
            if (noIntersection(ll, rr, l, r)) {
                return (long) 1e18;
            }
            if (covered(ll, rr, l, r)) {
                return min;
            }
            pushDown();
            int m = (l + r) >> 1;
            return Math.min(left.query(ll, rr, l, m), right.query(ll, rr, m + 1, r));
        }

    }
    static class FastOutput implements AutoCloseable, Closeable {
        private StringBuilder cache = new StringBuilder(1 << 20);
        private final Writer os;

        public FastOutput(Writer os) {
            this.os = os;
        }

        public FastOutput(OutputStream os) {
            this(new OutputStreamWriter(os));
        }

        public FastOutput println(long c) {
            cache.append(c).append('\n');
            return this;
        }

        public FastOutput flush() {
            try {
                os.append(cache);
                cache.setLength(0);
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
            return this;
        }

        public void close() {
            flush();
            try {
                os.close();
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        }

    }
    static class FastInput {
        private final InputStream is;
        private byte[] buf = new byte[1 << 13];
        private int bufLen;
        private int bufOffset;
        private int next;

        public FastInput(InputStream is) {
            this.is = is;
        }

        private int read() {
            while (bufLen == bufOffset) {
                bufOffset = 0;
                try {
                    bufLen = is.read(buf);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                if (bufLen == -1) {
                    return -1;
                }
            }
            return buf[bufOffset++];
        }

        public void skipBlank() {
            while (next >= 0 && next <= 32) {
                next = read();
            }
        }

        public int readInt() {
            int sign = 1;

            skipBlank();
            if (next == '+' || next == '-') {
                sign = next == '+' ? 1 : -1;
                next = read();
            }

            int val = 0;
            if (sign == 1) {
                while (next >= '0' && next <= '9') {
                    val = val * 10 + next - '0';
                    next = read();
                }
            } else {
                while (next >= '0' && next <= '9') {
                    val = val * 10 - next + '0';
                    next = read();
                }
            }

            return val;
        }

    }
}

