//package year2019.month01.cf.eduround59;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.InputMismatchException;

public class Compression {

    boolean ONLINE_JUDGE = (System.getProperty("ONLINE_JUDGE") != null);

    public Compression() throws IOException {
        InputReader in;
        if (ONLINE_JUDGE) {
            in = new InputReader(System.in);
        } else {
            in = new InputReader(new FileInputStream("/Users/karj/Competitive Programming/input.txt"));
        }
        PrintWriter out = new PrintWriter(System.out);

        int T = 1;
        for (int caseNo = 1; caseNo <= T; caseNo++) {
            solve(caseNo, in, out);
        }

        out.close();
    }

    private void solve(int caseNo, InputReader in, PrintWriter out) throws IOException {
        int N = in.nextInteger();
        char S[][] = new char[N][N / 4];
        for (int i = 0; i < N; i++) {
            S[i] = in.nextString().toCharArray();
        }
        long rowGcd = -1, colGcd = -1;
        for (int c = 0; c < N / 4; c++) {
            for (int r = 0; r < N; r++) {
                int rep = 1;
                while (r < N - 1 && S[r][c] == S[r + 1][c]) {
                    rep++;
                    r++;
                }
                if (rowGcd == -1) {
                    rowGcd = rep;
                } else {
                    rowGcd = gcd(rowGcd, rep);
                }
            }
        }
        for (int r = 0; r < N; r++) {
            char rr[] = new char[N];
            int idx = 0;
            for (char c : S[r]) {
                String bs = Integer.toBinaryString(Integer.parseInt(c + "", 16));
                int bsl = bs.length();
                while (bsl < 4) {
                    bs = "0" + bs;
                    bsl++;
                }
                for (char bc : bs.toCharArray()) {
                    rr[idx++] = bc;
                }
            }
            debug(r, rr);
            for (int c = 0; c < N; c++) {
                int rep = 1;
                while (c < N - 1 && rr[c] == rr[c + 1]) {
                    rep++;
                    c++;
                }
                if (colGcd == -1) {
                    colGcd = rep;
                } else {
                    colGcd = gcd(colGcd, rep);
                }
            }
        }
        debug(rowGcd, colGcd);
        out.println(gcd(rowGcd, colGcd));
    }

    long gcd(long a, long b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }

    static class InputReader {

        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;

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

        public boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return isWhitespace(c);
        }

        public interface SpaceCharFilter {

            public boolean isSpaceChar(int ch);
        }

        public String next() {
            return nextString();
        }

        public String nextString() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public int nextInteger() {
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

        public Long nextLong() {
            return Long.parseLong(nextString());
        }

        public Double nextDouble() {
            return Double.parseDouble(nextString());
        }

        public char nextCharacter() {
            return nextString().charAt(0);
        }
    }

    private void debug(Object... o) {
        if (ONLINE_JUDGE) {
            return;
        }
        System.out.println(Arrays.deepToString(o));
    }

    public static void main(String args[]) throws IOException {
        new Compression();
    }
}
