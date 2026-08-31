import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.IOException;
import java.util.InputMismatchException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author amotoma3
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
        boolean can = true;

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            List<List<Edge>> graph = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
            }

            int m = in.nextInt();
            for (int i = 0; i < m; i++) {
                int l = in.nextInt() - 1;
                int r = in.nextInt() - 1;
                int d = in.nextInt();

                graph.get(l).add(new Edge(r, d));
                graph.get(r).add(new Edge(l, -d));
            }

            int[] pos = new int[n];
            Arrays.fill(pos, Integer.MAX_VALUE);
            for (int i = 0; i < n; i++) {
                if (pos[i] == Integer.MAX_VALUE) {
                    pos[i] = 0;
                    rec(pos, i, graph);
                }
            }

            out.println(can ? "Yes" : "No");
        }

        void rec(int pos[], int x, List<List<Edge>> graph) {
            for (Edge e : graph.get(x)) {
                if (pos[e.to] != Integer.MAX_VALUE && pos[e.to] != pos[x] + e.cost) {
                    can = false;
                    break;
                }
                if (pos[e.to] == Integer.MAX_VALUE) {
                    pos[e.to] = pos[x] + e.cost;
                    rec(pos, e.to, graph);
                }
            }
        }

        class Edge implements Comparable<Edge> {
            int to;
            int cost;

            Edge(int to, int cost) {
                this.to = to;
                this.cost = cost;
            }

            public int compareTo(Edge edge) {
                return cost - edge.cost;
            }

        }

    }

    static class InputReader {
        BufferedReader in;
        StringTokenizer tok;

        public String nextString() {
            while (!tok.hasMoreTokens()) {
                try {
                    tok = new StringTokenizer(in.readLine(), " ");
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
            }
            return tok.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(nextString());
        }

        public InputReader(InputStream inputStream) {
            in = new BufferedReader(new InputStreamReader(inputStream));
            tok = new StringTokenizer("");
        }

    }
}

