import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.BufferedWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.Collections;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        TaskF solver = new TaskF();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskF {
        long[] answers;
        int[] size;
        List<TaskF.Edge>[] queries;
        List<Integer>[] descendants;
        int[] node;

        static void set(long[] t, int i, long value) {
            i += t.length / 2;
            if (t[i] < value && value != Long.MAX_VALUE)
                return;
            t[i] = value;
            for (; i > 1; i >>= 1)
                t[i >> 1] = Math.min(t[i], t[i ^ 1]);
        }

        static int minIndex(long[] t) {
            int res = 1;
            while (res < t.length / 2)
                res = res * 2 + (t[res * 2] > t[1] ? 1 : 0);
            return res - t.length / 2;
        }

        void unite(int x, int y, long w) {
            x = node[x];
            y = node[y];
            if (x == y) return;
            if (size[x] > size[y]) {
                x ^= y;
                y ^= x;
                x ^= y;
            }
            for (int a : descendants[x]) {
                for (TaskF.Edge e : queries[a]) if (node[e.t] == y && answers[e.cost] == 0) answers[e.cost] = w;
                node[a] = y;
                descendants[y].add(a);
            }
            descendants[x].clear();
            size[y] += size[x];
        }

        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int n = in.nextInt(), m = in.nextInt(), k = in.nextInt(), q = in.nextInt();
            List<TaskF.Edge>[] edges = Stream.generate(ArrayList::new).limit(n).toArray(List[]::new);
            queries = Stream.generate(ArrayList::new).limit(n).toArray(List[]::new);
            descendants = Stream.generate(ArrayList::new).limit(n).toArray(List[]::new);
            size = new int[n];
            node = new int[n];
            for (int i = 0; i < n; i++) {
                descendants[i].add(i);
                node[i] = i;
            }
            Arrays.fill(size, 1);
            for (int i = 0; i < m; i++) {
                int u = in.nextInt() - 1, v = in.nextInt() - 1, w = in.nextInt();
                edges[u].add(new TaskF.Edge(v, w));
                edges[v].add(new TaskF.Edge(u, w));
            }
            int[] a = new int[q], b = new int[q];
            answers = new long[q];
            for (int i = 0; i < q; i++) {
                a[i] = in.nextInt() - 1;
                b[i] = in.nextInt() - 1;
                queries[a[i]].add(new TaskF.Edge(b[i], i));
                queries[b[i]].add(new TaskF.Edge(a[i], i));
            }

            long[] dist = new long[n];
            int[] pred = new int[n];
            Arrays.fill(pred, -1);
            Arrays.fill(dist, Long.MAX_VALUE);
            long[] t = new long[edges.length * 2];
            Arrays.fill(t, Long.MAX_VALUE);
            boolean[] over = new boolean[n];
            for (int i = 0; i < k; i++) {
                dist[i] = 0;
                set(t, i, 0);
                pred[i] = i;
                over[i] = true;
            }

            ArrayList<Pair> E = new ArrayList<>();
            while (true) {
                int cur = minIndex(t);
                assert (!over[cur]);
                over[cur] = true;
                if (t[cur + t.length / 2] == Long.MAX_VALUE) {
                    break;
                }
                set(t, cur, Long.MAX_VALUE);
                for (TaskF.Edge e : edges[cur]) {
                    int v = e.t;
                    long ndist = dist[cur] + e.cost;
                    if (dist[v] > ndist) {
                        dist[v] = ndist;
                        pred[v] = pred[cur];
                        set(t, v, ndist);
                    } else if (over[v]) {
                        int x = pred[v], y = pred[cur];
                        if (x == y) continue;
                        long key = ((long) x << 32) + y;
                        long d = dist[v] + dist[cur] + e.cost;

                        E.add(new Pair(d, key));
                    }
                }
            }
            Collections.sort(E, new TaskF.PairComparator());
            for (Pair P : E) {
                long val = P.a, key = P.b;
                int x = (int) (key >>> 32);
                int y = (int) key;
                unite(x, y, val);
            }
            for (int i = 0; i < q; i++) out.println(answers[i]);
        }

        public static class Edge {
            int t;
            int cost;

            public Edge(int t, int cost) {
                this.t = t;
                this.cost = cost;
            }

        }

        class Pair {
            long a;
            long b;

            Pair(long _a, long _b) {
                a = _a;
                b = _b;
            }

        }

        static class PairComparator implements Comparator<Pair> {
            public int compare(Pair c1, Pair c2) {
                return (c1.a < c2.a || (c1.a == c2.a && c1.b < c2.b)) ? -1 : 1;
            }

        }

    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private InputReader.SpaceCharFilter filter;

        public InputReader(InputStream stream) {
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
            while (isSpaceChar(c)) c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
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

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

        }

    }

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void println(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0) {
                    writer.print(' ');
                }
                writer.print(objects[i]);
            }
            writer.print('\n');
        }

        public void close() {
            writer.close();
        }

    }
}

