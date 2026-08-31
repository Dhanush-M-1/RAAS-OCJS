import java.io.*;
import java.util.*;


public class test {
    static boolean DEBUG_FLAG = false;
    int INF = (int)1e9;
    long MOD = 1000000007;
    
    static void debug(String s) {
        if(DEBUG_FLAG) {
            System.out.print(s);
        }
    }
    
    
    void solve(InputReader in, PrintWriter out) throws IOException {
        int n = in.nextInt();
        String s = in.next();
        int a = 0, f = 0, i = 0;
        for(int j=0; j<n; j++) {
            if(s.charAt(j)=='A') a++;
            else if(s.charAt(j)=='F') f++;
            else i++;
        }
        int rs = 0;
        if(i==0) {
            rs = a;
        } else if(i==1) {
            rs = 1;
        }
        out.println(rs);
    }
    
    
    public static void main(String[] args) throws IOException {
        if(args.length>0 && args[0].equalsIgnoreCase("d")) {
            DEBUG_FLAG = true;
        }
        InputReader in = new InputReader();
        PrintWriter out = new PrintWriter(System.out);
        int t = 1;//in.nextInt();
        long start = System.nanoTime();
        while(t-- >0) {
            new test().solve(in, out);
        }
        long end = System.nanoTime();
        debug("\nTime: " + (end-start)/1e6 + " \n\n");
        out.close();
    }
    
    static class InputReader {
        static BufferedReader br;
        static StringTokenizer st;
    
        public InputReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        
        String next() {
            while (st == null || !st.hasMoreTokens()) {
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
    }
}