//package codeforces;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.StringTokenizer;

public class C implements Closeable {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter writer = new PrintWriter(System.out);
    StringTokenizer stringTokenizer;

    C() throws IOException {
//        reader = new BufferedReader(new FileReader("input.txt"));
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

    int pow(int x, long k) {
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
        final int n = nextInt();
        final int[] x = new int[n];
        final int[] h = new int[n];
        for(int i = 0; i < n; i++) {
            x[i] = nextInt();
            h[i] = nextInt();
        }
        class Utils {
            int maxChopDown(int i, int p) {
                if(i == n - 1) {
                    return 1;
                }
                if(i == 0) {
                    return 1 + maxChopDown(i + 1, 0);
                }
                int left = x[i] - x[i - 1] - p * h[i - 1];
                if(left > h[i]) {
                    return 1 + maxChopDown(i + 1, 0);
                }
                int ret = maxChopDown(i + 1, 0);
                if(x[i + 1] - x[i] > h[i]) {
                    ret = Math.max(ret, 1 + maxChopDown(i + 1, 1));
                }
                return ret;
            }
        }
        class CachedUtils extends Utils {
            int[][] cache = new int[n][2];
            boolean[][] hit = new boolean[n][2];

            @Override
            int maxChopDown(int i, int p) {
                if(hit[i][p]) {
                    return cache[i][p];
                }
                hit[i][p] = true;
                cache[i][p] = super.maxChopDown(i, p);
                return cache[i][p];
            }
        }
        writer.println(new CachedUtils().maxChopDown(0, 0));
    }

    public static void main(String[] args) throws IOException {
        try (C c = new C()) {
            c.solve();
        }
    }

    @Override
    public void close() throws IOException {
        reader.close();
        writer.close();
    }
}
