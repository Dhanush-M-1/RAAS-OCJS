import java.io.*;
import java.util.*;

public class Test {

    static int readInt() {
        int ans = 0;
        boolean neg = false;
        try {
            boolean start = false;
            for (int c = 0; (c = System.in.read()) != -1; ) {
                if (c == '-') {
                    start = true;
                    neg = true;
                    continue;
                } else if (c >= '0' && c <= '9') {
                    start = true;
                    ans = ans * 10 + c - '0';
                } else if (start) break;
            }
        } catch (IOException e) {
        }
        return neg ? -ans : ans;
    }

    static long readLong() {
        long ans = 0;
        boolean neg = false;
        try {
            boolean start = false;
            for (int c = 0; (c = System.in.read()) != -1; ) {
                if (c == '-') {
                    start = true;
                    neg = true;
                    continue;
                } else if (c >= '0' && c <= '9') {
                    start = true;
                    ans = ans * 10 + c - '0';
                } else if (start) break;
            }
        } catch (IOException e) {
        }
        return neg ? -ans : ans;
    }

    static String readString() {
        StringBuilder b = new StringBuilder();
        try {
            boolean start = false;
            for (int c = 0; (c = System.in.read()) != -1; ) {
                if (c >= '0' && c <= '9') {
                    start = true;
                    b.append((char) (c));
                } else if (start) break;
            }
        } catch (IOException e) {
        }
        return b.toString().trim();
    }

    static PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    void start() {
        int n = readInt(), m = readInt(), k = readInt();
        int[] ans = new int[m];
        int[] from = new int[m], to = new int[m], deg = new int[n+1];
        boolean[] alive = new boolean[m];
        int[] q = new int[n];
        List<int[]>[] g = new List[n+1];
        for (int i = 1; i <= n; i++) g[i] = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int u = readInt(), v = readInt();
            from[i] = u;
            to[i] = v;
            g[u].add(new int[]{v, i});
            g[v].add(new int[]{u, i});
            alive[i] = true;
        }
        int a = 0, b = 0;
        for (int i = 1; i <= n; i++) {
            deg[i] = g[i].size();
            if (deg[i] < k) q[b++] = i;
        }
        for (int i = m - 1; i >= 0; i--) {
            while (a < b) {
                int u = q[a++];
                for (int[] e : g[u])
                    if (alive[e[1]]) {
                        alive[e[1]] = false;
                        int v = e[0];
                        if (deg[v] == k) q[b++] = v;
                        deg[v]--;
                    }
            }
            ans[i] = n - b;
            if (!alive[i]) continue;
            alive[i] = false;
            int u = from[i], v = to[i];
            for (int x : new int[]{u, v}) {
                if (deg[x] == k) q[b++] = x;
                deg[x]--;
            }
        }
        for (int i = 0; i < m; i++) writer.println(ans[i]);
    }

    public static void main(String[] args) {
        Test te = new Test();
        te.start();
        writer.flush();
    }
}
