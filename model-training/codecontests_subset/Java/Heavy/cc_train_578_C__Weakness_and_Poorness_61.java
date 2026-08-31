//package codeforces;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class A implements Closeable {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

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

    double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    private int MOD = 1000 * 1000 * 1000 + 7;

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
        final int n = nextInt();
        final int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = nextInt();
        }
        double lo = -10000, hi = -lo;
        class Utils {
            double poverty(double x) {
                double min = 0, max = 0, sum = 0;
                double result = 0;
                for (int xa : a) {
                    sum += xa - x;
                    result = Math.max(result, Math.max(Math.abs(sum - min), Math.abs(sum - max)));
                    max = Math.max(max, sum);
                    min = Math.min(min, sum);
                }
                return result;
            }
        }
        Utils utils = new Utils();
        for(int k = 0; k < 100; k++) {
            double dx = (hi - lo) / 3.;
            double x1 = lo + dx;
            double x2 = x1 + dx;
            double r1 = utils.poverty(x1);
            double r2 = utils.poverty(x2);
            if(r1 > r2) {
                lo = x1;
            } else {
                hi = x2;
            }
        }
        writer.printf("%.10f\n", utils.poverty(0.5 * (lo + hi)));
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
