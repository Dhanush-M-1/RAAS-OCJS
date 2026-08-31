import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author Don Li
 */
public class Bulbs {
    void solve() {
        int n = in.nextInt(), m = in.nextInt();
        boolean[] on = new boolean[m + 1];
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            for (int j = 0; j < x; j++) {
                int k = in.nextInt();
                on[k] = true;
            }
        }
        
        boolean ok = true;
        for (int i = 1; i <= m; i++) {
            if (!on[i]) {
                ok = false;
                break;
            }
        }
        if (ok) out.println("YES");
        else out.println("NO");
    }
    
    public static void main(String[] args) {
        in = new FastScanner(new BufferedReader(new InputStreamReader(System.in)));
        out = new PrintWriter(System.out);
        new Bulbs().solve();
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
