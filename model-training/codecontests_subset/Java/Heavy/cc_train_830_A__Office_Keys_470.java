import java.util.*;
import java.io.*;

public class OfficeKeys {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        int n = scanner.nextInt(), k = scanner.nextInt(), p = scanner.nextInt() ;
        long[] arr = new long[n];
        for(int i = 0; i < n; i++) arr[i] = scanner.nextInt();
        long[] keys = new long[k];
        for(int i = 0; i < k; i++) keys[i] = scanner.nextInt();
        Arrays.sort(keys);
        Arrays.sort(arr);
        long best = Long.MAX_VALUE;
        for(int i = 0; i < k-n+1; i++) {
            long worst = 0;
            for(int j = 0; j < n; j++) {
                worst = Math.max(worst, Math.abs(keys[i + j] - arr[j]) + Math.abs(keys[i+j] - p));
            }
            best = Math.min(worst, best);
        }
        out.println(best);
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
