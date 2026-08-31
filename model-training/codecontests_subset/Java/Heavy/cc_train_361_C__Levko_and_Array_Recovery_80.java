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
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskA solver = new TaskA();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskA {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.readInt();
            int m = in.readInt();
            int[] a = new int[n];
            int[] l = new int[m], r = new int[m], d = new int[m];
            int[] t = new int[m];
            int[] diff = new int[n];
            Arrays.fill(a, (int) 1e9);

            for (int i = 0; i < m; i++) {
                t[i] = in.readInt();
                l[i] = in.readInt() - 1;
                r[i] = in.readInt() - 1;
                d[i] = in.readInt();
                if (t[i] == 1) {
                    for (int j = l[i]; j <= r[i]; j++) {
                        diff[j] += d[i];
                    }
                } else {
                    for (int j = l[i]; j <= r[i]; j++) {
                        a[j] = Math.min(a[j], d[i] - diff[j]);
                    }
                }
            }
            int[] ans = a.clone();

            for (int i = 0; i < m; i++) {
                if (t[i] == 1) {
                    for (int j = l[i]; j <= r[i]; j++) {
                        a[j] += d[i];
                    }
                } else {
                    int max = Integer.MIN_VALUE;
                    for (int j = l[i]; j <= r[i]; j++) {
                        max = Math.max(a[j], max);
                    }
                    if (max != d[i]) {
                        out.println("NO");
                        return;
                    }
                }
            }
            out.println("YES");
            for (int i : ans) out.print(i + " ");
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

        public int readInt() {
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

        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
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

