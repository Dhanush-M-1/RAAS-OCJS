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
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.util.Comparator;
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
        TaskD solver = new TaskD();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskD {
        private int n;
        private int k;
        private int p;
        private int[] a;
        private int[] b;
        private List<IntIntPair>[] g;
        private int[] used;
        private int[] parent;
        private int time;
        private long max;

        public void solve(int testNumber, InputReader in, OutputWriter out) {
            n = in.readInt();
            k = in.readInt();
            p = in.readInt();
            a = IOUtils.readIntArray(in, n);
            b = IOUtils.readIntArray(in, k);

            g = new List[n];
            int maxW = -1;
            for (int i = 0; i < n; i++) {
                g[i] = new ArrayList<>();
                for (int j = 0; j < k; j++) {
                    int w = Math.abs(a[i] - b[j]) + Math.abs(b[j] - p);
                    g[i].add(IntIntPair.makePair(j, w));
                    if (w > maxW) {
                        maxW = w;
                    }
                }
                g[i].sort(Comparator.comparingInt(e -> -e.second));
            }

            long[] done = new long[n];
            used = new int[k];
            parent = new int[k];
            long l = -1;
            long r = maxW;
            while (r - l > 1) {
                long m = (l + r) >> 1;
                max = m;

                Arrays.fill(parent, -1);
                for (int i = 0; i < n; i++) {
                    for (IntIntPair e : g[i]) {
                        if (e.second <= m && parent[e.first] == -1) {
                            parent[e.first] = i;
                            done[i] = m;
                            break;
                        }
                    }
                }
                boolean ok = true;
                for (int i = 0; i < n; i++) {
                    time++;
                    if (done[i] != m && !dfs(i)) {
                        ok = false;
                        break;
                    }
                }

                if (ok) {
                    r = m;
                } else {
                    l = m;
                }
            }
            out.print(l + 1);
        }

        private boolean dfs(int v) {
            if (used[v] == time) {
                return false;
            }
            used[v] = time;
            for (IntIntPair e : g[v]) {
                int cost = e.second;
                if (cost > max) {
                    continue;
                }
                int to = e.first;
                if (parent[to] == -1 || dfs(parent[to])) {
                    parent[to] = v;
                    return true;
                }
            }
            return false;
        }

    }

    static class IntIntPair implements Comparable<IntIntPair> {
        public final int first;
        public final int second;

        public static IntIntPair makePair(int first, int second) {
            return new IntIntPair(first, second);
        }

        public IntIntPair(int first, int second) {
            this.first = first;
            this.second = second;
        }


        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            IntIntPair pair = (IntIntPair) o;

            return first == pair.first && second == pair.second;
        }


        public int hashCode() {
            int result = first;
            result = 31 * result + second;
            return result;
        }


        public String toString() {
            return "(" + first + "," + second + ")";
        }

        @SuppressWarnings({"unchecked"})
        public int compareTo(IntIntPair o) {
            int value = Integer.compare(first, o.first);
            if (value != 0) {
                return value;
            }
            return Integer.compare(second, o.second);
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

    static class IOUtils {
        public static int[] readIntArray(InputReader in, int size) {
            int[] array = new int[size];
            for (int i = 0; i < size; i++) {
                array[i] = in.readInt();
            }
            return array;
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

        public void print(long i) {
            writer.print(i);
        }

    }
}

