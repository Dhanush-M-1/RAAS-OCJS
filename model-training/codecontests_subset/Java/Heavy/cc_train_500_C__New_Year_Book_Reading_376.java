//package codeforces;

        import java.io.*;
        import java.nio.charset.CharsetEncoder;
        import java.util.*;

public class C {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter writer = new PrintWriter(System.out);
    StringTokenizer stringTokenizer;

    C() throws IOException {
//        reader = new BufferedReader(new FileReader("bridges.in"));
//        writer = new PrintWriter(new FileWriter("bridges.out"));
    }

    String next() throws IOException {
        while (stringTokenizer == null || !stringTokenizer.hasMoreTokens()) {
            stringTokenizer = new StringTokenizer(reader.readLine());
        }
        return stringTokenizer.nextToken();
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    final int MOD = 1000 * 1000 * 1000 + 7;

    int sum(int a, int b) {
        a += b;
        return a >= MOD ? a - MOD : a;
    }

    int product(int a, int b) {
        return (int) (1l * a * b % MOD);
    }

    int pow(int x, int k) {
        int result = 1;
        while (k > 0) {
            if (k % 2 == 1) {
                result = product(result, x);
            }
            x = product(x, x);
            k /= 2;
        }
        return result;
    }

    int inv(int x) {
        return pow(x, MOD - 2);
    }

    void solve() throws IOException {
        int n = nextInt(), m = nextInt();
        int[] w = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            w[i] = nextInt();
        }
        int[] a = new int[m];
        int ans = 0;
        boolean[] take = new boolean[n + 1];
        for(int i = 0; i < m; i++) {
            a[i] = nextInt();
            Arrays.fill(take, false);
            for(int j = i - 1; j >= 0 && a[j] != a[i]; j--) {
                take[a[j]] = true;
            }
            for(int j = 1; j <= n; j++) {
                if(take[j]) {
                    ans += w[j];
                }
            }
        }
        writer.println(ans);
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        new C().solve();
    }
}
