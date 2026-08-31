import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author Don Li
 */
public class BarkUnlock {
    void solve() {
        char[] s = in.nextToken().toCharArray();
        int n = in.nextInt();
        
        int start = 0, end = 0;
        for (int i = 0; i < n; i++) {
            char[] t = in.nextToken().toCharArray();
            if (t[0] == s[0] && t[1] == s[1]) {
                out.println("YES");
                return;
            }
            if (t[0] == s[1]) end++;
            if (t[1] == s[0]) start++;
        }
        
        if (start > 0 && end > 0) {
            out.println("YES");
            return;
        }
        
        out.println("NO");
    }
    
    public static void main(String[] args) {
        in = new FastScanner(new BufferedReader(new InputStreamReader(System.in)));
        out = new PrintWriter(System.out);
        new BarkUnlock().solve();
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
