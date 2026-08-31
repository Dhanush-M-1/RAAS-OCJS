import java.io.*;
import java.util.*;

import static java.lang.Math.min;

public class Solution {

    BufferedReader in;
    PrintWriter out;
    StringTokenizer tok;

    void init() {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        tok = new StringTokenizer("");
    }

    String readString() throws IOException {
        while (!tok.hasMoreTokens()) {
            tok = new StringTokenizer(in.readLine());
        }
        return tok.nextToken();
    }

    int readInt() throws IOException {
        return Integer.parseInt(readString());
    }

    long readLong() throws IOException {
        return Long.parseLong(readString());
    }

    void run() throws IOException {
        init();
        solve();
        out.flush();
    }

    public static void main(String[] args) throws IOException {
        new Solution().run();
    }

    static class Rat implements Comparable<Rat> {
        int num, den;

        @Override
        public int compareTo(Rat o) {
            return num * o.den - den * o.num;
        }
    }

    boolean[] p;

    long solve(int x, int r) {
        return r / x;
    }

    void solve() throws IOException {
        int l = readInt();
        int r = readInt();
        p = new boolean[100000];
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i < 100000; i++) {
            if (p[i] == false && 1L * i * i < 100000) {
                primes.add(i);
                for (int j = i * i; j < 100000; j++) {
                    p[j] = true;
                }
            }
        }
        long ans = 0;
        int pr = 0;
        for (int i = 2; i * i <= l; i++) {
            if (l % i == 0) {
                ans = 1;
                pr = i;
                break;
            }
        }
        if (ans == 0) {
            ans = 1;
            pr = l;
        }

        for (int x : primes) {
            long currAns = solve(x, r) - solve(x, l - 1);
            if (currAns > ans) {
                ans = currAns;
                pr = x;
            }
        }
        out.print(pr);
    }
}
