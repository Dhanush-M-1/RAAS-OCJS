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
 * @author shivam
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

    static class TaskD {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int m = in.nextInt();
            int q = in.nextInt();
            TaskD.DisjointSetUnion dsu = new TaskD.DisjointSetUnion(n + m);
            int cnt = 0;
            for (int i = 0; i < q; i++) {
                int r = in.nextInt() - 1;
                int c = in.nextInt() - 1 + n;
                if (!dsu.connected(r, c)) {
                    dsu.connect(r, c);
                }
            }
            out.println(dsu.count - 1);
        }

        static class DisjointSetUnion {
            public int[] parent;
            public int[] weight;
            public int count;

            public DisjointSetUnion(int nodes) {
                count = nodes;
                parent = new int[nodes];
                weight = new int[nodes];
                for (int i = 0; i < nodes; i++) {
                    parent[i] = i;
                    weight[i] = 1;
                }
            }

            public int root(int p) {
                while (p != parent[p]) {
                    p = parent[p];
                }
                return p;
            }

            public void connect(int p, int q) {
                int rootP = root(p);
                int rootQ = root(q);
                if (rootP == rootQ) return;
                if (weight[rootP] < weight[rootQ]) {
                    parent[rootP] = rootQ;
                    weight[rootQ] += weight[rootP];
                } else {
                    parent[rootQ] = rootP;
                    weight[rootP] += weight[rootQ];
                }
                count--;
            }

            public boolean connected(int p, int q) {
                return root(p) == root(q);
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

