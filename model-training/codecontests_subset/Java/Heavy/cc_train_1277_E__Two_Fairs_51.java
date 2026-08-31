
import java.io.*;
import java.util.*;

public class E {
    ArrayList<Integer>[] g;
    int[] tin;
    int[] up;
    boolean[] used;
    int time;
    Set<Integer> cutpoints;

    void dfs(int v, int p) {
        time++;
        up[v] = tin[v] = time;
        used[v] = true;
        int count = 0;
        for (int u : g[v]) {
            if (u == p) {
                continue;
            }
            if (used[u]) {
                up[v] = Math.min(up[v], tin[u]);
            } else {
                dfs(u, v);
                count++;
                up[v] = Math.min(up[u], up[v]);
                if (p != -1 && up[v] >= tin[v]) {
                    cutpoints.add(v);
                }
            }
        }
        if (p == -1 && count >= 2) {
            cutpoints.add(v);
        }
    }

    boolean[] between;

    void dfsP(int v, int a, int b) {
        used[v] = true;
        if (v == b) {
            return;
        }
        for (int u : g[v]) {
            if (used[u] && u != a) {
                between[v] |= between[u];
            } else {
                dfsP(u, a, b);
                if (v != a) {
                    between[v] |= between[u];
                }
            }
        }
    }

    void dfsa(int v, int b) {
        if (v == b) {
            return;
        }
        used[v] = true;
        for (int u : g[v]) {
            if (!used[u]) {
                dfsa(u, b);
            }
        }
    }

    void dfsb(int v, int a) {
        if (v == a) {
            return;
        }
        used[v] = true;
        for (int u : g[v]) {
            if (!used[u]) {
                dfsa(u, a);
            }
        }
    }

    public void solve() throws IOException {
        int q = nextInt();
        while (q-- > 0) {
            int n = nextInt(), m = nextInt(), a = nextInt() - 1, b = nextInt() - 1;
            g = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                g[i] = new ArrayList<>();
            }
            for (int i = 0; i < m; i++) {
                int u = nextInt() - 1;
                int v = nextInt() - 1;
                g[u].add(v);
                g[v].add(u);
            }
//            between = new boolean[n];
//            cutpoints = new HashSet<>();
//            tin = new int[n];
//            up = new int[n];
//            used = new boolean[n];
//            used[a] = true;
//            int[] d = new int[n];
//            Deque<Integer> bfs = new LinkedList<>();
//            bfs.addLast(a);
//            int[] p = new int[n];
//            p[a] = -1;
//            while (!bfs.isEmpty()) {
//                int v = bfs.pollFirst();
//                for (int u : g[v]) {
//                    if (!used[u]) {
//                        d[u] = d[v] + 1;
//                        p[u] = v;
//                        used[u] = true;
//                        bfs.addLast(u);
//                    }
//                }
//            }
//            Set<Integer> shortest = new HashSet<>();
//            int x = b;
//            while (p[x] != a) {
//                x = p[x];
//                shortest.add(x);
//            }
//            used = new boolean[n];
//            time = 0;
//            out.print(shortest.size());
//            dfs(0, -1);
//            used = new boolean[n];
//            between[b] = true;
//            dfsP(a, a, b);
//            between[a] = true;
            used = new boolean[n];
            used[a] = true;
            dfsa(a, b);
            used[b] = true;
            long c1 = 0;
            for (int i = 0; i < n; i++) {
                if (!used[i]) {
                    c1++;
                }
            }
            used = new boolean[n];
            used[b] = true;
            dfsb(b, a);
            used[a] = true;
            long c2 = 0;
            for (int i = 0; i < n; i++) {
                if (!used[i]) {
                    c2++;
                }
            }
            out.println(c1 * c2);
        }
    }

    public void run() {
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);

            solve();

            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    BufferedReader br;
    StringTokenizer in;
    PrintWriter out;

    class Pair implements Comparable<Pair> {
        int f;
        int s;

        public Pair(int f, int s) {
            this.f = f;
            this.s = s;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return f == pair.f &&
                    s == pair.s;
        }

        @Override
        public int hashCode() {
            return Objects.hash(f, s);
        }

        @Override
        public int compareTo(Pair o) {
            if (f == o.f) {
                return s - o.s;
            }
            return f - o.f;
        }
    }

    public String nextToken() throws IOException {
        while (in == null || !in.hasMoreTokens()) {
            in = new StringTokenizer(br.readLine());
        }
        return in.nextToken();
    }

    public int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    public double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    public long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    public int[] nextArr(int n) throws IOException {
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = nextInt();
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        new E().run();
    }
}