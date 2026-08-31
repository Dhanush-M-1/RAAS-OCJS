import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.LinkedList;
import java.io.InputStreamReader;
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
        Task2 solver = new Task2();
        solver.solve(1, in, out);
        out.close();
    }

    static class Task2 {
        private static final int INF = Integer.MAX_VALUE;
        List<Task2.Edge>[] adj;
        int[] x;

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int N = in.nextInt();
            int M = in.nextInt();
            adj = (List<Task2.Edge>[]) new LinkedList[N];
            for (int i = 0; i < N; i++) adj[i] = new LinkedList<>();

            x = new int[N];
            Arrays.fill(x, INF);
            for (int i = 0; i < M; i++) {
                int l = in.nextInt() - 1;
                int r = in.nextInt() - 1;
                int d = in.nextInt();
                Task2.Edge e = new Task2.Edge(l, r, d);
                Task2.Edge e1 = new Task2.Edge(l, r, -d);
                adj[l].add(e);
                adj[r].add(e1);
            }

            boolean[] marked = new boolean[N];
            for (int v = 0; v < N; v++) {
                if (!marked[v]) {
                    x[v] = 0;
                    if (!dfs(v, marked)) {
                        out.println("No");
                        return;
                    }
                }
            }
            out.println("Yes");
        }

        private boolean dfs(int v, boolean[] marked) {
            marked[v] = true;
            boolean ans = true;
            for (Task2.Edge e : adj[v]) {
                int w = e.other(v);
                if (!marked[w]) {
                    x[w] = x[v] + e.d;
                    ans &= dfs(w, marked);
                } else if (x[w] != x[v] + e.d) {
                    return false;
                }
            }

            return ans;
        }

        static class Edge {
            int v;
            int w;
            int d;

            public Edge(int v, int w, int d) {

                this.v = v;
                this.w = w;
                this.d = d;
            }

            public int other(int x) {
                return x == v ? w : v;
            }

        }

    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

