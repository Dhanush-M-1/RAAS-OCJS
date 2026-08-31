import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author Don Li
 */
public class CompleteTheGraph2 {
    
    int N = 1000;
    int M = 10000;
    int INF = (int) (1e9 + 5);
    
    int n, m;
    int L, s, t;
    int[] u = new int[M], v = new int[M];
    long[] w = new long[M];
    int[] erased = new int[M];
    
    int[][][] G;
    
    long[] d = new long[N];
    
    void solve() {
        n = in.nextInt();
        m = in.nextInt();
        L = in.nextInt();
        s = in.nextInt();
        t = in.nextInt();
        int sz = 0;
        for (int i = 0; i < m; i++) {
            u[i] = in.nextInt();
            v[i] = in.nextInt();
            w[i] = in.nextInt();
            if (w[i] == 0) erased[sz++] = i;
        }
        G = build_graph(n, u, v);
        erased = Arrays.copyOf(erased, sz);
        
        // set weight of all unassigned edges to INF, then we find the upper bound of shortest_path(s,t)
        for (int i : erased) w[i] = L + 1;
        dijkstra();
        if (d[t] < L) {
            out.println("NO");
            return;
        } else if (d[t] == L) {
            printAns();
            return;
        }
        
        // set weight of all unassigned edges to 1, then we find the lower bound of shortest_path(s,t)
        for (int i : erased) w[i] = 1;
        dijkstra();
        if (d[t] > L) {
            out.println("NO");
            return;
        } else if (d[t] == L) {
            printAns();
            return;
        }
        
        int lb = -1, ub = sz - 1;
        while (ub - lb > 1) {
            int mid = (lb + ub) / 2;
            for (int i = 0; i <= mid; i++) w[erased[i]] = 1;
            for (int i = mid + 1; i < sz; i++) w[erased[i]] = L + 1;
            dijkstra();
            if (d[t] <= L) ub = mid;
            else lb = mid;
        }
        
        int p = erased[ub];
        lb = 1;
        ub = L + 1;
        while (ub - lb > 1) {
            int mid = (lb + ub) / 2;
            w[p] = mid;
            dijkstra();
            if (d[t] > L) ub = mid;
            else lb = mid;
        }
        w[p] = lb;
        
        printAns();
    }
    
    void printAns() {
        out.println("YES");
        for (int i = 0; i < m; i++) {
            out.printf("%d %d %d%n", u[i], v[i], w[i]);
        }
    }
    
    void dijkstra() {
        Arrays.fill(d, INF);
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
        new CompleteTheGraph2().solve();
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
