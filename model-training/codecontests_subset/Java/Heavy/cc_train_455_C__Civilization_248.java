import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;

/**
 * Created by hama_du on 2014/08/09.
 */
public class ProblemC {

    static int[][] graph;

    static int diameter(int i) {
        int[] tan = dfs(i, -1);
        int[] tan2 = dfs(tan[0], -1);
        return tan2[1];
    }


    static int[] dfs(int i, int parent) {
        int max = 0;
        int maxi = i;
        for (int to : graph[i]) {
            if (to != parent) {
                int[] ret = dfs(to, i);
                ret[1]++;
                if (max < ret[1]) {
                    max = ret[1];
                    maxi = ret[0];
                }
            }
        }
        return new int[]{maxi, max};
    }

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();
        int m = in.nextInt();
        int q = in.nextInt();

        UnionFind uf = new UnionFind(n);

        int[] deg = new int[n];

        int[][] edges = new int[m][2];
        for (int i = 0 ; i < m ; i++) {
            edges[i][0] = in.nextInt()-1;
            edges[i][1] = in.nextInt()-1;
            uf.unite(edges[i][0], edges[i][1]);
            deg[edges[i][0]]++;
            deg[edges[i][1]]++;
        }

        graph = new int[n][];
        for (int i = 0 ; i < n ; i++) {
            graph[i] = new int[deg[i]];
        }
        for (int i = 0 ; i < m ; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            graph[a][--deg[a]] = b;
            graph[b][--deg[b]] = a;
        }

        boolean[] visited = new boolean[n];
        int[] path = new int[n];
        for (int i = 0 ; i < n ; i++) {
            int id = uf.find(i);
            if (!visited[id]) {
                visited[id] = true;
                path[id] = diameter(id);
            }
        }

        while (--q >= 0) {
            int type = in.nextInt();
            if (type == 1) {
                int id = uf.find(in.nextInt() - 1);
                out.println(path[id]);
            } else {
                int x = in.nextInt() - 1;
                int y = in.nextInt() - 1;
                if (uf.issame(x, y)) {
                    continue;
                }
                int xid = uf.find(x);
                int yid = uf.find(y);
                int xpath = path[xid];
                int ypath = path[yid];

                uf.unite(x, y);

                // left -> right
                int next = (path[xid] + 1) / 2 + (path[yid] + 1) / 2 + 1;
                next = Math.max(next, Math.max(xpath, ypath));
                path[uf.find(x)] = next;
            }
        }
        out.flush();
    }

    static void debug(Object... obj) {
        System.err.println(Arrays.deepToString(obj));
    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int next() {
            if (numChars == -1)
                throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public int nextInt() {
            int c = next();
            while (isSpaceChar(c))
                c = next();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = next();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = next();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }


    static class UnionFind {
        int[] parent, rank;
        UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0 ; i < n ; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        int find(int x) {
            if (parent[x] == x) {
                return x;
            }
            parent[x] = find(parent[x]);
            return parent[x];
        }

        void unite(int x, int y) {
            x = find(x);
            y = find(y);
            if (x == y) {
                return;
            }
            if (rank[x] < rank[y]) {
                parent[x] = y;
            } else {
                parent[y] = x;
                if (rank[x] == rank[y]) {
                    rank[x]++;
                }
            }
        }
        boolean issame(int x, int y) {
            return (find(x) == find(y));
        }

        List<List<Integer>> groups() {
            int n = parent.length;
            List<Integer>[] groups = new List[n];
            for (int i = 0 ; i < n ; i++) {
                groups[i] = new ArrayList<>();
            }
            for (int i = 0 ; i < n ; i++) {
                groups[find(i)].add(i);
            }


            List<List<Integer>> clipedGroups = new ArrayList<List<Integer>>();
            for (List<Integer> g : groups) {
                if (g.size() >= 1) {
                    clipedGroups.add(g);
                }
            }
            return clipedGroups;
        }
    }

}
