/**
 * @author derrick20
 */

import java.io.*;
import java.util.*;

public class CompleteTheGraphFast implements Runnable {
    public static void main(String[] args) throws Exception {
        new Thread(null, new CompleteTheGraphFast(), ": )", 1 << 28).start();
    }

    public void run() {
        FastScanner sc = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        N = sc.nextInt();
        M = sc.nextInt();
        L = sc.nextInt();
        s = sc.nextInt();
        t = sc.nextInt();

        toFix = new boolean[N][N];
        adjList = new ArrayList[N];
        Arrays.setAll(adjList, i -> new ArrayList<>());
        edges = new ArrayList<>();
        all = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            long wt = sc.nextLong();
            if (wt == 0) {
                wt = 1;
                toFix[u][v] = true;
                toFix[v][u] = true;
                all.add(i);
            }
            Edge forward = new Edge(i, u, v, wt);
            edges.add(forward);
            adjList[u].add(forward);
            Edge backward = new Edge(i, v, u, wt);
            adjList[v].add(backward);
        }

        /*
        in fact, there are only two conditions for it to fail. Otherwise,
        we can ALWAYS construct it.
        1. (There exists) constant paths are always good < L, so we can't do anything.
            - check this by making the toFix edges oo weight
        2. (For all) all variable paths are already > L, so nothing will fix it.
            - check this by doing dijkstra from each end, then seeing for
            each edge to fix, if there exists a path that contains it
            and has total cost <= L.

        To invalidate those, we need to show that for all constant paths, it's bad >= L
        and that there exists some path with <= L.
         */

        // part 1
        long[] constDist = new long[N];
        boolean poss = checkConstant(constDist, s, new HashSet<>(all));
        poss = constDist[t] == L;
        // if no variable, it has to have L right away
        if (all.size() > 0) {
            boolean canImprove = checkVariable();
            if (!poss) {
                ASSERT(canImprove == doable(new long[N], s, new HashSet<>()));
            }
            // if nothing's missing, it has to also have a distance <= L
            // Two cases: if the constant was already < L, it's failed
            // if the constant is >= L, then the added path must also work
            poss |= constDist[t] > L && canImprove;
            // else, then we make sure it has potential to be improved
        }
        if (!poss) {
            out.println("NO");
        } else {
            // can't do this if size 0
            if (all.size() > 0) {
                int lo = 1;
                int hi = all.size(); // each number before (0, 1, ... size - 1)
                // has the opportunity to be modified
                // find the minimal number of free nodes we need to add
                // where we can get SOME distance <= L.
                // Space is from 1 to end to none removed
                while (lo < hi) {
                    int mid = (lo + hi) / 2;
                    // since we KNOW that there exists a path <= L in the set of
                    // all paths, then the state space contains some breaking point
                    // where we are able to change from not having one to having one.
                    // 0011
                    HashSet<Integer> missing = new HashSet<>();
                    for (int i = mid; i < all.size(); i++) {
                        missing.add(all.get(i));
                    }
                    if (doable(new long[N], s, missing)) {
                        hi = mid;
                    } else {
                        lo = mid + 1;
                    }
                }
                // now build the answer
                long[] dist = new long[N];
                HashSet<Integer> missing = new HashSet<>();
                for (int i = lo; i < all.size(); i++) {
                    missing.add(all.get(i));
                    edges.get(all.get(i)).wt = (int) 1e9; // let's go risky!
                }
                dijkstra(dist, s, missing);
                long curr = dist[t];
                edges.get(all.get(lo - 1)).wt += L - curr; // this is all that's necessary, since this is the critical path.
            }
            out.println("YES");
            for (Edge e : edges) {
                out.println(e.u + " " + e.v + " " + e.wt);
            }
        }
        out.close();
    }

    static long oo = (long) 1e18;
    static ArrayList<Edge>[] adjList;
    static ArrayList<Edge> edges;
    static ArrayList<Integer> all;
    static boolean[][] toFix;
    static int N, M, s, t, L;

    static boolean checkVariable() {
        long[] fromS = new long[N];
        long[] fromT = new long[N];
        HashSet<Integer> none = new HashSet<>();
        dijkstra(fromS, s, none);
        dijkstra(fromT, t, none);

        // ONLY CHECK WITH 1-WEIGHTS!!
        for (int id : all) {
            Edge e = edges.get(id);
            ASSERT(e.wt == 1);
            long total = Math.min(fromS[e.u] + 1 + fromT[e.v], fromS[e.v] + 1 + fromT[e.u]);
            if (total <= L) {
                // there's a way!
                return true;
            }
        }
        return false;
    }

    static boolean checkConstant(long[] dist, int start, HashSet<Integer> missing) {
        dijkstra(dist, start, missing);
        return dist[t] >= L;
    }

    static boolean doable(long[] dist, int start, HashSet<Integer> missing) {
        dijkstra(dist, start, missing);
        return dist[t] <= L;
    }

    static void dijkstra(long[] dist, int start, HashSet<Integer> missing) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Arrays.fill(dist, oo);
        pq.add(new Node(start, 0));
        dist[start] = 0;
        while (pq.size() > 0) {
            Node node = pq.poll();
            for (Edge e : adjList[node.id]) {
                if (missing.contains(e.i)) continue;
                long alt = node.dist + e.wt;
                if (alt < dist[e.v]) {
                    dist[e.v] = alt;
                    pq.add(new Node(e.v, alt));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int id;
        long dist;

        public Node(int ii, long dd) {
            id = ii;
            dist = dd;
        }

        public int compareTo(Node n2) {
            return Long.compare(dist, n2.dist);
        }

        public String toString() {
            return "(" + id + ": " + dist + ")";
        }
    }

    static class Edge {
        int i, u, v;
        long wt;

        public Edge(int ii, int uu, int vv, long ww) {
            i = ii;
            u = uu;
            v = vv;
            wt = ww;
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