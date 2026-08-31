import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author revanth
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        BPuttingBricksInTheWall solver = new BPuttingBricksInTheWall();
        solver.solve(1, in, out);
        out.close();
    }

    static class BPuttingBricksInTheWall {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int t = in.nextInt();
            while (t-- > 0) {
                int n = in.nextInt();
                char[][] c = new char[n][n];
                for (int i = 0; i < n; i++)
                    c[i] = in.nextString().toCharArray();
                ArrayList<Pair> al = new ArrayList<>();
                if (c[0][1] == c[1][0]) {
                    if (c[n - 1][n - 2] == c[0][1])
                        al.add(new Pair(n, n - 1));
                    if (c[n - 2][n - 1] == c[0][1])
                        al.add(new Pair(n - 1, n));
                } else if (c[n - 1][n - 2] == c[n - 2][n - 1]) {
                    if (c[0][1] == c[n - 1][n - 2])
                        al.add(new Pair(1, 2));
                    if (c[1][0] == c[n - 1][n - 2])
                        al.add(new Pair(2, 1));
                } else {
                    if (c[0][1] == c[n - 1][n - 2]) {
                        al.add(new Pair(2, 1));
                        al.add(new Pair(n, n - 1));
                    } else {
                        al.add(new Pair(2, 1));
                        al.add(new Pair(n - 1, n));
                    }
                }
                out.println(al.size());
                for (Pair p : al)
                    out.println(p.x + " " + p.y);
            }
        }

    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1 << 16];
        private int curChar;
        private int snumChars;
        private InputReader.SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int snext() {
            if (snumChars == -1)
                throw new InputMismatchException();
            if (curChar >= snumChars) {
                curChar = 0;
                try {
                    snumChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (snumChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public int nextInt() {
            int c = snext();
            while (isSpaceChar(c))
                c = snext();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = snext();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public String nextString() {
            int c = snext();
            while (isSpaceChar(c))
                c = snext();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = snext();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public interface SpaceCharFilter {
            boolean isSpaceChar(int ch);

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
            print(objects);
            writer.println();
        }

        public void close() {
            writer.close();
        }

    }

    static class Pair implements Comparable<Pair> {
        public int x;
        public int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x &&
                    y == pair.y;
        }

        public int hashCode() {
            return Objects.hash(x, y);
        }

        public int compareTo(Pair p) {
//        if(x==p.x)
//            return Integer.compare(y,p.y);
            return Long.compare(x, p.x);
        }

    }
}

