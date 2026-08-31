//package codeforces;

import java.io.*;
import java.util.*;

public class A {
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

    void solve() throws IOException {
        int n = nextInt();
        int c = nextInt();
        int ans = 0;
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = nextInt();
        }
        for(int i = 0; i < n - 1; i++) {
            ans = Math.max(ans, a[i] - a[i + 1] - c);
        }
        writer.println(ans);
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        new A().solve();
    }
}
