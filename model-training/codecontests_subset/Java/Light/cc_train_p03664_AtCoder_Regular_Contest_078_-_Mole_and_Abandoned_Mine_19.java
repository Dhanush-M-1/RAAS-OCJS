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
        int[] cost;
        long[][] dp;
        DigitUtils.DigitBase base3 = new DigitUtils.DigitBase(3);
        DigitUtils.BitOperator bo = new DigitUtils.BitOperator();
        int n;
        int m;
        int[][] edges;
        int[] buf;
        long lInf = (long) 1e10;

        public void solve(int testNumber, FastInput in, FastOutput out) {
            n = in.readInt();
            m = in.readInt();
            edges = new int[n][n];
            for (int i = 0; i < m; i++) {
                int a = in.readInt() - 1;
                int b = in.readInt() - 1;
                edges[a][b] = edges[b][a] = in.readInt();
            }

            cost = new int[(int) base3.setBit(0, n, 1)];
            dp = new long[(1 << n)][n];
            SequenceUtils.deepFill(cost, -1);
            SequenceUtils.deepFill(dp, -1L);
            buf = new int[n];

            long ans = dp((1 << n) - 1, n - 1);
            out.println(ans);
        }

        public int cost(int x) {
            if (cost[x] == -1) {
                base3.decompose(x, buf);
                int cnt1 = 0;
                int cnt2 = 0;
                int one = 0;
                int two = 0;
                for (int i = 0; i < n; i++) {
                    if (buf[i] == 1) {
                        cnt1++;
                        one = i;
                    }
                    if (buf[i] == 2) {
                        cnt2++;
                        two = i;
                    }
                }
                if (cnt1 == 0 || cnt2 == 0) {
                    cost[x] = 0;
                } else if (cnt1 > 1) {
                    int x1 = (int) base3.setBit(x, one, 0);
                    for (int i = 0; i < n; i++) {
                        if (buf[i] == 1) {
                            buf[i] = 0;
                        }
                    }
                    buf[one] = 1;
                    int x2 = (int) base3.compose(buf);
                    cost[x] = cost(x1) + cost(x2);
                } else if (cnt2 > 1) {
                    int x1 = (int) base3.setBit(x, two, 0);
                    for (int i = 0; i < n; i++) {
                        if (buf[i] == 2) {
                            buf[i] = 0;
                        }
                    }
                    buf[two] = 2;
                    int x2 = (int) base3.compose(buf);
                    cost[x] = cost(x1) + cost(x2);
                } else {
                    cost[x] = edges[one][two];
                }
            }
            return cost[x];
        }

        public long dp(int s, int t) {
            if (dp[s][t] == -1) {
                if (bo.bitAt(s, 0) == 0) {
                    return dp[s][t] = 0;
                }
                if (t == 0) {
                    return dp[s][t] = 0;
                }
                dp[s][t] = lInf;
                int next = bo.setBit(bo.setBit(s, t, false), 0, false);
                SubsetGenerator sg = new SubsetGenerator();
                sg.setSet(next);
                while (sg.hasNext()) {
                    int T = bo.setBit(sg.next(), t, true);
                    int S = bo.differ(s, T);
                    for (int i = 0; i < n; i++) {
                        if (bo.bitAt(S, i) == 1) {
                            buf[i] = 1;
                        } else if (bo.bitAt(T, i) == 1) {
                            buf[i] = 2;
                        } else {
                            buf[i] = 0;
                        }
                    }

                    int c = cost((int) base3.compose(buf));
                    for (int i = 0; i < n; i++) {
                        if (edges[i][t] == 0 || bo.bitAt(S, i) == 0) {
                            continue;
                        }
                        dp[s][t] = Math.min(dp[s][t], dp(bo.setBit(S, i, false), i) + c - edges[i][t]);
                    }
                }

            }
            return dp[s][t];
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

        public FastOutput println(long c) {
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
    static class DigitUtils {
        private static final long[] DIGIT_VALUES = new long[19];
        static {
            DIGIT_VALUES[0] = 1;
            for (int i = 1; i < 19; i++) {
                DIGIT_VALUES[i] = DIGIT_VALUES[i - 1] * 10;
            }
        }

        private DigitUtils() {}

        public static boolean isMultiplicationOverflow(long a, long b, long limit) {
            if (limit < 0) {
                limit = -limit;
            }
            if (a < 0) {
                a = -a;
            }
            if (b < 0) {
                b = -b;
            }
            if (a == 0 || b == 0) {
                return false;
            }
            return a > limit / b;
        }

        public static class BitOperator {
            public int bitAt(int x, int i) {
                return (x >> i) & 1;
            }

            public int setBit(int x, int i, boolean v) {
                if (v) {
                    x |= 1 << i;
                } else {
                    x &= ~(1 << i);
                }
                return x;
            }

            public int intersect(int x, int y) {
                return x & y;
            }

            public int differ(int x, int y) {
                return x - intersect(x, y);
            }

        }

        public static class DigitBase {
            private long[] pow;
            private long base;

            public DigitBase(long base) {
                if (base <= 1) {
                    throw new IllegalArgumentException();
                }
                this.base = base;
                LongList ll = new LongList(64);
                ll.add(1);
                while (!isMultiplicationOverflow(ll.tail(), base, Long.MAX_VALUE)) {
                    ll.add(ll.tail() * base);
                }
                pow = ll.toArray();
            }

            public int getBit(long x, int i) {
                return (int) (x / pow[i] % base);
            }

            public long setBit(long x, int i, long val) {
                return x + (val - getBit(x, i)) * pow[i];
            }

            public int bitCount() {
                return pow.length;
            }

            public int[] decompose(long x, int[] ans) {
                for (int i = 0; i < ans.length; i++) {
                    ans[i] = (int) (x % base);
                    x /= base;
                }
                return ans;
            }

            public long compose(int[] bits) {
                if (bits.length > bitCount()) {
                    throw new IllegalArgumentException();
                }
                long ans = 0;
                for (int i = bits.length - 1; i >= 0; i--) {
                    ans = ans * base + bits[i];
                }
                return ans;
            }

        }

    }
    static class SubsetGenerator {
        private int[] meanings = new int[33];
        private int[] bits = new int[33];
        private int remain;
        private int next;

        public void setSet(int set) {
            int bitCount = 0;
            while (set != 0) {
                meanings[bitCount] = set & -set;
                bits[bitCount] = 0;
                set -= meanings[bitCount];
                bitCount++;
            }
            remain = 1 << bitCount;
            next = 0;
        }

        public boolean hasNext() {
            return remain > 0;
        }

        private void consume() {
            remain = remain - 1;
            int i;
            for (i = 0; bits[i] == 1; i++) {
                bits[i] = 0;
                next -= meanings[i];
            }
            bits[i] = 1;
            next += meanings[i];
        }

        public int next() {
            int returned = next;
            consume();
            return returned;
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
    static class SequenceUtils {
        public static void deepFill(Object array, int val) {
            if (!array.getClass().isArray()) {
                throw new IllegalArgumentException();
            }
            if (array instanceof int[]) {
                int[] intArray = (int[]) array;
                Arrays.fill(intArray, val);
            } else {
                Object[] objArray = (Object[]) array;
                for (Object obj : objArray) {
                    deepFill(obj, val);
                }
            }
        }

        public static void deepFill(Object array, long val) {
            if (!array.getClass().isArray()) {
                throw new IllegalArgumentException();
            }
            if (array instanceof long[]) {
                long[] longArray = (long[]) array;
                Arrays.fill(longArray, val);
            } else {
                Object[] objArray = (Object[]) array;
                for (Object obj : objArray) {
                    deepFill(obj, val);
                }
            }
        }

    }
    static class LongList {
        private int size;
        private int cap;
        private long[] data;
        private static final long[] EMPTY = new long[0];

        public LongList(int cap) {
            this.cap = cap;
            if (cap == 0) {
                data = EMPTY;
            } else {
                data = new long[cap];
            }
        }

        public LongList(LongList list) {
            this.size = list.size;
            this.cap = list.cap;
            this.data = Arrays.copyOf(list.data, size);
        }

        public LongList() {
            this(0);
        }

        private void ensureSpace(int need) {
            int req = size + need;
            if (req > cap) {
                while (cap < req) {
                    cap = Math.max(cap + 10, 2 * cap);
                }
                data = Arrays.copyOf(data, cap);
            }
        }

        private void checkRange(int i) {
            if (i < 0 || i >= size) {
                throw new ArrayIndexOutOfBoundsException();
            }
        }

        public long tail() {
            checkRange(0);
            return data[size - 1];
        }

        public void add(long x) {
            ensureSpace(1);
            data[size++] = x;
        }

        public long[] toArray() {
            return Arrays.copyOf(data, size);
        }

        public String toString() {
            return Arrays.toString(Arrays.copyOf(data, size));
        }

    }
}

