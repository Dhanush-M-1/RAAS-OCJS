//package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class C {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter writer = new PrintWriter(System.out);
    StringTokenizer stringTokenizer;

    String next() throws IOException {
        while (stringTokenizer == null || !stringTokenizer.hasMoreTokens()) {
            stringTokenizer = new StringTokenizer(reader.readLine());
        }
        return stringTokenizer.nextToken();
    }

    int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    void solve() throws IOException {
        final int n = nextInt();
        int m = nextInt();
        int q = nextInt();
        class DSU {
            int[] parent = new int[n + 1];
            int[] rank = new int[n + 1];
            int[] longestRoute = new int[n + 1];
            {
                for(int i = 1; i <= n; i++) {
                    parent[i] = i;
                }
            }

            void link(int parent, int x) {
                this.parent[x] = parent;
                rank[parent] += rank[x];

                final int r1 = r(longestRoute[parent]);
                final int r2 = r(longestRoute[x]);
                longestRoute[parent] = Math.max(r1 + r2 + 1, Math.max(longestRoute[parent], longestRoute[x]));
            }

            int find(int x) {
                return parent[x] == x ? x : (parent[x] = find(parent[x]));
            }

            void union(int x, int y) {
                x = find(x);
                y = find(y);
                if(x == y) return;
                if(rank[x] > rank[y]) {
                    link(x, y);
                } else {
                    link(y, x);
                }
            }

            int r(int x) {
                return x / 2 + x % 2;
            }
        }
        List[] gg = new List[n + 1];
        for(int i = 1; i <= n; i++) {
            gg[i] = new ArrayList<Integer>();
        }
        DSU dsu = new DSU();
        for(int i = 0; i < m; i++) {
            int u = nextInt();
            int v = nextInt();
            dsu.union(u, v);
            gg[u].add(v);
            gg[v].add(u);
        }
        final int[][] g = new int[n + 1][];
        for(int i = 1; i <= n; i++) {
            g[i] = new int[gg[i].size()];
            for(int j = 0; j < g[i].length; j++) {
                g[i][j] = (int)gg[i].get(j);
            }
        }
        class Utils {
            int dist = -1;
            int farthest = 0;

            int getLongestRoute(int u) {
                Queue<Integer> q = new LinkedList<>();
                dist = -1;
                dfs(u, 0, 0);
                dist = -1;
                dfs(farthest, 0, 0);
                return dist;
            }

            void dfs(int u, int p, int d) {
                if(d > dist) {
                    farthest = u;
                    dist = d;
                }
                for (int v : g[u]) {
                    if(v != p) {
                        dfs(v, u, d + 1);
                    }
                }
            }
        }
        Utils utils = new Utils();
        int[] longestRoute = dsu.longestRoute;
        for(int i = 1; i <= n; i++) {
            if(dsu.parent[i] == i) {
                longestRoute[i] = utils.getLongestRoute(i);
            }
        }
        for(int i = 0; i < q; i++) {
            int t = nextInt();
            if(t == 1) {
                int u = nextInt();
                u = dsu.find(u);
                writer.println(longestRoute[u]);
            }
            if(t == 2) {
                int u = nextInt();
                int v = nextInt();
                dsu.union(u, v);
            }
        }
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        new C().solve();
    }
}
