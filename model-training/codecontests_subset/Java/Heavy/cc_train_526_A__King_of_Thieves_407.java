import java.io.*;
import java.util.*;
import java.math.*;


public class Main implements Runnable {
    static BufferedReader in;
    static PrintWriter out;
    static StringTokenizer tok;
    
    
    static void solve() throws Exception {
        int n = nextInt();
        String s = next();
        for (int len = 1; len <= n; ++len) {
            for (int i = 0; i < n; ++i) {
                if (s.charAt(i) == '*') {
                    boolean ok = true;
                    for (int j = 1; j <= 4; ++j) {
                        if (i + len * j >= n || s.charAt(i + len * j) == '.') {
                            ok = false;
                            break;
                        }
                    }
                    if (ok) {
                        out.println("yes");
                        return;
                    }
                }
            }
        }
        out.println("no");
    }
    
    static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    static long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    static BigInteger nextBigInteger() throws IOException {
        return new BigInteger(next());
    }
    
    static String next() throws IOException {
        while (tok == null || !tok.hasMoreTokens()) {
            tok = new StringTokenizer(in.readLine());
        }
        return tok.nextToken();
    }
    
    static String nextLine() throws IOException {
        tok = new StringTokenizer("");
        return in.readLine();
    }

    static boolean hasNext() throws IOException {
        while (tok == null || !tok.hasMoreTokens()) {
            String s = in.readLine();
            if (s == null) {
                return false;
            }
            tok = new StringTokenizer(s);
        }
        return true;
    }
    
    public static void main(String args[]) {
        new Thread(null, new Main(), "Main", 1 << 28).start();
    }
    
    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(new OutputStreamWriter(System.out));
            //in = new BufferedReader(new FileReader("input.in"));
            //out = new PrintWriter(new FileWriter("output.out"));
            Locale.setDefault(Locale.US);
            solve();
            in.close();
            out.close();
        } catch (Throwable e) {
            e.printStackTrace();
            java.lang.System.exit(1);
        }
    }
}