//package codeforces;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class A implements Closeable {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter writer = new PrintWriter(System.out);

    A() throws IOException {
//        reader = new BufferedReader(new FileReader("input.txt"));
//        writer = new PrintWriter(new FileWriter("output.txt"));
    }

    StringTokenizer stringTokenizer;

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
        int n = nextInt();
        char[] a = next().toCharArray();
        for(int i = 0; i < n; i++) {
            for(int l = 1; i + 4 * l < n; l++) {
                boolean ok = true;
                for(int j = 0; j < 5; j++) {
                    if(a[i + j * l] == '.') {
                        ok = false;
                    }
                }
                if(ok) {
                    writer.println("yes");
                    return;
                }
            }
        }
        writer.println("no");
    }

    public static void main(String[] args) throws IOException {
        try (A a = new A()) {
            a.solve();
        }
    }

    @Override
    public void close() throws IOException {
        reader.close();
        writer.close();
    }
}
