import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static boolean[][] vis;
    static final int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};
    static char[][] g;

    static boolean valid(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int tc = sc.nextInt();
        while (tc-- > 0) {
            n = sc.nextInt();
            char[][] grid = new char[n][];
            for (int i = 0; i < n; i++)
                grid[i] = sc.next().toCharArray();
            g = new char[n][n];
            int[] xs = {0, 1, n - 1, n - 2}, ys = {1, 0, n - 2, n - 1};
            for (int mask = 0; mask < 16; mask++) {
                if (Integer.bitCount(mask) > 2) continue;
                for (int i = 0; i < n; i++)
                    for (int j = 0; j < n; j++)
                        g[i][j] = grid[i][j];
                for (int i = 0; i < 4; i++)
                    if ((mask & 1 << i) != 0) {
                        char c = g[xs[i]][ys[i]];
                        g[xs[i]][ys[i]] = c == '1' ? '0' : '1';
                    }

                if (check()) {
                    out.println(Integer.bitCount(mask));
                    for (int i = 0; i < 4; i++)
                        if ((mask & 1 << i) != 0) out.println(xs[i] + 1 + " " + (ys[i] + 1));
                    break;
                }
            }
        }
        out.flush();
        out.close();
    }

    static boolean check() {
        vis = new boolean[n][n];
        if (dfs(0, 0, '0')) return false;
        vis = new boolean[n][n];
        if (dfs(0, 0, '1')) return false;
        return true;
    }

    static boolean dfs(int x, int y, char m) {
        if (x == n - 1 && y == n - 1) return true;
        boolean can = false;
        vis[x][y] = true;
        for (int k = 0; k < 4 && !can; k++) {
            int xx = x + dx[k], yy = y + dy[k];
            if (valid(xx, yy) && g[xx][yy] != m && !vis[xx][yy])
                can |= dfs(xx, yy, m);
        }
        return can;
    }

    static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        public Scanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public Scanner(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(s));
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public int[] nextIntArray(int n) throws IOException {
            int[] ans = new int[n];
            for (int i = 0; i < n; i++)
                ans[i] = nextInt();
            return ans;
        }

        public Integer[] nextIntegerArray(int n) throws IOException {
            Integer[] ans = new Integer[n];
            for (int i = 0; i < n; i++)
                ans[i] = nextInt();
            return ans;
        }

        public char nextChar() throws IOException {
            return next().charAt(0);
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public String nextLine() throws IOException {
            return br.readLine();
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        public boolean ready() throws IOException {
            return br.ready();
        }


    }
}