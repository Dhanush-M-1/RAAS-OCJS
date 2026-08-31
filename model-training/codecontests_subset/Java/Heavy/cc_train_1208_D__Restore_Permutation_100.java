/*
Code for task B by detestmaths
 */


import java.io.*;
import java.util.*;

import static java.lang.Math.*;


public class Solver {
    public static void main(String[] args) throws IOException {
        FastScanner in = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        // FastScanner in = new FastScanner("search.in");
        //PrintWriter out = new PrintWriter("search.out");
        int n = in.nextInt();
        long s[] = new long[n];
        for (int i = 0; i < n; i++) {
            s[i] = in.nextLong();
        }
        segment_tree st = new segment_tree(s);
        int ans[] = new int[n];
        for (int i = 1; i < n + 1; i++) {
            pair p = st.get(0, n - 1);
            int ind = p.ind;
            ans[ind] = i;
            st.add(ind, ind, 1000000000000000000L);
            st.add(ind + 1, n - 1, -i);
        }
        for (int i = 0; i < n; i++) {
            out.print(ans[i] + " ");
        }
        out.close();
    }
}

class segment_tree {
    long min[];
    int id[];
    long a[];
    long sum[];

    segment_tree(long a[]) {
        this.a = a;
        int n = a.length;
        min = new long[4 * n];
        sum = new long[4 * n];
        id = new int[4 * n];
        build(1, 0, n - 1);
    }

    void build(int v, int l, int r) {
        if (l == r) {
            min[v] = a[l];
            id[v] = l;
            return;
        }
        int m = ((l + r) >> 1);
        build(v * 2, l, m);
        build(v * 2 + 1, m + 1, r);
        if (min[v * 2] < min[v * 2 + 1]){
            min[v] = min[v*2];
            id[v] = id[v * 2];
        }else if(min[v*2+1] < min[v*2]){
            min[v] = min[v*2+1];
            id[v] = id[v*2+1];
        }else{
            min[v] = min[v*2];
            id[v] = max(id[v*2],id[v*2+1]);
        }
    }

    void push(int v) {
        min[v] += sum[v];
        sum[v * 2] += sum[v];
        sum[v * 2 + 1] += sum[v];
        sum[v] = 0;
    }

    void upd(int v) {
        long p1 = get_el(v * 2);
        long p2 = get_el(v * 2 + 1);
        if (p1 < p2) {
            min[v] = p1;
            id[v] = id[v * 2];
        } else if (p1 > p2) {
            min[v] = p2;
            id[v] = id[v * 2 + 1];
        } else {
            min[v] = p1;
            id[v] = max(id[v * 2], id[v * 2 + 1]);
        }
    }

    long get_el(int v) {
        return min[v] + sum[v];
    }

    void add(int l, int r, long x) {
        add(1, 0, a.length - 1, l, r, x);
    }

    void add(int v, int l, int r, int left, int right, long x) {
        if (l > right || r < left) return;
        if (l >= left && r <= right) {
            sum[v] += x;
            return;
        }
        push(v);
        int m = ((l + r) >> 1);

        add(v * 2, l, m, left, right, x);
        add(v * 2 + 1, m + 1, r, left, right, x);

        upd(v);
    }

    pair get(int l, int r) {
        return get(1, 0, a.length - 1, l, r);
    }

    pair combine(pair a, pair b) {
        if (a.min < b.min) return a;
        if (b.min < a.min) return b;
        return new pair(a.min, max(a.ind, b.ind));
    }

    pair get(int v, int l, int r, int left, int right) {
        if (l > right || r < left) return new pair((long) 1e10, -1);
        if (l >= left && r <= right) {
            return new pair(get_el(v), id[v]);
        }
        push(v);
        int m = ((l + r) >> 1);
        pair p1 = get(v * 2, l, m, left, right);
        pair p2 = get(v * 2 + 1, m + 1, r, left, right);
        pair q = combine(p1, p2);
        upd(v);
        return q;
    }

}

class pair {
    long min;
    int ind;

    public pair(long min, int ind) {
        this.min = min;
        this.ind = ind;
    }
}

class FastScanner {
    BufferedReader br;
    StringTokenizer st = new StringTokenizer("");

    public FastScanner(InputStream s) {
        br = new BufferedReader(new InputStreamReader(s));
    }

    public FastScanner(String s) throws FileNotFoundException {
        br = new BufferedReader(new FileReader(new File(s)));
    }

    public String next() throws IOException {
        if (!st.hasMoreTokens())
            st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }

    public int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    public long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    public double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }
}
