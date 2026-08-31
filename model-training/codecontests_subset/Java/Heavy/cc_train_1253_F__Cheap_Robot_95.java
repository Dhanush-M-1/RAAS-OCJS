import java.util.*;
import java.io.*;

public class CheapRobot {
    static ArrayList<Edge>[] graph;
    static Edge[] edges;
    static int blsz;
    static int[][] bl;
    static long[][] max;
    static int[] depth;
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        PrintWriter out = new PrintWriter(System.out, false);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        int q = scanner.nextInt();
        graph = new ArrayList[n];
        edges = new Edge[m];
        for(int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            int u = scanner.nextInt()-1;
            int v = scanner.nextInt()-1;
            int w = scanner.nextInt();
            graph[u].add(new Edge(v,u, w));
            graph[v].add(new Edge(u,v, w));
            edges[i] = new Edge(u,v,w);
        }
        long[] dists = new long[n];
        Arrays.fill(dists, Long.MAX_VALUE/3);
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        for(int i = 0; i < k; i++) {
            dists[i] = 0;
            queue.offer(new Edge(i,-1, 0));
        }
        while(!queue.isEmpty()){
            Edge cur = queue.poll();
            if (cur.w != dists[cur.to]) continue;
            for(Edge edge: graph[cur.to]) {
                long nextDist = edge.w + cur.w;
                if (nextDist < dists[edge.to]) {
                    dists[edge.to] = nextDist;
                    queue.offer(new Edge(edge.to, -1,dists[edge.to]));
                }
            }
        }
        DSU dsu = new DSU(n);
        for(Edge edge: edges) { edge.w = edge.w + dists[edge.to] + dists[edge.from]; }
        Arrays.sort(edges);
        for(ArrayList<Edge> list: graph) list.clear();
        int p = 0;
        while(dsu.nSets > 1) {
            Edge e = edges[p];
            if (dsu.union(e.from, e.to)) {
                graph[e.from].add(new Edge(e.to, e.from, e.w));
                graph[e.to].add(new Edge(e.from, e.to, e.w));
            }
            p++;
        }
        ArrayDeque<Integer> qq = new ArrayDeque<>();
        blsz = Integer.numberOfTrailingZeros(Integer.highestOneBit(n));
        bl = new int[blsz + 1][n];
        max = new long[blsz + 1][n];
        depth = new int[n];
        Arrays.fill(depth, -1);
        depth[0] = 0;
        qq.offer(0);
        while(!qq.isEmpty()) {
            int cur = qq.poll();
            for(Edge edge: graph[cur]) {
                if (depth[edge.to] == -1) {
                    depth[edge.to] = depth[cur] + 1;
                    bl[0][edge.to] = cur;
                    max[0][edge.to] = edge.w;
                    qq.offer(edge.to);
                }
            }
        }
        for(int z = 1; z <= blsz; z++) for(int i = 0; i < n; i++){
            bl[z][i] = bl[z-1][bl[z-1][i]];
            max[z][i] = Math.max(max[z-1][i], max[z-1][bl[z-1][i]]);
        }
        while(q-->0) {
            int a = scanner.nextInt()-1;
            int b = scanner.nextInt()-1;
            int l = lca(a,b);
            long m1 = max(a, depth[a] - depth[l]);
            long m2 = max(b, depth[b] - depth[l]);
            out.println(Math.max(m1, m2));
        }
        out.flush();
    }
    static int lca(int u, int v) {
        if (depth[v] < depth[u]) u = walk(u, depth[u] - depth[v]);
        if (depth[u] < depth[v]) v = walk(v, depth[v] - depth[u]);
        if (u == v) return u;
        for(int k = blsz; k >= 0; k--) if (bl[k][u] != bl[k][v]) {
            u = bl[k][u];
            v = bl[k][v];
        }
        return bl[0][v];
    }
    static int walk(int v, int d) {
        for(int k = 0; k <= blsz; k++) {
            if (((1 << k) & d) > 0) v = bl[k][v];
        }
        return v;
    }
    static long max(int v, int d) {
        long m = 0;
        for(int k = 0; k <= blsz; k++) {
            if (((1 << k) & d) > 0) {
                m = Math.max(m, max[k][v]);
                v = bl[k][v];
            }
        }
        return m;
    }
    static class Edge implements Comparable<Edge>{
        int to, from;
        long w;
        public Edge(int tt, int ff, long ww) {
            to = tt; w = ww;from = ff;
        }
        public int compareTo(Edge o) {
            return Long.compare(w, o.w);
        }
    }
    static class DSU {
        int[] rank, parent;
        int nSets;
        public DSU(int ss) {
            rank = new int[ss];
            parent = new int[ss];
            for(int i = 0; i < ss; i++) {
                rank[i] = 1;
                parent[i] = i;
            }
            nSets = ss;
        }
        int find(int a) {
            int p = a;
            while(parent[a] != a) a = parent[a];
            while(parent[p] != a) {
                int t = parent[p];
                parent[p] = a;
                p = t;
            }
            return a;
        }
        boolean union(int a, int b) {
            int pa = find(a);
            int pb = find(b);
            if (pa == pb) return false;
            if(rank[pa] <= rank[pb]) {
                rank[pb] += rank[pa];
                parent[pa] = pb;
            } else {
                rank[pa] += rank[pb];
                parent[pb] = pa;
            }
            nSets--;
            return true;
        }
    }
    public static class FastScanner {
        BufferedReader br;
        StringTokenizer st;
        
        public FastScanner(Reader in) {
            br = new BufferedReader(in);
        }
        
        public FastScanner() {
            this(new InputStreamReader(System.in));
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
        
        String readNextLine() {
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
