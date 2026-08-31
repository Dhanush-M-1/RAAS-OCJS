import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.io.BufferedWriter;
import java.io.Writer;
import java.util.Set;
import java.io.OutputStreamWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Rustam Musin (PloadyFree@gmail.com)
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        TaskB solver = new TaskB();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskB {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int n = in.readInt();
            int m = in.readInt();
            Set<Integer>[] byCol = new Set[m];
            for (int i = 0; i < m; i++) {
                byCol[i] = new HashSet<>();
            }
            int q = in.readInt();
            DSU dsu = new DSU(n);
            Set<Integer> usedRow = new HashSet<>();
            Set<Integer> usedCol = new HashSet<>();
            for (int i = 0; i < q; i++) {
                int r = in.readInt() - 1;
                int c = in.readInt() - 1;
                if (!byCol[c].isEmpty()) {
                    dsu.unite(r, byCol[c].iterator().next());
                }
                byCol[c].add(r);
                usedRow.add(r);
                usedCol.add(c);
            }

            int answer = dsu.compCount - 1;
            answer += m - usedCol.size();
            out.print(answer);
        }

        class DSU {
            int[] parent;
            int compCount;

            DSU(int n) {
                parent = new int[n];
                compCount = n;
                for (int i = 0; i < n; i++) {
                    parent[i] = i;
                }
            }

            int find(int u) {
                if (parent[u] == u) {
                    return u;
                }
                return parent[u] = find(parent[u]);
            }

            boolean unite(int u, int v) {
                u = find(u);
                v = find(v);
                if (u == v) {
                    return false;
                }
                parent[u] = v;
                compCount--;
                return true;
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

        public int readInt() {
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

        public void close() {
            writer.close();
        }

        public void print(int i) {
            writer.print(i);
        }

    }
}

