import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class CF405E {
    static PrintWriter pw;

    static class UndirectedGraph {
        ArrayList<Integer>[] adjList;
        int n;

        @SuppressWarnings("unchecked")
        UndirectedGraph(int n) {
            this.n = n;
            this.adjList = new ArrayList[n];
            for (int i = 0; i < n; i++)
                adjList[i] = new ArrayList<Integer>();
        }

        void addEdge(int v, int u) {
            adjList[v].add(u);
            adjList[u].add(v);
        }

        void formPaths() {
            int[] visited = new int[n];
            formPaths(0, visited);
        }

        int formPaths(int v, int[] visited) {
            visited[v] = 1;
            LinkedList<Integer> unpaired = new LinkedList<>();
            for (int u : adjList[v]) {
                if (visited[u] == 1)
                    continue;
                int w;
                if (visited[u] == 2 || (w = formPaths(u, visited)) == -1)
                    unpaired.add(u);
                else
                    print(v, u, w);
            }
            visited[v] = 2;
            while (unpaired.size() > 1) {
                print(unpaired.remove(), v, unpaired.remove());
            }
            if (!unpaired.isEmpty())
                return unpaired.remove();
            return -1;
        }
    }

    static void print(int v, int u, int w) {
        pw.println(++v + " " + ++u + " " + ++w);
    }

    public static void main(String[] args) throws IOException {
        FastScanner sc = new FastScanner();
        pw = new PrintWriter(System.out);

        int n = sc.nextInt(), m = sc.nextInt();
        UndirectedGraph g = new UndirectedGraph(n);
        for (int i = 0; i < m; i++) {
            g.addEdge(sc.nextInt() - 1, sc.nextInt() - 1);
        }
        if ((m & 1) == 1) {
            pw.println("No solution");
            pw.flush();
            return;
        }
        g.formPaths();

        pw.flush();
    }

    static class FastScanner {
        BufferedReader in;
        StringTokenizer st;

        public FastScanner() {
            this.in = new BufferedReader(new InputStreamReader(System.in));
        }

        public String nextToken() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(in.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(nextToken());
        }

        public long nextLong() {
            return Long.parseLong(nextToken());
        }

        public double nextDouble() {
            return Double.parseDouble(nextToken());
        }

        public void close() throws IOException {
            in.close();
        }
    }
}