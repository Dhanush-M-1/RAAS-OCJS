import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.io.FilterInputStream;
import java.io.BufferedInputStream;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Jenish
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        ScanReader in = new ScanReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        CCivilization solver = new CCivilization();
        solver.solve(1, in, out);
        out.close();
    }

    static class CCivilization {
        int[] centre;
        boolean[] visited;
        int[] size;
        int ss = 0;
        int[] dia;
        int[] dis;
        int[][] graph;
        HashSet<Integer> hashSet;
        int[] disA;
        int[] disB;

        public void solve(int testNumber, ScanReader in, PrintWriter out) {
            int n = in.scanInt();
            int m = in.scanInt();
            int q = in.scanInt();

            {
                visited = new boolean[n + 1];
                size = new int[n + 1];
                centre = new int[n + 1];
                dia = new int[n + 1];
                disA = new int[n + 1];
                dis = new int[n + 1];
                disB = new int[n + 1];
            }


            {

                int from[] = new int[m];
                int to[] = new int[n];
                for (int i = 0; i < m; i++) {
                    int a = in.scanInt();
                    int b = in.scanInt();
                    from[i] = a;
                    to[i] = b;
                }
                graph = CodeX.packGraph(from, to, n);
            }


            for (int i = 1; i <= n; i++) {
                if (visited[i]) continue;
                hashSet = new HashSet<>();
                ss = 0;
                dfs(i);
                pair p = center(i);
                dfs22(i, -1, p.a);
                size[p.a] = ss;
                dia[p.a] = p.b;
            }


            while (q-- > 0) {
                int type = in.scanInt();
                if (type == 1) {
                    out.println(dia[root(in.scanInt())]);
                } else {
                    int x = in.scanInt();
                    int y = in.scanInt();
                    int a = root(x);
                    int b = root(y);
                    if (a == b) continue;
                    int len = dia[a];
                    len = Math.max(len, dia[b]);
                    len = Math.max(len, ((dia[a] + 1)) / 2 + ((dia[b] + 1) / 2) + 1);
                    int n_C;
                    if (size[a] > size[b]) {
                        centre[b] = a;
                        n_C = a;
                        size[a] += size[b];
                        size[b] = 0;
                    } else {
                        centre[a] = b;
                        n_C = b;
                        size[b] += size[a];
                        size[a] = 0;
                    }
                    dia[n_C] = len;
                }
            }


        }

        void dfs22(int node, int parent, int center) {
            centre[node] = center;
            for (int k : graph[node]) {
                if (k != parent) {
                    dfs22(k, node, center);
                }
            }
        }

        int root(int x) {
            while (centre[x] != x) {
                x = centre[centre[x]];
            }
            return x;
        }

        pair center(int root) {
            dfs(root, 0, -1);
            int max = -1;
            for (int i : hashSet) max = Math.max(max, dis[i]);
            int a = -1;
            for (int i : hashSet) if (dis[i] == max) a = i;
            dfs(a, 0, -1);
            max = -1;
            for (int i : hashSet) max = Math.max(max, dis[i]);
            int b = -1;
            for (int i : hashSet) if (dis[i] == max) b = i;
            dfsfromA(a, 0, -1);
            dfsfromB(b, 0, -1);
            for (int i : hashSet) if (disB[i] == (max + 1) / 2 && disA[i] == max - disB[i]) return new pair(i, max);
            return new pair(-1, max);
        }

        void dfs(int node, int level, int parent) {
            dis[node] = level;
            for (int k : graph[node]) {
                if (k != parent) {
                    dfs(k, level + 1, node);
                }
            }
        }

        void dfsfromA(int node, int level, int parent) {
            disA[node] = level;
            for (int k : graph[node]) {
                if (k != parent) {
                    dfsfromA(k, level + 1, node);
                }
            }
        }

        void dfsfromB(int node, int level, int parent) {
            disB[node] = level;
            for (int k : graph[node]) {
                if (k != parent) {
                    dfsfromB(k, level + 1, node);
                }
            }
        }

        void dfs(int node) {
            ss++;
            visited[node] = true;
            hashSet.add(node);
            for (int k : graph[node]) {
                if (!visited[k]) dfs(k);
            }
        }

        class pair {
            int a;
            int b;

            public pair(int a, int b) {
                this.a = a;
                this.b = b;
            }

        }

    }

    static class ScanReader {
        private byte[] buf = new byte[4 * 1024];
        private int INDEX;
        private BufferedInputStream in;
        private int TOTAL;

        public ScanReader(InputStream inputStream) {
            in = new BufferedInputStream(inputStream);
        }

        private int scan() {
            if (INDEX >= TOTAL) {
                INDEX = 0;
                try {
                    TOTAL = in.read(buf);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (TOTAL <= 0) return -1;
            }
            return buf[INDEX++];
        }

        public int scanInt() {
            int I = 0;
            int n = scan();
            while (isWhiteSpace(n)) n = scan();
            int neg = 1;
            if (n == '-') {
                neg = -1;
                n = scan();
            }
            while (!isWhiteSpace(n)) {
                if (n >= '0' && n <= '9') {
                    I *= 10;
                    I += n - '0';
                    n = scan();
                }
            }
            return neg * I;
        }

        private boolean isWhiteSpace(int n) {
            if (n == ' ' || n == '\n' || n == '\r' || n == '\t' || n == -1) return true;
            else return false;
        }

    }

    static class CodeX {
        public static int[][] packGraph(int[] from, int[] to, int n) {
            int[][] g = new int[n + 1][];
            int p[] = new int[n + 1];
            for (int i : from) p[i]++;
            for (int i : to) p[i]++;
            for (int i = 0; i <= n; i++) g[i] = new int[p[i]];
            for (int i = 0; i < from.length; i++) {
                g[from[i]][--p[from[i]]] = to[i];
                g[to[i]][--p[to[i]]] = from[i];
            }
            return g;
        }

    }
}

