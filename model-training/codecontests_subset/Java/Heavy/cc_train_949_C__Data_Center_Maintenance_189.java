import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastScanner in = new FastScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        C949 solver = new C949();
        solver.solve(1, in, out);
        out.close();
    }

    static class C949 {
        int N;
        int M;
        int H;
        int[] times;

        public void solve(int testNumber, FastScanner s, PrintWriter out) {

            N = s.nextInt();
            M = s.nextInt();
            H = s.nextInt();
            C949.SCC tarzan = new C949.SCC(N);
            times = s.nextIntArray(N);
            ArrayList<int[]> edges = new ArrayList<>();
            for (int i = 0; i < M; i++) {
                int u = s.nextInt() - 1, v = s.nextInt() - 1;
                if ((times[u] + 1) % H == times[v]) {
                    tarzan.add(u, v);
                    edges.add(new int[]{u, v});
                }
                if ((times[v] + 1) % H == times[u]) {
                    tarzan.add(v, u);
                    edges.add(new int[]{v, u});
                }
            }

            int[] scc = tarzan.go();

            ArrayList<ArrayList<Integer>> blocs = new ArrayList<>();
            int mx = 0;
            for (int i : scc)
                mx = Math.max(i, mx);
            mx++;
            for (int i = 0; i < mx; i++)
                blocs.add(new ArrayList<>());
            for (int i = 0; i < N; i++)
                blocs.get(scc[i]).add(i);
            ArrayList<Integer> best = null;
            search:
            for (ArrayList<Integer> group : blocs) {
                // go through each node
                // if we point to any other SCCs, don't take us
                if (best != null && group.size() > best.size()) continue;
                for (int i : group) {
                    for (int j : tarzan.adj[i])
                        if (scc[j] != scc[i]) continue search;
                }
                best = group;
            }

            if (best == null) {
                out.println(N);
                for (int i = 0; i < N; i++)
                    out.print(i + 1 + " ");
                out.println();
                return;
            }

            out.println(best.size());
            for (int i : best)
                out.print(i + 1 + " ");
            out.println();


        }

        static class SCC {
            ArrayList<Integer>[] adj;
            int n;
            int idx;
            int cs;
            boolean[] u;
            int[] pre;
            int[] low;
            int[] map;
            ArrayDeque<Integer> s;

            public SCC(int nn) {
                adj = new ArrayList[n = nn];
                for (int curr = 0; curr < n; ++curr)
                    adj[curr] = new ArrayList<>();
            }

            void add(int v1, int v2) {
                adj[v1].add(v2);
            }

            int[] go() {
                idx = 1;
                cs = 0;
                pre = new int[n];
                low = new int[n];
                map = new int[n];
                u = new boolean[n];
                s = new ArrayDeque<Integer>();
                for (int i = 0; i < n; ++i)
                    if (pre[i] == 0)
                        dfs(i);
                return map;
            }

            void dfs(int v) {
                pre[v] = low[v] = idx++;
                s.push(v);
                u[v] = true;
                for (int to : adj[v]) {
                    if (pre[to] == 0) {
                        dfs(to);
                        low[v] = Math.min(low[v], low[to]);
                    } else if (u[to]) {
                        low[v] = Math.min(low[v], pre[to]);
                    }
                }
                if (low[v] == pre[v]) {
                    int next;
                    do {
                        next = s.pop();
                        u[next] = false;
                        map[next] = cs;
                    } while (next != v);
                    cs++;
                }
            }

        }

    }

    static class FastScanner {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;

        public FastScanner(InputStream stream) {
            this.stream = stream;
        }

        int read() {
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

        boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public String next() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public int[] nextIntArray(int N) {
            int[] ret = new int[N];
            for (int i = 0; i < N; i++)
                ret[i] = this.nextInt();
            return ret;
        }

    }
}

