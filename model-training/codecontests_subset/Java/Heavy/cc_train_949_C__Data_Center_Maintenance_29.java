import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author Don Li
 */
public class DataCenterMaintenance {
    
    int N = (int) 1e5 + 10;
    
    int ne = 0;
    int[] fr = new int[N << 1], to = new int[N << 1];
    int[][] G;
    
    int nc = 0, timer = 0, ssz = 0;
    int[] enter = new int[N], low = new int[N], stack = new int[N], comp = new int[N];
    boolean[] in_stack = new boolean[N];
    
    void solve() {
        int n = in.nextInt(), m = in.nextInt(), h = in.nextInt();
        int[] u = new int[n];
        for (int i = 0; i < n; i++) u[i] = in.nextInt();
        
        int[][] client_to_ds = new int[m][2];
        for (int i = 0; i < m; i++) {
            client_to_ds[i][0] = in.nextInt() - 1;
            client_to_ds[i][1] = in.nextInt() - 1;
        }
        
        for (int i = 0; i < m; i++) {
            int a = client_to_ds[i][0], b = client_to_ds[i][1];
            if ((u[a] + 1) % h == u[b]) addEdge(a, b);
            if ((u[b] + 1) % h == u[a]) addEdge(b, a);
        }
        fr = Arrays.copyOf(fr, ne);
        to = Arrays.copyOf(to, ne);
        G = build_graph(n, fr, to);
        
        for (int i = 0; i < n; i++) {
            if (enter[i] == 0) tarjan(i);
        }
        
        int[] comp_sz = new int[nc];
        for (int i = 0; i < n; i++) comp_sz[comp[i]]++;
        
        int[] out_deg = new int[nc];
        for (int i = 0; i < ne; i++) {
            if (comp[fr[i]] != comp[to[i]]) {
                out_deg[comp[fr[i]]]++;
            }
        }
        int ans = n + 1, idx = -1;
        for (int i = 0; i < nc; i++) {
            if (out_deg[i] == 0 && ans > comp_sz[i]) {
                ans = comp_sz[i];
                idx = i;
            }
        }
        out.println(ans);
        for (int i = 0; i < n; i++) {
            if (comp[i] == idx) out.print(i + 1 + " ");
        }
    }
    
    void tarjan(int u) {
        low[u] = enter[u] = ++timer;
        stack[ssz++] = u;
        in_stack[u] = true;
        
        for (int v : G[u]) {
            if (enter[v] == 0) {
                tarjan(v);
                low[u] = Math.min(low[u], low[v]);
            } else if (in_stack[v]) {
                low[u] = Math.min(low[u], enter[v]);
            }
        }
        
        if (enter[u] == low[u]) {
            while (ssz > 0) {
                int v = stack[--ssz];
                in_stack[v] = false;
                comp[v] = nc;
                if (v == u) break;
            }
            nc++;
        }
    }
    
    int[][] build_graph(int n, int[] from, int[] to) {
        int[][] G = new int[n][];
        int[] cnt = new int[n];
        for (int i = 0; i < from.length; i++) {
            cnt[from[i]]++;
        }
        for (int i = 0; i < n; i++) G[i] = new int[cnt[i]];
        for (int i = 0; i < from.length; i++) {
            G[from[i]][--cnt[from[i]]] = to[i];
        }
        return G;
    }
    
    void addEdge(int u, int v) {
        fr[ne] = u;
        to[ne] = v;
        ne++;
    }
    
    public static void main(String[] args) {
        in = new FastScanner(new BufferedReader(new InputStreamReader(System.in)));
        out = new PrintWriter(System.out);
        new DataCenterMaintenance().solve();
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
