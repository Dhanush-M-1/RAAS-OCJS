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
 * @author Pranay2516
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastReader in = new FastReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        CPairProgramming solver = new CPairProgramming();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class CPairProgramming {
        public void solve(int testNumber, FastReader in, PrintWriter out) {
            int k = in.nextInt(), n = in.nextInt(), m = in.nextInt();
            int[] a = in.readArray(n);
            int[] b = in.readArray(m);
            int p = 0;
            int[] ans = new int[n + m];
            //out.println(k+" "+n+" "+m);
            int i = 0, j = 0;
            while (i < n && j < m) {
                if (a[i] == 0) {
                    ans[p] = 0;
                    k++;
                    i++;
                } else if (b[j] == 0) {
                    ans[p] = 0;
                    k++;
                    j++;
                } else if (a[i] < b[j]) {
                    if (a[i] > k) {
                        out.println(-1);
                        return;
                    }
                    ans[p] = a[i];
                    i++;
                } else {
                    if (b[j] > k) {
                        out.println(-1);
                        return;
                    }
                    ans[p] = b[j];
                    j++;
                }
                p++;
            }
            while (i < n) {
                if (a[i] == 0) {
                    ans[p] = 0;
                    k++;
                } else {
                    if (a[i] > k) {
                        out.println(-1);
                        return;
                    }
                    ans[p] = a[i];
                }
                i++;
                p++;
            }
            while (j < m) {
                if (b[j] == 0) {
                    ans[p] = 0;
                    k++;
                } else {
                    if (b[j] > k) {
                        out.println(-1);
                        return;
                    }
                    ans[p] = b[j];
                }
                j++;
                p++;
            }
            for (int e : ans) {
                out.print(e + " ");
            }
            out.println();
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
            }
            while (!isSpaceChar(c));
            return res * sgn;
        }

        public String next() {
            int c = read();
            while (isSpaceChar(c)) c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null) return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public int[] readArray(int size) {
            int[] array = new int[size];
            for (int i = 0; i < size; i++) array[i] = nextInt();
            return array;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

        }

    }
}

