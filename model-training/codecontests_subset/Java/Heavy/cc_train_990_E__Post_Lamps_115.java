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
 * @author prakharjain
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
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int n = in.nextInt();
            int m = in.nextInt();
            int k = in.nextInt();

            int[] s = new int[m];

            boolean[] block = new boolean[n];

            for (int i = 0; i < m; i++) {
                s[i] = in.nextInt();
                block[s[i]] = true;
            }

            if (block[0]) {
                out.println(-1);
                return;
            }

            int lnb = -1;

            int[] lnba = new int[n];

            int mxcb = 0;
            int cb = 0;
            for (int i = 0; i < n; i++) {
                if (!block[i]) {
                    lnba[i] = i;
                    lnb = i;
                    if (cb > mxcb) {
                        mxcb = cb;
                    }
                    cb = 0;
                } else {
                    lnba[i] = lnb;
                    cb++;
                }
            }

            if (cb > mxcb) {
                mxcb = cb;
            }

            int[] a = new int[k + 1];

            for (int i = 1; i <= k; i++) {
                a[i] = in.nextInt();
            }

            long fans = Long.MAX_VALUE;
            for (int i = mxcb + 1; i <= k; i++) {
                int ci = 0;
                long ans = 0;
                for (int j = 1; ; j++) {
                    ans++;
                    ci += i;
                    if (ci >= n)
                        break;
                    ci = lnba[ci];
                }
                ans *= a[i];
                fans = Math.min(ans, fans);
            }

            if (fans == Long.MAX_VALUE) {
                out.println(-1);
                return;
            }

            out.println(fans);
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

        public void println(int i) {
            writer.println(i);
        }

    }
}

