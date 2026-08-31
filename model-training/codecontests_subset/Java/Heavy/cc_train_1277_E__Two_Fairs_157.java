import java.util.*;
import java.io.*;

public class CFA {
    BufferedReader br;
    PrintWriter out;
    StringTokenizer st;
    boolean eof;
    private static final long MOD = 1000L * 1000L * 1000L + 7;
    private static final int[] dx = {0, -1, 0, 1};
    private static final int[] dy = {1, 0, -1, 0};
    private static final String yes = "Yes";
    private static final String no = "No";

    void solve() throws IOException {
        int T = nextInt();
        for (int i = 0; i < T; i++) {
            helper();
        }
    }

    List<List<Integer>> graph;
    void helper() throws IOException {
        int n = nextInt();
        int m = nextInt();
        int a = nextInt() - 1;
        int b = nextInt() - 1;
        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int from = nextInt() - 1;
            int to = nextInt() - 1;
            graph.get(from).add(to);
            graph.get(to).add(from);
        }
        outln(find(a, b) * find(b, a));
    }

    long find(int from, int to) {
        boolean[] vis = new boolean[graph.size()];
        dfs(from, to, vis);
        long res = 0;
        for (boolean v : vis) {
            if (!v) {
                res++;
            }
        }
        return res - 1;
    }

    void dfs(int node, int exclude, boolean[] vis) {
        if (vis[node] || node == exclude) {
            return;
        }
        vis[node] = true;
        for (int nxt : graph.get(node)) {
            dfs(nxt, exclude, vis);
        }
    }

    void shuffle(long[] a) {
        int n = a.length;
        for(int i = 0; i < n; i++) {
            int r = i + (int) (Math.random() * (n - i));
            long tmp = a[i];
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
        outln(String.format("%.9f%n", val));
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