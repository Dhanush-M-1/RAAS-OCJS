import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
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
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskC solver = new TaskC();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskC {
        int[] parent;
        int[] dia;
        int maxD;
        int maxDnode;
        ArrayList<ArrayList<Integer>> neig;

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int m = in.nextInt();
            int q = in.nextInt();
            parent = new int[n + 1];
            neig = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                neig.add(new ArrayList<>());
                parent[i] = i;
            }
            for (int i = 0; i < m; i++) {
                int u = in.nextInt();
                int v = in.nextInt();
                neig.get(u).add(v);
                neig.get(v).add(u);
                union_dia(u, v, false);
            }
            boolean[] used = new boolean[n + 1];
            dia = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                if (!used[find(i)] && neig.get(i).size() == 1) {
                    used[find(i)] = true;
                    maxD = 0;
                    dfs(i, 0, 0);
                    maxD = 0;
                    dfs(maxDnode, 0, 0);
                    dia[find(i)] = maxD;
                }
            }
            for (int i = 0; i < q; i++) {
                int type = in.nextInt();
                if (type == 1) {
                    int x = in.nextInt();
                    out.println(dia[find(x)]);
                } else if (type == 2) {
                    int x = in.nextInt();
                    int y = in.nextInt();
                    union_dia(x, y, true);
                }
            }
        }

        int find(int node) {
            if (node == parent[node]) return node;
            return parent[node] = find(parent[node]);
        }

        void union_dia(int n1, int n2, boolean diaUp) {
            n1 = find(n1);
            n2 = find(n2);
            if (n1 != n2) {
                parent[n1] = n2;
                if (diaUp) {
                    int d1 = dia[n1] / 2 + dia[n1] % 2;
                    int d2 = dia[n2] / 2 + dia[n2] % 2;
                    dia[n2] = Math.max(d1 + d2 + 1, Math.max(dia[n1], dia[n2]));
                }
            }
        }

        void dfs(int node, int parent, int depth) {
            if (depth > maxD) {
                maxD = depth;
                maxDnode = node;
            }
            for (int nei : neig.get(node)) {
                if (nei != parent) {
                    dfs(nei, node, depth + 1);
                }
            }
        }

    }

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer stt;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        public String nextLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                return null;
            }
        }

        public String next() {
            while (stt == null || !stt.hasMoreTokens()) {
                stt = new StringTokenizer(nextLine());
            }
            return stt.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

