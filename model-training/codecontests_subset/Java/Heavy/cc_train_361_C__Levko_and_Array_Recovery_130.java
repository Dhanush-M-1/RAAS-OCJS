import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.OutputStream;
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
        FastReader in = new FastReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskC solver = new TaskC();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskC {
        public static final long oo = (long) 4e8;

        public void solve(int testNumber, FastReader in, PrintWriter out) {
            Debug debug = new Debug();
            int n = in.nextInt();
            int m = in.nextInt();
            long[] a = new long[n];
            ArrayUtils.fill(a, oo);
            int[][] queries = new int[m][];
            for (int q = 0; q < m; ++q) {
                queries[q] = in.nextIntArray(4);
            }

            //build array
            for (int q = m - 1; q >= 0; --q) {
                int[] cur = queries[q];
                if (cur[0] == 1) {
                    int L = cur[1] - 1;
                    int R = cur[2] - 1;
                    int d = cur[3];
                    for (int i = L; i <= R; ++i) a[i] -= d;
                } else {
                    int L = cur[1] - 1;
                    int R = cur[2] - 1;
                    int max = cur[3];
                    for (int i = L; i <= R; ++i) {
                        a[i] = Math.min(a[i], max);
                    }
                }
            }

            //check all <= 10^9
            for (int i = 0; i < n; ++i) {
                if (Math.abs(a[i]) > 1e9) {
                    out.println("NO");
                    return;
                }
            }
            long[] b = a.clone();
            //rebuild queries to check validity
            for (int q = 0; q < m; ++q) {
                int[] cur = queries[q];
                if (cur[0] == 1) {
                    int L = cur[1] - 1;
                    int R = cur[2] - 1;
                    int d = cur[3];
                    for (int i = L; i <= R; ++i) a[i] += d;
                } else {
                    int L = cur[1] - 1;
                    int R = cur[2] - 1;
                    int max = cur[3];
                    long mm = a[L];
                    for (int i = L; i <= R; ++i) {
                        mm = Math.max(a[i], mm);
                    }
                    if (mm != max) {
                        out.println("NO");
                        return;
                    }
                }
            }
            out.println("YES");
            ArrayUtils.printArray(out, b);
        }

    }

    static class Debug {
        PrintWriter out;
        boolean oj;
        boolean system;
        long timeBegin;
        Runtime runtime;

        public Debug(PrintWriter out) {
            oj = System.getProperty("ONLINE_JUDGE") != null;
            this.out = out;
            this.timeBegin = System.currentTimeMillis();
            this.runtime = Runtime.getRuntime();
        }

        public Debug() {
            system = true;
            oj = System.getProperty("ONLINE_JUDGE") != null;
            OutputStream outputStream = System.out;
            this.out = new PrintWriter(outputStream);
            this.timeBegin = System.currentTimeMillis();
            this.runtime = Runtime.getRuntime();
        }

    }

    static class FastReader {
        private InputStream stream;
        private byte[] buf = new byte[8192];
        private int curChar;
        private int pnumChars;

        public FastReader(InputStream stream) {
            this.stream = stream;
        }

        private int pread() {
            if (pnumChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= pnumChars) {
                curChar = 0;
                try {
                    pnumChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (pnumChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public int nextInt() {
            int c = pread();
            while (isSpaceChar(c))
                c = pread();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = pread();
            }
            int res = 0;
            do {
                if (c == ',') {
                    c = pread();
                }
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = pread();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public int[] nextIntArray(int n) {
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = nextInt();
            }
            return array;
        }

        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

    }

    static class ArrayUtils {
        public static void fill(long[] array, long value) {
            Arrays.fill(array, value);
        }

        public static void printArray(PrintWriter out, long[] array) {
            if (array.length == 0) return;
            for (int i = 0; i < array.length; i++) {
                if (i != 0) out.print(" ");
                out.print(array[i]);
            }
            out.println();
        }

    }
}

