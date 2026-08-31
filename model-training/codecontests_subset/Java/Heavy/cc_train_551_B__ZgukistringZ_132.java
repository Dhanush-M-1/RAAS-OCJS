//package codeforces;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class B implements Closeable {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter writer = new PrintWriter(System.out);
    StringTokenizer stringTokenizer;

    B() throws IOException {
//        reader = new BufferedReader(new FileReader("input.txt"));
//        writer = new PrintWriter(new FileWriter("output.txt"));
    }

    String next() throws IOException {
        while (stringTokenizer == null || !stringTokenizer.hasMoreTokens()) {
            stringTokenizer = new StringTokenizer(reader.readLine());
        }
        return stringTokenizer.nextToken();
    }

    int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    final int MOD = 1000 * 1000 * 1000 + 7;

    int sum(int a, int b) {
        a += b;
        return a >= MOD ? a - MOD : a;
    }

    int product(int a, int b) {
        return (int) (1l * a * b % MOD);
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

    @SuppressWarnings("unchecked")
    void solve() throws IOException {
        int[][] f = new int[3][26];
        String[] s = new String[3];
        for(int i = 0; i < 3; i++) {
            s[i] = next();
            for (char c : s[i].toCharArray()) {
                f[i][c - 'a']++;
            }
        }
        int[] a = f[0];
        int[] b = f[1];
        int[] c = f[2];
        int qb = 0, qc = 0;
        for(int i = 0; i <= 100 * 1000; i++) {
            boolean ok = true;
            for(int j = 0; j < 26; j++) {
                if(i * b[j] > a[j]) {
                    ok = false;
                    break;
                }
            }
            if(!ok) {
                break;
            }
            int q = Integer.MAX_VALUE;
            for(int j = 0; j < 26; j++) {
                if(c[j] > 0) {
                    q = Math.min(q, (a[j] - i * b[j]) / c[j]);
                }
            }
            if(i + q > qb + qc) {
                qb = i;
                qc = q;
            }
        }
        StringBuilder sb = new StringBuilder(s[0].length());
        for(int i = 0; i < qb; i++) {
            sb.append(s[1]);
        }
        for(int i = 0; i < qc; i++) {
            sb.append(s[2]);
        }
        for(int i = 0; i < 26; i++) {
            a[i] -= qb * b[i];
            a[i] -= qc * c[i];
            for(int j = 0; j < a[i]; j++) {
                sb.append((char)('a' + i));
            }
        }
        writer.println(sb);
    }

    public static void main(String[] args) throws IOException {
        try (B b = new B()) {
            b.solve();
        }
    }

    @Override
    public void close() throws IOException {
        reader.close();
        writer.close();
    }
}