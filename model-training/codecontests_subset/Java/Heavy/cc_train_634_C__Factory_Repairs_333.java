import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.util.InputMismatchException;
import java.io.IOException;
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
        TaskD solver = new TaskD();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskD {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int n = in.readInt();
            int k = in.readInt();
            int a = in.readInt();
            int b = in.readInt();
            int q = in.readInt();

            SumIntervalTree treeA = new SumIntervalTree(n, a);
            SumIntervalTree treeB = new SumIntervalTree(n, b);

            for (int i = 0; i < q; i++) {
                switch (in.readInt()) {
                case 1:
                    int di = in.readInt();
                    int ai = in.readInt();
                    treeA.update(di, ai);
                    treeB.update(di, ai);
                    break;

                case 2:
                    int pi = in.readInt();
                    long ans = treeB.query(0, pi - 1) + treeA.query(pi + k, n);
                    out.printLine(ans);
                }
            }
        }

    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;

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

    static class SumIntervalTree {
        private int n;
        private long[] a;
        private int maxSpeed;

        public SumIntervalTree(int n, int maxSpeed) {
            int log = 1;
            while ((1 << log) < n) {
                log++;
            }
            this.n = n = 1 << log;
            this.maxSpeed = maxSpeed;
            a = new long[2 * n];
        }

        public long query(int from, int to) {
            long res = 0;
            for (from += n, to += n; from <= to; from /= 2, to /= 2) {
                if (from % 2 == 1) {
                    res += a[from++];
                }
                if (to % 2 == 0) {
                    res += a[to--];
                }
            }
            return res;
        }

        public void update(int v, long val) {
            v += n;
            a[v] += val;
            if (a[v] > maxSpeed) {
                a[v] = maxSpeed;
            }
            updateTree(v / 2);
        }

        private void updateTree(int v) {
            if (v == 0) {
                return;
            }

            a[v] = a[v * 2] + a[v * 2 + 1];
            updateTree(v / 2);
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

        public void printLine(long i) {
            writer.println(i);
        }

    }
}

