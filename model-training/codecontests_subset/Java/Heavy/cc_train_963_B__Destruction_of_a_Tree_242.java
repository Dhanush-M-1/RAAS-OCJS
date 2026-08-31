import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author Don Li
 */
public class DestructionTree {
    
    int N = (int) 2e5 + 10;
    
    int[][] G;
    int[] sz = new int[N];
    
    void solve() {
        int n = in.nextInt();
        int[] p = new int[n];
        for (int i = 0; i < n; i++) p[i] = in.nextInt() - 1;
        
        if (n % 2 == 0) {
            out.println("NO");
            return;
        }
        
        int[] fr = new int[n - 1], to = new int[n - 1];
        for (int i = 0, j = 0; i < n; i++) {
            if (p[i] != -1) {
                fr[j] = p[i];
                to[j++] = i;
            }
        }
        G = build_graph(n, fr, to);
        
        int root = -1;
        for (int i = 0; i < n; i++) {
            if (G[i].length % 2 == 0) {
                root = i;
                break;
            }
        }
        
        dfs(root, -1);
        
        out.println("YES");
        dfs_print(root, -1);
    }
    
    void dfs_print(int u, int p) {
        for (int v : G[u]) {
            if (v != p) {
                if (sz[v] % 2 == 0) dfs_print(v, u);
            }
        }
        out.println(u + 1);
        for (int v : G[u]) {
            if (v != p) {
                if (sz[v] % 2 == 1) dfs_print(v, u);
            }
        }
    }
    
    void dfs(int u, int p) {
        sz[u] = 1;
        for (int v : G[u]) {
            if (v != p) {
                dfs(v, u);
                sz[u] += sz[v];
            }
        }
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
        new DestructionTree().solve();
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
