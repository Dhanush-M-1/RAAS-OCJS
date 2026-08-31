import java.io.*;
import java.util.*;
import java.math.*;
 
//Sub_To_Errichto
public class Main {
    //static final long MOD = 1000000007L;
    //static final long MOD = 998244353L;
    static final int INF = 50000000;
    static final int NINF = -500000000;
    
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        PrintWriter pw = new PrintWriter(System.out);
        
        long[] A = new long[] {sc.nl(),sc.nl()};
        long[] B = new long[] {sc.nl(),sc.nl()};
        long[] C = new long[] {sc.nl(),sc.nl()};
        long[][] vals = new long[][] {{A[0],A[1]},{A[1],-A[0]},{-A[0],-A[1]},{-A[1],A[0]}};
        String ans = "NO";
        for (long[] v: vals) {
        	long X = B[0]-v[0];
        	long Y = B[1]-v[1];
        	if (C[0]==0 && C[1]==0) {
        		if (X==0&&Y==0)
        			ans = "YES";
        	} else if (C[0]==0) {
        		if (X%C[1]==0&&Y%C[1]==0)
        			ans = "YES";
        	} else if (C[1]==0) {
        		if (X%C[0]==0&&Y%C[0]==0)
        			ans = "YES";
        	} else {
            	long num = C[1]*X-C[0]*Y;
            	long den = C[1]*C[1]+C[0]*C[0];
            	if (num%den==0) {
            		long other = num/den;
            		long sub = X-C[1]*other;
            		if (sub%C[0]==0)
            			ans = "YES";
            	}
        	}
        }
        pw.println(ans);
        pw.close();
    }
    
    //Find the GCD of two numbers
    public static long gcd(long a, long b) {
    	if (a < b) return gcd(b,a);
    	if (b == 0)
    		return a;
    	else
    		return gcd(b,a%b);
    }
    
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;
 
        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
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
 
        int ni() {
            return Integer.parseInt(next());
        }
 
        long nl() {
            return Long.parseLong(next());
        }
 
        double nd() {
            return Double.parseDouble(next());
        }
 
        String nextLine() {
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