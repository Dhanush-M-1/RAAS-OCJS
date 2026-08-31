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
        for (int tc=ni();tc>0;tc--) {
            long n=nl(),a=nl(),b=nl();
            
            long curr=1;
            long p=0;
            for (long x=1;x<=n;x++) {
                long nc=curr+2*(n-x);
                if (nc>a) { p=x; break; }
                curr=nc;
            }
            
            if (p==0) {
                out.println(1);
                continue;
            }
            
            long q=p+1;
            while (curr<a) { curr+=2; q++; }
            if (curr>a) { out.print((q-1)+" "); }
            
            while (curr<b-1 && q<=n) {
                out.print(p+" "+q+" ");
                q++;
                curr+=2;
            }
            if (curr==b) {
                if (q>n) 
                    if (p+2>n) out.println(1);
                    else out.println(p+1);
                else
                    out.println(p); 
                continue; 
            }
            if (curr==b-1) {
                if (q>n) {
                    if (p+2>n) out.println(n+"1");
                    else out.println((p+1)+" "+(p+2));
                }
                else out.println(p+" "+q);
                continue;
            }
            
            p++;
            while (p<n) {
                q=p+1;
                while (curr<b-1 && q<=n) {
                    out.print(p+" "+q+" ");
                    q++;
                    curr+=2;
                }
                if (curr>=b-1) break;
                p++;
            }
            
            if (p==n) {
                if (curr==b) out.println(n);
                else out.println(n+" 1");
            }
            else {
                if (curr==b) {
                    if (q>n) 
                        if (p+2>n) out.println(1);
                        else out.println(p+1);
                    else
                        out.println(p); 
                    continue; 
                }
                if (curr==b-1) {
                    if (q>n) {
                        if (p+2>n) out.println(n+"1");
                        else out.println((p+1)+" "+(p+2));
                    }
                    else out.println(p+" "+q);
                }
            }
            
        }
        out.flush();
    }
    
    public static void main(String[] args) throws IOException {
        new Main().solve();
    }
}