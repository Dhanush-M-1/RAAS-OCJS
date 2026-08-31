import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

/**
 * @author Don Li
 */
public class CompleteTheGraph {
    
    int N = 1000;
    int M = 10000;
    int INF = (int) (1e9 + 5);
    
    int n, m;
    int L, s, t;
    int[] u = new int[M], v = new int[M];
    long[] w = new long[M];
    boolean[] mark = new boolean[M];
    
    int[][][] G;
    
    long[] d = new long[N];
    
    int[] prev = new int[N];
    
    void solve() {
        n = in.nextInt();
        m = in.nextInt();
        L = in.nextInt();
        s = in.nextInt();
        t = in.nextInt();
        for (int i = 0; i < m; i++) {
            u[i] = in.nextInt();
            v[i] = in.nextInt();
            w[i] = in.nextInt();
            if (w[i] == 0) mark[i] = true;
        }
        G = build_graph(n, u, v);
        
        // set weight of all unassigned edges to INF, then we find the upper bound of shortest_path(s,t)
        for (int i = 0; i < m; i++) {
            if (mark[i]) w[i] = L + 1;
        }
        dijkstra();
        if (d[t] < L) {
            out.println("NO");
            return;
        } else if (d[t] == L) {
            printAns();
            return;
        }
        
        // set weight of all unassigned edges to 1, then we find the lower bound of shortest_path(s,t)
        for (int i = 0; i < m; i++) {
            if (mark[i]) w[i] = 1;
        }
        dijkstra();
        if (d[t] > L) {
            out.println("NO");
            return;
        } else if (d[t] == L) {
            printAns();
            return;
        }
    
        // repeatedly assign shortest path to L
        while (d[t] < L) {
            Set<Integer> path = getPath();
            boolean ok = false;
            for (int e : path) {
                if (mark[e] && !ok) {
                    w[e] = L - (d[t] - 1);
                    ok = true;
                    mark[e] = false;
                }
            }
            for (int i = 0; i < m; i++) {
                if (mark[i] && !path.contains(i)) w[i] = L + 1;
            }
            dijkstra();
        }
    
        printAns();
    }
    
    void printAns() {
        out.println("YES");
        for (int i = 0; i < m; i++) {
            out.printf("%d %d %d%n", u[i], v[i], w[i]);
        }
    }
    
    Set<Integer> getPath() {
        Set<Integer> path = new HashSet<>();
        int x = t;
        while (x != s) {
            int id = prev[x];
            int y = u[id] == x ? v[id] : u[id];
            path.add(id);
            x = y;
        }
        return path;
    }
    
    void dijkstra() {
        Arrays.fill(d, INF);
        Arrays.fill(prev, -1);
        d[s] = 0;
        Queue<long[]> pq = new PriorityQueue<>((p, q) -> Long.compare(p[1], q[1]));
        pq.offer(new long[]{s, 0});
        while (!pq.isEmpty()) {
            long[] p = pq.poll();
            int u = (int) p[0];
            if (p[1] > d[u]) continue;
            for (int[] q : G[u]) {
                int v = q[0], e = q[1];
                if (d[v] > d[u] + w[e]) {
                    d[v] = d[u] + w[e];
                    prev[v] = e;
                    pq.offer(new long[]{v, d[v]});
                }
            }
        }
    }
    
    int[][][] build_graph(int n, int[] from, int[] to) {
        int[][][] G = new int[n][][];
        int[] cnt = new int[n];
        for (int i = 0; i < from.length; i++) {
            cnt[from[i]]++;
            cnt[to[i]]++;
        }
        for (int i = 0; i < n; i++) G[i] = new int[cnt[i]][];
        for (int i = 0; i < from.length; i++) {
            G[from[i]][--cnt[from[i]]] = new int[]{to[i], i};
            G[to[i]][--cnt[to[i]]] = new int[]{from[i], i};
        }
        return G;
    }
    
    public static void main(String[] args) {
        in = new FastScanner(new BufferedReader(new InputStreamReader(System.in)));
        out = new PrintWriter(System.out);
        new CompleteTheGraph().solve();
        out.close();
    }
    
    static FastScanner in;
    static PrintWriter out;
    
    static class FastScanner {
        BufferedReader in;
        StringTokenizer st;
        
        public FastScanner(BufferedReader in) {
            this.in = in;
        }
        
        public String nextToken() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(in.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        
        public int nextInt() {
            return Integer.parseInt(nextToken());
        }
        
        public long nextLong() {
            return Long.parseLong(nextToken());
        }
        
        public double nextDouble() {
            return Double.parseDouble(nextToken());
        }
    }
}
