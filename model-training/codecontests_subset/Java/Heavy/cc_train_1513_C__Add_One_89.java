import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Pranay2516
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastReader in = new FastReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        CAddOne solver = new CAddOne();
        solver.solve(1, in, out);
        out.close();
    }

    static class CAddOne {
        public void solve(int testNumber, FastReader in, PrintWriter out) {
            int t = in.nextInt();

            long mod = (long) 1e9 + 7;
            int MX = (int) 2e5 + 2;
            long[][] dp = new long[MX][10];
            Arrays.fill(dp[0], 1);

            for (int i = 1; i < MX; ++i) {
                for (int j = 0; j < 9; ++j) {
                    dp[i][j] = dp[i - 1][j + 1];
                }
                dp[i][9] = func.modAdd(dp[i - 1][0], dp[i - 1][1], mod);
            }

            while (t-- > 0) {
                int n = in.nextInt(), m = in.nextInt();
                long ans = 0;
                while (n > 0) {
                    ans = func.modAdd(ans, dp[m][n % 10], mod);
                    n /= 10;
                }
                out.println(ans);
            }

        }

    }

    static class func {
        public static long modAdd(long a, long b, long m) {
            a %= m;
            b %= m;
            return ((a + b) % m + m) % m;
        }

    }

    static class FastReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private FastReader.SpaceCharFilter filter;

        public FastReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1) throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) return -1;
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
                if (c < '0' || c > '9') throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            while (!isSpaceChar(c));
            return res * sgn;
        }

        public boolean isSpaceChar(int c) {
            if (filter != null) return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

        }

    }
}

