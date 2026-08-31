import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class CFD {

    BufferedReader br;
    PrintWriter out;
    StringTokenizer st;
    boolean eof;
    private static final long MOD = 1000L * 1000L * 1000L + 7;
    private static final int[] dx = {0, -1, 0, 1};
    private static final int[] dy = {1, 0, -1, 0};
    private static final String yes = "Yes";
    private static final String no = "No";

    List<List<Integer>> graph = new ArrayList<>();
    boolean[] vis;
    int size;
    void solve() throws IOException {
        int n = nextInt();
        int m = nextInt();
        int q = nextInt();
        size = n + m;
        for (int i = 0; i < size; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < q; i++) {
            int u = nextInt() - 1;
            int v = nextInt() - 1 + n;
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        vis = new boolean[size];
        int com = 0;
        for (int i = 0; i < size; i++) {
            if (!vis[i]) {
                dfs(i);
                com++;
            }
        }

        outln(com - 1);
    }

    void dfs(int i) {
        if (vis[i]) {
            return;
        }
        vis[i] = true;
        for (int nxt : graph.get(i)) {
            dfs(nxt);
        }
    }

    int gcd(int a, int b) {
        while(a != 0 && b != 0) {
            int c = b;
            b = a % b;
            a = c;
        }
        return a + b;
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
        outln(String.format("%.9f%n", val));
    }
    public CFD() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }
    public static void main(String[] args) throws IOException {
        new CFD();
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
