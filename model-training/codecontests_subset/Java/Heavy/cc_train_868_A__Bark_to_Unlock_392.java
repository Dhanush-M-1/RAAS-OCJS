import java.io.*;
import java.util.*;
 
public class utkarsh {
    
    BufferedReader br;
    PrintWriter out;
    
    long mod = (long) (1e9 + 7), inf = (long) (3e18);
    
    void solve() {
        char s[] = ns().toCharArray();
        boolean b[] = new boolean[2];
        boolean found = false;
        int n = ni();
        for(int i = 0; i < n; i++) {
            char c[] = ns().toCharArray();
            if(s[0] == c[1])    b[0] = true;
            if(s[1] == c[0])    b[1] = true;
            
            if(c[0] == s[0] && c[1] == s[1] || c[0] == s[1] && c[1] == s[0])    found = true;
        }
        out.println(b[0] && b[1] || found ? "YES" : "NO");
    }
    
    int gcd(int a, int b) {
        if(b == 0)  return a;
        return gcd(b, a % b);
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
