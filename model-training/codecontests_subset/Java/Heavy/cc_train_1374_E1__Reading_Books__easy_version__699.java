
import java.io.*;
import java.util.*;

public class fastIO {

    static InputReader in;
    static PrintWriter w;

    public static void main(String[] args) {
        in = new InputReader(System.in);
        w = new PrintWriter(System.out);
        // for (int t = in.nextInt(); t > 0; t--) {

        // }
        long inf = (long) 1e11;
        int n = in.nextInt();
        int k = in.nextInt();
        ArrayList<Long>[][] al = new ArrayList[2][2];
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++)
                al[i][j] = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            long t = in.nextLong();
            int a = in.nextInt();
            int b = in.nextInt();
            al[a][b].add(t);
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int t = al[i][j].size(); t <= k; t++) {
                    al[i][j].add(inf);
                }
                Collections.sort(al[i][j]);
            }
        }
        long cur = 0;
        long ans = inf;
        for (int i = 0; i < k; i++) {
            cur += al[1][1].get(i);
        }
        ans = Math.min(ans, cur);
        for (int i = 0; i < k; i++) {
            cur -= al[1][1].get(k - i - 1);
            cur += al[0][1].get(i);
            cur += al[1][0].get(i);
            ans = Math.min(ans, cur);
        }
        if (ans >= inf) {
            w.println(-1);
        } else {
            w.println(ans);
        }
        w.close();
    }

    static class InputReader {

        private final InputStream stream;
        private final byte[] buf = new byte[8192];
        private int curChar, snumChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int snext() {
            if (snumChars == -1)
                throw new InputMismatchException();
            if (curChar >= snumChars) {
                curChar = 0;
                try {
                    snumChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (snumChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public int nextInt() {
            int c = snext();
            while (isSpaceChar(c)) {
                c = snext();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = snext();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public long nextLong() {
            int c = snext();
            while (isSpaceChar(c)) {
                c = snext();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = snext();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public int[] nextIntArray(int n) {
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = this.nextInt();
            }
            return a;
        }

        public long[] nextLongArray(int n) {
            long a[] = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = this.nextLong();
            }
            return a;
        }

        public String readString() {
            int c = snext();
            while (isSpaceChar(c)) {
                c = snext();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = snext();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public String nextLine() {
            int c = snext();
            while (isSpaceChar(c))
                c = snext();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = snext();
            } while (!isEndOfLine(c));
            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        private boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }
}