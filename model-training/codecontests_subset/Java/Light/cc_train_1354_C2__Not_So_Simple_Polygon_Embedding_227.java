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
            int n=ni()*2;
            double a=360.0/n;
            double b=(180-a)/2;
            double c=Math.sin(Math.toRadians(b))/Math.sin(Math.toRadians(a));
            c*=2;
            int p=n/4;
            a=a*p;
            b=(180-a)/2-45;
            out.println((c*Math.cos(Math.toRadians(b))));
        }
        out.flush();
    }
    
    public static void main(String[] args) throws IOException {
        new Main().solve();
    }
}