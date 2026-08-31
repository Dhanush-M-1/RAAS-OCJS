import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Vector;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.Stack;
import java.util.ArrayList;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Pradyumn
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastReader in = new FastReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskC solver = new TaskC();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskC {
        public void solve(int testNumber, FastReader in, PrintWriter out) {
            int n = in.nextInt();
            int m = in.nextInt();
            int h = in.nextInt();
            int[] u = in.nextIntArray(n);
            List<Integer>[] g = new List[n];
            for (int i = 0; i < n; ++i) g[i] = new ArrayList<>();
            for (int i = 0; i < m; ++i) {
                int x = in.nextInt() - 1;
                int y = in.nextInt() - 1;
                if ((u[x] + 1) % h == u[y])
                    g[x].add(y);
                if ((u[y] + 1) % h == u[x])
                    g[y].add(x);
            }
            StronglyConnectedComponents stronglyConnectedComponents = new StronglyConnectedComponents(g);
            List<List<Integer>> scc = stronglyConnectedComponents.getComponents();
            List<Integer> best = new ArrayList<>();
            for (int i = 0; i < n; i++) best.add(i);
            int[] comp = new int[n];
            int cidx = 0;
            for (List<Integer> r : scc) {
                if (r.size() >= best.size()) continue;
                cidx++;
                for (int k : r) comp[k] = cidx;
                boolean ok = true;
                for (int k : r) {
                    for (int e : g[k]) {
                        if (comp[e] != cidx) {
                            ok = false;
                        }
                    }
                }
                if (ok) best = r;
            }
            out.println(best.size());
            boolean first = true;
            for (int k : best) {
                if (!first) out.print(" ");
                out.print(k + 1);
                first = false;
            }
            out.println();
        }

    }

    static class FastReader {
        private InputStream stream;
        private byte[] buf = new byte[8192];
        private int curChar;
        private int pnumChars;

        public FastReader(InputStream stream) {
            this.stream = stream;
        }

        private int pread() {
            if (pnumChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= pnumChars) {
                curChar = 0;
                try {
                    pnumChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (pnumChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public int nextInt() {
            int c = pread();
            while (isSpaceChar(c))
                c = pread();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = pread();
            }
            int res = 0;
            do {
                if (c == ',') {
                    c = pread();
                }
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = pread();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public int[] nextIntArray(int n) {
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = nextInt();
            }
            return array;
        }

        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

    }

    static class StronglyConnectedComponents {
        private List<Integer>[] graph;
        private boolean[] visited;
        private Stack<Integer> stack;
        private int time;
        private int[] lowlink;
        private List<List<Integer>> components;

        public List<List<Integer>> getComponents() {
            return components;
        }

        public StronglyConnectedComponents(List<Integer>[] g) {
            this.graph = g;
            components = scc();
        }

        public List<List<Integer>> scc() {
            int n = graph.length;
            visited = new boolean[n];
            stack = new Stack<>();
            time = 0;
            lowlink = new int[n];
            components = new ArrayList<>();

            for (int u = 0; u < n; u++)
                if (!visited[u])
                    dfs(u);

            return components;
        }

        void dfs(int u) {
            lowlink[u] = time++;
            visited[u] = true;
            stack.add(u);
            boolean isComponentRoot = true;

            for (int v : graph[u]) {
                if (!visited[v])
                    dfs(v);
                if (lowlink[u] > lowlink[v]) {
                    lowlink[u] = lowlink[v];
                    isComponentRoot = false;
                }
            }

            if (isComponentRoot) {
                List<Integer> component = new ArrayList<>();
                while (true) {
                    int x = stack.pop();
                    component.add(x);
                    lowlink[x] = Integer.MAX_VALUE;
                    if (x == u)
                        break;
                }
                components.add(component);
            }
        }

    }
}

