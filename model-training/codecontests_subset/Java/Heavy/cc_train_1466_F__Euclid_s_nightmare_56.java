import java.io.*;
import java.util.*;

public class F {
    private static final int MOD = (int) 1e9 + 7;

    private static int[] parent;
    private static int[] size;
    private static boolean[] single;

    private static int find(int x) {
        if (x == parent[x])
            return x;

        parent[x] = find(parent[x]);
        return parent[x];
    }

    private static boolean unite(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y)
            return false;

        if (size[x] < size[y]) {
            int tmp = x;
            x = y;
            y = tmp;
        }

        parent[y] = x;
        size[x] += size[y];
        single[x] = single[x] || single[y];
        return true;
    }

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();
        int m = in.nextInt();

        parent = new int[m];
        size = new int[m];
        single = new boolean[m];

        for (int i = 0; i < m; i++) {
            parent[i] = i;
            size[i] = 1;
            single[i] = false;
        }

        int[] save = new int[n];
        int s = 0;
        int lastSingle = -1;

        for (int v = 0; v < n; v++) {
            int k = in.nextInt();

            if (k == 1) {
                int x = in.nextInt() - 1;
                x = find(x);

                if (!single[x]) {
                    save[s++] = v + 1;
                    single[x] = true;

                    if (lastSingle >= 0)
                        unite(x, lastSingle);

                    lastSingle = x;
                }
            } else {
                int x = in.nextInt() - 1;
                int y = in.nextInt() - 1;
                x = find(x);
                y = find(y);

                if (x != y) {
                    save[s++] = v + 1;
                    unite(x, y);
                }
            }
        }

        long t = 1;

        for (int i = 0; i < s; i++)
            t = 2 * t % MOD;

        out.println(t + " " + s);

        for (int i = 0; i < s; i++)
            out.print(save[i] + " ");

        out.println();
        out.close();
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

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}
