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
 * @author lewin
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        DShikAndGame solver = new DShikAndGame();
        solver.solve(1, in, out);
        out.close();
    }

    static class DShikAndGame {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int n = in.nextInt(), e = in.nextInt(), t = in.nextInt();
            int[] x = in.readIntArray(n);
            long[] dp = new long[n + 1];
            int f = 0;
            long m2 = 1L << 50;
            MinQueue mq = new MinQueue(n + 10);
            mq.add(dp[0], 0);
            for (int i = 1; i <= n; i++) {
                while (2 * (x[i - 1] - x[f]) >= t) {
                    m2 = Math.min(m2, dp[f] - 2 * x[f]);
                    f++;
                }
                dp[i] = Math.min(m2 + 2 * x[i - 1], mq.getMin(f) + t);
                mq.add(dp[i], i);
            }
            out.println(dp[n] + e);
        }

    }

    static class MinQueue {
        public long[] value;
        public int front;
        public int back;
        public int[] index;

        public MinQueue(int N) {
            value = new long[N];
            index = new int[N];
            front = back = 0;
        }

        public void add(long val, int idx) {
            while (front < back && value[back - 1] >= val) back--;
            value[back] = val;
            index[back++] = idx;
        }

        public long getMin(int idx) {
            while (front < back && index[front] < idx) front++;
            return front == back ? Integer.MAX_VALUE : value[front];
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
        private byte[] buf = new byte[1 << 16];
        private int curChar;
        private int numChars;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int[] readIntArray(int tokens) {
            int[] ret = new int[tokens];
            for (int i = 0; i < tokens; i++) {
                ret[i] = nextInt();
            }
            return ret;
        }

        public int read() {
            if (this.numChars == -1) {
                throw new InputMismatchException();
            } else {
                if (this.curChar >= this.numChars) {
                    this.curChar = 0;

                    try {
                        this.numChars = this.stream.read(this.buf);
                    } catch (IOException var2) {
                        throw new InputMismatchException();
                    }

                    if (this.numChars <= 0) {
                        return -1;
                    }
                }

                return this.buf[this.curChar++];
            }
        }

        public int nextInt() {
            int c;
            for (c = this.read(); isSpaceChar(c); c = this.read()) {
                ;
            }

            byte sgn = 1;
            if (c == 45) {
                sgn = -1;
                c = this.read();
            }

            int res = 0;

            while (c >= 48 && c <= 57) {
                res *= 10;
                res += c - 48;
                c = this.read();
                if (isSpaceChar(c)) {
                    return res * sgn;
                }
            }

            throw new InputMismatchException();
        }

        public static boolean isSpaceChar(int c) {
            return c == 32 || c == 10 || c == 13 || c == 9 || c == -1;
        }

    }
}

