import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author Don Li
 */
public class Game {
    
    void solve() {
        int n = in.nextInt(), r = in.nextInt();
        int[] c = new int[1 << n];
        for (int i = 0; i < 1 << n; i++) c[i] = in.nextInt();
        
        long sum = 0;
        for (int i = 0; i < 1 << n; i++) sum += c[i];
        
        out.println((double) sum / (1 << n));
        for (int i = 0; i < r; i++) {
            int z = in.nextInt(), g = in.nextInt();
            sum -= c[z];
            sum += g;
            c[z] = g;
            out.println((double) sum / (1 << n));
        }
    }
    
    public static void main(String[] args) {
        in = new FastScanner(new BufferedReader(new InputStreamReader(System.in)));
        out = new PrintWriter(System.out);
        new Game().solve();
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
