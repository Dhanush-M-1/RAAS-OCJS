import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Hieu Le
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
        private int dfsNumberCounter;
        private Stack<Integer> stack;

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int m = in.nextInt();
            int h = in.nextInt();

            int[] hours = in.readIntArray(n);
            List<Integer>[] graph = new List[n];
            for (int i = 0; i < n; ++i)
                graph[i] = new ArrayList<>();

            for (int i = 0; i < m; ++i) {
                int a = in.nextInt() - 1;
                int b = in.nextInt() - 1;

                if ((hours[a] + 1) % h == hours[b])
                    graph[a].add(b);
                if ((hours[b] + 1) % h == hours[a])
                    graph[b].add(a);
            }

            List<List<Integer>> components = tarjanSCC(graph);
            int[] keys = new int[n];
            int numSCC = 0;

            List<Integer> minSubset = new ArrayList<>();
            for (int i = 0; i < n; ++i)
                minSubset.add(i);

            for (List<Integer> component : components) {
                ++numSCC;

                if (minSubset.size() < component.size())
                    continue;

                for (int node : component)
                    keys[node] = numSCC;

                boolean ok = true;
                for (int node : component) {
                    for (int neighbor : graph[node]) {
                        if (keys[neighbor] != numSCC) {
                            ok = false;
                            break;
                        }
                    }

                    if (!ok) break;
                }

                if (ok)
                    minSubset = component;
            }

            out.println(minSubset.size());
            for (int node : minSubset)
                out.print((node + 1) + " ");
        }

        private List<List<Integer>> tarjanSCC(List<Integer>[] graph) {
            int n = graph.length;
            int[] dfsNum = new int[n];
            Arrays.fill(dfsNum, -1);
            int[] dfsLow = new int[n];
            boolean[] visited = new boolean[n];
            dfsNumberCounter = 0;
            stack = new Stack<>();

            List<List<Integer>> components = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                if (dfsNum[i] == -1) {
                    tarjanSCCUtil(i, dfsNum, dfsLow, visited, graph, components);
                }
            }

            return components;
        }

        private void tarjanSCCUtil(int u, int[] dfsNum, int[] dfsLow, boolean[] visited,
                                   List<Integer>[] graph, List<List<Integer>> components) {
            dfsLow[u] = dfsNum[u] = ++dfsNumberCounter;
            stack.push(u);
            visited[u] = true;
            for (int v : graph[u]) {
                if (dfsNum[v] == -1)
                    tarjanSCCUtil(v, dfsNum, dfsLow, visited, graph, components);
                if (visited[v])
                    dfsLow[u] = Math.min(dfsLow[u], dfsLow[v]);
            }

            if (dfsLow[u] == dfsNum[u]) {
                List<Integer> component = new ArrayList<>();
                while (true) {
                    int v = stack.pop();
                    visited[v] = false;
                    component.add(v);
                    if (u == v)
                        break;
                }
                components.add(component);
            }
        }

    }

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;
        private static final int BUFFER_SIZE = 32768;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(
                    new InputStreamReader(stream), BUFFER_SIZE);
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

        public int[] readIntArray(int length) {
            int[] result = new int[length];
            for (int i = 0; i < length; ++i)
                result[i] = nextInt();
            return result;
        }

    }
}

