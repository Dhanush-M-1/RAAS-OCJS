import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author Don Li
 */
public class DestructionTree2 {
    
    int N = (int) 2e5 + 10;
    
    int[][] G;
    
    int ptr = 0;
    int[] fr, to;
    int[] in_deg = new int[N];
    int[][] D;
    
    void solve() {
        int n = in.nextInt();
        
        if (n % 2 == 0) {
            out.println("NO");
            return;
        }
        
        fr = new int[n - 1];
        to = new int[n - 1];
        for (int i = 0, j = 0; i < n; i++) {
            int p = in.nextInt() - 1;
            if (p != -1) {
                fr[j] = p;
                to[j++] = i;
            }
        }
        G = build_graph(n, fr, to);
        
        dfs(0, -1);
        D = build_directed_graph(n, fr, to);
        
        int[] q = new int[n];
        int qh = 0, qt = 0;
        for (int i = 0; i < n; i++) {
            if (in_deg[i] == 0) q[qt++] = i;
        }
        while (qh < qt) {
            int u = q[qh++];
            for (int v : D[u]) {
                if (--in_deg[v] == 0) q[qt++] = v;
            }
        }
        
        out.println("YES");
        for (int u : q) out.println(u + 1);
    }
    
    boolean dfs(int u, int p) {
        boolean odd_sz = true;
        for (int v : G[u]) {
            if (v != p) {
                boolean odd = dfs(v, u);
                if (odd) {
                    odd_sz = !odd_sz;
                    add_directed_edge(u, v);
                } else {
                    add_directed_edge(v, u);
                }
            }
        }
        return odd_sz;
    }
    
    void add_directed_edge(int u, int v) {
        fr[ptr] = u;
        to[ptr++] = v;
        in_deg[v]++;
    }
    
    int[][] build_directed_graph(int n, int[] from, int[] to) {
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
    
    int[][] build_graph(int n, int[] from, int[] to) {
        int[][] G = new int[n][];
        int[] cnt = new int[n];
        for (int i = 0; i < from.length; i++) {
            cnt[from[i]]++;
            cnt[to[i]]++;
        }
        for (int i = 0; i < n; i++) G[i] = new int[cnt[i]];
        for (int i = 0; i < from.length; i++) {
            G[from[i]][--cnt[from[i]]] = to[i];
            G[to[i]][--cnt[to[i]]] = from[i];
        }
        return G;
    }
    
    public static void main(String[] args) {
        in = new FastScanner(new BufferedReader(new InputStreamReader(System.in)));
        out = new PrintWriter(System.out);
        new DestructionTree2().solve();
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
