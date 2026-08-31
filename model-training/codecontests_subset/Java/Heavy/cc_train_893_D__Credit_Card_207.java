import java.util.*;
import java.io.*;

public class CreditCard {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        int n = scanner.nextInt();
        int d = scanner.nextInt();
        int[] trans = new int[n];
        for(int i = 0; i < n; i++) trans[i] = scanner.nextInt();
        int ans = 0;
        int pref = 0;
        int rem = 0;
        for(int i = 0; i < n; i++) {
            if (trans[i] == 0) {
                if (rem < 0) {
                    ans++;
                    pref = 0;
                    rem = d;
                }
                else pref = Math.max(pref, 0);
            }
            else {
                pref += trans[i];
                rem = Math.min(rem + trans[i], d);
                if (pref > rem) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        out.println(ans);
        out.flush();
    }
    
    public static class FastScanner {
        BufferedReader br;
        StringTokenizer st;
        
        public FastScanner(Reader in) {
            br = new BufferedReader(in);
        }
        
        public FastScanner() {
            this(new InputStreamReader(System.in));
        }
        
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        
        int nextInt() {
            return Integer.parseInt(next());
        }
        
        long nextLong() {
            return Long.parseLong(next());
        }
        
        double nextDouble() {
            return Double.parseDouble(next());
        }
        
        String readNextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
