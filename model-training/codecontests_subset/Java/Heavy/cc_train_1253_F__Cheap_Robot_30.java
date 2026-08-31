import java.io.*;
import java.util.*;

import static java.lang.Math.*;
import static java.util.Arrays.*;

public class Solver {
    static int n;
    static ArrayList<pair> gr[];
    static int tr = 0;
    static int tin[], tout[], p[][], h[];
    static long mx[][];

    static void dfs(int v, int pr, long pw) {
        tin[v] = tr++;
        mx[v][0] = pw;
        h[v] = v == 0 ? 0 : (h[pr] + 1);
        if (v != 0) {
            p[v][0] = pr;
            for (int i = 1; i < 30; i++) {
                p[v][i] = p[p[v][i - 1]][i - 1];
                mx[v][i] = max(mx[v][i - 1], mx[p[v][i - 1]][i - 1]);
            }
        }
        for (pair to : gr[v]) {
            if (to.u == pr) continue;
            dfs(to.u, v, to.w);
        }
        tout[v] = tr++;
    }

    static long calc(int v, int u) {
        if (batya(v,u)) return 0;
        long max = 0;
        for (int i = 29; i >= 0; i--) {
            if (!batya(p[v][i], u)) {
                max = max(max, mx[v][i]);
                v = p[v][i];
            }
        }
        return max(max, mx[v][0]);
    }

    static boolean batya(int v, int u) {
        return tin[v] <= tin[u] && tout[v] >= tout[u];
    }

    public static void main(String[] args) throws IOException {
        FastScanner in = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        int q = in.nextInt();
        ArrayList<pair> g[] = new ArrayList[n];
        gr = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
            gr[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int v = in.nextInt() - 1;
            int u = in.nextInt() - 1;
            long w = in.nextLong();
            g[v].add(new pair(u, w));
            g[u].add(new pair(v, w));
        }
        long d[] = new long[n];
        for (int i = 0; i < n; i++) {
            d[i] = Long.MAX_VALUE / 4;
        }
        TreeSet<pair> verts = new TreeSet<>();
        for (int i = 0; i < k; i++) {
            d[i] = 0;
            verts.add(new pair(i, 0));
        }
        while (!verts.isEmpty()) {
            pair v = verts.pollFirst();
            for (pair u : g[v.u]) {
                if (d[u.u] > v.w + u.w) {
                    verts.remove(new pair(u.u, d[u.u]));
                    d[u.u] = v.w + u.w;
                    verts.add(new pair(u.u, d[u.u]));
                }
            }
        }
        edge e[] = new edge[400000];
        int ptr = 0;
        for (int i = 0; i < n; i++) {
            for (pair to : g[i]) {
                if(to.u > i)continue;
                e[ptr] = new edge(i, to.u, d[i] + d[to.u] + to.w);
                ptr++;
            }
        }
        for (int i = 0; i < 400000; i++) {
            if(e[i] == null)e[i] = new edge(0,0,Long.MAX_VALUE);
        }
        sort(e);
        dsu dsu = new dsu(n);
        for (int i = 0; i < m; i++) {
            if (!dsu.same(e[i].u, e[i].v)) {
                dsu.merge(e[i].u, e[i].v);
                gr[e[i].u].add(new pair(e[i].v, e[i].w));
                gr[e[i].v].add(new pair(e[i].u, e[i].w));
            }
        }
        p = new int[n][30];
        mx = new long[n][30];
        tin = new int[n];
        tout = new int[n];
        h = new int[n];

        dfs(0, 0, 0);
        while (q-- > 0) {
            int v = in.nextInt() - 1;
            int u = in.nextInt() - 1;
            out.println(max(calc(u,v),calc(v,u)));
        }
        out.close();
    }
}

class pair implements Comparable<pair> {
    int u;
    long w;

    public pair(int u, long w) {
        this.u = u;
        this.w = w;
    }

    @Override
    public int compareTo(pair o) {
        if (w != o.w) return Long.compare(w, o.w);
        return Integer.compare(u, o.u);
    }
}

class edge implements Comparable<edge> {
    int v, u;
    long w;

    public edge(int v, int u, long w) {
        this.v = v;
        this.u = u;
        this.w = w;
    }

    @Override
    public int compareTo(edge o) {
        return Long.compare(w, o.w);
    }
}

class dsu {
    int n;
    int p[];

    dsu(int n) {
        this.n = n;
        p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = i;
        }
    }

    int find(int a) {
        if (a == p[a]) return a;
        return p[a] = find(p[a]);
    }

    void merge(int a, int b) {
        p[find(a)] = find(b);
    }

    boolean same(int a, int b) {
        return find(a) == find(b);
    }
}

class FastScanner {
    BufferedReader br;
    StringTokenizer st;

    FastScanner(File f) throws FileNotFoundException {
        br = new BufferedReader(new FileReader(f));
    }

    FastScanner(InputStream is) {
        br = new BufferedReader(new InputStreamReader(is));
    }

    String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }

    int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    long nextLong() throws IOException {
        return Long.parseLong(next());
    }
}