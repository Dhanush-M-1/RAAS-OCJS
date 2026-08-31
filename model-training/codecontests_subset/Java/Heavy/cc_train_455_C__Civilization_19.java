import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author pandusonu
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
        public int[] dia;
        public int[] longest;
        public boolean[] visited;

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            // out.print("Case #" + testNumber + ": ");
            int n = in.readInt();
            int m = in.readInt();
            int q = in.readInt();
            Graph g = new Graph(n);
            UnionFind uf = new UnionFind(n);
            int[] ans = new int[n];
            while (m-- > 0) {
                int u = in.readInt() - 1;
                int v = in.readInt() - 1;
                g.add(u, v);
                g.add(v, u);
                uf.union(u, v);
            }
            visited = new boolean[n];
            dia = new int[n];
            longest = new int[n];
            for (int i = 0; i < n; i++) {
                int s = uf.find(i);
                if (ans[s] == 0) {
                    ans[s] = dfs(i, g);
                }
            }
            for (int i = 0; i < q; i++) {
                int ch = in.readInt();
                if (ch == 1) {
                    int x = in.readInt() - 1;
                    out.println(ans[uf.find(x)]);
                } else {
                    int u = in.readInt() - 1;
                    int v = in.readInt() - 1;
                    int d1 = ans[uf.find(u)];
                    int d2 = ans[uf.find(v)];
                    if (uf.find(u) == uf.find(v)) continue;
                    uf.union(u, v);
                    ans[uf.find(u)] = (int) Math.max(Math.max(d1, d2), ((d1 + 1) >> 1) + ((d2 + 1) >> 1) + 1);
                }
            }
        }

        public int dfs(int curr, Graph g) {
            visited[curr] = true;
            int max1 = -1, max2 = -1;
            for (Edge e : g.adj[curr]) {
                if (!visited[e.j]) {
                    dfs(e.j, g);
                    dia[curr] = Math.max(dia[curr], dia[e.j]);
                    dia[curr] = Math.max(dia[curr], longest[e.j] + 1 + longest[curr]);
                    longest[curr] = Math.max(longest[curr], longest[e.j] + 1);
                }
            }
            return dia[curr];
        }

    }

    static class UnionFind {
        private final int[] group;

        public UnionFind(int size) {
            group = new int[size];
            Arrays.fill(group, -1);
        }

        public final int find(int x) {
            while (group[x] >= 0)
                x = group[x];
            return x;
        }

        public final boolean union(int x, int y) {
            x = find(x);
            y = find(y);
            if (x != y) {
                if (group[x] > group[y]) {
                    group[y] += group[x];
                    group[x] = y;
                } else {
                    group[x] += group[y];
                    group[y] = x;
                }
            }
            return (x != y);
        }

    }

    static class Graph {
        public int N;
        public int M;
        public ArrayList<Edge>[] adj;

        public Graph(int nodes) {
            N = nodes;
            adj = new ArrayList[N];
            for (int i = 0; i < N; i++) {
                adj[i] = new ArrayList<>();
            }
        }

        public void add(int i, int j) {
            adj[i].add(new Edge(j, 0, M));
            M++;
        }

    }

    static class InputReader {
        private final InputStream stream;
        private final byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        private int read() {
            try {
                if (curChar >= numChars) {
                    curChar = 0;
                    numChars = stream.read(buf);
                    if (numChars <= 0)
                        return -1;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return buf[curChar++];
        }

        public int readInt() {
            return (int) readLong();
        }

        public long readLong() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
                if (c == -1) throw new RuntimeException();
            }
            boolean negative = false;
            if (c == '-') {
                negative = true;
                c = read();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9') throw new InputMismatchException();
                res *= 10;
                res += (c - '0');
                c = read();
            } while (!isSpaceChar(c));
            return negative ? (-res) : (res);
        }

        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

    }

    static class Edge {
        public int j;
        public int w;
        public int id;

        public Edge(int neigh, int weight, int identity) {
            j = neigh;
            w = weight;
            identity = id;
        }

    }
}

