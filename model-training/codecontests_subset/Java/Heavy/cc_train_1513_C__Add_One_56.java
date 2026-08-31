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
    long[]D,E;
    
    void solve() throws IOException {
        D=new long[200001];
        E=new long[200001];
        for (int i=0;i<10;i++) D[i]=1;
        for (int i=0;i<9;i++) E[i]=1;
        E[9]=2;
        for (int i=10;i<200001;i++) {
            D[i]=(D[i-10]+E[i-10])%mod;
            E[i]=(E[i-9]+D[i-9])%mod;
        }
        
        for (int tc=ni();tc>0;tc--) {
            int n=ni(),m=ni();
            long ans=0;
            while (n>0) {
                int d=n%10;
                if (d==0) ans=(ans+D[m])%mod;
                if (d==1) ans=(ans+E[m])%mod;
                if (d>1) {
                    if (d+m<10) ans++;
                    else {
                        int left=(m-10+d);
                        ans=(ans+D[left]+E[left])%mod;
                    }
                }
                n/=10;
            }
            ans=ans%mod;
            out.println(ans);
        }
        out.flush();
    }

    int gcd(int a,int b) { return(b==0?a:gcd(b,a%b)); }
    long gcd(long a,long b) { return(b==0?a:gcd(b,a%b)); }
    long mp(long a,long p) { long r=1; while(p>0) { if ((p&1)==1) r=(r*a)%mod; p>>=1; a=(a*a)%mod; } return r; }
    
    public static void main(String[] args) throws IOException {
        new Main().solve();
    }
}