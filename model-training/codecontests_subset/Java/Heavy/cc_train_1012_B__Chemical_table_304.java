import java.io.*;
import java.util.*;

public class Main {
    private static class Solver {
        static class DSU {
            int[] p;
            int n;
            DSU(int n) {
                this.n = n;
                p = new int[n + 1];
                for (int i = 1; i <= n; ++i) {
                    p[i] = -1;
                }
            }
            int Root(int u) {
                if (p[u] < 0) {
                    return u;
                }
                p[u] = Root(p[u]);
                return p[u];
            }
            void Merge(int u, int v) {
                u = Root(u);
                v = Root(v);
                if (u == v) {
                    return;
                }
                if (p[u] > p[v]) {
                    int tmp = u;
                    u = v;
                    v = tmp;
                }
                p[u] += p[v];
                p[v] = u;
            }
        }
        private void Solve() {
            int n = inp.nextInt();
            int m = inp.nextInt();
            int q = inp.nextInt();
            if (n == 1 || m == 1) {
                out.println(n * m - q);
                return;
            }

            List<Integer>[] zx = new ArrayList[n + 1];
            List<Integer>[] zy = new ArrayList[m + 1];
            for (int i = 1; i <= n; ++i) {
                zx[i] = new ArrayList<>();
            }
            for (int i = 1; i <= m; ++i) {
                zy[i] = new ArrayList<>();
            }
            for (int i = 1; i <= q; ++i) {
                int x = inp.nextInt();
                int y = inp.nextInt();
                zx[x].add(y);
                zy[y].add(x);
            }

            DSU dsu = new DSU(m);
            for (int x = 1; x <= n; ++x) {
                int f = -1;
                for (int y: zx[x]) {
                    f = y;
                    break;
                }
                if (f == -1) {
                    continue;
                }
                for (int y: zx[x]) {
                    dsu.Merge(y, f);
                }
            }

            int ans = 0;
            for (int i = 1; i <= m; ++i) {
                if (dsu.Root(i) == i) {
                    ans += 1;
                }
            }
            for (int i = 1; i <= n; ++i) {
                if (zx[i].size() == 0) {
                    ans += 1;
                }
            }
            out.println(ans - 1);
        }
        static InputReader inp;
        static PrintWriter out;
    }

    private static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        private InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        private String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        private int nextInt() {
            return Integer.parseInt(next());
        }
        private long nextLong() {
            return Long.parseLong(next());
        }
        private int[] nextIntArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; ++i) {
                a[i] = nextInt();
            }
            return a;
        }
    }
    public static void main(String[] args) throws IOException {
        if (!"true".equals(System.getProperty("ONLINE_JUDGE"))) {
            System.setIn(new FileInputStream(new File("input.txt")));
        }
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Solver.inp = new InputReader(inputStream);
        Solver.out = new PrintWriter(outputStream);
        Solver solver = new Solver();
        solver.Solve();
        Solver.out.close();
    }
}