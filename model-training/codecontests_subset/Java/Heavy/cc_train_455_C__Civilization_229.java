import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.BiFunction;

public class Main {

    static BiFunction<Integer, Integer, Integer> ADD = (x, y) -> (x + y);

    static Map<Integer, Pair<Integer, Integer>> cc_p = new HashMap<>();
    static int[] cc_ind;

    public static void main(String[] args) throws Exception {
        long startTime = System.nanoTime();
        int t = 1;
        while (t-- > 0) {
            solve();
        }
        long endTime = System.nanoTime();
        err.println("Execution Time : +" + (endTime - startTime) / 1000000 + " ms");
        exit(0);
    }

    /*****
     *
     * Idea is to find connected components. Find longest path in each connected component.
     * Maintain union set to find same regions.
     * Retrieving is the tricky part.
     */

    static void solve() {
        int n = in.nextInt();
        int m = in.nextInt();
        int q = in.nextInt();
        g = graph(n + 1);
        parent = new int[n + 1];
        rank = new int[n + 1];
        diameter = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            make_set(i);
        }
        for (int i = 0; i < m; i++) {
            int u = in.nextInt() - 1;
            int v = in.nextInt() - 1;
            g[u].add(v);
            g[v].add(u);
            union_sets(u, v);
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                Pair<Integer, Integer> p = BFS(i, i);
                diameter[i] = p.second;
            }
        }
        for (int i = 0; i < q; i++) {
            int t = in.nextInt();
            int x = in.nextInt() - 1;
            int y;
            if (t == 1) {
                out.println(diameter[find_set(x)]);
            } else {
                x = find_set(x);
                y = find_set(in.nextInt() - 1);
                if (x == y) {
                    continue;
                }
                parent[x] = y;
                int old = (diameter[x] > diameter[y]) ? diameter[x] : diameter[y];
                diameter[y] = (diameter[y] + 1) / 2 + 1 + (diameter[x] + 1) / 2;
                if (old > diameter[y]) {
                    diameter[y] = old;
                }
            }
        }
    }

    static ArrayList<Integer>[] g;

    static int[] dist;
    static boolean[] visited;
    static int[] dist2;
    static boolean[] visited2;
    static int[] diameter;

    static ArrayList<Integer>[] graph(int n) {
        ArrayList<Integer>[] g = new ArrayList[n];
        dist = new int[n];
        visited = new boolean[n];
        dist2 = new int[n];
        visited2 = new boolean[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        return g;
    }

    static Pair<Integer, Integer> BFS(int s, int i) {
        Queue<Integer> Q = new ArrayDeque<>();
        int maxd = 0;
        int maxv = 0;
        dist[s] = 0;
        visited[s] = true;
        Q.add(s);
        while (!Q.isEmpty()) {
            int v = Q.poll();
            for (int a : g[v]) {
                parent[a] = i;
                if (!visited[a]) {
                    visited[a] = true;
                    dist[a] = dist[v] + 1;
                    Q.add(a);
                    if (dist[a] > maxd) {
                        maxd = dist[a];
                        maxv = a;
                    }
                }
            }
        }
        return BFS2(maxv);
    }

    static Pair<Integer, Integer> BFS2(int s) {
        Queue<Integer> Q = new ArrayDeque<>();
        int maxd = 0;
        int maxv = 0;
        dist2[s] = 0;
        visited2[s] = true;
        Q.add(s);
        while (!Q.isEmpty()) {
            int v = Q.poll();
            for (int a : g[v]) {
                if (!visited2[a]) {
                    visited2[a] = true;
                    dist2[a] = dist2[v] + 1;
                    Q.add(a);
                    if (dist2[a] > maxd) {
                        maxd = dist2[a];
                        maxv = a;
                    }
                }
            }
        }
        return make_pair(maxv, maxd);
    }

    static class Pair<T, R> {
        public T first;
        public R second;

        public Pair(T first, R second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            final Pair<?, ?> pair = (Pair<?, ?>) o;
            return Objects.equals(first, pair.first) && Objects.equals(second, pair.second);
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }

        @Override
        public String toString() {
            return "Pair{" + "a=" + first + ", b=" + second + '}';
        }

        public T getFirst() {
            return first;
        }

        public R getSecond() {
            return second;
        }
    }

    static <T, R> Pair<T, R> make_pair(T a, R b) {
        return new Pair<>(a, b);
    }

    static int[] parent;
    static int[] rank;

    static int find_set(int v) {
        if (v == parent[v]) {
            return v;
        }
        return parent[v] = find_set(parent[v]);
    }

    static void make_set(int v) {
        parent[v] = v;
        rank[v] = 0;
    }

    static void union_sets(int a, int b) {
        a = find_set(a);
        b = find_set(b);
        if (a != b) {
            if (rank[a] < rank[b]) {
                int temp = a;
                a = b;
                b = temp;
            }
            parent[b] = a;
            if (rank[a] == rank[b]) {
                rank[a]++;
            }
        }
    }

    static void debug(Object... args) {
        for (Object a : args) {
            out.println(a);
        }
    }

    static void y() {
        out.println("YES");
    }

    static void n() {
        out.println("NO");
    }

    static void fail() {
        out.println("-1");
        exit(0);
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

        public long nextLong() {
            return Long.parseLong(next());
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public int[] readAllInts(int n) {
            int[] p = new int[n];
            for (int i = 0; i < n; i++) {
                p[i] = in.nextInt();
            }
            return p;
        }

        public int[] readAllInts(int n, int s) {
            int[] p = new int[n + s];
            for (int i = s; i < n + s; i++) {
                p[i] = in.nextInt();
            }
            return p;
        }

        public long[] readAllLongs(int n) {
            long[] p = new long[n];
            for (int i = 0; i < n; i++) {
                p[i] = in.nextInt();
            }
            return p;
        }

        public long[] readAllLongs(int n, int s) {
            long[] p = new long[n + s];
            for (int i = s; i < n + s; i++) {
                p[i] = in.nextInt();
            }
            return p;
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }

    static void exit(int a) {
        out.close();
        err.close();
        System.exit(a);
    }

    static InputStream inputStream = System.in;
    static OutputStream outputStream = System.out;
    static OutputStream errStream = System.err;
    static InputReader in = new InputReader(inputStream);
    static PrintWriter out = new PrintWriter(outputStream);
    static PrintWriter err = new PrintWriter(errStream);
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

}
