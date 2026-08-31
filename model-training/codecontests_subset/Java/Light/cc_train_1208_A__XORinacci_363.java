import java.lang.*;
import java.util.*;
import java.io.*;

public class Main {
    void solve() {
       int t=ni();
       while(t-->0){
           int a=ni(),b=ni(),n=ni();
           n%=3;
           if(n==0) pw.println(a);
           else if(n==1) pw.println(b);
           else pw.println(a^b);
       }

    }

    long M = (long)1e9+7;

    // END
    PrintWriter pw;
    StringTokenizer st;
    BufferedReader br;

    void run() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(System.out);
        long s = System.currentTimeMillis();
        solve();
        pw.flush();
    }
    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    String ns() {
        while (st == null || !st.hasMoreElements()) {

            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    String nextLine() throws Exception {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            throw new Exception(e.toString());
        }
        return str;
    }

    int ni() {
        return Integer.parseInt(ns());
    }

    long nl() {
        return Long.parseLong(ns());
    }

    double nd() {
        return Double.parseDouble(ns());
    }
}