import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author prakharjain
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        _949C solver = new _949C();
        solver.solve(1, in, out);
        out.close();
    }

    static class _949C {
        KosarajuScc scc;
        int maxc = -1;
        int maxcs = -1;

        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int n = in.nextInt();
            int m = in.nextInt();
            int h = in.nextInt();

            int[] u = new int[n];
            for (int i = 0; i < n; i++) {
                u[i] = in.nextInt();
            }

            List[] g = new List[n];
            List[] ug = new List[n];

            for (int i = 0; i < n; i++) {
                g[i] = new ArrayList();
                ug[i] = new ArrayList();
            }

            for (int i = 0; i < m; i++) {
                int c1 = in.nextInt() - 1;
                int c2 = in.nextInt() - 1;

                int c1n = (u[c1] + 1) % h;
                int c2n = (u[c2] + 1) % h;

                if (c1n == u[c2]) {
                    g[c1].add(c2);
                    ug[c2].add(c1);
                    ug[c1].add(c2);
                }
                if (c2n == u[c1]) {
                    g[c2].add(c1);
                    ug[c2].add(c1);
                    ug[c1].add(c2);
                }
            }

            scc = new KosarajuScc(n, g);
            scc.generateSccOrder();
            scc.reverseEdge();
            scc.scc();

            int ans = n + 1;
            int ansc = -1;
            boolean[] vis = new boolean[n];
            for (int i = 0; i < n; i++) {
                if (!vis[i]) {
                    maxc = -1;
                    maxcs = -1;
                    dfs(i, vis, ug);
                    if (ans > maxcs) {
                        ans = maxcs;
                        ansc = maxc;
                    }
                }
            }

            out.println(ans);

            for (int i = 0; i < n; i++) {
                if (scc.comp[i] == ansc) {
                    out.print((i + 1) + " ");
                }
            }

        }

        void dfs(int u, boolean[] vis, List[] g) {
            if (scc.comp[u] == maxc) {
                maxcs++;
            }

            if (scc.comp[u] > maxc) {
                maxc = scc.comp[u];
                maxcs = 1;
            }

            vis[u] = true;

            for (int i = 0; i < g[u].size(); i++) {
                int v = (int) g[u].get(i);
                if (!vis[v])
                    dfs(v, vis, g);
            }
        }

        class KosarajuScc {
            int n;
            List[] g;
            ArrayDeque<Integer> sccOrder = new ArrayDeque<>();
            int[] comp;
            List[] rg;

            public KosarajuScc(int n, List[] g) {
                this.n = n;
                this.g = g;
                this.comp = new int[n];
                this.rg = new List[n];
            }

            void generateSccOrder() {
                boolean[] vis = new boolean[2 * n];
                for (int i = 0; i < n; i++) {
                    if (!vis[i])
                        dfs0(i, vis);
                }
            }

            void dfs0(int u, boolean[] vis) {
                vis[u] = true;
                for (Integer v : (List<Integer>) g[u]) {
                    if (!vis[v]) {
                        dfs0(v, vis);
                    }
                }

                sccOrder.addFirst(u);
            }

            void reverseEdge() {
                for (int i = 0; i < n; i++) {
                    rg[i] = new ArrayList<>();
                }

                for (int i = 0; i < n; i++) {
                    for (Integer v : (List<Integer>) g[i]) {
                        rg[v].add(i);
                    }
                }
            }

            void scc() {
                boolean[] vis = new boolean[n];
                int cn = 0;
                for (Integer v : sccOrder) {

                    if (!vis[v]) {
                        dfs1(v, rg, cn, vis);
                        cn++;
                    }
                }
            }

            void dfs1(int u, List[] g, int cn, boolean[] vis) {
                comp[u] = cn;
                vis[u] = true;

                for (int j = 0; j < g[u].size(); j++) {
                    int v = (int) g[u].get(j);

                    if (!vis[v]) {
                        dfs1(v, g, cn, vis);
                    }
                }
            }

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

        public static boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public int nextInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return isWhitespace(c);
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

        }

    }

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0) {
                    writer.print(' ');
                }
                writer.print(objects[i]);
            }
        }

        public void close() {
            writer.close();
        }

        public void println(int i) {
            writer.println(i);
        }

    }
}

