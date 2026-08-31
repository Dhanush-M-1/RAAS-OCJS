//package Codeforces.CF731;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C {

    static final long mod = (long) 1e9 + 7l;

    private static void solve(int t) {
        int k = fs.nextInt();
        int n = fs.nextInt(), m = fs.nextInt();
        int mono[] = fs.readArray(n);
        int poly[] = fs.readArray(m);
        int large = Integer.MIN_VALUE;
        int lines = k;
        int mo = 0, po = 0;
        int res[] = new int[m + n];
        int idx = 0;
        while (mo < mono.length && po < poly.length) {
            if (lines >= mono[mo] && lines >= poly[po]) {
                if (mono[mo] == 0) lines++;
                if (poly[po] == 0) lines++;
                res[idx++] = mono[mo++];
                res[idx++] = poly[po++];
                continue;
            }
            if (lines >= mono[mo]) {
                if (mono[mo] == 0) lines++;
                res[idx++] = mono[mo++];
                continue;
            }
            if (lines >= poly[po]) {
                if (poly[po] == 0) lines++;
                res[idx++] = poly[po++];
                continue;
            }
            System.out.println(-1);
            return;
        }
        while (idx < res.length) {
            while (mo < mono.length) {
                if (lines >= mono[mo]) {
                    if (mono[mo] == 0) lines++;
                    res[idx++] = mono[mo++];
                    continue;
                } else {
                    System.out.println(-1);
                    return;
                }
            }
            while (po < poly.length) {
                if (lines >= poly[po]) {
                    if (poly[po] == 0) lines++;
                    res[idx++] = poly[po++];
                    continue;
                } else {
                    System.out.println(-1);
                    return;
                }
            }

        }
        for (int i = 0; i < m + n; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();

    }


    public static void main(String[] args) {
        fs = new FastScanner();
        out = new PrintWriter(System.out);
        long s = System.currentTimeMillis();
        int t = fs.nextInt();
        for (int i = 1; i <= t; i++) solve(t);
        out.close();
//        System.err.println( System.currentTimeMillis() - s + "ms" );
    }

    static boolean DEBUG = true;
    static PrintWriter out;
    static FastScanner fs;

    static void trace(Object... o) {
        if (!DEBUG) return;
        System.err.println(Arrays.deepToString(o));
    }

    static void pl(Object o) {
        out.println(o);
    }

    static void p(Object o) {
        out.print(o);
    }

    static long gcd(long a, long b) {
        return (b == 0) ? a : gcd(b, a % b);
    }

    static int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }

    static void sieveOfEratosthenes(int n, int factors[]) {
        factors[1] = 1;
        for (int p = 2; p * p <= n; p++) {
            if (factors[p] == 0) {
                factors[p] = p;
                for (int i = p * p; i <= n; i += p)
                    factors[i] = p;
            }
        }
    }

    static long mul(long a, long b) {
        return a * b % mod;
    }

    static long fact(int x) {
        long ans = 1;
        for (int i = 2; i <= x; i++) ans = mul(ans, i);
        return ans;
    }

    static long fastPow(long base, long exp) {
        if (exp == 0) return 1;
        long half = fastPow(base, exp / 2);
        if (exp % 2 == 0) return mul(half, half);
        return mul(half, mul(half, base));
    }

    static long modInv(long x) {
        return fastPow(x, mod - 2);
    }

    static long nCk(int n, int k) {
        return mul(fact(n), mul(modInv(fact(k)), modInv(fact(n - k))));
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        public String next() {
            while (!st.hasMoreElements())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
