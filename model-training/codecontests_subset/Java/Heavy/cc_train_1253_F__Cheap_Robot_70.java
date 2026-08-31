import com.sun.javafx.geom.Edge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class D {
    static ArrayList<Edge>[] adj;
    static HashSet<Integer>[] connected;
    static int n, m, k, q;
    static long[] minDist, query;
    static long INF = Long.MAX_VALUE/100;
    static int[] parent, size;

    public static void main(String[] args) {
        FastReader scan = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        n = scan.nextInt();
        m = scan.nextInt();
        k = scan.nextInt();
        q = scan.nextInt();
        adj = new ArrayList[n];
        minDist = new long[n];
        parent = new int[n];
        size = new int[n];
        connected = new HashSet[n];
        query = new long[q];
        ArrayList<Edge> recalculated = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
            parent[i] = i;
            size[i] = 1;
            connected[i] = new HashSet<Integer>();
            if(i >= k) minDist[i] = INF;
        }
        for(int i = 0; i < m; i++) {
            int a = scan.nextInt()-1, b = scan.nextInt()-1, c = scan.nextInt();
            adj[a].add(new Edge(a, b, c));
            adj[b].add(new Edge(b, a, c));
            recalculated.add(new Edge(a, b, c));
        }
        dijkstra();
        for(Edge e : recalculated) e.weight += minDist[e.from] + minDist[e.to];
        for(int i = 0; i < q; i++) {
            int a = scan.nextInt()-1, b = scan.nextInt()-1;
            connected[a].add(i);
            connected[b].add(i);
        }
        Collections.sort(recalculated);
        for(Edge e : recalculated) {
            unite(e.from, e.to, e.weight);
        }
        for(long i : query) out.println(i);
        out.close();
    }

    static int root(int at) {
        return at == parent[at] ? at : root(parent[at]);
    }

    static void unite(int a, int b, long currWeight) {
        int ra = root(a), rb = root(b);
        if(ra == rb) return;
        if(size[rb] > size[ra]) {
            int temp = ra;
            ra = rb;
            rb = temp;
        }
        size[ra] += size[rb];
        parent[rb] = ra;
        for(int have : connected[rb]) {
            if(connected[ra].contains(have)) {
                query[have] = currWeight;
                connected[ra].remove(have);
            }
            else connected[ra].add(have);
        }
        connected[rb].clear();
    }
    

    static void dijkstra() {
        boolean[] visited = new boolean[n];
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        for(int i = 0; i < k; i++) queue.add(new Edge(-1, i, 0));
        while(!queue.isEmpty()) {
            Edge curr = queue.poll();
            if(visited[curr.to]) continue;
            visited[curr.to] = true;
            for(Edge e : adj[curr.to]) {
                if(visited[e.to]) continue;
                if(minDist[e.to] > curr.weight + e.weight) {
                    minDist[e.to] = curr.weight + e.weight;
                    queue.add(new Edge(-1, e.to, minDist[e.to]));
                }
            }
        }
    }

    static class Edge implements Comparable<Edge> {
        int from, to;
        long weight;
        public Edge(int a, int b, long c) {
            from = a;
            to = b;
            weight = c;
        }
        @Override
        public int compareTo(Edge o) {
            return Long.compare(weight, o.weight);
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
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
