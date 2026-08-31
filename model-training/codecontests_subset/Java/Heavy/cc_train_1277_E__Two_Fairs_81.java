import java.io.*;
import java.util.*;

/*
───────────────■■■─────────────────────────
──█▄─▄█─▄▀▀▀▄─█──▄█─────█──▄▀─▄▀▀▀▄─▀▀█▀▀──
──█─▀─█─█───█─█─█─█─────█■█───█───█───█────
──█───█─▀▄▄▄▀─█▀──█─────█──▀▄─▀▄▄▄▀───█────
───────────────────────────────────────────
*/

public class Main {

    static FastReader in;
    static PrintWriter out;
    static Random rand = new Random();
    static final int INF = (int) (1e9);
    static final int MOD = (int) (1e9 + 7);
    static int n, m, a, b;
    static ArrayList<Integer>[] g;
    static boolean[] vis;

    static void dfs(int v, int x) {
        vis[v] = true;
        if (v == x) return;
        for (int u : g[v]) {
            if (!vis[u]) {
                dfs(u, x);
            }
        }
    }

    static void solve() {
        n = in.nextInt();
        m = in.nextInt();
        a = in.nextInt();
        b = in.nextInt();

        g = new ArrayList[n + 1];
        Arrays.setAll(g, i -> new ArrayList<>());
        vis = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            int v = in.nextInt();
            int u = in.nextInt();
            g[v].add(u);
            g[u].add(v);
        }

        dfs(a, b);
        int cnta = 0;
        for (int i = 1; i <= n; i++) {
            if (!vis[i]) {
                cnta++;
            }
        }
        Arrays.fill(vis, false);

        dfs(b, a);
        int cntb = 0;
        for (int i = 1; i <= n; i++) {
            if (!vis[i]) {
                cntb++;
            }
        }

        out.println((long) cnta * cntb);
    }

    public static void main(String[] args) {
        in = new FastReader(System.in);
//        in = new FastReader(new FileInputStream("input.txt"));
        out = new PrintWriter(System.out);
//        out = new PrintWriter(new FileOutputStream("output.txt"));


        int q = in.nextInt();

        while (q-- > 0) {
            solve();
        }

        out.close();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        FastReader(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
        }

        Integer nextInt() {
            return Integer.parseInt(next());
        }

        Long nextLong() {
            return Long.parseLong(next());
        }

        Double nextDouble() {
            return Double.parseDouble(next());
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(nextLine());
            }
            return st.nextToken();
        }

        String nextLine() {
            String s = "";
            try {
                s = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return s;
        }
    }
}