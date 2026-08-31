import java.util.*;
import java.io.*;

public class E18 {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        int n = sc.nextInt(); int m = sc.nextInt(); int k = sc.nextInt();
        HashSet<Integer> [] adj = new HashSet[n + 1];
        for (int i = 1; i <= n; i++) adj[i] = new HashSet<>();
        int [][] edge = new int[m][2];
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt(); int v = sc.nextInt();
            edge[i][0] = u; edge[i][1] = v;
            adj[u].add(v);
            adj[v].add(u);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x.deg));
        boolean [] processed = new boolean[n + 1];
        int [] in = new int[n + 1];
        int [] deg = new int[n + 1];
        Arrays.fill(in, -1);
        for (int i = 1; i <= n; i++) {
            pq.add(new Pair(i, adj[i].size()));
            deg[i] = adj[i].size();
        }
        int vis = 0;
        while (!pq.isEmpty() && vis < n) {
            Pair next = pq.poll();
            if (processed[next.node]) continue;
            ++vis;
            processed[next.node] = true;
            if (next.deg >= k) {
                in[next.node] = 1;
                continue;
            }
            in[next.node] = 0;
            for (Integer i: adj[next.node]) {
                if (!processed[i]) {
                    deg[i]--;
                    pq.add(new Pair(i, deg[i]));
                }
            }
        }
        int [] ret = new int[m];
        for (int i = 1; i <= n; i++) ret[m - 1] += in[i];
        for (int i = m - 1; i > 0; i--) {
            int u = edge[i][0]; int v = edge[i][1];
            if (in[v] == 1 && in[u] == 1) deg[u]--;
            if (in[v] == 1 && in[u] == 1) deg[v]--;
            pq = new PriorityQueue<>(Comparator.comparingInt(x ->x.deg));
            if (in[u] == 0 || in[v] == 0) {
                ret[i - 1] = ret[i];
                adj[u].remove(v);
                adj[v].remove(u);
                continue;
            }
            if (deg[u] < k) pq.add(new Pair(u, k - 1));
            if (deg[v] < k) pq.add(new Pair(v, k - 1));
            int off = 0;
            while (!pq.isEmpty()) {
                Pair next = pq.poll();
                if (in[next.node] == 0 || next.deg >= k) continue;
                in[next.node] = 0;
                off++;
                for (Integer x : adj[next.node]) {
                    if (in[x] == 1 && !((next.node == u && x == v) || (next.node == v && x == u))) {
                        deg[x]--;
                        pq.add(new Pair(x, deg[x]));
                    }
                }
            }
            adj[u].remove(v);
            adj[v].remove(u);
            ret[i - 1] = ret[i] - off;
        }
        for (int i = 0; i < m; i++) out.println(ret[i]);
        out.close();
    }

    static class Pair {
        int node; int deg;
        Pair(int node, int deg) {
            this.node = node; this.deg = deg;
        }
    }


    //-----------MyScanner class for faster input----------
    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
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

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }


    }

}