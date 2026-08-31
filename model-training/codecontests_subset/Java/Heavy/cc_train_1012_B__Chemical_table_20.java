import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Vadim Semenov
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskD solver = new TaskD();
        solver.solve(1, in, out);
        out.close();
    }

    static final class TaskD {
        public void solve(int __, InputReader in, PrintWriter out) {
            int rows = in.nextInt();
            int cols = in.nextInt();
            int count = in.nextInt();
            int answer = rows + cols - 1;
            TaskD.DSU dsu = new TaskD.DSU(rows + cols);
            for (int i = 0; i < count; ++i) {
                int r = in.nextInt() - 1;
                int c = in.nextInt() - 1;
                if (dsu.unite(r, rows + c)) {
                    answer--;
                }
            }
            out.println(answer);
        }

        static class DSU {
            final int[] parent;
            final int[] size;

            DSU(int capacity) {
                parent = new int[capacity];
                size = new int[capacity];
                for (int i = 0; i < capacity; ++i) {
                    parent[i] = i;
                    size[i] = 1;
                }
            }

            int get(int v) {
                if (parent[v] != v) {
                    parent[v] = get(parent[v]);
                }
                return parent[v];
            }

            boolean unite(int v, int u) {
                u = get(u);
                v = get(v);
                if (u == v) return false;
                if (size[u] < size[v]) {
                    int t = u;
                    u = v;
                    v = t;
                }
                parent[v] = u;
                size[u] += size[v];
                return true;
            }

        }

    }

    static class InputReader {
        private final BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream in) {
            reader = new BufferedReader(new InputStreamReader(in));
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(readLine());
            }
            return tokenizer.nextToken();
        }

        public String readLine() {
            String line;
            try {
                line = reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return line;
        }

    }
}

