import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
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
        FastReader in = new FastReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        EAlmostEverywhereZero solver = new EAlmostEverywhereZero();
        solver.solve(1, in, out);
        out.close();
    }

    static class EAlmostEverywhereZero {
        public void solve(int testNumber, FastReader s, PrintWriter out) {
            String str = s.nextString();
            int k = s.nextInt();
            long len = str.length();
            long ans;
            if (k == 1) {
                ans = solve1(len, str);
            } else if (k == 2) {
                ans = solve2(len, str);
            } else {
                ans = solve3(len, str);
            }
            out.println(ans);
        }

        public long solve1(long len, String s) {
            while (true) {
                if (s.length() == 0) {
                    return 0;
                }
                if (s.charAt(0) != '0') {
                    break;
                } else {
                    s = s.substring(1);
                }
            }
            len = s.length();
            int first = Integer.parseInt(s.substring(0, 1));
            long ans = 0;
            ans += (len - 1) * 9;
            ans += first;
            // System.out.println(ans);
            return ans;
        }

        public long solve2(long len, String s) {
            while (true) {
                if (s.length() <= 1) {
                    return 0;
                }
                if (s.charAt(0) != '0') {
                    break;
                } else {
                    s = s.substring(1);
                }
            }
            len = s.length();
            int first = Integer.parseInt(s.substring(0, 1));
            long ans = 0;
            ans += (len - 1) * (len - 2) / 2 * 9 * 9;
            ans += (first - 1) * (len - 1) * 9;
            ans += solve1(len, s.substring(1));
            // System.out.println(ans);
            return ans;
        }

        public long solve3(long len, String s) {
            // System.out.println(s);
            while (true) {
                if (s.length() < 3) {
                    return 0;
                }
                if (s.charAt(0) != '0') {
                    break;
                } else {
                    s = s.substring(1);
                }
            }
            long ans = 0;
            int first = Integer.parseInt(s.substring(0, 1));
            ans += (len - 1) * (len - 2) * (len - 3) / 2 * 3 * 9 * 9;
            ans += (first - 1) * (len - 1) * (len - 2) / 2 * 9 * 9;
            ans += solve2(len, s.substring(1));
            return ans;

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

        public String nextString() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                if (Character.isValidCodePoint(c)) {
                    res.appendCodePoint(c);
                }
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
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

