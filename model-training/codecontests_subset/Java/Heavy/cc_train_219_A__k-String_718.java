import java.io.*;
import java.security.SecureRandom;
import java.util.*;
import java.math.*;
import java.awt.geom.*;

import static java.lang.Math.*;

public class Solution implements Runnable {
    
    
    
    
    public void solve() throws Exception {
        int k = sc.nextInt();
        char seq[] = sc.nextToken().toCharArray();
        int len = seq.length / k;
        if (len * k != seq.length) {
            out.println(-1);
            return;
        }
        int n = seq.length;
        int cnt[] = new int[256];
        for (int i = 0;i < n; ++ i) {
            cnt[(int)seq[i]]++;
        }
        String ans = "";
        for (int i = 0;i < 256; ++ i) {
            if (cnt[i] > 0) {
                if (cnt[i] % k != 0) {
                    out.println(-1);
                    return;
                }
                for (int j = 0;j < cnt[i] / k; ++ j) {
                    ans += (char)i;
                }
            }
        }
        for (int i = 0;i < k; ++ i) {
            out.print(ans);
        }
    }
    
    
    
    
    /*--------------------------------------------------------------*/
    
    static String filename = "";
    static boolean fromFile = false;
    
    BufferedReader in;
    PrintWriter out;
    FastScanner sc;
    
    public static void main(String[] args) {
        new Thread(null, new Solution(), "", 1 << 25).start();
    }
   
    public void run() {
        try {
            init();
            solve();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            out.close();
        }
    }
    
    void init() throws Exception {
        if (fromFile) {
            in = new BufferedReader(new FileReader(filename+".in"));
            out = new PrintWriter(new FileWriter(filename+".out"));
        } else {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
        }
        sc = new FastScanner(in);
    }
}

class FastScanner {
    
    BufferedReader reader;
    StringTokenizer strTok;
    
    public FastScanner(BufferedReader reader) {
        this.reader = reader;
    }
    
    public String nextToken() throws IOException {
        while (strTok == null || !strTok.hasMoreTokens()) {
            strTok = new StringTokenizer(reader.readLine());
        }
        
        return strTok.nextToken();
    }
    
    public int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }
    
    public long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }
    
    public double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }
    
    public BigInteger nextBigInteger() throws IOException {
        return new BigInteger(nextToken());
    }
    
    public BigDecimal nextBigDecimal() throws IOException {
        return new BigDecimal(nextToken());
    }
}