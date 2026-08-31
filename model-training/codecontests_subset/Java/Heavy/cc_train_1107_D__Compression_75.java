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
        TaskD solver = new TaskD();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskD {
        public void solve(int testNumber, FastReader in, PrintWriter out) {
            int n = in.nextInt();
            int[][] map = new int[n + 1000][n + 1000];
            for (int i = 0; i < n; ++i) {
                String cur = in.nextString();
                for (int j = 0; j < n / 4; ++j) {
                    char cc = cur.charAt(j);
                    int c;
                    if (cc >= 'A') {
                        c = cc - 'A' + 10;
                    } else {
                        c = cc - '0';
                    }
                    for (int k = 3; k >= 0; --k) {
                        map[i][j * 4 + k] = c % 2;
                        c /= 2;
                    }
                }
            }

            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (i - 1 >= 0) map[i][j] += map[i - 1][j];
                    if (j - 1 >= 0) map[i][j] += map[i][j - 1];
                    if (i - 1 >= 0 && j - 1 >= 0) map[i][j] -= map[i - 1][j - 1];
                }
            }

            for (int div = n; div >= 1; --div) {
                if (n % div != 0) continue;

                boolean ok = true;

                for (int i = 0; i < n / div; ++i) {
                    if (!ok) break;
                    for (int j = 0; j < n / div; ++j) {
                        int lx = i * div;
                        int ly = j * div;
                        int rx = (i + 1) * div - 1;
                        int ry = (j + 1) * div - 1;

                        int sum = map[rx][ry];
                        if (lx > 0 && ly > 0) sum += map[lx - 1][ly - 1];
                        if (lx > 0) sum -= map[lx - 1][ry];
                        if (ly > 0) sum -= map[rx][ly - 1];

                        if (sum == 0 || sum == div * div) {
                            continue;
                        } else {
                            ok = false;
                            break;
                        }
                    }
                }
                if (ok) {
                    out.println(div);
                    return;
                }
            }
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

        public String nextString() {
            int c = pread();
            while (isSpaceChar(c))
                c = pread();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = pread();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

    }
}

