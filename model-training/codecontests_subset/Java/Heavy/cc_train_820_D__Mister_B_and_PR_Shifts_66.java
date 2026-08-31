import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author Don Li
 */
public class MisterBPRShifts {
    
    int N = (int) 1e6 + 10;
    
    long[] d = new long[N];
    long[] df = new long[N];
    
    void solve() {
        int n = in.nextInt();
        int[] p = new int[n];
        for (int i = 0; i < n; i++) p[i] = in.nextInt() - 1;
        
        for (int i = 0; i < n; i++) {
            if (p[i] >= i) {
                add(0, p[i] - i + 1, -1, p[i] - i);
                add(p[i] - i + 1, n - i, 1, 1);
                add(n - i, n, -1, p[i]);
            } else {
                add(0, n - i, 1, i - p[i]);
                add(n - i, n - i + p[i] + 1, -1, p[i]);
                add(n - i + p[i] + 1, n, 1, 1);
            }
        }
        
        for (int i = 1; i < n; i++) {
            df[i] += df[i - 1];
        }
        for (int i = 0; i < n; i++) {
            d[i] += df[i];
        }
        for (int i = 1; i < n; i++) {
            d[i] += d[i - 1];
        }
        
        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (d[ans] > d[i]) ans = i;
        }
        out.printf("%d %d%n", d[ans], ans);
    }
    
    void add(int l, int r, int k, int b) {
        if (l < r) {
            d[l] += b;
            df[l + 1] += k;
            d[r] -= b + (long) (r - l - 1) * k;
            df[r] -= k;
        }
    }
    
    public static void main(String[] args) {
        in = new FastScanner(new BufferedReader(new InputStreamReader(System.in)));
        out = new PrintWriter(System.out);
        new MisterBPRShifts().solve();
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
