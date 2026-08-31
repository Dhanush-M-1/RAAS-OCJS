import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class Main {

    static class Pair {

        long x;
        int i;

        public Pair (long x, int i) {
            this.x = x;
            this.i = i;
        }
    }

    static long[] s, a, add;
    static Pair[] t;
    static int N = 1;
    static long INF = Long.MAX_VALUE / 10;

    static void build() {
        for (int i = 0; i < N; i++) {
            t[i + N] = new Pair(s[i], i);
        }
        for (int i = N - 1; i >= 1; i--) {
            if (t[i * 2].x >= t[i * 2 + 1].x) {
                t[i] = new Pair(t[i * 2 + 1].x, t[i * 2 + 1].i);
            } else {
                t[i] = new Pair(t[i * 2].x, t[i * 2].i);
            }
        }
    }

    static Pair min() {
        return min(1, 0, N, 0, N);
    }

    static Pair min(int v, int vl, int vr, int ql, int qr) {
        if (vl >= qr || vr <= ql) {
            return new Pair(INF, -1);
        }
        push(v);
        if (vl >= ql && vr <= qr) {
            return t[v];
        }
        Pair o1 = min(v * 2, vl, (vl + vr) / 2, ql, qr);
        Pair o2 = min(v * 2 + 1, (vl + vr) / 2, vr, ql, qr);
        if (o1.x < o2.x) {
            return new Pair(o1.x, o1.i);
        }
        return new Pair(o2.x, o2.i);
    }

    static void push(int v) {
        t[v].x += add[v];
        add[v * 2] += add[v];
        add[v * 2 + 1] += add[v];
        add[v] = 0;
    }

    static void update(int l, int r, long value) {
        update(1, 0, N, l, r, value);
    }

    static void update(int v, int vl, int vr, int ql, int qr, long value) {
        if (vl >= qr || vr <= ql) {
            return;
        }
        push(v);
        if (vl >= ql && vr <= qr) {
            add[v] -= value;
            return;
        }
        update(v * 2, vl, (vl + vr) / 2, ql, qr, value);
        update(v * 2 + 1, (vl + vr) / 2, vr, ql, qr, value);
        push(v * 2);
        push(v * 2 + 1);
        if (t[v * 2].x >= t[v * 2 + 1].x) {
            t[v] = new Pair(t[v * 2 + 1].x, t[v * 2 + 1].i);
        } else {
            t[v] = new Pair(t[v * 2].x, t[v * 2].i);
        }
    }

    public static void main(String[] args) throws IOException{
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        while (N * 2 < n) N *= 2;
        N *= 2;
        s = new long[N];
        t = new Pair[4 * N];
        a = new long[N];
        add = new long[4 * N];
        Arrays.fill(s, INF);


        for (int i = 0; i < n; i++) {
            s[i] = scan.nextLong();
        }
        build();

        long value = 1;
        while (value <= n) {
            Pair right = min();
            a[right.i] = value;
            update(right.i, right.i + 1, - INF);
            update(right.i + 1, N, value);
            value++;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }
}