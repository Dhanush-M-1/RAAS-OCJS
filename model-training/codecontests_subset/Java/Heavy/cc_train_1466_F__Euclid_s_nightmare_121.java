import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.BufferedWriter;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.ArrayList;
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
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int n = in.nextInt(), m = in.nextInt();
            int[] U = new int[n], V = new int[n];
            TaskF.DisjointSetsRank dsr = new TaskF.DisjointSetsRank(m);
            long answer = 1;
            for (int i = 0; i < n; i++) {
                int k = in.nextInt();
                U[i] = V[i] = in.nextInt() - 1;
                if (k == 2) {
                    V[i] = in.nextInt() - 1;
                }
                dsr.unite(U[i], V[i], i + 1);
            }
            for (int i : dsr.indices) answer = (answer * 2) % 1000000007;
            out.println(answer + " " + dsr.indices.size());
            for (int i : dsr.indices) out.print(i + " ");
        }

        static class DisjointSetsRank {
            int[] p;
            int[] deficit;
            ArrayList<Integer> indices;

            public DisjointSetsRank(int size) {
                p = new int[size];
                for (int i = 0; i < size; i++) p[i] = i;
                deficit = new int[size];
                Arrays.fill(deficit, 1);
                indices = new ArrayList<>();
            }

            public int root(int x) {
                return x == p[x] ? x : (p[x] = root(p[x]));
            }

            public void unite(int a, int b, int i) {
                boolean eq = a == b;
                a = root(a);
                b = root(b);
                if (a == b) {
                    if (!eq) return;
                    if (deficit[a] == 1) {
                        deficit[a] = 0;
                        indices.add(i);
                    }
                    return;
                }
                int d = deficit[a] + deficit[b];
                if (d == 0) return;
                indices.add(i);
                deficit[b] = d - 1;
                p[a] = b;
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

        public void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0) {
                    writer.print(' ');
                }
                writer.print(objects[i]);
            }
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
}

