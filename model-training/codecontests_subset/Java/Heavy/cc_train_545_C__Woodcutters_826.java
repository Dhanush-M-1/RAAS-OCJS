import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    void run()throws Exception {
        int n = ni();
        int x[] = new int[n];
        int h[] = new int[n];
        int ans=2;
        for(int i=0;i<n;i++) {
            x[i] = ni();
            h[i] = ni();
        }h[0]=0;h[n-1]=0;
        if(n<3) {pn(n);return;}
        for(int i=1;i<n-1;i++) {
            if(x[i]-h[i]>x[i-1]) {
                ++ans;
            } else if(x[i]+h[i]<x[i+1]) {
                ++ans;
                x[i] += h[i];
            }
        }
        pn(ans);
    }
    StringTokenizer st;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(System.out);
    public static void main(String args[])throws Exception { new Main().run(); out.flush();}
    static long gcd(long a, long b){return (b==0)?a:gcd(b,a%b); }
    static int gcd(int a, int b){return (b==0)?a:gcd(b,a%b); }
    int ni() throws Exception { return Integer.parseInt(next()); }
    long nl() throws Exception { return Long.parseLong(next()); }
    double nd() throws Exception { return Double.parseDouble(next()); }
    String n() throws Exception { return next(); }
    String nln() throws Exception { return nextLine(); }
    void p(Object o) { out.print(o); }
    void pn(Object o) { out.println(o); }
    void pni(Object o) { out.println(o);out.flush(); }
    String next() throws Exception{
        while (st == null || !st.hasMoreElements()){
            try{st = new StringTokenizer(br.readLine());}
            catch (Exception  e){throw new Exception(e.toString());}
        }return st.nextToken();
    }
    String nextLine() throws Exception{
        String str = "";
        try{str = br.readLine();}catch (Exception e)
        {throw new Exception(e.toString());}
        return str;
    }
}