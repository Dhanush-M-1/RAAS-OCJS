import java.io.*;
import java.util.*;

public class Main {


    static void solve(long x) {
        int k = (int) Math.sqrt(x);
        for (int i = k; i >= 1; i--) {
            if (x % i == 0) {
                long a = i;
                long b = x / i;
                if (a * b == x * gcd(a, b)) {
                    out.println(a + " " + b);
                    return;
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        long x = nextLong();
        solve(x);
        out.close();
    }

    static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }


    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st = new StringTokenizer("");

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    static long nextLong() throws IOException {
        return Long.parseLong(next());
    }

}
