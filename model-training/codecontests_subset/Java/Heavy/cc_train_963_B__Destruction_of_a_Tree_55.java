import java.io.*;
import java.util.*;

public class CFB {

    BufferedReader br;
    PrintWriter out;
    StringTokenizer st;
    boolean eof;
    private static final long MOD = 1000L * 1000L * 1000L + 7;
    private static final int[] dx = {0, -1, 0, 1};
    private static final int[] dy = {1, 0, -1, 0};
    private static final String yes = "Yes";
    private static final String no = "No";

    int n;
    List<List<Integer>> graph = new ArrayList<>();
    int root;
    int[] sz;
    void solve() throws IOException {
        n = nextInt();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            int p = nextInt();
            if (p == 0) {
                root = i;
            }
            else {
                graph.get(p - 1).add(i);
            }
        }

        if (n % 2 == 0) {
            outln(no.toUpperCase());
            return;
        }
        outln(yes.toUpperCase());
        sz = new int[n];
        dfs1(root);
        dfs2(root);
    }

    void dfs1(int cur) {
        sz[cur] = 1;
        for (int nxt : graph.get(cur)) {
            dfs1(nxt);
            sz[cur] += sz[nxt];
        }
    }

    void dfs2(int cur) {
        for (int nxt : graph.get(cur)) {
            if (sz[nxt] % 2 == 0) {
                dfs2(nxt);
            }
        }
        outln(cur + 1);
        for (int nxt : graph.get(cur)) {
            if (sz[nxt] % 2 != 0) {
                dfs2(nxt);
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
    private void outln(Object o) {
        out.println(o);
    }
    private void out(Object o) {
        out.print(o);
    }
    private void formatPrint(double val) {
        System.out.format("%.9f%n", val);
    }
    public CFB() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }
    public static void main(String[] args) throws IOException {
        new CFB();
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
