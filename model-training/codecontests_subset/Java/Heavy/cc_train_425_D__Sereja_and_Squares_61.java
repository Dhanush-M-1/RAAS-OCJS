import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.io.IOException;
import java.util.ArrayList;
import java.io.UncheckedIOException;
import java.util.List;
import java.io.Closeable;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.util.Comparator;
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
            DSerejaAndSquares solver = new DSerejaAndSquares();
            solver.solve(1, in, out);
            out.close();
        }
    }

    static class DSerejaAndSquares {
        long id(int i, int j) {
            return DigitUtils.asLong(i, j);
        }

        public void solve(int testNumber, FastInput in, FastOutput out) {
            int n = in.ri();
            int[][] pts = new int[n][2];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 2; j++) {
                    pts[i][j] = in.ri();
                }
            }
            IntegerHashMap map = new IntegerHashMap(n, false);
            LongHashSet set = new LongHashSet(n, false);
            for (int i = 0; i < n; i++) {
                set.add(id(pts[i][0], pts[i][1]));
                map.modify(pts[i][0], 1);
            }
            int sqrt = IntMath.floorSqrt(n);
            List<int[]> forRow = new ArrayList<>(n);
            List<int[]> forCol = new ArrayList<>(n);
            for (int[] pt : pts) {
                if (map.get(pt[0]) <= sqrt) {
                    forRow.add(pt);
                } else {
                    forCol.add(pt);
                }
            }
            forRow.sort(Comparator.<int[]>comparingInt(x -> x[0]).thenComparingInt(x -> x[1]));
            forCol.sort(Comparator.<int[]>comparingInt(x -> x[1]).thenComparingInt(x -> x[0]));
            int[][] forRowData = forRow.toArray(new int[0][]);
            int[][] forColData = forCol.toArray(new int[0][]);
            int ans = 0;
            for (int i = 0; i < forRowData.length; i++) {
                int l = i;
                int r = i;
                while (r + 1 < forRowData.length && forRowData[r + 1][0] == forRowData[i][0]) {
                    r++;
                }
                i = r;
                for (int j = l; j <= r; j++) {
                    for (int k = j + 1; k <= r; k++) {
                        int[] a = forRowData[j];
                        int[] b = forRowData[k];
                        int d = b[1] - a[1];
                        if (set.contain(id(a[0] - d, a[1])) && set.contain(id(b[0] - d, b[1]))) {
                            ans++;
                        }
                        if (set.contain(id(a[0] + d, a[1])) && set.contain(id(b[0] + d, b[1]))) {
                            ans++;
                        }
                    }
                }
                for (int j = l; j <= r; j++) {
                    int[] a = forRowData[j];
                    set.remove(id(a[0], a[1]));
                }
            }

            for (int i = 0; i < forColData.length; i++) {
                int l = i;
                int r = i;
                while (r + 1 < forColData.length && forColData[r + 1][1] == forColData[i][1]) {
                    r++;
                }
                i = r;
                for (int j = l; j <= r; j++) {
                    for (int k = j + 1; k <= r; k++) {
                        int[] a = forColData[j];
                        int[] b = forColData[k];
                        int d = b[0] - a[0];
                        if (set.contain(id(a[0], a[1] - d)) && set.contain(id(b[0], b[1] - d))) {
                            ans++;
                        }
                        if (set.contain(id(a[0], a[1] + d)) && set.contain(id(b[0], b[1] + d))) {
                            ans++;
                        }
                    }
                }
                for (int j = l; j <= r; j++) {
                    int[] a = forColData[j];
                    set.remove(id(a[0], a[1]));
                }
            }

            out.println(ans);
        }

    }

    static interface LongIterator {
        boolean hasNext();

        long next();

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

    static class Hasher {
        private long time = System.nanoTime() + System.currentTimeMillis() * 31L;

        public int shuffle(long z) {
            z += time;
            z = (z ^ (z >>> 33)) * 0x62a9d9ed799705f5L;
            return (int) (((z ^ (z >>> 28)) * 0xcb24d0a5c88c35b3L) >>> 32);
        }

        public int hash(int x) {
            return shuffle(x);
        }

        public int hash(long x) {
            return shuffle(x);
        }

    }

    static class DigitUtils {
        public static long INT_TO_LONG_MASK = (1L << 32) - 1;

        private DigitUtils() {
        }

        public static long asLong(int high, int low) {
            return (((long) high) << 32) | (((long) low) & INT_TO_LONG_MASK);
        }

    }

    static class LongHashSet {
        private int now;
        private int[] slot;
        private int[] version;
        private int[] next;
        private long[] keys;
        private int alloc;
        private boolean[] removed;
        private int mask;
        private int size;
        private boolean rehash;
        private Hasher hasher = new Hasher();

        public LongHashSet(int cap, boolean rehash) {
            now = 1;
            this.mask = (1 << (32 - Integer.numberOfLeadingZeros(cap - 1))) - 1;
            this.rehash = rehash;
            slot = new int[mask + 1];
            version = new int[slot.length + 1];
            next = new int[cap + 1];
            keys = new long[cap + 1];
            removed = new boolean[cap + 1];
        }

        private void access(int i) {
            if (version[i] != now) {
                version[i] = now;
                slot[i] = 0;
            }
        }

        private void doubleCapacity() {
            int newSize = Math.max(next.length + 10, next.length * 2);
            next = Arrays.copyOf(next, newSize);
            keys = Arrays.copyOf(keys, newSize);
            removed = Arrays.copyOf(removed, newSize);
        }

        public void alloc() {
            alloc++;
            if (alloc >= next.length) {
                doubleCapacity();
            }
            next[alloc] = 0;
            removed[alloc] = false;
            size++;
        }

        private int hash(long x) {
            return hasher.hash(x);
        }

        public void add(long x) {
            int h = hash(x);
            int s = h & mask;
            access(s);
            if (slot[s] == 0) {
                alloc();
                slot[s] = alloc;
                keys[alloc] = x;
                return;
            } else {
                int index = findIndexOrLastEntry(s, x);
                if (keys[index] != x) {
                    alloc();
                    next[index] = alloc;
                    keys[alloc] = x;
                }
            }
            if (rehash && size >= slot.length) {
                rehash();
            }
        }

        private void rehash() {
            int[] newSlots = new int[Math.max(16, slot.length * 2)];
            int[] newVersions = new int[newSlots.length];
            int newMask = newSlots.length - 1;
            for (int i = 0; i < slot.length; i++) {
                access(i);
                if (slot[i] == 0) {
                    continue;
                }
                int head = slot[i];
                while (head != 0) {
                    int n = next[head];
                    int s = hash(keys[head]) & newMask;
                    next[head] = newSlots[s];
                    newSlots[s] = head;
                    head = n;
                }
            }
            this.slot = newSlots;
            this.version = newVersions;
            now = 0;
            this.mask = newMask;
        }

        public boolean contain(long x) {
            int h = hash(x);
            int s = h & mask;
            access(s);
            if (slot[s] == 0) {
                return false;
            }
            return keys[findIndexOrLastEntry(s, x)] == x;
        }

        public void remove(long x) {
            int h = hash(x);
            int s = h & mask;
            access(s);
            if (slot[s] == 0) {
                return;
            }
            int pre = 0;
            int index = slot[s];
            while (keys[index] != x) {
                pre = index;
                if (next[index] != 0) {
                    index = next[index];
                } else {
                    break;
                }
            }
            if (keys[index] != x) {
                return;
            }
            if (slot[s] == index) {
                slot[s] = next[index];
            } else {
                next[pre] = next[index];
            }
            removed[index] = true;
            size--;
        }

        private int findIndexOrLastEntry(int s, long x) {
            int iter = slot[s];
            while (keys[iter] != x) {
                if (next[iter] != 0) {
                    iter = next[iter];
                } else {
                    return iter;
                }
            }
            return iter;
        }

        public LongIterator iterator() {
            return new LongIterator() {
                int index = 1;


                public boolean hasNext() {
                    while (index <= alloc && removed[index]) {
                        index++;
                    }
                    return index <= alloc;
                }


                public long next() {
                    if (!hasNext()) {
                        throw new IllegalStateException();
                    }
                    return keys[index++];
                }
            };
        }

        public String toString() {
            LongIterator iterator = iterator();
            StringBuilder builder = new StringBuilder("{");
            while (iterator.hasNext()) {
                builder.append(iterator.next()).append(',');
            }
            if (builder.charAt(builder.length() - 1) == ',') {
                builder.setLength(builder.length() - 1);
            }
            builder.append('}');
            return builder.toString();
        }

    }

    static class IntMath {
        private IntMath() {
        }

        public static int floorSqrt(long x) {
            int lo = 0;
            int hi = (int) 2e9;

            while (lo < hi) {
                int mid = (lo + hi + 1) >> 1;
                if ((long) mid * mid <= x) {
                    lo = mid;
                } else {
                    hi = mid - 1;
                }
            }

            return lo;
        }

    }

    static interface IntegerEntryIterator {
        boolean hasNext();

        void next();

        int getEntryKey();

        int getEntryValue();

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

        public FastOutput append(int c) {
            cache.append(c);
            afterWrite();
            return this;
        }

        public FastOutput println(int c) {
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

    static class IntegerHashMap {
        private int now;
        private int[] slot;
        private int[] version;
        private int[] next;
        private int[] keys;
        private int[] values;
        private int alloc;
        private boolean[] removed;
        private int mask;
        private int size;
        private boolean rehash;
        private Hasher hasher = new Hasher();

        public IntegerHashMap(int cap, boolean rehash) {
            now = 1;
            this.mask = (1 << (32 - Integer.numberOfLeadingZeros(cap - 1))) - 1;
            slot = new int[mask + 1];
            version = new int[slot.length];
            next = new int[cap + 1];
            keys = new int[cap + 1];
            values = new int[cap + 1];
            removed = new boolean[cap + 1];
            this.rehash = rehash;
        }

        private void doubleCapacity() {
            int newSize = Math.max(next.length + 10, next.length * 2);
            next = Arrays.copyOf(next, newSize);
            keys = Arrays.copyOf(keys, newSize);
            values = Arrays.copyOf(values, newSize);
            removed = Arrays.copyOf(removed, newSize);
        }

        public void alloc() {
            alloc++;
            if (alloc >= next.length) {
                doubleCapacity();
            }
            next[alloc] = 0;
            removed[alloc] = false;
            size++;
        }

        private void rehash() {
            int[] newSlots = new int[Math.max(16, slot.length * 2)];
            int[] newVersions = new int[newSlots.length];
            int newMask = newSlots.length - 1;
            for (int i = 0; i < slot.length; i++) {
                access(i);
                if (slot[i] == 0) {
                    continue;
                }
                int head = slot[i];
                while (head != 0) {
                    int n = next[head];
                    int s = hash(keys[head]) & newMask;
                    next[head] = newSlots[s];
                    newSlots[s] = head;
                    head = n;
                }
            }
            this.slot = newSlots;
            this.version = newVersions;
            now = 0;
            this.mask = newMask;
        }

        private int hash(int x) {
            return hasher.hash(x);
        }

        public void modify(int x, int dy) {
            int h = hash(x);
            int s = h & mask;
            access(s);
            if (slot[s] == 0) {
                alloc();
                slot[s] = alloc;
                keys[alloc] = x;
                values[alloc] = dy;
            } else {
                int index = findIndexOrLastEntry(s, x);
                if (keys[index] != x) {
                    alloc();
                    next[index] = alloc;
                    keys[alloc] = x;
                    values[alloc] = dy;
                } else {
                    values[index] += dy;
                }
            }
            if (rehash && size >= slot.length) {
                rehash();
            }
        }

        public int getOrDefault(int x, int def) {
            int h = hash(x);
            int s = h & mask;
            access(s);
            if (slot[s] == 0) {
                return def;
            }
            int index = findIndexOrLastEntry(s, x);
            return keys[index] == x ? values[index] : def;
        }

        public int get(int x) {
            return getOrDefault(x, 0);
        }

        private int findIndexOrLastEntry(int s, int x) {
            int iter = slot[s];
            while (keys[iter] != x) {
                if (next[iter] != 0) {
                    iter = next[iter];
                } else {
                    return iter;
                }
            }
            return iter;
        }

        private void access(int i) {
            if (version[i] != now) {
                version[i] = now;
                slot[i] = 0;
            }
        }

        public IntegerEntryIterator iterator() {
            return new IntegerEntryIterator() {
                int index = 1;
                int readIndex = -1;


                public boolean hasNext() {
                    while (index <= alloc && removed[index]) {
                        index++;
                    }
                    return index <= alloc;
                }


                public int getEntryKey() {
                    return keys[readIndex];
                }


                public int getEntryValue() {
                    return values[readIndex];
                }


                public void next() {
                    if (!hasNext()) {
                        throw new IllegalStateException();
                    }
                    readIndex = index;
                    index++;
                }
            };
        }

        public String toString() {
            IntegerEntryIterator iterator = iterator();
            StringBuilder builder = new StringBuilder("{");
            while (iterator.hasNext()) {
                iterator.next();
                builder.append(iterator.getEntryKey()).append("->").append(iterator.getEntryValue()).append(',');
            }
            if (builder.charAt(builder.length() - 1) == ',') {
                builder.setLength(builder.length() - 1);
            }
            builder.append('}');
            return builder.toString();
        }

    }
}

