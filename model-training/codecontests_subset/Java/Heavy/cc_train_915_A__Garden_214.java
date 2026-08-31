import java.lang.*;
import java.io.*;
import java.util.*;
import java.math.*;
import java.net.*;

import static java.lang.Math.*;

public class Solution implements Runnable {
    
    void solve() throws Exception {
        int n = sc.nextInt();
        int k = sc.nextInt();
        int ans = k;
        while (n-- > 0) {
            int x = sc.nextInt();
            if (k % x == 0) {
                ans = min(ans, k / x);
            }
        }
        out.println(ans);
    }

    BufferedReader in;
    PrintWriter out;
    FastScanner sc;

    final String INPUT_FILE = "";
    final String OUTPUT_FILE = "";

    static Throwable throwable;

    public static void main(String[] args) throws Throwable {
        Thread thread = new Thread(null, new Solution(), "", (1 << 26));
        thread.start();
        thread.join();
        thread.run();
        if (Solution.throwable != null)
            throw Solution.throwable;
    }

    public void run() {
        try {
            if (INPUT_FILE.equals("")) {
                in = new BufferedReader(new InputStreamReader(System.in));
            } else {
                in = new BufferedReader(new FileReader(INPUT_FILE));
            }
            if (OUTPUT_FILE.equals("")) {
                out = new PrintWriter(System.out);
            } else {
                out = new PrintWriter(OUTPUT_FILE);
            }
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
        while (strTok == null || !strTok.hasMoreTokens()) {
            strTok = new StringTokenizer(reader.readLine());
        }
        return strTok.nextToken();
    }

    public int nextInt() throws Exception {
        return Integer.parseInt(nextToken());
    }

    public double nextDouble() throws Exception {
        return Double.parseDouble(nextToken());
    }

    public long nextLong() throws Exception {
        return Long.parseLong(nextToken());
    }
}