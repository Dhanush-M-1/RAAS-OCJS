import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Vector;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.LinkedList;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author xwchen
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskC solver = new TaskC();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskC {
        int lowestDepth = 0;
        int lowestNode = 0;
        Graph graph = null;
        boolean[] visited = null;

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int m = in.nextInt();
            int q = in.nextInt();
            DisjointSet ds = new DisjointSet(n);
            int[] length = new int[n + 1];
            graph = new Graph(n);
            for (int i = 0; i < m; ++i) {
                int a = in.nextInt();
                int b = in.nextInt();
                graph.addEdge(a, b);
            }
            visited = new boolean[n + 1];
            for (int i = 1; i <= n; ++i) {
                if (!visited[i]) {
                    Vector<Integer> regionNodes = new Vector<>();
                    lowestNode = i;
                    lowestDepth = 0;
                    search(i, regionNodes, 0);
                    for (int v : regionNodes) {
                        visited[v] = false;
                    }
                    search(lowestNode, 0);
                    for (int j = 0; j < regionNodes.size(); ++j) {
                        if (j > 0) {
                            ds.union(regionNodes.get(j), regionNodes.get(j - 1));
                        }
                        length[ds.find(regionNodes.get(j))] = lowestDepth;
                    }
                }
            }
            while (q-- > 0) {
                int t = in.nextInt();
                if (t == 1) {
                    int x = in.nextInt();
                    out.println(length[ds.find(x)]);
                } else {
                    int a = in.nextInt();
                    int b = in.nextInt();
                    int regionA = ds.find(a);
                    int regionB = ds.find(b);
                    if (regionA != regionB) {
                        int mergedLength = (length[regionA] + 1) / 2 + (length[regionB] + 1) / 2 + 1;
                        mergedLength = Math.max(mergedLength, length[regionA]);
                        mergedLength = Math.max(mergedLength, length[regionB]);
                        ds.union(regionA, regionB);
                        length[regionA] = mergedLength;
                        length[regionB] = mergedLength;
                    }
                }
            }
        }

        void search(int cur, int depth) {
            visited[cur] = true;
            if (depth > lowestDepth) {
                lowestDepth = depth;
                lowestNode = cur;
            }
            for (Graph.Edge e : graph.adj[cur]) {
                int v = e.v;
                if (!visited[v]) {
                    search(v, depth + 1);
                }
            }
        }

        void search(int cur, Vector<Integer> visitedNodes, int depth) {
            visited[cur] = true;
            if (visitedNodes != null) {
                visitedNodes.add(cur);
            }
            if (depth > lowestDepth) {
                lowestDepth = depth;
                lowestNode = cur;
            }
            for (Graph.Edge e : graph.adj[cur]) {
                int v = e.v;
                if (!visited[v]) {
                    search(v, visitedNodes, depth + 1);
                }
            }
        }

    }

    static class Graph {
        public LinkedList<Edge>[] adj;
        int n;

        public Graph() {

        }

        public Graph(int n) {
            this.n = n;
            adj = new LinkedList[n + 1];
            for (int i = 0; i <= n; ++i) {
                adj[i] = new LinkedList<>();
            }
        }

        public void addEdge(int u, int v) {

            adj[u].add(new Edge(v, 1));
            adj[v].add(new Edge(u, 1));
            //System.out.println("add edge "+u+" "+v);
        }

        public class Edge {
            public int u;
            public int v;
            public int value;

            public Edge(int u, int v, int value) {
                this.u = u;
                this.v = v;
                this.value = value;
            }

            public Edge(int v, int value) {
                this.v = v;
                this.value = value;
            }

        }

    }

    static class DisjointSet {
        int[] f;

        public DisjointSet(int n) {
            f = new int[n + 1];
            for (int i = 1; i <= n; ++i) {
                f[i] = i;
            }
        }

        public int find(int x) {
            return f[x] == x ? x : (f[x] = find(f[x]));
        }

        public void union(int x, int y) {
            f[find(y)] = find(x);
        }

    }

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer = new StringTokenizer("");

        public InputReader(InputStream inputStream) {
            this.reader = new BufferedReader(
                    new InputStreamReader(inputStream));
        }

        public String next() {
            while (!tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

