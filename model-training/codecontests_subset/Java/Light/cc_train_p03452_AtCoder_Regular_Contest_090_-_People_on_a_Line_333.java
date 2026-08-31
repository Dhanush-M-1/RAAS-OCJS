import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        InputReader in = new InputReader();
        PrintWriter out = new PrintWriter(System.out);
        int t = 1;
        Solver s = new Solver();
        for (int i = 1; i <= t; i++) {
            s.solve(i, in, out);
        }
        out.close();
    }

}

class Solver {

    static class Pair {
        int cost, dir, to;

        public Pair(int to, int cost, int dir) {
            this.cost = cost;
            this.dir = dir;
            this.to = to;
        }
    }

    ArrayList<Pair>[] v;

    int[] cost;
    boolean[] visited;
    boolean ok;

    void solve(int test, InputReader in, PrintWriter out) throws IOException {
        int n = in.nextInt();
        int m = in.nextInt();
        v = new ArrayList[n];
        for (int i = 0; i < n; i++) v[i] = new ArrayList<>();
        visited = new boolean[n];
        cost = new int[n];
        while (m-- > 0) {
            int x = in.nextInt() - 1;
            int y = in.nextInt() - 1;
            int c = in.nextInt();
            v[x].add(new Pair(y, c, 1));
            v[y].add(new Pair(x, c, -1));
        }
        ok = true;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                cost[i] = 0;
                dfs(i);
            }
        }
        for (int i = 0; i < n; i++) if (!visited[i]) ok = false;
        out.println(ok ? "Yes" : "No");
    }

    private void dfs(int source) {
        if (!ok) return;
        visited[source] = true;
        for (Pair x : v[source]) {
            if (!visited[x.to]) {
                cost[x.to] = cost[source] + x.cost * x.dir;
                dfs(x.to);
            } else if (cost[x.to] != cost[source] + x.cost * x.dir) {
//                System.out.println("source = " + source);
//                System.out.println("x.to = " + x.to);
//                System.out.println("cost = " + Arrays.toString(cost));
//                System.out.println("x.dir = " + x.dir);
                ok = false;
                return;
            }
        }
    }
}

class InputReader {
    BufferedReader br;
    StringTokenizer st;

    public InputReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = null;
    }

    public String next() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return st.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }

    public String nextLine() throws IOException {
        return br.readLine();
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }
}