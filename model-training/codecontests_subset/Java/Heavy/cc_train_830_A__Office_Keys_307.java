import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.IOException;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Aman Kumar Singh
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        AOfficeKeys solver = new AOfficeKeys();
        solver.solve(1, in, out);
        out.close();
    }

    static class AOfficeKeys {
        long INF = (long) 1e18 + 1;
        PrintWriter out;
        InputReader in;
        long[][] dp;
        long p;
        long[] arr1;
        long[] arr2;

        long go(int n, int k) {
            if (n < 0 || k < 0) {
                return INF;
            }
            if (n > k) {
                return INF;
            }
            if (n == 0) {
                return 0;
            }
            if (dp[n][k] != -1) {
                return dp[n][k];
            }
            long o1 = go(n, k - 1);
            long o2 = Math.max(Math.abs(arr1[n] - arr2[k]) + Math.abs(arr2[k] - p), go(n - 1, k - 1));
            return dp[n][k] = Math.min(o1, o2);
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            this.out = out;
            this.in = in;
            int n = ni();
            int k = ni();
            p = nl();
            dp = new long[n + 1][k + 1];
            int i = 0;
            arr1 = new long[n + 1];
            arr2 = new long[k + 1];
            for (i = 1; i <= n; i++)
                arr1[i] = ni();
            for (i = 1; i <= k; i++)
                arr2[i] = ni();
            Arrays.sort(arr1);
            Arrays.sort(arr2);
            for (i = 0; i <= n; i++)
                Arrays.fill(dp[i], -1);
            pn(go(n, k));
        }

        int ni() {
            return in.nextInt();
        }

        long nl() {
            return in.nextLong();
        }

        void pn(Object o) {
            out.println(o);
        }

    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1)
                throw new UnknownError();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new UnknownError();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public String next() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuffer res = new StringBuffer();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));

            return res.toString();
        }

        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

    }
}

