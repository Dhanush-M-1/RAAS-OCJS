import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	PrintWriter out = new PrintWriter(System.out);
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer tok = new StringTokenizer("");
    String next() throws IOException {
        if (!tok.hasMoreTokens()) { tok = new StringTokenizer(in.readLine()); }
        return tok.nextToken();
    }
    int ni() throws IOException { return Integer.parseInt(next()); }
    long nl() throws IOException { return Long.parseLong(next()); }
    
    long mod=1000000007;
    int n;
    long big=200000*200000;
    
    void solve() throws IOException {
        n=ni();
        long[]A=new long[n+1];
        for (int i=1;i<=n;i++) A[i]=nl();
        segtree st=new segtree(A,1,n);
        int[]ans=new int[n+1];
        int p=1;
        while (p<=n) {
            int posn=st.getnext(p);
            ans[posn]=p;
            p++;
        }
        
        for (int i=1;i<=n;i++) out.print(ans[i]+" ");
        out.println();
        out.flush();
    }
    
    class segtree {
        int lt,rt;
        long min,up;
        segtree lc,rc;
        public segtree(long[]A,int p,int q) {
            lt=p;
            rt=q;
            if (lt==rt) min=A[lt];
            else {
                int mid=(lt+rt)/2;
                lc=new segtree(A,lt,mid);
                rc=new segtree(A,mid+1,rt);
                min=Math.min(lc.min,rc.min);
            }
        }
        
        public int getnext(int v) {
            if (lt==rt) {
                //out.println(lt);
                min=Long.MAX_VALUE;
                return lt;
            }
            //out.println(lt+" "+rt+" "+lc.min+" "+rc.min+" "+up);
            if (up>0) {
               lc.min-=up;
               lc.up+=up;
               rc.min-=up;
               rc.up+=up;
               up=0;
            }
            
            int ret=-1;
            if (rc.min==0) ret=rc.getnext(v);
            else {
                ret=lc.getnext(v);
                rc.min-=v;
                rc.up+=v;
            }
            min=Math.min(lc.min,rc.min);
            return ret;
        }
    }
    
    int gcd(int a,int b) { return(b==0?a:gcd(b,a%b)); }
    long gcd(long a,long b) { return(b==0?a:gcd(b,a%b)); }
    long mp(long a,long p) { long r=1; while(p>0) { if ((p&1)==1) r=(r*a)%mod; p>>=1; a=(a*a)%mod; } return r; }
    
    public static void main(String[] args) throws IOException {
        new Main().solve();
    }
}