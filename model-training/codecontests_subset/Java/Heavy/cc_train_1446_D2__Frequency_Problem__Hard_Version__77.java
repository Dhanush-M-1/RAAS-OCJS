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
            F1FrequencyProblemEasyVersion solver = new F1FrequencyProblemEasyVersion();
            solver.solve(1, in, out);
            out.close();
        }
    }

    static class F1FrequencyProblemEasyVersion {
        int[] occur;
        int exceed;
        int threshold;

        public void solve(int testNumber, FastInput in, FastOutput out) {
            int n = in.readInt();
            int[] a = new int[n];
            in.populate(a);
            int[] cnts = new int[n + 1];
            for (int x : a) {
                cnts[x]++;
            }
            int maxOccur = 0;
            for (int i = 1; i <= n; i++) {
                if (cnts[i] > cnts[maxOccur]) {
                    maxOccur = i;
                }
            }
            int sqrt = (int) Math.ceil(Math.sqrt(n));
            int ans = 0;
            int[] reg = new int[n + n + 10];
            int zero = n;
            for (int i = 1; i <= n; i++) {
                if (cnts[i] < sqrt || i == maxOccur) {
                    continue;
                }
                Arrays.fill(reg, -2);
                int ps = 0;
                reg[zero] = -1;
                for (int j = 0; j < n; j++) {
                    if (a[j] == maxOccur) {
                        ps++;
                    } else if (a[j] == i) {
                        ps--;
                    }
                    if (reg[ps + zero] != -2) {
                        ans = Math.max(ans, j - reg[ps + zero]);
                    } else {
                        reg[ps + zero] = j;
                    }
                }
            }

            occur = new int[n + 1];
            for (int i = 1; i < sqrt; i++) {
                Arrays.fill(occur, 0);
                exceed = 0;
                threshold = i;
                for (int j = 0, l = 0; j < n; j++) {
                    add(a[j], 1);
                    while (occur[maxOccur] > threshold) {
                        assert l < j;
                        add(a[l++], -1);
                    }
                    if (exceed >= 2) {
                        ans = Math.max(ans, j - l + 1);
                    }
                }
            }

            out.println(ans);
        }

        public void add(int x, int d) {
            if (occur[x] >= threshold) {
                exceed--;
            }
            occur[x] += d;
            if (occur[x] >= threshold) {
                exceed++;
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

        public void populate(int[] data) {
            for (int i = 0; i < data.length; i++) {
                data[i] = readInt();
            }
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

    static class FastOutput implements AutoCloseable, Closeable, Appendable {
        private static final int THRESHOLD = 1 << 13;
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

        public FastOutput append(int c) {
            cache.append(c);
            afterWrite();
            return this;
        }

        public FastOutput append(String c) {
            cache.append(c);
            afterWrite();
            return this;
        }

        public FastOutput println(int c) {
            return append(c).println();
        }

        public FastOutput println() {
            return append(System.lineSeparator());
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

        public String toString() {
            return cache.toString();
        }

    }
}

