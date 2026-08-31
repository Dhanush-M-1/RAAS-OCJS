import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.util.Collection;
import java.util.Set;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.HashSet;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.util.Queue;
import java.util.ArrayDeque;
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
        TaskE solver = new TaskE();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskE {
        int n;
        int m;
        int k;
        Set<Integer>[] g;
        boolean[] removed;

        public void solve(int testNumber, InputReader in, OutputWriter out) {
            n = in.readInt();
            m = in.readInt();
            k = in.readInt();
            g = new Set[n];
            for (int i = 0; i < n; i++) {
                g[i] = new HashSet<>();
            }
            int[][] queries = in.readIntTable(m, 2);
            for (int i = 0; i < m; i++) {
                MiscUtils.decreaseByOne(queries[i]);
                g[queries[i][0]].add(queries[i][1]);
                g[queries[i][1]].add(queries[i][0]);
            }
            int answer = n;
            removed = new boolean[n];
            for (int i = 0; i < n; i++) {
                if (g[i].size() < k) {
                    answer -= remove(i);
                }
            }
            int[] res = new int[m];
            for (int i = m - 1; i >= 0; i--) {
                res[i] = answer;
                int u = queries[i][0];
                int v = queries[i][1];
                g[u].remove(v);
                g[v].remove(u);
                if (g[u].size() < k) {
                    answer -= remove(u);
                }
                if (g[v].size() < k) {
                    answer -= remove(v);
                }
            }
            for (int x : res) {
                out.printLine(x);
            }
        }

        int remove(int v) {
            if (removed[v]) {
                return 0;
            }
            removed[v] = true;
            Queue<Integer> q = new ArrayDeque<>();
            q.add(v);
            int rem = 0;
            while (!q.isEmpty()) {
                rem++;
                v = q.poll();
                for (int to : g[v]) {
                    g[to].remove(v);
                    if (!removed[to] && g[to].size() < k) {
                        removed[to] = true;
                        q.add(to);
                    }
                }
                g[v].clear();
            }
            return rem;
        }

    }

    static class MiscUtils {
        public static void decreaseByOne(int[]... arrays) {
            for (int[] array : arrays) {
                for (int i = 0; i < array.length; i++) {
                    array[i]--;
                }
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

        public int[][] readIntTable(int rowCount, int columnCount) {
            int[][] table = new int[rowCount][];
            for (int i = 0; i < rowCount; i++) {
                table[i] = readIntArray(columnCount);
            }
            return table;
        }

        public int[] readIntArray(int size) {
            int[] array = new int[size];
            for (int i = 0; i < size; i++) {
                array[i] = readInt();
            }
            return array;
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

        public void printLine(int i) {
            writer.println(i);
        }

    }
}

