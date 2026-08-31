import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author Don Li
 */
public class KitaharaHarukiGift {
    void solve() {
        int n = in.nextInt();
        
        int one = 0, two = 0;
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            if (x == 100) one++;
            else two++;
        }
        
        if (two % 2 == 0 && one % 2 == 0) {
            out.println("YES");
        } else if (two % 2 == 0) {
            out.println("NO");
        } else if (one % 2 == 0) {
            if (one > 0) out.println("YES");
            else out.println("NO");
        } else {
            out.println("NO");
        }
    }
    
    public static void main(String[] args) {
        in = new FastScanner(new BufferedReader(new InputStreamReader(System.in)));
        out = new PrintWriter(System.out);
        new KitaharaHarukiGift().solve();
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
