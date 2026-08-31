import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
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
            for (int i = 0; i < n; ++i) g[i] = new ArrayList<>();

            int[] from = new int[m];
            int[] to = new int[m];
            int[] deg = new int[n];
            for (int i = 0; i < m; ++i) {
                int u = in.nextInt() - 1;
                int v = in.nextInt() - 1;
                from[i] = u;
                to[i] = v;
                g[u].add(new int[]{v, i});
                g[v].add(new int[]{u, i});
                ++deg[u];
                ++deg[v];
            }

            int[] queue = new int[n];
            int sizeQ = 0;
            for (int i = 0; i < n; ++i) {
                if (deg[i] < K) {
                    queue[sizeQ++] = i;
                }
            }
            int ptr = 0;
            int[] ans = new int[m];
            boolean[] dead = new boolean[m];

            for (int step = m - 1; step >= 0; --step) {

                while (ptr < sizeQ) {
                    int cur = queue[ptr];
                    for (int[] v : g[cur]) {
                        int next = v[0];
                        int id = v[1];
                        if (dead[id]) continue;

                        dead[id] = true;
                        if (deg[next] == K) queue[sizeQ++] = next;
                        --deg[next];
                        --deg[cur];
                    }
                    ++ptr;
                }

                ans[step] = n - sizeQ;
                if (!dead[step]) {
                    if (deg[from[step]] == K) queue[sizeQ++] = from[step];
                    if (deg[to[step]] == K) queue[sizeQ++] = to[step];
                    --deg[from[step]];
                    --deg[to[step]];
                    dead[step] = true;
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
}

