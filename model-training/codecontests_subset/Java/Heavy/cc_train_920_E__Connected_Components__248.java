import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.LinkedList;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastScanner in = new FastScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        E solver = new E();
        solver.solve(1, in, out);
        out.close();
    }

    static class E {
        int n;
        List<GraphUtil.Edge>[] g;
        int[] size;
        int[] parent;
        int sets;

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int xRoot = find(x), yRoot = find(y);
            if (xRoot == yRoot)
                return;
            sets--;
            int newSize = size[xRoot] + size[yRoot];
            if (size[xRoot] < size[yRoot]) {
                parent[xRoot] = yRoot;
                size[yRoot] = newSize;
                size[xRoot] = 0;
            } else {
                parent[yRoot] = xRoot;
                size[xRoot] = newSize;
                size[yRoot] = 0;
            }
        }

        public void solve(int testNumber, FastScanner in, PrintWriter out) {

            n = in.ni();
            int m = in.ni();

            g = in.readEdgesGraph(n, m, true);
            sets = n;
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }

            int min = Integer.MAX_VALUE;
            int start = 0;
            for (int i = 0; i < n; i++) {
                if (g[i].size() < min) {
                    min = g[i].size();
                    start = i;
                }
            }
            boolean[] disj = new boolean[n];
            for (GraphUtil.Edge e : g[start]) {
                disj[e.to] = true;
            }
            for (int i = 0; i < n; i++) {
                if (i != start && !disj[i]) {
                    union(start, i);
                }
            }
            for (int i = 0; i < n; i++) {
                if (i != start && disj[i]) {
                    boolean[] curDisj = new boolean[n];
                    for (GraphUtil.Edge e : g[i]) {
                        curDisj[e.to] = true;
                    }
                    for (int j = 0; j < n; j++) {
                        if (j != i && !curDisj[j]) {
                            union(i, j);
                        }
                    }
                }
            }
            out.println(sets);
            Arrays.sort(size);
            for (int i = 0; i < n; i++) {
                if (size[i] != 0) {
                    out.print(size[i] + " ");
                }
            }

        }

    }

    static class FastScanner {
        private BufferedReader in;
        private StringTokenizer st;

        public FastScanner(InputStream stream) {
            in = new BufferedReader(new InputStreamReader(stream));
        }

        public String ns() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    String rl = in.readLine();
                    if (rl == null) {
                        return null;
                    }
                    st = new StringTokenizer(rl);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

        public int ni() {
            return Integer.parseInt(ns());
        }

        public List<GraphUtil.Edge>[] readEdgesGraph(int n, int m, boolean bidirected) {
            List<GraphUtil.Edge>[] g = new List[n];
            for (int i = 0; i < n; i++) {
                g[i] = new LinkedList<>();
            }
            for (int i = 0; i < m; i++) {
                int u = ni() - 1;
                int v = ni() - 1;
                g[u].add(new GraphUtil.Edge(u, v, i));
                if (bidirected)
                    g[v].add(new GraphUtil.Edge(v, u, i));
            }

            return g;
        }

    }

    static class GraphUtil {
        public static class Edge {
            public int from;
            public int to;
            public int id;
            public long w;

            public Edge(int from, int to) {
                this.from = from;
                this.to = to;
            }

            public Edge(int from, int to, int id) {
                this.from = from;
                this.to = to;
                this.id = id;
            }

            public Edge(int from, int to, int id, long w) {
                this.from = from;
                this.to = to;
                this.id = id;
                this.w = w;
            }

        }

    }
}

