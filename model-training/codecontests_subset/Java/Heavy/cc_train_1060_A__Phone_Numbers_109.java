import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author Don Li
 */
public class PhoneNumbers {
    void solve() {
        int n = in.nextInt();
        char[] s = in.nextToken().toCharArray();
        int[] cnt = new int[10];
        for (int i = 0; i < n; i++) cnt[s[i] - '0']++;
        
        int tot = 0;
        for (int i = 0; i < 10; i++) tot += cnt[i];
        
        int ans = 0;
        for (int i = 1; i <= cnt[8]; i++) {
            int rem = tot - i;
            if (rem / 10 >= i) ans = i;
        }
        out.println(ans);
    }
    
    public static void main(String[] args) {
        in = new FastScanner(new BufferedReader(new InputStreamReader(System.in)));
        out = new PrintWriter(System.out);
        new PhoneNumbers().solve();
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
