import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author Don Li
 */
public class GraphCutting {
    
    int n, m;
    int[][][] G;
    
    boolean[] used;
    
    void solve() {
        n = in.nextInt();
        m = in.nextInt();
        
        if (m % 2 == 1) {
            out.println("No solution");
            return;
        }
        
        int[] fr = new int[m], to = new int[m], id = new int[m];
        for (int i = 0; i < m; i++) {
            fr[i] = in.nextInt() - 1;
            to[i] = in.nextInt() - 1;
            id[i] = i;
        }
        G = build_graph(n, fr, to, id);
        
        used = new boolean[m];
        dfs(0);
    }
    
    int dfs(int u) {
        Queue<Integer> unpaired = new LinkedList<>();
        for (int[] p : G[u]) {
            int v = p[0], e = p[1];
            if (!used[e]) {
                used[e] = true;
                int w = dfs(v);
                if (w >= 0) {
                    out.printf("%d %d %d%n", u + 1, v + 1, w + 1);
                } else {
                    unpaired.offer(v);
                }
            }
        }
        
        while (unpaired.size() >= 2) {
            int v = unpaired.poll(), w = unpaired.poll();
            out.printf("%d %d %d%n", v + 1, u + 1, w + 1);
        }
        
        if (unpaired.isEmpty()) return -1;
        return unpaired.poll();
    }
    
    int[][][] build_graph(int n, int[] from, int[] to, int[] weight) {
        int[][][] G = new int[n][][];
        int[] cnt = new int[n];
        for (int i = 0; i < from.length; i++) {
            cnt[from[i]]++;
            cnt[to[i]]++;
        }
        for (int i = 0; i < n; i++) G[i] = new int[cnt[i]][];
        for (int i = 0; i < from.length; i++) {
            G[from[i]][--cnt[from[i]]] = new int[]{to[i], weight[i]};
            G[to[i]][--cnt[to[i]]] = new int[]{from[i], weight[i]};
        }
        return G;
    }
    
    public static void main(String[] args) {
        in = new FastScanner(new BufferedReader(new InputStreamReader(System.in)));
        out = new PrintWriter(System.out);
        new GraphCutting().solve();
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
