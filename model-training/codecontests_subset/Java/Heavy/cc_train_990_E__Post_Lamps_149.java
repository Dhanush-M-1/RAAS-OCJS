import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

/*

3
1 3
3 8
0 3
6 1 10
010001
8
4 6
00111011

7
1 3

*/
public class CodeForces {
    public static void main(String[] args) {
        InputReader fi=new InputReader(System.in);
        int n, m, k, i, j;
        n = fi.nextInt();
        m = fi.nextInt();
        k = fi.nextInt();
        long ans = Long.MAX_VALUE;
        boolean blocked[] = new boolean[n + 1];
        for (i = 0; i < m; i++) {
            blocked[fi.nextInt()] = true;
        }
        int[] prices = new int[k];
        for (i = 0; i < k; i++) {
            prices[i] = fi.nextInt();
        }
        int last[] = new int[n + 1];
        if (blocked[0]) {
            last[0] = -1;
        } else last[0] = 0;
        for (i = 1; i <= n; i++) {
            if (blocked[i]) {
                last[i] = last[i - 1];
            } else last[i] = i;
        }
        for (i = 1; i <= k; i++) {
            long temp = 0;
            int next, current;
            next = current = 0;
            while (next < n) {
                current = last[next];
                if (current < 0 || (current + i) < next + 1) {
                    temp = Long.MAX_VALUE;
                    break;
                }
                next = current + i;
                temp += prices[i - 1];
            }
            ans = Math.min(ans, temp);
        }
        if (ans == Long.MAX_VALUE) ans = -1;
        System.out.println(ans);

    }
    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[8192];
        private int curChar;
        private int snumChars;
        private InputReader.SpaceCharFilter filter;

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
            while (isSpaceChar(c))
                c = snext();
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


