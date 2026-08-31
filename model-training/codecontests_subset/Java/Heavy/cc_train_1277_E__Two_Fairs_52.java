import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class E {
    public static void main(String[] args) throws Exception {
        InputReader in = new InputReader(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int test = in.nextInt();
        for (int t = 1; t <= test; t++) {
            int n = in.nextInt(), m = in.nextInt();
            int a = in.nextInt(), b = in.nextInt();
            ArrayDeque<Integer> g[] = genDQ(n + 1);
            for (int i = 0; i < m; i++) {
                int u = in.nextInt(), v = in.nextInt();
                g[u].addLast(v);
                g[v].addLast(u);
            }
            int va[] = bfs(a, b, n, g, 1);
            int vb[] = bfs(b, a, n, g, 2);
            long A = 0, B = 0;
            for (int i = 1; i <= n; i++) {
                if (va[i] == 1 && vb[i] == 0) A++;
                if (vb[i] == 2 && va[i] == 0) B++;
            }
            pw.println(A * B);
        }

        pw.close();
    }

    static int[] bfs(int src, int tgr, int n, ArrayDeque<Integer> g[], int clr) {
        int vis[] = new int[n + 1];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(src);
        vis[src] = clr;
        vis[tgr] = clr;
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : g[u]) {
                if (vis[v] == 0) {
                    vis[v] = clr;
                    q.add(v);
                }
            }
        }
        return vis;
    }

    static <T> ArrayDeque<T>[] genDQ(int n) {
        ArrayDeque<T> list[] = new ArrayDeque[n];
        for (int i = 0; i < n; i++) list[i] = new ArrayDeque<T>();
        return list;
    }


    static void debug(Object... obj) {
        System.err.println(Arrays.deepToString(obj));
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
            tokenizer = null;
        }

        public String next() throws Exception {
            while (tokenizer == null || !tokenizer.hasMoreTokens())
                tokenizer = new StringTokenizer(reader.readLine());
            return tokenizer.nextToken();
        }

        public String nextLine() throws Exception {
            String line = null;
            tokenizer = null;
            line = reader.readLine();
            return line;
        }

        public int nextInt() throws Exception {
            return Integer.parseInt(next());
        }

        public double nextDouble() throws Exception {
            return Double.parseDouble(next());
        }

        public long nextLong() throws Exception {
            return Long.parseLong(next());
        }

    }
}