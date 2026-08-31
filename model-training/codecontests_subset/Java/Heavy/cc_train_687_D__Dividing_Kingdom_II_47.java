import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.io.UncheckedIOException;
import java.util.List;
import java.io.Closeable;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.io.InputStream;
import java.util.function.IntFunction;

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
            DDividingKingdomII solver = new DDividingKingdomII();
            solver.solve(1, in, out);
            out.close();
        }
    }

    static class DDividingKingdomII {
        public void solve(int testNumber, FastInput in, FastOutput out) {
            int n = in.readInt();
            int m = in.readInt();
            int q = in.readInt();

            Edge[] edges = new Edge[m];
            for (int i = 0; i < m; i++) {
                edges[i] = new Edge();
                edges[i].u = in.readInt() - 1;
                edges[i].v = in.readInt() - 1;
                edges[i].w = in.readInt();
            }


            XorDeltaDSU dsu = new XorDeltaDSU(n);
            List<Edge> collect = new ArrayList<>();
            Segment seg = new Segment(0, m - 1, i -> edges[i]);
            CompareUtils.ensureObjectSpace(m);
            for (int i = 0; i < q; i++) {
                int l = in.readInt() - 1;
                int r = in.readInt() - 1;
                collect.clear();
                seg.query(l, r, 0, m - 1, collect);
                int ans = -1;
                dsu.reset();
                for (Edge e : collect) {
                    if (dsu.find(e.u) == dsu.find(e.v)) {
                        if (dsu.delta(e.u, e.v) == 0) {
                            ans = e.w;
                            break;
                        }
                        continue;
                    }
                    dsu.merge(e.u, e.v, 1);
                }
                out.println(ans);
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

    static class Edge {
        int u;
        int v;
        int w;

        public String toString() {
            return String.format("(%d, %d)=%d", u, v, w);
        }

    }

    static class FastOutput implements AutoCloseable, Closeable, Appendable {
        private StringBuilder cache = new StringBuilder(10 << 20);
        private final Writer os;

        public FastOutput append(CharSequence csq) {
            cache.append(csq);
            return this;
        }

        public FastOutput append(CharSequence csq, int start, int end) {
            cache.append(csq, start, end);
            return this;
        }

        public FastOutput(Writer os) {
            this.os = os;
        }

        public FastOutput(OutputStream os) {
            this(new OutputStreamWriter(os));
        }

        public FastOutput append(char c) {
            cache.append(c);
            return this;
        }

        public FastOutput append(int c) {
            cache.append(c);
            return this;
        }

        public FastOutput println(int c) {
            return append(c).println();
        }

        public FastOutput println() {
            cache.append(System.lineSeparator());
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

        public String toString() {
            return cache.toString();
        }

    }

    static class Segment implements Cloneable {
        private Segment left;
        private Segment right;
        private static XorDeltaDSU dsu = new XorDeltaDSU(1000);
        private List<Edge> sorted;
        private static List<Edge> buf = new ArrayList<>();

        public static void mergeTo(List<Edge> a, List<Edge> b, List<Edge> c) {
            int lOffset = 0;
            int rOffset = 0;
            int lSize = a.size();
            int rSize = b.size();
            dsu.reset();
            while (lOffset < lSize || rOffset < rSize) {
                if (rOffset >= rSize || lOffset < lSize &&
                        a.get(lOffset).w >=
                                b.get(rOffset).w) {
                    c.add(a.get(lOffset++));
                } else {
                    c.add(b.get(rOffset++));
                }
                Edge last = c.get(c.size() - 1);
                if (dsu.find(last.u) == dsu.find(last.v)) {
                    if (dsu.delta(last.u, last.v) == 1) {
                        c.remove(c.size() - 1);
                        continue;
                    }
                    break;
                }
                dsu.merge(last.u, last.v, 1);
            }
        }

        public void pushUp() {
            mergeTo(left.sorted, right.sorted, sorted = new ArrayList<>());
        }

        public void pushDown() {
        }

        public Segment(int l, int r, IntFunction<Edge> func) {
            if (l < r) {
                int m = DigitUtils.floorAverage(l, r);
                left = new Segment(l, m, func);
                right = new Segment(m + 1, r, func);
                pushUp();
            } else {
                sorted = Collections.singletonList(func.apply(l));
            }
        }

        private boolean covered(int ll, int rr, int l, int r) {
            return ll <= l && rr >= r;
        }

        private boolean noIntersection(int ll, int rr, int l, int r) {
            return ll > r || rr < l;
        }

        public void query(int ll, int rr, int l, int r, List<Edge> collect) {
            if (noIntersection(ll, rr, l, r)) {
                return;
            }
            if (covered(ll, rr, l, r)) {
                buf.clear();
                mergeTo(sorted, collect, buf);
                collect.clear();
                collect.addAll(buf);
                return;
            }
            pushDown();
            int m = DigitUtils.floorAverage(l, r);
            left.query(ll, rr, l, m, collect);
            right.query(ll, rr, m + 1, r, collect);
        }

        private Segment deepClone() {
            Segment seg = clone();
            if (seg.left != null) {
                seg.left = seg.left.deepClone();
            }
            if (seg.right != null) {
                seg.right = seg.right.deepClone();
            }
            return seg;
        }

        protected Segment clone() {
            try {
                return (Segment) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException(e);
            }
        }

        private void toString(StringBuilder builder) {
            if (left == null && right == null) {
                builder.append("val").append(",");
                return;
            }
            pushDown();
            left.toString(builder);
            right.toString(builder);
        }

        public String toString() {
            StringBuilder builder = new StringBuilder();
            deepClone().toString(builder);
            if (builder.length() > 0) {
                builder.setLength(builder.length() - 1);
            }
            return builder.toString();
        }

    }

    static class DigitUtils {
        private DigitUtils() {
        }

        public static int floorAverage(int x, int y) {
            return (x & y) + ((x ^ y) >> 1);
        }

    }

    static class CompareUtils {
        private static Object[] objectList = new Object[0];

        private CompareUtils() {
        }

        public static void ensureObjectSpace(int n) {
            if (objectList.length < n) {
                objectList = new Object[n];
            }
        }

    }

    static class XorDeltaDSU {
        int[] p;
        int[] rank;
        int[] delta;
        int[] version;
        int now;

        public void access(int i) {
            if (version[i] != now) {
                version[i] = now;
                rank[i] = 0;
                delta[i] = 0;
                p[i] = i;
            }
        }

        public XorDeltaDSU(int n) {
            p = new int[n];
            rank = new int[n];
            delta = new int[n];
            version = new int[n];
            reset();
        }

        public void reset() {
            now++;
        }

        public int find(int a) {
            access(a);
            if (p[a] == p[p[a]]) {
                return p[a];
            }
            find(p[a]);
            delta[a] ^= delta[p[a]];
            return p[a] = p[p[a]];
        }

        public int delta(int a, int b) {
            find(a);
            find(b);
            return delta[a] ^ delta[b];
        }

        public void merge(int a, int b, int d) {
            find(a);
            find(b);
            d = d ^ delta[a] ^ delta[b];
            a = find(a);
            b = find(b);
            if (a == b) {
                return;
            }
            if (rank[a] == rank[b]) {
                rank[a]++;
            }
            if (rank[a] > rank[b]) {
                p[b] = a;
                delta[b] = d;
            } else {
                p[a] = b;
                delta[a] = d;
            }
        }

    }
}

