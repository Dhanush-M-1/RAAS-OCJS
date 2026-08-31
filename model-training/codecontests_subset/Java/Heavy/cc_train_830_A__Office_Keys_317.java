import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Math.random;

/**
 * @author Don Li
 */
public class OfficeKeys {
    void solve() {
        int n = in.nextInt(), k = in.nextInt(), p = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = in.nextInt();
        int[] b = new int[k];
        for (int i = 0; i < k; i++) b[i] = in.nextInt();
        
        sort(a);
        sort(b);
        
        long ans = (long) 1e18;
        for (int i = 0; i <= k - n; i++) {
            long max = 0;
            for (int j = 0; j < n; j++) {
                long dist = Math.abs(b[i + j] - p) + Math.abs(b[i + j] - a[j]);
                max = Math.max(max, dist);
            }
            ans = Math.min(ans, max);
        }
        out.println(ans);
    }
    
    void sort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int j = (int) (i + random() * (n - i));
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }
        Arrays.sort(a);
    }
    
    public static void main(String[] args) {
        in = new FastScanner(new BufferedReader(new InputStreamReader(System.in)));
        out = new PrintWriter(System.out);
        new OfficeKeys().solve();
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
