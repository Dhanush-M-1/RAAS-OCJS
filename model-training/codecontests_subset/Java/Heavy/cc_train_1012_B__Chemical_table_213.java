import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author Don Li
 */
public class ChemicalTable {
    
    int N = (int) 4e5 + 10;
    
    int[] parent = new int[N];
    
    void solve() {
        int n = in.nextInt(), m = in.nextInt();
        int q = in.nextInt();
        
        Arrays.fill(parent, -1);
        for (int i = 0; i < q; i++) {
            int r = in.nextInt() - 1, c = in.nextInt() - 1;
            union(r, n + c);
        }
        
        int num = 0;
        for (int i = 0; i < n + m; i++) {
            if (parent[i] < 0) num++;
        }
        
        out.println(num - 1);
    }
    
    int find(int x) {
        if (parent[x] < 0) return x;
        return parent[x] = find(parent[x]);
    }
    
    void union(int x, int y) {
        int u = find(x), v = find(y);
        if (u == v) return;
        if (parent[u] > parent[v]) {
            int tmp = u; u = v; v = tmp;
        }
        parent[u] += parent[v];
        parent[v] = u;
    }
    
    public static void main(String[] args) {
        in = new FastScanner(new BufferedReader(new InputStreamReader(System.in)));
        out = new PrintWriter(System.out);
        new ChemicalTable().solve();
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
