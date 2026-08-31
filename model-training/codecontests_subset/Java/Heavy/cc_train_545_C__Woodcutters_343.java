import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class a {
    public static class node implements Comparable<node> {
        int index;
        int val;
        int r;

        node(int index, int val, int r) {
            this.index = index;
            this.r = r;
            this.val = val;
        }

        @Override
        public int compareTo(node o) {
            if (o.val < val)
                return 1;
            else if (o.val > val)
                return -1;
            else if (o.index < index)
                return 1;
            else
                return -1;
        }

    }

    public static long gcd(long a, long b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static ArrayList<Integer> prime;

    public static void sieve(int n) {
        boolean vis[] = new boolean[n + 5];
        vis[1] = true;
        vis[0] = true;
        for (int i = 2; i <= n; i++) {
            if (!vis[i]) {
                prime.add(i);
                for (long j = (long) i * (long) i; j <= n; j += i) {
                    vis[(int) j] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader in = new BufferedReader(new FileReader(
        // "B-small-attempt0.in"));

        StringBuilder q = new StringBuilder();
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        // PrintWriter out = new PrintWriter(new FileWriter("out.txt"));

        int n = Integer.parseInt(in.readLine());

        int x[] = new int[n];
        int h[] = new int[n];
        for (int i = 0; i < n; i++) {
            String y[] = in.readLine().split(" ");
            x[i] = Integer.parseInt(y[0]);
            h[i] = Integer.parseInt(y[1]);
        }
        int ans = 1;
        int max = x[0];
        for (int i = 1; i < n - 1; i++) {
            int one = x[i] - h[i];
            int two = x[i] + h[i];
            if (one > max) {
                ans++;
                max = x[i];
            } else if (two < x[i + 1]) {
                ans++;
                max = two;
            } else {
                max = x[i];
            }

        }
        if (n != 1)
            ans++;
        System.out.println(ans);

        out.close();
    }
}
