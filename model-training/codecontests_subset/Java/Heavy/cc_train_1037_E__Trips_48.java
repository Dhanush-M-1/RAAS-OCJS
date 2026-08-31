import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskE solver = new TaskE();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskE {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int m = in.nextInt();
            int k = in.nextInt();
            int[] deg = new int[n];
            List<Integer>[] g = new List[n];
            for (int i = 0; i < n; i++) {
                g[i] = new ArrayList<>();
            }
            int[] x = new int[m];
            int[] y = new int[m];
            for (int i = 0; i < m; i++) {
                x[i] = in.nextInt() - 1;
                y[i] = in.nextInt() - 1;
                g[x[i]].add(y[i]);
                g[y[i]].add(x[i]);
                ++deg[x[i]];
                ++deg[y[i]];
            }
            int[] q = new int[n];
            int qh = 0;
            int qt = 0;
            boolean[] vis = new boolean[n];
            int cnt = n;
            for (int i = 0; i < n; i++) {
                if (deg[i] < k) {
                    --cnt;
                    q[qt++] = i;
                    vis[i] = true;
                }
            }

            int[] res = new int[m];
            Set<Long> edges = new HashSet<>();

            for (int i = m - 1; i >= 0; i--) {
                while (qh < qt) {
                    int u = q[qh++];
                    for (int v : g[u]) {
                        if (vis[v]) continue;
                        long edge = ((long) Math.min(u, v) << 32) + Math.max(u, v);
                        if (edges.contains(edge)) continue;
                        --deg[v];
                        if (deg[v] < k) {
                            --cnt;
                            q[qt++] = v;
                            vis[v] = true;
                        }
                    }
                }
                res[i] = cnt;
                long edge = ((long) Math.min(x[i], y[i]) << 32) + Math.max(x[i], y[i]);
                edges.add(edge);
                if (!vis[x[i]] && !vis[y[i]]) {
                    --deg[x[i]];
                    if (deg[x[i]] < k) {
                        q[qt++] = x[i];
                        vis[x[i]] = true;
                        --cnt;
                    }
                    --deg[y[i]];
                    if (deg[y[i]] < k) {
                        q[qt++] = y[i];
                        vis[y[i]] = true;
                        --cnt;
                    }
                }
            }

            for (int v : res) {
                out.println(v);
            }
        }

    }

    static class InputReader {
        final InputStream is;
        final byte[] buf = new byte[1024];
        int pos;
        int size;

        public InputReader(InputStream is) {
            this.is = is;
        }

        public int nextInt() {
            int c = read();
            while (isWhitespace(c))
                c = read();
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res = res * 10 + c - '0';
                c = read();
            } while (!isWhitespace(c));
            return res * sign;
        }

        int read() {
            if (size == -1)
                throw new InputMismatchException();
            if (pos >= size) {
                pos = 0;
                try {
                    size = is.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (size <= 0)
                    return -1;
            }
            return buf[pos++] & 255;
        }

        static boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

    }
}

