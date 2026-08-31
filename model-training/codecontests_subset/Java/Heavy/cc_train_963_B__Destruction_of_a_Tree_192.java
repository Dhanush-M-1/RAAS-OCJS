import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.Collections;
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
        FastScanner in = new FastScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskB solver = new TaskB();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskB {
        List<Integer> stage0 = new ArrayList<>();
        List<Integer> stage1 = new ArrayList<>();

        public void solve(int testNumber, FastScanner in, PrintWriter out) {
            int n = in.nextInt();
            if (n % 2 == 0) {
                out.println("NO");
                return;
            }
            out.println("YES");

            List<Integer>[] adj = new List[n];
            for (int i = 0; i < n; i++) {
                adj[i] = new ArrayList<>();
            }

            for (int i = 0; i < n; i++) {
                int p = in.nextInt() - 1;
                if (p >= 0) {
                    adj[p].add(i);
                    adj[i].add(p);
                }
            }

            dfs(0, -1, adj);
            List<Integer> ans = new ArrayList<>();
            ans.addAll(stage0);
            Collections.reverse(stage1);
            ans.addAll(stage1);
            for (int v : ans) {
                out.println(v + 1);
            }
        }

        private int dfs(int v, int p, List<Integer>[] adj) {
            int parity = 1;
            for (int u : adj[v]) {
                if (u == p) {
                    continue;
                }
                parity ^= dfs(u, v, adj);
            }
            if (parity == 0) {
                stage0.add(v);
            } else {
                stage1.add(v);
            }
            return parity;
        }

    }

    static class FastScanner {
        private BufferedReader in;
        private StringTokenizer st;

        public FastScanner(InputStream stream) {
            in = new BufferedReader(new InputStreamReader(stream));
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(in.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

