import java.util.*;
import java.io.*;

public class CFA {
    BufferedReader br;
    PrintWriter out;
    StringTokenizer st;
    boolean eof;
    private static final long MOD = 1000 * 1000 * 1000 + 7;
    private static final int[] dx = {0, -1, 0, 1};
    private static final int[] dy = {1, 0, -1, 0};
    private static final String yes = "Yes";
    private static final String no = "No";

    // union find
    int[] id;
    int[] sz;
    int[] diameter;
    int n;
    int parent(int v) {
        while (v != id[v]) {
            v = id[v];
        }

        return v;
    }
    boolean merge(int u, int v) {
        int p1 = parent(u);
        int p2 = parent(v);
        if (p1 == p2) {
            return false;
        }

        if (sz[p1] < sz[p2]) {
            sz[p2] += sz[p1];
            id[p1] = p2;
        }
        else {
            sz[p1] += sz[p2];
            id[p2] = p1;
        }
        return true;
    }

    int upper(int v) {
        return (1 + v) / 2;
    }

    boolean merge2(int u, int v) {
        int p1 = parent(u);
        int p2 = parent(v);
        if (p1 == p2) {
            return false;
        }

        int parent;
        if (sz[p1] < sz[p2]) {
            sz[p2] += sz[p1];
            id[p1] = p2;
            parent = p2;
        }
        else {
            sz[p1] += sz[p2];
            id[p2] = p1;
            parent = p1;
        }

        int max = Math.max(diameter[p1], diameter[p2]);
        max = Math.max(max, upper(diameter[p1]) + upper(diameter[p2]) + 1);
        diameter[parent] = max;
        return true;
    }

    int findDia(int root) {
        Pair cur = findMaxIdx(root);
        if (cur.dist == 0) {
            return 0;
        }
        cur = findMaxIdx(cur.idx);
        return cur.dist;
    }

    class Pair {
        int dist;
        int idx;
        public Pair(int dist, int idx) {
            this.dist = dist;
            this.idx = idx;
        }
    }

    Pair findMaxIdx(int root) {
        Deque<Integer> deck = new LinkedList<>();
        Deque<Integer> ds = new LinkedList<>();
        int max = 0;
        int id = -1;
        Set<Integer> hs = new HashSet<>();
        hs.add(root);
        deck.add(root);
        ds.add(0);
        while (!deck.isEmpty()) {
            int cur = deck.removeFirst();
            int d = ds.removeFirst();
            if (d > max) {
                max = d;
                id = cur;
            }

            for (int nxt : graph.get(cur)) {
                if (!hs.contains(nxt)) {
                    hs.add(nxt);
                    deck.add(nxt);
                    ds.add(d + 1);
                }
            }
        }

        return new Pair(max, id);
    }

    List<List<Integer>> graph = new ArrayList<>();
    int dia = -1;
    void solve() throws IOException {
        n = nextInt();
        int m = nextInt();
        int q = nextInt();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        id = new int[n];
        sz = new int[n];
        diameter = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
            sz[i] = 1;
        }

        for (int i = 0; i < m; i++) {
            int a = nextInt() - 1;
            int b = nextInt() - 1;
            graph.get(a).add(b);
            graph.get(b).add(a);
            merge(a, b);
        }

        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            int par = parent(i);
            if (!vis[par]) {
                dia = -1;
                vis[par] = true;
                int d = findDia(par);
                diameter[par] = d;
            }
        }

        for (int i = 0; i < q; i++) {
            int t = nextInt();
            if (t == 1) {
                int x = nextInt() - 1;
                outln(diameter[parent(x)]);
            }
            else {
                int x = nextInt() - 1;
                int y = nextInt() - 1;
                merge2(x, y);
            }
        }
    }

    void shuffle(int[] a) {
        int n = a.length;
        for(int i = 0; i < n; i++) {
            int r = i + (int) (Math.random() * (n - i));
            int tmp = a[i];
            a[i] = a[r];
            a[r] = tmp;
        }
    }

    long gcd(long a, long b) {
        while(a != 0 && b != 0) {
            long c = b;
            b = a % b;
            a = c;
        }
        return a + b;
    }

    private void outln(Object o) {
        out.println(o);
    }
    private void out(Object o) {
        out.print(o);
    }
    private void formatPrint(double val) {
        System.out.format("%.9f%n", val);
    }
    public CFA() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }
    public static void main(String[] args) throws IOException {
        new CFA();
    }

    public long[] nextLongArr(int n) throws IOException{
        long[] res = new long[n];
        for(int i = 0; i < n; i++)
            res[i] = nextLong();
        return res;
    }
    public int[] nextIntArr(int n) throws IOException {
        int[] res = new int[n];
        for(int i = 0; i < n; i++)
            res[i] = nextInt();
        return res;
    }
    public String nextToken() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (Exception e) {
                eof = true;
                return null;
            }
        }
        return st.nextToken();
    }
    public String nextString() {
        try {
            return br.readLine();
        } catch (IOException e) {
            eof = true;
            return null;
        }
    }
    public int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }
    public long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }
    public double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }
}