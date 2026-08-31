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
  
    void solve() throws IOException {
        int n=ni(),m=ni();
        int[]A=new int[n];
        int[]B=new int[n];
        for (int x=0;x<n;x++) A[x]=ni();
        for (int x=0;x<n;x++) B[x]=ni();
        Arrays.sort(A);
        Arrays.sort(B);
        int ans=Integer.MAX_VALUE;
        
        for (int p=n-1;p>=0;p--) {
            int na=0;
            if (A[p]<=B[n-1]) na=B[n-1]-A[p];
            else na=m+B[n-1]-A[p];
            boolean f=true;
            int q=p;
            for (int x=n-1;x>=0;x--) {
                if (B[x]!=(A[q]+na)%m) {f=false; break;}
                q--;
                if (q<0) q=n-1;
            }
            if (f) ans=Math.min(ans,na);
        }
        System.out.println(ans);
    }
    
    public static void main(String[] args) throws IOException {
        new Main().solve();
    }
}