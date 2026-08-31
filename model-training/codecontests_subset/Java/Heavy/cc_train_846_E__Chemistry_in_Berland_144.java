import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FastScanner in = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        new Main().run(in, out);
        out.close();
    }

    public static long mod = 17352642619633L;

    int N;
    long[] a;
    long[] b;
    List<Edge>[] adj;

    void run(FastScanner in, PrintWriter out) {
        N = in.nextInt();
        a = new long[N];
        b = new long[N];
        for (int i = 0; i < N; i++) b[i] = in.nextLong();
        for (int i = 0; i < N; i++) a[i] = in.nextLong();

        adj = new List[N+1];
        int[] deg = new int[N+1];
        for (int i = 0; i < N; i++) adj[i] = new ArrayList<>();
        for (int i = 1; i < N; i++) {
            int u = in.nextInt()-1;
            long k = in.nextLong();
            int v = i;
            adj[u].add(new Edge(v, k));
            deg[v]++;
        }

        int root = 0;
        for (int i = 0; i < N; i++) {
            if (deg[i] == 0) root = i;
        }

        double bal = dfs(root);
        if (bal >= 0) {
            out.println("YES");
        } else {
            out.println("NO");
        }


    }

    double dfs(int u) {

        double bal = b[u];
        for (Edge e : adj[u]) {
            double ret = dfs(e.v);
            if (ret >= 0) bal += ret;
            else bal += e.k * ret;
            if (bal < Long.MIN_VALUE) return bal;
        }
        bal -= a[u];
        return bal;
    }



    class Edge {
        int v;
        long k;
        Edge(int v, long k) {
            this.v = v;
            this.k = k;
        }
    }


    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(InputStream in) {
            br = new BufferedReader(new InputStreamReader(in));
            st = null;
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
