import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.ArrayList;
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
        DMinimumEulerCycle solver = new DMinimumEulerCycle();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class DMinimumEulerCycle {
        public void solve(int testNumber, FastReader s, PrintWriter w) {
            int n = s.nextInt();
            long l = s.nextLong(), r = s.nextLong();
            ArrayList<Integer> sizes = new ArrayList<>();
            int cur = n - 1 << 1;
            for (int i = n - 1; i > 0; i--) {
                sizes.add(cur);
                cur -= 2;
            }
            sizes.add(1);
            cur = 0;
            while (l > sizes.get(cur)) {
                l -= sizes.get(cur);
                r -= sizes.get(cur++);
            }
            long dif = r - l + 1;
            int[] ans = new int[4 * n];
            if (cur == sizes.size() - 1) {
                w.println(1);
                return;
            } else {
                int cnt = cur + 1;
                for (int i = 0; i < sizes.get(cur); i += 2) ans[i] = cnt;
                cnt++;
                for (int i = 1; i < sizes.get(cur); i += 2) ans[i] = cnt++;
            }
            for (int i = (int) l - 1; i < sizes.get(cur) && dif > 0; i++) {
                w.print(ans[i] + " ");
                dif--;
            }
            cur++;
            while (dif > 0) {
                if (cur == sizes.size() - 1) {
                    w.println(1);
                    return;
                } else {
                    int cnt = cur + 1;
                    for (int i = 0; i < sizes.get(cur); i += 2) ans[i] = cnt;
                    cnt++;
                    for (int i = 1; i < sizes.get(cur); i += 2) ans[i] = cnt++;
                }
                for (int i = 0; i < sizes.get(cur) && dif > 0; i++) {
                    w.print(ans[i] + " ");
                    dif--;
                }
                cur++;
            }
            w.println();
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

        public String next() {

            int c = read();

            while (isSpaceChar(c))
                c = read();

            StringBuilder res = new StringBuilder();

            do {
                res.appendCodePoint(c);
                c = read();
            }
            while (!isSpaceChar(c));

            return res.toString();
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

