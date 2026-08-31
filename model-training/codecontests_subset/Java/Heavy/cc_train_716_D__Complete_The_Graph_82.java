/**
 * @author derrick20
 */
import java.io.*;
import java.util.*;

public class CompleteTheGraph implements Runnable {
    public static void main(String[] args) throws Exception {
        new Thread(null, new CompleteTheGraph(), ": )", 1 << 28).start();
    }

    public void run() {
        FastScanner sc = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int L = sc.nextInt();
        int s = sc.nextInt();
        int t = sc.nextInt();

        boolean[][] toFix = new boolean[N][N];
        adjList = new ArrayList[N];
        Arrays.setAll(adjList, i -> new ArrayList<>());
        ArrayList<Edge> edges = new ArrayList<>();
        ArrayList<Edge> backEdges = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            long wt = sc.nextLong();
            if (wt == 0) {
                wt = 1;
                toFix[u][v] = true;
                toFix[v][u] = true;
            }
            Edge forward = new Edge(i, u, v, wt);
            edges.add(forward);
            adjList[u].add(forward);
            Edge backward = new Edge(i, v, u, wt);
            backEdges.add(backward);
            adjList[v].add(backward);
        }
        long[] distFromT = new long[N];
        Arrays.fill(distFromT, oo);
        dijkstra(distFromT, t);
//        System.out.println(Arrays.toString(distFromT));

        long[] distFromS = new long[N];
        Arrays.fill(distFromS, oo);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(s, 0));
        distFromS[s] = 0; // oops!!
        search: while (pq.size() > 0) {
            Node node = pq.poll();
//            System.out.println("Exploring " + node);
            for (Edge e : adjList[node.id]) {
//                System.out.println(e);
                if (toFix[node.id][e.v]) {
                    // let's see the cost currently:
                    long curr = node.dist + e.wt + distFromT[e.v];
//                    System.out.println("Splits = " + node.dist + " " + e.wt + " " + distFromT[e.v]);
                    if (curr <= L) {
                        // who cares if it's greater
                        long delta = L - curr;
                        edges.get(e.i).wt += delta;
                        // perhaps we travel on a back edge before forwad, the graph could be oriented weirdly
                        backEdges.get(e.i).wt += delta;
                    }
                    // This edge MUST be visited by the shortest path
                    // which is less than L. It couldn't have been visited
                    // and unmodified by a previous pathway (that would
                    // be bad, we would've let a path escape past and
                    // get a distance < L. However, if it did that,
                    // then it would have modified to become L first.)
                    // The other case is if someone visited with a path > L,
                    // in which case it would've broke already, so it works.
                }
                // once we've fixed that edge, we know that this path
                // will have cost >= L.
                // If, in the process of fixing
                long alt = node.dist + e.wt;
                if (alt < distFromS[e.v]) {
                    distFromS[e.v] = alt;
                    pq.add(new Node(e.v, alt));
                }
            }
        }
//        System.out.println(Arrays.toString(distFromS));
        boolean poss = distFromS[t] == L;
        if (poss) {
            out.println("YES");
            for (Edge e : edges) {
                out.println(e.u + " " + e.v + " " + e.wt);
            }
        } else {
            out.println("NO");
        }
        out.close();
    }
    /*
swapping s and t fails!
5 5 13 4 0
0 1 5
2 1 2
3 2 3
1 4 0
4 3 4

     */
    static long oo = (long) 9e18;
    static ArrayList<Edge>[] adjList;

    static void dijkstra(long[] dist, int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start] = 0;
        while (pq.size() > 0) {
            Node node = pq.poll();
            for (Edge e : adjList[node.id]) {
                long alt = node.dist + e.wt;
                if (alt < dist[e.v]) {
                    dist[e.v] = alt;
                    pq.add(new Node(e.v, alt));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int id; long dist;
        public Node(int ii, long dd) {
            id = ii; dist = dd;
        }
        public int compareTo(Node n2) {
            return Long.compare(dist, n2.dist);
        }
        public String toString() {
            return "(" + id + ": " + dist + ")";
        }
    }

    static class Edge {
        int i, u, v; long wt;
        public Edge(int ii, int uu, int vv, long ww) {
            i = ii; u = uu; v = vv; wt = ww;
        }
        public String toString() {
            return "(" + u + " -> " + v + ": " + wt + ")";
        }
    }

    static class FastScanner {
        private int BS = 1 << 16;
        private char NC = (char) 0;
        private byte[] buf = new byte[BS];
        private int bId = 0, size = 0;
        private char c = NC;
        private double cnt = 1;
        private BufferedInputStream in;

        public FastScanner() {
            in = new BufferedInputStream(System.in, BS);
        }

        public FastScanner(String s) {
            try {
                in = new BufferedInputStream(new FileInputStream(new File(s)), BS);
            } catch (Exception e) {
                in = new BufferedInputStream(System.in, BS);
            }
        }

        private char getChar() {
            while (bId == size) {
                try {
                    size = in.read(buf);
                } catch (Exception e) {
                    return NC;
                }
                if (size == -1) return NC;
                bId = 0;
            }
            return (char) buf[bId++];
        }

        public int nextInt() {
            return (int) nextLong();
        }

        public int[] nextInts(int N) {
            int[] res = new int[N];
            for (int i = 0; i < N; i++) {
                res[i] = (int) nextLong();
            }
            return res;
        }

        public long[] nextLongs(int N) {
            long[] res = new long[N];
            for (int i = 0; i < N; i++) {
                res[i] = nextLong();
            }
            return res;
        }

        public long nextLong() {
            cnt = 1;
            boolean neg = false;
            if (c == NC) c = getChar();
            for (; (c < '0' || c > '9'); c = getChar()) {
                if (c == '-') neg = true;
            }
            long res = 0;
            for (; c >= '0' && c <= '9'; c = getChar()) {
                res = (res << 3) + (res << 1) + c - '0';
                cnt *= 10;
            }
            return neg ? -res : res;
        }

        public double nextDouble() {
            double cur = nextLong();
            return c != '.' ? cur : cur + nextLong() / cnt;
        }

        public double[] nextDoubles(int N) {
            double[] res = new double[N];
            for (int i = 0; i < N; i++) {
                res[i] = nextDouble();
            }
            return res;
        }

        public String next() {
            StringBuilder res = new StringBuilder();
            while (c <= 32) c = getChar();
            while (c > 32) {
                res.append(c);
                c = getChar();
            }
            return res.toString();
        }

        public String nextLine() {
            StringBuilder res = new StringBuilder();
            while (c <= 32) c = getChar();
            while (c != '\n') {
                res.append(c);
                c = getChar();
            }
            return res.toString();
        }

        public boolean hasNext() {
            if (c > 32) return true;
            while (true) {
                c = getChar();
                if (c == NC) return false;
                else if (c > 32) return true;
            }
        }
    }

    static void ASSERT(boolean assertion, String message) {
        if (!assertion) throw new AssertionError(message);
    }

    static void ASSERT(boolean assertion) {
        if (!assertion) throw new AssertionError();
    }
}