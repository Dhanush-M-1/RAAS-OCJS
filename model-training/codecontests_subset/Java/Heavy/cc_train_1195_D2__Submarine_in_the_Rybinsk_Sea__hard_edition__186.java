import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.Comparator;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Vaibhav Pulastya
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        D2SubmarineInTheRybinskSeaHardEdition solver = new D2SubmarineInTheRybinskSeaHardEdition();
        solver.solve(1, in, out);
        out.close();
    }

    static class D2SubmarineInTheRybinskSeaHardEdition {
        long MOD = 998244353;

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            String[] a = in.nextStringArray(n);
            Arrays.sort(a, new Comparator<String>() {

                public int compare(String o1, String o2) {
                    return o1.length() - o2.length();
                }
            });
            long[] lenC = new long[a[n - 1].length() + 1];
            long[][] digOc = new long[2 * a[n - 1].length()][10];
            for (int i = 0; i < n; i++) {

                for (int pt = a[i].length() - 1; pt >= 0; pt--) {

                    int ii = (a[i].length() - 1 - pt);

                    for (int len = 1; len <= a[i].length(); len++) {
                        // len -- length of the other num
                        if (ii + 1 <= len) {
                            digOc[2 * ii][a[i].charAt(pt) - '0'] += lenC[len];
                            digOc[2 * ii + 1][a[i].charAt(pt) - '0'] += lenC[len];
                        } else {
                            digOc[ii + len][a[i].charAt(pt) - '0'] += 2 * lenC[len];
                        }
                    }

                    digOc[2 * ii][a[i].charAt(pt) - '0'] += (n - i);
                    digOc[2 * ii + 1][a[i].charAt(pt) - '0'] += (n - i);

                }

                lenC[a[i].length()]++;

            }

            long pow = 1;
            long ans = 0;
            for (int i = 0; i < digOc.length; i++) {
                long ss = 0;
                for (int j = 1; j < 10; j++) {
                    ss += (long) j * digOc[i][j];
                    ss %= MOD;
                }
                ans += (ss * pow) % MOD;
                pow *= 10;
                pow %= MOD;
                ans %= MOD;
            }

            out.println(ans % MOD);
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
            } while (!isSpaceChar(c));
            return res * sgn;
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

        public String[] nextStringArray(int size) {
            String[] array = new String[size];
            for (int i = 0; i < size; i++)
                array[i] = next();
            return array;
        }

    }
}

