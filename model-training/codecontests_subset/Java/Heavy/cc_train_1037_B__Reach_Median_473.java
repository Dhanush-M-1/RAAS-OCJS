import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
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
        FastInputReader in = new FastInputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskB solver = new TaskB();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskB {
        public void solve(int testNumber, FastInputReader in, PrintWriter out) {
            int n = in.nextInt(), s = in.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            if (n == 1) {
                out.println(Math.abs(a[0] - s));
                return;
            }
            Arrays.sort(a);

            int position = Arrays.binarySearch(a, s);
            if (position < 0) position = -position - 1;

            long ans = 0;
            boolean flag = true;
            if (position == n / 2 && a[n / 2] > s) flag = false;
            if (position >= n / 2 && flag) {
                for (int i = n / 2; i < position; i++) {
                    ans += s - a[i];
                }
            } else if (position <= n / 2) {
                for (int i = position; i <= n / 2; i++) {
                    ans += a[i] - s;
                }
            }
            out.println(ans);
        }

    }

    static class FastInputReader {
        final InputStream stream;
        final byte[] buf = new byte[8192];
        int curChar;
        int numChars;
        FastInputReader.SpaceCharFilter filter;

        public FastInputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1) throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) return -1;
            }
            return buf[curChar++];
        }

        public int nextInt() {
            int c = read();
            while (isSpaceChar(c)) c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public boolean isSpaceChar(int c) {
            if (filter != null) return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

        }

    }
}

