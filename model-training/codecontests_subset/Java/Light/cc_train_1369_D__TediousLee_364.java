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
        long mod=1000000007;
        int max=2000100;
        long[]A=new long[max];
        A[1]=1;
        for (int x=2;x<max;x++)
            A[x]=(A[x-1]+A[x-2]*2)%mod;
            
        long[]S=new long[max];
        S[1]=4;
        S[2]=4;
        for (int x=3;x<max;x++)
            S[x]=(A[x]*4+S[x-3])%mod;
            
        //for (int x=0;x<100;x++) out.println(x+" "+A[x]+" "+S[x]);
        
        for (int tc=ni();tc>0;tc--) {
            int n=ni();
            if (n<2) out.println(0);
            else out.println(S[n-2]);
        }
        out.flush();
    }
    
    public static void main(String[] args) throws IOException {
        new Main().solve();
    }
}