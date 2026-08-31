import java.io.*;
import java.util.*;

public class Main {
    private static PrintWriter out;
    private static FastReader in;

    private static ArrayList<Integer>[] G;
    private static boolean[] used;
    private static int[] d;

    private static class DSU {
        private int[] parent;
        private int[] length;
        private int[] rank;

        public DSU (int size) {
            parent = new int[size];
            length = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; ++i)
                makeSet(i);
        }

        private void makeSet(int v) {
            parent[v] = v;
            length[v] = 0;
            rank[v] = 0;
        }

        public void putLength(int v, int l) {
            length[findSet(v)] = l;
        }

        public int findSet (int v) {
            if (v == parent[v])
                return v;
            return parent[v] = findSet(parent[v]);
        }

        public void unionSets (int a, int b) {
            a = findSet(a);
            b = findSet(b);
            if (a != b) {
                if (rank[a] < rank[b]) {
                    int t = a; a = b; b = t;
                }
                parent[b] = a;
                if (rank[a] == rank[b])
                    ++rank[a];
                int l1 = length[a],
                    l2 = length[b];
                length[a] = length[b] = Math.max(
                        Math.max(l1, l2),
                        l1/2 + l2/2 + l1 % 2 + l2 % 2 + 1);
            }
        }

        public int length(int v) {
            return length[findSet(v)];
        }
    }

    private static class FastReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public FastReader(InputStream inputStream) {
            reader = new BufferedReader(
                    new InputStreamReader(inputStream), 1 << 16);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                }
                catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
            return tokenizer.nextToken();
        }

        public String nextLine() {
            try {
                return reader.readLine();
            }
            catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }

    private static int bfs(int start) {
        d[start]= 0;
        int furthest = start;
        Queue<Integer> Q = new ArrayDeque<Integer>();
        Q.add(start);
        used[start] = true;
        while (!Q.isEmpty()) {
            int v = Q.remove();
            for (int adj : G[v]) {
                if (!used[adj]) {
                    Q.add(adj);
                    furthest = adj;
                    used[adj] = true;
                    d[adj] = d[v] + 1;
                }
            }
        }
        return furthest;
    }

    public static void main(String[] args) throws FileNotFoundException {
        in = new FastReader(System.in);
        out = new PrintWriter(System.out);

        int n = in.nextInt();
        DSU dsu = new DSU(n);
        int m = in.nextInt();
        int q = in.nextInt();
        G = new ArrayList[n];
        for (int i = 0; i < n; ++i)
            G[i] = new ArrayList<Integer>();
        for (int i = 0; i < m; ++i) {
            int u = in.nextInt();
            int v = in.nextInt();
            --u; --v;
            G[u].add(v);
            G[v].add(u);
            dsu.unionSets(u, v);
        }
        used = new boolean[n];
        Arrays.fill(used, false);
        d = new int[n];
        Arrays.fill(d, 0);
        ArrayList<Integer> furthest = new ArrayList<Integer>();
        for (int i = 0; i < n; ++i) {
            if (!used[i]) {
                furthest.add(bfs(i));
            }
        }
        Arrays.fill(used, false);
        ArrayList<Integer> diameters = new ArrayList<Integer>();
        for (int v : furthest) {
            diameters.add(d[bfs(v)]);
        }
        for (int i = 0; i < diameters.size(); ++i) {
            dsu.putLength(furthest.get(i),
                          diameters.get(i));
        }
        for (int i = 0; i < q; ++i) {
            int t = in.nextInt();
            if (t == 1) {
                out.println(dsu.length(in.nextInt()-1));
            }
            else {
                dsu.unionSets(in.nextInt()-1, in.nextInt()-1);
            }
        }

        out.flush();
    }
}