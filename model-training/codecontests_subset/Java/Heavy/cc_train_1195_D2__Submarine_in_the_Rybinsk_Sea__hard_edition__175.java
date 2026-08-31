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
  
    static long m=998244353;
  
    void solve() throws IOException {
        int n=ni();
        long[]A=new long[n];
        for (int x=0;x<n;x++) A[x]=nl();
        
        Arrays.sort(A);
        
        long a=A[0];
        int digits=0;
        while (a>0) {digits++; a/=10;}
        
        long ans=0;
        int[]C=new int[15];
        int[]TC=new int[15];
        
        for (int x=0;x<n;x++) {
            a=A[x];
            int nd=0;
            while (a>0) {nd++; a/=10;}
            C[nd]++;
            TC[nd]++;
            if (nd>digits) {
                for (int p=digits+1;p<=nd;p++) TC[p]+=TC[p-1];
                digits=nd;
            }
            
            
            a=A[x];
            int b=1;
            long c=0;
            int cd=1;
            while (a>0) {
                c=a%10;
                long d = (c*(n-TC[cd-1]))%m;
                d = (d*11)%m;
                for (int y=1;y<b;y++) d=(d*10)%m;
                ans = (ans+d)%m;
                
                for (int p=cd-1;p>0;p--) {
                    long e=(c*2*C[p])%m;
                    for (int y=1;y<=(cd+p-1);y++) e=(e*10)%m;
                    ans = (ans+e)%m;
                }
                
                a/=10;
                b+=2;
                cd++;
            }
        }
        
        System.out.println(ans);
    }
    
    public static void main(String[] args) throws IOException {
        new Main().solve();
    }
}