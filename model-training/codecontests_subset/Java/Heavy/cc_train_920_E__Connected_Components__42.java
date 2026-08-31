//package info.stochastic;

import java.io.*;
import java.util.*;

public class D {
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

        Set[] g;
        boolean[] visited;
        int nodesCounter = 0;
        int n;
        Set<Integer> nodes;

        void dfs(int index) {
            if (visited[index]) {
                return;
            }

            visited[index] = true;
            nodes.remove(index);
            nodesCounter++;

            Set<Integer> toDel = new TreeSet<>();
            for (int i: nodes) {
                if (!g[index].contains(i)) {
                    toDel.add(i);
                }
            }

            for (Integer i: toDel) {
                nodes.remove(i);
            }

            for (int i: toDel) {
                dfs(i);
            }
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            n = in.nextInt();
            int m = in.nextInt();
            visited = new boolean[n];
            nodes = new TreeSet<>();
            g = new HashSet[n];

            for (int i = 0; i < n; i++) {
                g[i] = new HashSet();
                nodes.add(i);
            }

            for (int i = 0; i < m; i++) {
                int node1 = in.nextInt() - 1;
                int node2 = in.nextInt() - 1;
                g[node1].add(node2);
                g[node2].add(node1);
            }

            int counter = 0;
            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    counter++;
                    nodesCounter = 0;
                    dfs(i);
                    ans.add(nodesCounter);
                }
            }

            out.println(counter);
            Collections.sort(ans);
            for (int g: ans) {
                out.print(g + " ");
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
