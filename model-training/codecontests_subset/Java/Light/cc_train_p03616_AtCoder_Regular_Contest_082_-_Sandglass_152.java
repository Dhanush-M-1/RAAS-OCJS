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
            TaskB solver = new TaskB();
            solver.solve(1, in, out);
            out.close();
        }
    }
    static class TaskB {
        public void solve(int testNumber, FastInput in, FastOutput out) {
            int x = in.readInt();
            int k = in.readInt();
            int[] r = new int[k + 1];
            for (int i = 1; i <= k; i++) {
                r[i] = in.readInt();
            }


            BulkAddSubArray b = new BulkAddSubArray(0, x);
            BulkAddSubArray[] blocks = new BulkAddSubArray[k + 1];
            blocks[0] = b.clone();
            for (int i = 1; i <= k; i++) {
                if (i % 2 == 1) {
                    // lose
                    b.bulkSubtract(r[i] - r[i - 1]);
                } else {
                    b.bulkAdd(r[i] - r[i - 1]);
                }
                blocks[i] = b.clone();
            }

            int q = in.readInt();
            for (int i = 0; i < q; i++) {
                int t = in.readInt();
                int a = in.readInt();

                int index = SequenceUtils.floorIndex(r, t);
                int remain = (int) blocks[index].get(a);

                if (index % 2 == 0) {
                    // lose
                    remain = Math.max(0, remain - (t - r[index]));
                } else {
                    remain = Math.min(x, remain + (t - r[index]));
                }
                out.println(remain);
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
    static class FastOutput implements AutoCloseable, Closeable {
        private StringBuilder cache = new StringBuilder(10 << 20);
        private final Writer os;

        public FastOutput(Writer os) {
            this.os = os;
        }

        public FastOutput(OutputStream os) {
            this(new OutputStreamWriter(os));
        }

        public FastOutput println(int c) {
            cache.append(c).append('\n');
            return this;
        }

        public FastOutput flush() {
            try {
                os.append(cache);
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

    }
    static class SequenceUtils {
        public static int floorIndex(int[] data, int x) {
            int index = Arrays.binarySearch(data, x);
            if (index < 0) {
                return -(index + 1) - 1;
            }
            return index;
        }

    }
    static class BulkAddSubArray implements Cloneable {
        private long l;
        private long r;
        private long lCnt;
        private long min;
        private long max;

        public BulkAddSubArray(long l, long r) {
            this.l = l;
            this.r = r;
            this.lCnt = 1;
            this.min = l;
            this.max = r;
        }

        public void bulkAdd(long x) {
            if (r + x <= max) {
                l += x;
                r += x;
                return;
            }

            // t + x >= max => t >= max - x
            long t = max - x;
            if (t > l) {
                r = t;
            } else {
                l = r;
            }

            l = Math.min(l + x, max);
            r = Math.min(r + x, max);
        }

        public void bulkSubtract(long x) {
            if (l - x >= min) {
                l -= x;
                r -= x;
                return;
            }

            // t - x = min => t = x + min
            long t = x + min;
            if (t < r) {
                lCnt += t - l;
                l = t;
            } else {
                l = r;
            }

            l = Math.max(l - x, min);
            r = Math.max(r - x, min);
        }

        public long get(long i) {
            if (l == r) {
                return l;
            }
            if (i < lCnt) {
                return l;
            }
            i -= lCnt;
            if (i < r - l - 1) {
                return i + l + 1;
            }
            return r;
        }

        public BulkAddSubArray clone() {
            try {
                return (BulkAddSubArray) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}

