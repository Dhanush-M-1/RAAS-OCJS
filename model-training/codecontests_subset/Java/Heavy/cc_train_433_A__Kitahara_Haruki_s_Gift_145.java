import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author Don Li
 */
public class KitaharaHarukiGift2 {
    void solve() {
        int n = in.nextInt();
        
        int a = 0, b = 0;
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            if (x == 100) a++;
            else b++;
        }
        
        int sum = a + 2 * b;
        if (sum % 2 != 0) {
            out.println("NO");
            return;
        }
        
        int half = sum / 2;
        int one = half - 2 * Math.min(b, half / 2);
        if (one <= a) out.println("YES");
        else out.println("NO");
    }
    
    public static void main(String[] args) {
        in = new FastScanner(new BufferedReader(new InputStreamReader(System.in)));
        out = new PrintWriter(System.out);
        new KitaharaHarukiGift2().solve();
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
