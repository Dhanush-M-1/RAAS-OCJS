// #pragma GCC optimize("Ofast")
// #pragma GCC target("sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,tune=native")

import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class Main {
    static int infi = Integer.MAX_VALUE / 2, mod = (int) (1e9 + 7), maxn = (int) 1e5;
    static long infl = Long.MAX_VALUE / 2;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        int n = nextInt();
        int[] a = new int[n];
        long sum = 0;
        long max = 0;
        for (int i = 0; i < n; i++) {
            a[i] = nextInt();
            sum += a[i];
            max = max(max, a[i]);
        }
        out.print(max(sum / (n - 1) + (sum % (n - 1) == 0 ? 0 : 1), max));
        out.close();
    }

    static BufferedReader br;
    static StringTokenizer st = new StringTokenizer("");
    static PrintWriter out;

    static String next() throws IOException {
        while (!st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    static long nextLong() throws IOException {
        return Long.parseLong(next());
    }

}

class f {
    int x, y;

    public f(int x, int y) {
        this.x = x;
        this.y = y;
    }
}