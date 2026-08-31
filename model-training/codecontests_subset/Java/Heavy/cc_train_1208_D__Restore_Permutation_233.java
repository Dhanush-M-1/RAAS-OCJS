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
 *
 * @author KharYusuf
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastReader in = new FastReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        DRestorePermutation solver = new DRestorePermutation();
        solver.solve(1, in, out);
        out.close();
    }

    static class DRestorePermutation {
        int n;
        long[] t;

        public void solve(int testNumber, FastReader s, PrintWriter w) {
            n = s.nextInt();
            long[] a = new long[n];
            t = new long[n + 2];
            int[] ans = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = s.nextLong();
                modify(i + 1, i + 1);
            }
            for (int i = n - 1; i >= 0; i--) {
                int ind = bins(0, n - 1, a[i]);
                //w.println(ind+" ok");
                //w.flush();
                ans[i] = ind + 1;
                modify(ind + 1, -ind - 1);
            }
            for (int i : ans) w.print(i + " ");
        }

        public int bins(int l, int r, long val) {
            int mid, ans = r;
            while (l <= r) {
                mid = l + r >> 1;
                long m = query(mid);
                if (m == val) {
                    l = mid + 1;
                    ans = mid;
                } else if (m > val) {
                    r = mid - 1;
                    ans = r;
                } else {
                    l = mid + 1;
                }
            }
            return ans;
        }

        public void modify(int ind, int val) {
            ind++;
            while (ind <= n) {
                t[ind] += val;
                ind += ind & (-ind);
            }
        }

        public long query(int ind) {
            ind++;
            long sum = 0;
            while (ind > 0) {
                sum += t[ind];
                ind -= ind & (-ind);
            }
            return sum;
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

