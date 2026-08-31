import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.io.BufferedWriter;
import java.util.Set;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author prakharjain
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        TaskD solver = new TaskD();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskD {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int n = in.nextInt();
            int m = in.nextInt();
            int q = in.nextInt();

            Set[] rl = new Set[n + 1];

            for (int i = 1; i <= n; i++) {
                rl[i] = new HashSet<Integer>();
            }

            int an = q;
            for (int i = 0; i < q; i++) {
                int r = in.nextInt();
                int c = in.nextInt();

                if (rl[r].contains(c))
                    an--;
                else
                    rl[r].add(c);
            }

            DSU<Integer> dsu = new DSU<>();

            for (int i = 1; i <= m; i++) {
                dsu.createSet(i);
            }

            for (int i = 1; i <= n; i++) {
                Map<Integer, Integer> map = new HashMap<>();

                if (rl[i].isEmpty())
                    continue;

                for (Integer num : (Set<Integer>) rl[i]) {
                    int g = dsu.findSet(num);
                    map.merge(g, 1, (x, y) -> x + y);
                }

                for (Integer key : map.keySet()) {
                    an -= (map.get(key) - 1);
                }

                int oc = ((Set<Integer>) rl[i]).iterator().next();

                for (Integer num : (Set<Integer>) rl[i]) {
                    dsu.mergeSets(oc, num);
                }
            }

            out.println(n + m - 1 - an);
        }

        public class DSU<T> {
            Map<T, T> parent = new HashMap<>();
            Map<T, Integer> rank = new HashMap<>();

            T createSet(T x) {
                parent.put(x, x);
                rank.put(x, 0);
                return x;
            }

            T findSet(T x) {
                T par = parent.get(x);
                if (!x.equals(par)) {
                    parent.put(x, findSet(par));
                    return parent.get(x);
                }
                return par;
            }

            T mergeSets(T x, T y) {
                T rx = findSet(x);
                T ry = findSet(y);

                if (rx.equals(ry)) {
                    return rx;
                }

                T fp = null;

                if (rank.get(rx) > rank.get(ry)) {
                    parent.put(ry, rx);
                    fp = rx;
                } else {
                    parent.put(rx, ry);
                    fp = ry;
                }

                if (rank.get(rx).equals(rank.get(ry))) {
                    rank.put(ry, rank.get(ry) + 1);
                }

                return fp;
            }

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

        public void close() {
            writer.close();
        }

        public void println(int i) {
            writer.println(i);
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

        public static boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
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

        public boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return isWhitespace(c);
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

        }

    }
}

