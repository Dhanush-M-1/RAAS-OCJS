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
        D2PodvodnayaLodkaVRibinskomMoreUslozhnennayaRedakciya solver =
          new D2PodvodnayaLodkaVRibinskomMoreUslozhnennayaRedakciya();
        solver.solve(1, in, out);
        out.close();
    }

    static class D2PodvodnayaLodkaVRibinskomMoreUslozhnennayaRedakciya {
        int[] pow10;
        int mod = 998244353;

        public void solve(int testNumber, InputReader in, OutputWriter out) {
            init();
            int n = in.readInt();
            int[] a = in.readIntArray(n);
            int[] countByLen = new int[20];
            for (int i = 0; i < n; i++) {
                countByLen[len(a[i])]++;
            }
            int[] countSuffix = new int[20];
            countSuffix[19] = countByLen[19];
            for (int i = countSuffix.length - 2; i >= 0; i--) {
                countSuffix[i] = countSuffix[i + 1] + countByLen[i];
            }
            int ans = 0;
            for (int x : a) {
                int lenX = len(x);

                for (int curLen = 1; curLen <= lenX; curLen++, x /= 10) {
                    int d = x % 10;

                    ans = add(ans, mul(countSuffix[curLen], mul(d, pow10[(curLen - 1) * 2])));
                    for (int j = 1; j < curLen; j++) {
                        int at = curLen + j - 1;
                        ans = add(ans, mul(2, mul(countByLen[j], mul(d, pow10[at]))));
                    }

                    ans = add(ans, mul(countSuffix[curLen], mul(d, pow10[curLen * 2 - 1])));
                }
            }
            out.print(ans);
        }

        int len(int x) {
            int len = 0;
            while (x > 0) {
                len++;
                x /= 10;
            }
            return len;
        }

        void init() {
            pow10 = new int[100];
            pow10[0] = 1;
            for (int i = 1; i < pow10.length; i++) {
                pow10[i] = mul(pow10[i - 1], 10);
            }
        }

        int add(int a, int b) {
            a += b;
            if (a >= mod) {
                a -= mod;
            }
            return a;
        }

        int mul(int a, int b) {
            long c = a * (long) b;
            return (int) (c % mod);
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

        public int[] readIntArray(int size) {
            int[] array = new int[size];
            for (int i = 0; i < size; i++) {
                array[i] = readInt();
            }
            return array;
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

        public void print(int i) {
            writer.print(i);
        }

    }
}

