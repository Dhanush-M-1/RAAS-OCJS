import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
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
        FastScanner in = new FastScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        r546_D solver = new r546_D();
        solver.solve(1, in, out);
        out.close();
    }

    static class r546_D {
        public void solve(int testNumber, FastScanner in, PrintWriter out) {
            int n = in.ni(), m = in.ni();
            int[] p = in.na(n);
            List<Integer>[] g = new List[n];
            for (int i = 0; i < n; i++) {
                g[i] = new LinkedList<>();
            }
            boolean[] canJumpOver = new boolean[n];
            int last = p[n - 1] - 1;
            for (int i = 0; i < m; i++) {
                int u = in.ni() - 1, v = in.ni() - 1;
                g[u].add(v);
                if (v == last)
                    canJumpOver[u] = true;
            }

            boolean[] blockers = new boolean[n];
            int nBlockers = 0;
            int ans = 0;
            for (int i = n - 2; i >= 0; i--) {
                int no = p[i] - 1;
                if (!canJumpOver[no]) {
                    blockers[no] = true;
                    nBlockers++;
                } else {
                    int swaps = 0;
                    for (int v : g[no]) {
                        if (blockers[v]) {
                            swaps++;
                        }
                    }
                    if (swaps == nBlockers) {
                        ans++;
                    } else {
                        blockers[no] = true;
                        nBlockers++;
                    }
                }
            }
            out.println(ans);
        }

    }

    static class FastScanner {
        private BufferedReader in;
        private StringTokenizer st;

        public FastScanner(InputStream stream) {
            in = new BufferedReader(new InputStreamReader(stream));
        }

        public String ns() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    String rl = in.readLine();
                    if (rl == null) {
                        return null;
                    }
                    st = new StringTokenizer(rl);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

        public int ni() {
            return Integer.parseInt(ns());
        }

        public int[] na(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = ni();
            return a;
        }

    }
}

