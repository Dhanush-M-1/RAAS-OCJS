import java.io.*;
import java.math.BigInteger;
import java.util.*;
import static java.lang.Math.*;

public class SolutionA {
    private static FastScanner in = new FastScanner();
    private static PrintWriter out =
        new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) {
    
        // tests();
        solve();
        
        out.close();
    }

    static void solve() {
        int n = in.nextInt();
        char[] chars = in.next().toCharArray();

        char[] sorted = new char[n];
        System.arraycopy(chars, 0, sorted, 0, n);
        Arrays.sort(sorted);

        int lo = -1;
        int hi = -1;
        char big = '\0';
        char small = '\0';

        for (int i = 0; i < n; i++) {
            if (big == '\0' && chars[i] > sorted[i]) {
                big = chars[i];
                lo = i;
                small = sorted[i];
            }
            if (small != '\0' && chars[i] == small) {
                hi = i;
                out.printf("YES\n%d %d\n", lo + 1, hi + 1); return;
            }
        }
        out.println("NO");
    }
    
    static void tests() {
        int t = in.nextInt();
        while (t-- > 0) {
            solve();
        }
    }

    private static class FastScanner {
        private BufferedReader br;
        private StringTokenizer st;
    
        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
    
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) { e.printStackTrace(); }
            }
            return st.nextToken();
        }
    
        int nextInt() { return Integer.parseInt(next()); }
    
        long nextLong() { return Long.parseLong(next()); }
    
        double nextDouble() { return Double.parseDouble(next()); }
    
        String nextLine() {
            String str = "";
            try { str = br.readLine(); } 
            catch (IOException e) { e.printStackTrace(); }
            return str;
        }
    }
}
