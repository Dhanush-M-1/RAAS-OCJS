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
        BPuttingBricksInTheWall solver = new BPuttingBricksInTheWall();
        solver.solve(1, in, out);
        out.close();
    }

    static class BPuttingBricksInTheWall {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int ntc = 1;
            ntc = in.nextInt();
            while ((ntc--) > 0) {
                int n = in.nextInt();
                char[][] mat = new char[n][n];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        mat[i][j] = in.nextCharacter();
                    }
                }
                char a = mat[0][1];
                char b = mat[1][0];
                char c = mat[n - 2][n - 1];
                char d = mat[n - 1][n - 2];
                int mina = 0;
                ArrayList<int[]> coorda = new ArrayList<>();
                ArrayList<int[]> coordb = new ArrayList<>();
                if (a != '1') {
                    mina += 1;
                    coorda.add(new int[]{0, 1});
                }
                if (b != '1') {
                    mina += 1;
                    coorda.add(new int[]{1, 0});
                }
                if (c != '0') {
                    mina += 1;
                    coorda.add(new int[]{n - 2, n - 1});
                }
                if (d != '0') {
                    mina += 1;
                    coorda.add(new int[]{n - 1, n - 2});
                }


                int minb = 0;
                if (a != '0') {
                    minb += 1;
                    coordb.add(new int[]{0, 1});
                }
                if (b != '0') {
                    minb += 1;
                    coordb.add(new int[]{1, 0});
                }
                if (c != '1') {
                    minb += 1;
                    coordb.add(new int[]{n - 2, n - 1});
                }
                if (d != '1') {
                    minb += 1;
                    coordb.add(new int[]{n - 1, n - 2});
                }
                if (coorda.size() < coordb.size()) {
                    out.println(coorda.size());
                    for (int[] cr : coorda) {
                        out.println(cr[0] + 1, cr[1] + 1);
                    }
                } else {
                    out.println(coordb.size());
                    for (int[] cr : coordb) {
                        out.println(cr[0] + 1, cr[1] + 1);
                    }
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

        public static boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public char nextCharacter() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            return (char) c;
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

        public void print(Object... objects) {
            for (int i = 0; i < objects.length; ++i) {
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

        public void println(long i) {
            writer.println(i);
        }

    }
}

