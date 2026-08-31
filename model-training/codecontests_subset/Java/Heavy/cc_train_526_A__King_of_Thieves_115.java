import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;

import static java.lang.Math.*;

public class Main implements Runnable {
    
    void solve() throws Exception {
           int n = sc.nextInt();
           char c[] = sc.nextToken().toCharArray();
           for(int i = 0; i < n; i++){
               if(c[i] == '*'){
                   for(int j = 1; j < n; j++){
                       char t = '*';
                       if(j*4 + i < n && c[i+j] == t && c[2*j+i] == t && c[j*3 + i] == t && c[j*4 + i] == t){
                           out.println("yes");
                           return;
                       }
                   }
               }
           }
           out.println("no");
        }
     
    BufferedReader in;
    PrintWriter out;
    FastScanner sc;
    
    static Throwable throwable;
    
    public static void main(String[] args) throws Throwable {
        Thread thread = new Thread(null, new Main(), "", (1 << 26));
        thread.start();
        thread.join();
        thread.run();
        if (throwable != null)
            throw throwable;
    }
    
    
    public void run() {
        try {
            //in = new BufferedReader(new FileReader(".in"));
            //out = new PrintWriter(new FileWriter(".out"));
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            sc = new FastScanner(in);
            solve();
        } catch (Exception e) {
            throwable = e;
        } finally {
            out.close();
        }
    }
}

class FastScanner {
    BufferedReader reader;
    StringTokenizer strTok;
    
    FastScanner(BufferedReader reader) {
        this.reader = reader;
    }
    
    public String nextToken() throws Exception {
        while (strTok == null || !strTok.hasMoreTokens())
            strTok = new StringTokenizer(reader.readLine());
        return strTok.nextToken();
    }
    
    public int nextInt() throws Exception {
        return Integer.parseInt(nextToken());
    }
    
    public long nextLong() throws Exception {
        return Long.parseLong(nextToken());
    }
    
    public double nextDouble() throws Exception {
        return Double.parseDouble(nextToken());
    }
}
