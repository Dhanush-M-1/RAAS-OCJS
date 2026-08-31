import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class E {
    FastScanner in;
    PrintWriter out;

    public static void main(String[] args) {
        new E().run();
    }

    void solve() throws IOException {
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();

        int[][] es = new int[m][];
        Arrays.setAll(es, i -> new int[]{in.nextInt() - 1, in.nextInt() - 1});

        Set<Integer>[] edges = new Set[n];
        Arrays.setAll(edges, i -> new HashSet<>());
        for (int[] e : es) {
            edges[e[0]].add(e[1]);
            edges[e[1]].add(e[0]);
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(i);
        }

        int[] q = new int[n];
        boolean[] was = new boolean[n];
        int head = 0;
        int tail = 0;
        for (int i = 0; i < n; i++) {
            if (edges[i].size() < k) {
                q[tail++] = i;
                was[i] = true;
            }
        }

        int[] ans = new int[m];

        for (int i = m - 1; i >= 0; --i) {
            for (; head < tail; head++) {
                int v = q[head];
                set.remove(v);
                for (int u : edges[v]) {
                    if (set.contains(u) && !was[u]) {
                        edges[u].remove(v);
                        if (edges[u].size() < k) {
                            q[tail++] = u;
                            was[u] = true;
                        }
                    }
                }
            }
            ans[i] = set.size();
            int u = es[i][0];
            int v = es[i][1];
            if (set.contains(u) && set.contains(v)) {
                edges[u].remove(v);
                edges[v].remove(u);
                if (edges[u].size() < k) { q[tail++] = u; was[u] = true; }
                if (edges[v].size() < k) { q[tail++] = v; was[v] = true; }
            }
        }
        Arrays.stream(ans).forEach(out::println);
    }

    void run() {
        try {
            in = new FastScanner(System.in);
            out = new PrintWriter(System.out);
            solve();

            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
