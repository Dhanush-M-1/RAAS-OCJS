import com.sun.org.apache.xalan.internal.xslt.Process;

import java.io.*;
import java.util.*;

public class main {
    public static void main(String[] args) throws IOException {
        init();//"prizes.in", "prizes.out");
        int q = nextInt();
        for (int i = 0; i < q; i++) {
            long l = nextLong();
            long r = nextLong();
            long d = nextLong();
            long minRight = 0;
            long minLeft = 0;
            if (r % d == 0) {
                minRight = r + d;
            } else if (r % d != 0) {
                if (d > r) {
                    minRight = d;
                } else {
                    minRight = r + d - (r % d);
                }
            }
            if (d > l) {
                minLeft = -1;
            } else {
                if (l % d == 0) {
                    if (l / d <= 1) minLeft = -1;
                    else minLeft = l - d * (l / d - 1);
                } else {
                    minLeft = l - (l % d) - d * (l / d - 1);
                }
            }
            if (minLeft != -1) pw.println(minLeft);
            else pw.println(minRight);
        }
        pw.close();
    }

    static StringTokenizer st;
    static BufferedReader sc;
    static PrintWriter pw;

    static String next() throws IOException {
        while (st == null || !st.hasMoreElements()) {
            st = new StringTokenizer(sc.readLine());
        }
        return st.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    static long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    static void init(String in, String out) throws IOException {
        sc = new BufferedReader(new FileReader(in));
        pw = new PrintWriter(out);
    }

    static void init() {
        sc = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(System.out);
    }
}

class DSU {
    int parent[];
    public DSU(int n){
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    int get(int i){
        if (i == parent[i]){
            return i;
        }
        int p = get(parent[i]);
        parent[i] = p;
        return p;
    }

    boolean union(int a, int b){
        a = get(a);
        b = get(b);
        if (a == b) return false;
        parent[a] = b;
        return true;
    }
}