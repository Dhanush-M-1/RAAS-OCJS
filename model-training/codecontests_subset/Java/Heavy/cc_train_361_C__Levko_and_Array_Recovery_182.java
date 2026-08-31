import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.io.Closeable;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Thread thread = new Thread(null, new TaskAdapter(), "", 1 << 29);
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
            ALevkoAndArrayRecovery solver = new ALevkoAndArrayRecovery();
            solver.solve(1, in, out);
            out.close();
        }
    }

    static class ALevkoAndArrayRecovery {
        public void solve(int testNumber, FastInput in, FastOutput out) {
            int n = in.ri();
            int m = in.ri();
            int[][] ops = new int[m][4];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < 4; j++) {
                    ops[i][j] = in.ri();
                }
            }
            long[] data = new long[n];
            Arrays.fill(data, (long) 1e18);
            for (int i = m - 1; i >= 0; i--) {
                int t = ops[i][0];
                int l = ops[i][1] - 1;
                int r = ops[i][2] - 1;
                int x = ops[i][3];
                if (t == 1) {
                    update(data, (a, b) -> a - b, x, l, r);
                } else {
                    update(data, Math::min, x, l, r);
                }
            }
            update(data, Math::min, (int) 1e9, 0, n - 1);
            update(data, Math::max, (int) -1e9, 0, n - 1);
            long[] clone = data.clone();
            for (int i = 0; i < m; i++) {
                int t = ops[i][0];
                int l = ops[i][1] - 1;
                int r = ops[i][2] - 1;
                int x = ops[i][3];
                if (t == 1) {
                    update(data, (a, b) -> a + b, x, l, r);
                } else {
                    if (query(data, l, r) != x) {
                        out.println("NO");
                        return;
                    }
                }
            }
            out.println("YES");
            for (long x : clone) {
                out.append(x).append(' ');
            }
        }

        public long query(long[] data, int l, int r) {
            long ans = data[l];
            for (int i = l; i <= r; i++) {
                ans = Math.max(ans, data[i]);
            }
            return ans;
        }

        public void update(long[] data, LongBinaryFunction merger, long x, int l, int r) {
            for (int i = l; i <= r; i++) {
                data[i] = merger.apply(data[i], x);
            }
        }

    }

    static interface LongBinaryFunction {
        long apply(long a, long b);

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
                    bufLen = -1;
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

        public int ri() {
            return readInt();
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

    static class FastOutput implements AutoCloseable, Closeable, Appendable {
        private static final int THRESHOLD = 32 << 10;
        private final Writer os;
        private StringBuilder cache = new StringBuilder(THRESHOLD * 2);

        public FastOutput append(CharSequence csq) {
            cache.append(csq);
            return this;
        }

        public FastOutput append(CharSequence csq, int start, int end) {
            cache.append(csq, start, end);
            return this;
        }

        private void afterWrite() {
            if (cache.length() < THRESHOLD) {
                return;
            }
            flush();
        }

        public FastOutput(Writer os) {
            this.os = os;
        }

        public FastOutput(OutputStream os) {
            this(new OutputStreamWriter(os));
        }

        public FastOutput append(char c) {
            cache.append(c);
            afterWrite();
            return this;
        }

        public FastOutput append(long c) {
            cache.append(c);
            afterWrite();
            return this;
        }

        public FastOutput append(String c) {
            cache.append(c);
            afterWrite();
            return this;
        }

        public FastOutput println(String c) {
            return append(c).println();
        }

        public FastOutput println() {
            return append('\n');
        }

        public FastOutput flush() {
            try {
//            boolean success = false;
//            if (stringBuilderValueField != null) {
//                try {
//                    char[] value = (char[]) stringBuilderValueField.get(cache);
//                    os.write(value, 0, cache.length());
//                    success = true;
//                } catch (Exception e) {
//                }
//            }
//            if (!success) {
                os.append(cache);
//            }
                os.flush();
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

        public String toString() {
            return cache.toString();
        }

    }
}

