import java.io.*;
import java.util.*;
 
import java.math.*;
import java.awt.Point;
 
public class CFTemplate {
    static final long MOD = 1000000007L;
    //static final long MOD2 = 1000000009L;
    //static final long MOD = 998244353L;
    //static final long INF = 500000000000L;
    static final int INF = 1100000000;
    static final int NINF = -100000;
    static FastScanner sc;
    static PrintWriter pw;
    static final int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
 
    public static void main(String[] args) {
        sc = new FastScanner();
        pw = new PrintWriter(System.out);
        
        int Q = sc.ni();
        for (int q = 0; q < Q; q++) {
            int N = sc.ni();
            int M = sc.ni();
            long[] A = sc.longArray(N, 0);
            long p = A[0];
            long m = A[0];
            TreeMap<Long,Integer> tm = new TreeMap<Long,Integer>();
            tm.put(p,0);
            for (int i = 1; i < N; i++) {
                p += A[i];
                if (p > m) {
                    tm.put(p,i);
                    m = p;
                }
            }
            for (int i = 0; i < M; i++) {
                long X = sc.nl();
                if (p <= 0) {
                    Long ind = tm.ceilingKey(X);
                    if (ind==null)
                        pw.print("-1 ");
                    else
                        pw.print(tm.get(ind) + " ");
                } else {
                    long rot = Math.max(0,(X-m+p-1)/p);
                    long ans = rot*N+tm.get(tm.ceilingKey(X-rot*p));
                    pw.print(ans + " ");
                }
            }
            pw.println();
        }
        pw.close();
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;
 
        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in), 32768);
            st = null;
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
 
        int[] intArray(int N, int mod) {
            int[] ret = new int[N];
            for (int i = 0; i < N; i++)
                ret[i] = ni()+mod;
            return ret;
        }
 
        long nl() {
            return Long.parseLong(next());
        }
 
        long[] longArray(int N, long mod) {
            long[] ret = new long[N];
            for (int i = 0; i < N; i++)
                ret[i] = nl()+mod;
            return ret;
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