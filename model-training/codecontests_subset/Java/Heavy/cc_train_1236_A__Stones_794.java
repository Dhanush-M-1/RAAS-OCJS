import java.util.*;
import java.io.*;

public class A {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        PrintWriter out = new PrintWriter(System.out, false);
        int t = scanner.nextInt();
        while(t-->0) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            int ans = 0;
            for(int i = 0; i <= 50; i++) {
                if (i > a) break;
                if (i * 2 > b) break;
                for(int j = 0; j <= 50; j++) {
                    int stone = 0;
                    stone += i;
                    stone += i * 2;
                    int temp = b - 2 *i;
                    if (j > temp) break;
                    if (2 * j > c) break;
                    stone += j;
                    stone += 2*j;
                    ans=Math.max(ans, stone);
                }
            }
            out.println(ans);
        }
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
