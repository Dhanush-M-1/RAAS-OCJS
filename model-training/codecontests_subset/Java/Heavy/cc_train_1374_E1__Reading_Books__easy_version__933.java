import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.AbstractCollection;
import java.util.PriorityQueue;
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
        E1ReadingBooksEasyVersion solver = new E1ReadingBooksEasyVersion();
        solver.solve(1, in, out);
        out.close();
    }

    static class E1ReadingBooksEasyVersion {
        int IINF = (int) 1e9 + 331;

        public void solve(int testNumber, InputReader in, OutputWriter out) {
            long n = in.nextInt(), k = in.nextInt(), ans = 0;
            PriorityQueue<Integer> both = new PriorityQueue<>(), aLikes = new PriorityQueue<>(), bLikes = new PriorityQueue<>();
            for (int i = 0; i < n; i++) {
                int time = in.nextInt(), a = in.nextInt(), b = in.nextInt();
                if (a == b && b == 1) both.add(time);
                if (a != b && a == 1) aLikes.add(time);
                if (a != b && b == 1) bLikes.add(time);
            }
            int aGot = 0, bGot = 0;
            while (aGot < k || bGot < k) {
                if ((aLikes.size() == 0 || bLikes.size() == 0) && both.size() == 0) break;

                int blbboth = IINF, blbalice = IINF, blbbob = IINF;

                if (!both.isEmpty()) blbboth = both.peek();
                if (!aLikes.isEmpty()) blbalice = aLikes.peek();
                if (!bLikes.isEmpty()) blbbob = bLikes.peek();

                if (blbboth <= blbalice + blbbob || (blbalice == IINF || blbbob == IINF)) {
                    ans += blbboth;
                    both.poll();
                    aGot++;
                    bGot++;
                } else if (blbboth > blbalice + blbbob || blbboth == IINF) {
                    ans += (blbalice + blbbob);
                    aLikes.poll();
                    bLikes.poll();
                    aGot++;
                    bGot++;
                } else {
                    break;
                }
            }
            if (aGot < k || bGot < k) out.println(-1);
            else out.println(ans);
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

        public void println(long i) {
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

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

        }

    }
}

