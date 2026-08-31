import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.Set;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskE solver = new TaskE();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskE {
        int n;
        int m;
        int k;
        Set<Integer> going = new HashSet<>();
        Vertex[] vs;

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            n = in.nextInt();
            m = in.nextInt();
            k = in.nextInt();
            vs = new Vertex[n];
            for (int i = 0; i < n; ++i) {
                vs[i] = new Vertex(i);
                going.add(i);
            }
            int[] res = new int[m];
            Edge[] edges = new Edge[m];
            for (int i = 0; i < m; ++i) {
                int x = in.nextInt() - 1;
                int y = in.nextInt() - 1;
                vs[x].adj.add(y);
                vs[y].adj.add(x);
                edges[i] = new Edge(x, y);
            }
            for (int i = 0; i < n; ++i) {
                vs[i].erase();
            }
            for (int i = m - 1; i >= 0; --i) {
                res[i] = going.size();
                int from = edges[i].from;
                int to = edges[i].to;
                vs[from].adj.remove(to);
                vs[to].adj.remove(from);
                vs[from].erase();
                vs[to].erase();
            }
            for (int i = 0; i < m; ++i) {
                out.println(res[i]);
            }
        }

        class Edge {
            int from;
            int to;

            public Edge(int from, int to) {
                this.from = from;
                this.to = to;
            }

        }

        class Vertex {
            int id;
            boolean marked;
            Set<Integer> adj = new HashSet<>();

            Vertex(int id) {
                this.id = id;
            }

            void erase() {
                this.marked = true;
                if (this.adj.size() < k && going.contains(this.id)) {
                    going.remove(this.id);
                    for (int vId : this.adj) {
                        if (vs[vId].marked) continue;
                        vs[vId].adj.remove(this.id);
                        vs[vId].erase();
                    }
                }
                this.marked = false;
            }

        }

    }

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
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

