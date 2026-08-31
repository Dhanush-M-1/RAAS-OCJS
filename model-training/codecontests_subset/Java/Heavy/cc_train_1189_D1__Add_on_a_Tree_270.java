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
    ArrayList<Integer>[]A;
    boolean f;
    boolean[]L;
    
    void solve() throws IOException {
        n=ni();
        A=new ArrayList[n+1];
        for (int i=1;i<=n;i++) A[i]=new ArrayList();
        for (int i=1;i<n;i++) {
            int u=ni(),v=ni();
            A[u].add(v);
            A[v].add(u);
        }
        /*f=true;
        L=new boolean[n+1];
        int root=0;
        for (int i=1;i<=n;i++) {
            if (A[i].size()>1) { root=i; break; }
        }
        if (root==0) out.println("YES");
        else if (n==3) out.println("NO");
        else {
            dfs(root,0);
            if (f) out.println("YES");
            else out.println("NO");
        }*/
        
        f=true;
        for (int i=1;i<=n;i++) {
            if (A[i].size()==2) f=false;
        }
        
        if (f) out.println("YES");
        else out.println("NO");
        out.flush();
    }
    
    void dfs(int u,int p) {
        int lc=0;
        if (A[u].size()==1) {
            L[u]=true;
            return;
        }
        for (int v:A[u]) {
            if (v==p) continue;
            dfs(v,u);
            if (L[v]) lc++;
        }
        if (lc==1 && A[u].size()==2) f=false;
    }
    
    int gcd(int a,int b) { return(b==0?a:gcd(b,a%b)); }
    long gcd(long a,long b) { return(b==0?a:gcd(b,a%b)); }
    long mp(long a,long p) { long r=1; while(p>0) { if ((p&1)==1) r=(r*a)%mod; p>>=1; a=(a*a)%mod; } return r; }
    
    public static void main(String[] args) throws IOException {
        new Main().solve();
    }
}