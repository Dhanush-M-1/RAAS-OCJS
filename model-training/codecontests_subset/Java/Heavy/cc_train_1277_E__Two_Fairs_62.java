import java.io.*;
import java.util.*;
 
public class utkarsh {
    
    BufferedReader br;
    PrintWriter out;
    
    long mod = (long) (1e9 + 7), inf = (long) (3e18);
    
    ArrayList <Integer> a[];
    
    void dfs(int c, int b, HashSet <Integer> seen) {
        seen.add(c);
        for(int x : a[c]) {
            if(x == b || seen.contains(x))  continue;
            dfs(x, b, seen);
        }
    }
    
    void solve() {
        int t = ni();
        while(t-- > 0) {
            int n = ni(), m = ni();
            int X = ni() - 1, Y = ni() - 1;
            a = new ArrayList[n];
            for(int i = 0; i < n; i++)  a[i] = new ArrayList<>();
            for(int i = 0; i < m; i++) {
                int u = ni()-1, v = ni()-1;
                a[u].add(v);    a[v].add(u);
            }
            HashSet <Integer> fx = new HashSet<>();
            HashSet <Integer> fy = new HashSet<>();
            dfs(X, Y, fx);
            dfs(Y, X, fy);
            
            long x = 0;
            for(int xc : fx) {
                if(!fy.contains(xc))    x++;
            }
            long y = fy.size() - (fx.size() - x);
            out.println((x-1) * (y-1));
        }
    }
    
    long mp(long b, long e) {
        long r = 1;
        while(e > 0) {
            if( (e&1) == 1 )    r = (r * b) % mod;
            b = (b * b) % mod;
            e >>= 1;
        }
        return r;
    }
    
    // -------- I/O Template -------------
    
    char nc() {
        return ns().charAt(0);
    }
    
    String nLine() {
        try {
            return br.readLine();
        } catch(IOException e) {
            return "-1";
        }
    }
    
    double nd() {
        return Double.parseDouble(ns());
    }
    
    long nl() {
        return Long.parseLong(ns());
    }
    
    int ni() {
        return Integer.parseInt(ns());
    }
    
    StringTokenizer ip;
    
    String ns() {
        if(ip == null || !ip.hasMoreTokens()) {
            try {
                ip = new StringTokenizer(br.readLine());
            } catch(IOException e) {
                throw new InputMismatchException();
            }
        }
        return ip.nextToken();
    }
    
    void run() {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        solve();
        out.flush();
    }
    
    public static void main(String[] args) {
        new utkarsh().run();
    }
}
