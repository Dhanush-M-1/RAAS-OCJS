import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
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
            int n = in.nextInt(), m = in.nextInt(), q = in.nextInt();
            Vertex[] g = new Vertex[n];
            for (int i = 0; i < n; ++i) {
                g[i] = new Vertex(i);
            }
            UnionFind uf = new UnionFind(n);
            for (int i = 0; i < m; ++i) {
                int u = in.nextInt() - 1, v = in.nextInt() - 1;
                g[u].adj.add(g[v]);
                g[v].adj.add(g[u]);
                uf.join(u, v);
            }
            for (int i = 0; i < n; ++i) {
                if (!g[i].vis[0]) {
                    int[] dfs1 = g[i].dfs(null, 0, 0);
                    int[] dfs2 = g[dfs1[1]].dfs(null, 0, 1);
                    int[] dfs3 = g[dfs2[1]].dfs(null, 0, 2);
                    int diameter = Math.max(dfs1[0], Math.max(dfs2[0], dfs3[0]));
                    uf.diam[uf.rep(i)] = diameter;
                }
            }
            while (q-- > 0) {
                int queryType = in.nextInt();
                if (queryType == 1) {
                    int x = in.nextInt() - 1;
                    out.println(uf.diam[uf.rep(x)]);
                } else {
                    int u = in.nextInt() - 1, v = in.nextInt() - 1;
                    int repu = uf.rep(u), repv = uf.rep(v);
                    if (repu == repv) {
                        continue;
                    }
                    int diamu = uf.diam[repu], diamv = uf.diam[repv];
                    int ans = Math.max(diamu, diamv);
                    ans = Math.max(ans, (diamu + 1) / 2 + (diamv + 1) / 2 + 1);
                    uf.join(u, v);
                    uf.diam[uf.rep(u)] = ans;
                }
            }
        }

        class UnionFind {
            int[] rep;
            int[] diam;

            public UnionFind(int n) {
                rep = new int[n];
                diam = new int[n];
                for (int i = 0; i < n; ++i) {
                    rep[i] = i;
                }
            }

            int rep(int u) {
                if (rep[u] == u) return u;
                return rep[u] = rep(rep[u]);
            }

            void join(int u, int v) {
                if (u > v) {
                    join(v, u);
                } else {
                    diam[rep(u)] += diam[rep(v)];
                    rep[rep(u)] = rep[rep(v)];
                }
            }

        }

        class Vertex {
            boolean[] vis = new boolean[3];
            int index;
            ArrayList<Vertex> adj = new ArrayList<>();

            int[] dfs(Vertex par, int level, int round) {
                int[] ret = {level, index};
                vis[round] = true;
                for (Vertex u : adj) {
                    if (u != par) {
                        int[] rec = u.dfs(this, level + 1, round);
                        if (rec[0] > ret[0]) {
                            ret = rec;
                        }
                    }
                }
                return ret;
            }

            public Vertex(int index) {
                this.index = index;
            }

        }

    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 65536);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

