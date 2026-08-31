import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Collection;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.util.Queue;
import java.util.LinkedList;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author beginner1010
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskC solver = new TaskC();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskC {
        ArrayList<Integer>[] G;
        int[] parent;
        int[] height;
        int[] dist;
        int[] longest_path_size;

        int root(int x) {
            return x == parent[x] ? x : (parent[x] = root(parent[x]));
        }

        boolean join(int x, int y) {
            x = root(x);
            y = root(y);
            if (x == y) return false;
            if (height[x] > height[y]) {
                parent[y] = x;
            } else {
                parent[x] = y;
                if (height[x] == height[y]) height[y]++;
            }
            return true;
        }

        int farthest(int r) {
            Queue<Integer> q = new LinkedList<Integer>();
            HashSet<Integer> visited = new HashSet<Integer>();
            q.add(r);
            visited.add(r);
            dist[r] = 0;
            int fartherst = r;
            while (!q.isEmpty()) {
                int vertex = q.poll();
                fartherst = vertex;
                for (int neighbor : G[vertex]) {
                    if (visited.contains(neighbor)) continue;
                    visited.add(neighbor);
                    dist[neighbor] = dist[vertex] + 1;
                    q.add(neighbor);
                }
            }
            return fartherst;
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n, m, q;
            n = in.nextInt();
            m = in.nextInt();
            q = in.nextInt();

            G = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) G[i] = new ArrayList<Integer>();

            height = new int[n + 1];
            parent = new int[n + 1];
            longest_path_size = new int[n + 1];
            for (int i = 1; i <= n; i++)
                parent[i] = i;

            for (int i = 0; i < m; i++) {
                int a, b;
                a = in.nextInt();
                b = in.nextInt();
                G[a].add(b);
                G[b].add(a);
                join(a, b);
            }


            dist = new int[n + 1];
            for (int i = 1; i <= n; i++)
                if (parent[i] == i) {
                    int leaf = farthest(i);
                    int f = farthest(leaf);
                    longest_path_size[i] = dist[f];
                }

            for (int i = 0; i < q; i++) {
                int type = in.nextInt();
                if (type == 1) {
                    int x = in.nextInt();
                    x = root(x);
                    out.println(longest_path_size[x]);
                } else {
                    int x = in.nextInt();
                    int y = in.nextInt();
                    x = root(x);
                    y = root(y);
                    if (join(x, y) == true) {
                        int diam_x = longest_path_size[x];
                        int diam_y = longest_path_size[y];
                        x = root(x);
                        longest_path_size[x] = Math.max((diam_x + 1) / 2 + (diam_y + 1) / 2 + 1, Math.max(diam_x, diam_y));
                    }
                }
            }

        }

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

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

