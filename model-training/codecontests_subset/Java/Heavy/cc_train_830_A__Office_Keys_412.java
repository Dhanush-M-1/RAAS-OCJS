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
public class OfficeKeys2 {
    
    int INF = (int) 2e9 + 10;
    
    void solve() {
        int n = in.nextInt(), k = in.nextInt(), p = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = in.nextInt();
        int[] b = new int[k];
        for (int i = 0; i < k; i++) b[i] = in.nextInt();
        
        sort(a);
        sort(b);
        
        long lb = -1, ub = INF;
        while (ub - lb > 1) {
            long m = (lb + ub) >> 1;
            int i = 0, j = 0;
            for (; i < n && j < k; ) {
                int need = Math.abs(a[i] - b[j]) + Math.abs(p - b[j]);
                if (need <= m) {
                    i++;
                    j++;
                } else {
                    j++;
                }
            }
            if (i == n) ub = m;
            else lb = m;
        }
        out.println(ub);
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
        new OfficeKeys2().solve();
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
