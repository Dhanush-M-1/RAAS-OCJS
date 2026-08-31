import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.Collections;
import java.util.ArrayList;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author KharYusuf
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastReader in = new FastReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        FDestroyIt solver = new FDestroyIt();
        solver.solve(1, in, out);
        out.close();
    }

    static class FDestroyIt {
        public void solve(int testNumber, FastReader s, PrintWriter w) {
            int n = s.nextInt(), k;
            long dp[][] = new long[n + 1][10], ans = 0;
            ArrayList<Long> a[] = new ArrayList[4];
            for (int i = 1; i < 4; i++) a[i] = new ArrayList<>();
            Arrays.fill(dp[0], -1);
            dp[0][0] = 0;
            for (int i = 1; i <= n; i++) {
                k = s.nextInt();
                for (int j = 1; j < 4; j++) a[j].clear();
                while (k-- > 0) {
                    a[s.nextInt()].add(s.nextLong());
                }
                Arrays.fill(dp[i], -1);
                for (int j = 1; j < 4; j++) Collections.sort(a[j], Collections.reverseOrder());
                for (int j = 0; j < 10; j++) {
                    if (dp[i - 1][j] == -1) continue;
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                    if (a[1].size() > 0) {
                        dp[i][(j + 1) % 10] = Math.max(dp[i][(j + 1) % 10], dp[i - 1][j] + (j == 9 ? a[1].get(0) << 1 : a[1].get(0)));
                    }
                    if (a[2].size() > 0) {
                        dp[i][(j + 1) % 10] = Math.max(dp[i][(j + 1) % 10], dp[i - 1][j] + (j == 9 ? a[2].get(0) << 1 : a[2].get(0)));
                    }
                    if (a[3].size() > 0) {
                        dp[i][(j + 1) % 10] = Math.max(dp[i][(j + 1) % 10], dp[i - 1][j] + (j == 9 ? a[3].get(0) << 1 : a[3].get(0)));
                    }
                    if (a[1].size() > 1) {
                        dp[i][(j + 2) % 10] = Math.max(dp[i][(j + 2) % 10], dp[i - 1][j] + a[1].get(0) + a[1].get(1) + (j >= 8 ? Math.max(a[1].get(0), a[1].get(1)) : 0));
                    }
                    if (a[1].size() > 2) {
                        dp[i][(j + 3) % 10] = Math.max(dp[i][(j + 3) % 10], dp[i - 1][j] + a[1].get(0) + a[1].get(1) + a[1].get(2) + (j >= 7 ? Math.max(a[1].get(0), Math.max(a[1].get(1), a[1].get(2))) : 0));
                    }
                    if (a[1].size() > 0 && a[2].size() > 0) {
                        dp[i][(j + 2) % 10] = Math.max(dp[i][(j + 2) % 10], dp[i - 1][j] + a[1].get(0) + a[2].get(0) + (j >= 8 ? Math.max(a[1].get(0), a[2].get(0)) : 0));
                    }
                }
            }
            for (int i = 0; i < 10; i++) ans = Math.max(ans, dp[n][i]);
            w.println(ans);
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

            if (numChars == -1)
                throw new InputMismatchException();

            if (curChar >= numChars) {

                curChar = 0;

                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }

                if (numChars <= 0)
                    return -1;
            }

            return buf[curChar++];
        }

        public int nextInt() {

            int c = read();

            while (isSpaceChar(c))
                c = read();

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
            }
            while (!isSpaceChar(c));

            return res * sgn;
        }

        public long nextLong() {

            int c = read();

            while (isSpaceChar(c))
                c = read();

            int sgn = 1;

            if (c == '-') {
                sgn = -1;
                c = read();
            }

            long res = 0;

            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();

                res *= 10;
                res += c - '0';
                c = read();
            }

            while (!isSpaceChar(c));
            return res * sgn;
        }

        public boolean isSpaceChar(int c) {

            if (filter != null)
                return filter.isSpaceChar(c);

            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

        }

    }
}

