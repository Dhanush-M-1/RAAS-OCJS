import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;


public class CF455C {

    public static void main(String[] args) throws Exception {
        new CF455C().solve();
    }

    // http://www.prefield.com/algorithm/container/union_find.html
    public static class DisjointSet {
        final int[] data;

        public DisjointSet(int size) {
            data = new int[size];
            for (int i = 0; i < size; i++) {
                data[i] = -1;
            }
        }

        boolean unite(int x, int y) {
            x = root(x);
            y = root(y);
            if (x != y) {
                if (data[y] < data[x]) {
                    int temp = x;
                    x = y;
                    y = temp;
                }
                data[x] += data[y];
                data[y] = x;
            }
            return x != y;
        }

        boolean same(int x, int y) {
            return root(x) == root(y);
        }

        int root(int x) {
            return data[x] < 0 ? x : (data[x] = root(data[x]));
        }

        int size(int x) {
            return -data[root(x)];
        }
    };

    static class InputReader extends BufferedReader {
        StringTokenizer st = new StringTokenizer("");

        public InputReader() {
            super(new InputStreamReader(System.in));
        }

        public InputReader(String s) {
            super(new StringReader(s));
        }

        String next() {
            try {
                while (!st.hasMoreTokens())
                    st = new StringTokenizer(readLine());
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        int[] nextInts(int n) {
            int[] ret = new int[n];
            for (int i = 0; i < n; i++) {
                ret[i] = nextInt();
            }
            return ret;
        }
    }

    int n;
    ArrayList<Integer>[] edges;
    DisjointSet uf;

    private void solve() throws Exception {
        InputReader sc = new InputReader();
        n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();

        edges = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            edges[i] = new ArrayList<Integer>(2);
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            edges[a].add(b);
            edges[b].add(a);
        }
        uf = new DisjointSet(n);
        int[] diameters = new int[n];
        for (int i = 0; i < n; i++) {
            if (uf.size(i) == 1) {
                int d = diameter(i);
                diameters[uf.root(i)] = d;
                // System.out.println(i + ":" +d);
            }
        }

        StringBuilder sb = new StringBuilder(q * 2);
        for (int i = 0; i < q; i++) {
            int cmd = sc.nextInt();
            if (cmd == 1) {
                int x = sc.nextInt() - 1;
                sb.append(diameters[uf.root(x)]).append("\n");
            }
            else {
                int x = sc.nextInt() - 1;
                int y = sc.nextInt() - 1;
                if (!uf.same(x, y)) {
                    int xr = uf.root(x);
                    int yr = uf.root(y);
                    int d1 = diameters[xr];
                    int d2 = diameters[yr];
                    int d3 = (d1 + 1) / 2 + (d2 + 1) / 2 + 1;
                    uf.unite(xr, yr);
                    diameters[uf.root(x)] = Math.max(d1, Math.max(d2, d3));
                }
            }
        }
        System.out.print(sb);
    }

    static class VisResult {
        int v;
        int dist;
    }

    // http://www.prefield.com/algorithm/graph/tree_diameter.html
    private int diameter(int v) {
        VisResult vr1 = visit(v, -1);
        VisResult vr2 = visit(vr1.v, -1);
        return vr2.dist;
    }

    private VisResult visit(int v, int p) {
        VisResult res = new VisResult();
        res.v = v;
        for (int u : edges[v]) {
            if (u != p) {
                uf.unite(v, u);
                VisResult vr = visit(u, v);
                vr.dist++;
                if (res.dist < vr.dist) res = vr;
            }
        }
        return res;
    }

}
