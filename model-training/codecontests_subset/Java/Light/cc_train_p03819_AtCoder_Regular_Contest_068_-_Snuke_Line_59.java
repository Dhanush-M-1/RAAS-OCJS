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
 *
 * @author Rustam Musin (t.me/musin_acm)
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        ESnukeLine solver = new ESnukeLine();
        solver.solve(1, in, out);
        out.close();
    }

    static class ESnukeLine {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int m = in.readInt();
            int n = in.readInt();
            int sq = (int) Math.ceil(Math.sqrt(n));
            int[] delta = new int[n + 2];
            for (int i = 0; i < m; i++) {
                int first = in.readInt();
                int second = in.readInt();
                int rightmost = Integer.MAX_VALUE;
                for (int p = 1; rightmost > sq; p++) {
                    int r = second / p;
                    int l = (first + p - 1) / p;
                    r = Math.min(r, rightmost - 1);
                    if (l <= r) {
                        delta[l]++;
                        delta[r + 1]--;
                        rightmost = l;
                    }
                }
                while (--rightmost > 0) {
                    int k = (first + rightmost - 1) / rightmost;
                    int pos = k * rightmost;
                    if (pos <= second) {
                        delta[rightmost]++;
                        delta[rightmost + 1]--;
                    }
                }
            }
            for (int i = 1, s = 0; i <= n; i++) {
                s += delta[i];
                if (i > 0) out.print(s + " ");
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
}

