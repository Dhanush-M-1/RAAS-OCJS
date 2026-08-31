
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    int n, m;
    int[] ls, rs, ds;
    long[] xs;
    ArrayList<ArrayList<Edge>> es;
    boolean flg;
    public static void main(String[] args) {
        Main m = new Main();
        m.read();
        m.solve();
    }

    private void read() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        ls = new int[m];
        rs = new int[m];
        ds = new int[m];
        es = new ArrayList<>(n);
        for (int i = 0; i < n; i++)
            es.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            ls[i] = sc.nextInt();
            rs[i] = sc.nextInt();
            ds[i] = sc.nextInt();
            es.get(ls[i]- 1).add(new Edge(rs[i]- 1, ds[i]));
            es.get(rs[i]-1).add(new Edge(ls[i]-1, -ds[i]));
        }
    }

    private void solve() {
        xs = new long[n];
        Arrays.fill(xs, Long.MAX_VALUE);
        flg = true;
        for (int i = 0; i < n; i++) {
            if (xs[i] == Long.MAX_VALUE && flg) {
                xs[i] = 0;
                dfs(i);
            }
        }
        if (flg)
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    private void dfs(int cur) {
        ArrayList<Edge> c_es = es.get(cur);
        for (Edge e: c_es) {
            if (xs[e.to] == Long.MAX_VALUE) {
                xs[e.to] = e.cost + xs[cur];
                dfs(e.to);
            }
            else {
                long check = e.cost + xs[cur];
                flg &= xs[e.to] == check;
            }
        }
    }

    private class Edge {
        int to, cost;
        Edge(int t, int c) {
            to = t;
            cost = c;
        }
    }
}
