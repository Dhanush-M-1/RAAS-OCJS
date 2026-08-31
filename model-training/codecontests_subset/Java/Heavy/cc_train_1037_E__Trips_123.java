import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.ArrayList;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Pradyumn
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastReader in = new FastReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskE solver = new TaskE();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskE {
        public void solve(int testNumber, FastReader in, PrintWriter out) {
            int n = in.nextInt();
            int m = in.nextInt();
            int K = in.nextInt();
            List<int[]>[] g = new List[n];
            int[] from = new int[m];
            int[] to = new int[m];
            for (int i = 0; i < n; ++i) g[i] = new ArrayList<>();
            for (int i = 0; i < m; ++i) {
                from[i] = in.nextInt() - 1;
                to[i] = in.nextInt() - 1;
                g[from[i]].add(new int[]{to[i], i});
                g[to[i]].add(new int[]{from[i], i});
            }
            boolean[] alive = new boolean[m];
            ArrayUtils.fill(alive, true);
            int[] deg = new int[n];
            int[] queue = new int[n];
            int sizeQ = 0;
            int ptr = 0;
            for (int i = 0; i < n; ++i) {
                deg[i] = g[i].size();
                if (deg[i] < K) {
                    queue[sizeQ++] = i;
                }
            }
            int[] ans = new int[m];
            for (int i = m - 1; i >= 0; --i) {
                while (ptr < sizeQ) {
                    int cur = queue[ptr++];
                    for (int[] edge : g[cur]) {
                        if (!alive[edge[1]]) continue;
                        alive[edge[1]] = false;
                        if (deg[edge[0]] == K) {
                            queue[sizeQ++] = edge[0];
                        }
                        --deg[edge[0]];
                        --deg[cur];
                    }
                }
                ans[i] = n - sizeQ;
                if (alive[i]) {
                    if (deg[from[i]] == K) queue[sizeQ++] = from[i];
                    if (deg[to[i]] == K) queue[sizeQ++] = to[i];
                    --deg[from[i]];
                    --deg[to[i]];
                    alive[i] = false;
                }
            }
            for (int aa : ans) out.println(aa);
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

        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

    }

    static class ArrayUtils {
        public static void fill(boolean[] array, boolean value) {
            Arrays.fill(array, value);
        }

    }
}

