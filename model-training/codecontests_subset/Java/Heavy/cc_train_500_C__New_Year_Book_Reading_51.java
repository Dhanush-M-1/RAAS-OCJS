import java.io.*;
import java.util.*;
import java.math.*;


public class Main {
    static BufferedReader in;
    static PrintWriter out;
    static StringTokenizer tok;
    
    
    static void solve() throws Exception {
        int n = nextInt();
        int m = nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; ++i) {
            w[i] = nextInt();
        }
        int[] b = new int[m];
        for (int i = 0; i < m; ++i) {
            b[i] = nextInt() - 1;
        }
        boolean[] used = new boolean[n];
        int[] a = new int[n];
        int x = 0;
        for (int i = 0; i < m; ++i) {
            if (!used[b[i]]) {
                a[x] = b[i];
                ++x;
                used[b[i]] = true;
            }
        }
        int res = 0;
        for (int j = 0; j < m; ++j) {
            int i = 0;
            while (a[i] != b[j]) {
                res += w[a[i]];
                ++i;
            }
            while (i > 0) {
                int tmp = a[i - 1];
                a[i - 1] = a[i];
                a[i] = tmp;
                --i;
            }
        }
        out.println(res);
    }
    
    static long sqr(int x) {
        return (long)x * x;
    }
    
    static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
    
    static long lcm(int a, int b) {
        return (long)a / gcd(a, b) * b;
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
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(new OutputStreamWriter(System.out));
            //in = new BufferedReader(new FileReader("input.in"));
            //out = new PrintWriter(new FileWriter("output.out"));
            solve();
            in.close();
            out.close();
        } catch (Throwable e) {
            e.printStackTrace();
            java.lang.System.exit(1);
        }
    }
}