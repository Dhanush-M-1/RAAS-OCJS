import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
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
        TaskE solver = new TaskE();
        solver.solve(1, in, out);
        out.close();
    }

    static final class TaskE {
        public void solve(int __, InputReader in, PrintWriter out) {
            int vertices = in.nextInt();
            int edges = in.nextInt();
            int threshold = in.nextInt();
            int[] u = new int[edges];
            int[] v = new int[edges];
            int[] degree = new int[vertices];
            for (int edge = 0; edge < edges; ++edge) {
                u[edge] = in.nextInt() - 1;
                v[edge] = in.nextInt() - 1;
                degree[u[edge]]++;
                degree[v[edge]]++;
            }
            int[][] graph = new int[vertices][];
            Arrays.setAll(graph, vertex -> new int[degree[vertex]]);
            Arrays.fill(degree, 0);
            for (int edge = 0; edge < edges; ++edge) {
                graph[u[edge]][degree[u[edge]]++] = edge;
                graph[v[edge]][degree[v[edge]]++] = edge;
            }
            int[] queue = new int[vertices];
            int head = 0;
            int tail = 0;
            for (int vertex = 0; vertex < vertices; ++vertex) {
                if (degree[vertex] < threshold) {
                    queue[tail++] = vertex;
                }
            }
            int[] answer = new int[edges];
            boolean[] removed = new boolean[edges];
            for (int day = edges; day-- > 0; ) {
                while (head < tail) {
                    int vertex = queue[head++];
                    for (int edge : graph[vertex]) {
                        if (removed[edge]) continue;
                        removed[edge] = true;
                        int next = vertex ^ u[edge] ^ v[edge];
                        if (degree[next] == threshold) {
                            queue[tail++] = next;
                        }
                        degree[next]--;
                    }
                }
                answer[day] = vertices - tail;
                if (!removed[day]) {
                    removed[day] = true;
                    if (degree[v[day]] == threshold) {
                        queue[tail++] = v[day];
                    }
                    if (degree[u[day]] == threshold) {
                        queue[tail++] = u[day];
                    }
                    degree[u[day]]--;
                    degree[v[day]]--;
                }
            }
            for (int ans : answer) {
                out.println(ans);
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

