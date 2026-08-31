import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
        DataCenterMaintenance solver = new DataCenterMaintenance();
        solver.solve(1, in, out);
        out.close();
    }

    static class DataCenterMaintenance {
        HashSet<Integer>[] edge;
        boolean[] visited;
        int[] compId;
        ArrayList<Integer> topSort = new ArrayList<>();
        ArrayList<Integer>[] compAdjList;
        ArrayList<Integer>[] adjList;
        ArrayList<Integer>[] adjListR;
        ArrayList<Integer>[] components;

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int N = in.nextInt();
            int M = in.nextInt();
            int H = in.nextInt();
            int[] p = new int[N];
            for (int i = 0; i < N; i++) {
                p[i] = in.nextInt();
            }
            edge = new HashSet[N];
            for (int i = 0; i < N; i++) {
                edge[i] = new HashSet<>();
            }
//        for (int i = 0; i < N; i++) {
//            up[i] = i;
//        }
            for (int i = 0; i < M; i++) {
                int u1 = in.nextInt() - 1;
                int u2 = in.nextInt() - 1;
                if (p[u2] < p[u1]) {
                    int temp = u1;
                    u1 = u2;
                    u2 = temp;
                }
                if (H == 2) {
                    edge[u2].add(u1);
                    edge[u1].add(u2);
                } else {
                    if (p[u1] == 0 && p[u2] == H - 1) {
                        edge[u2].add(u1);
                    } else if (p[u2] - p[u1] == 1) {
                        edge[u1].add(u2);
                    }
                }
            }
            visited = new boolean[N];
            init(edge);
            int min = 100000000;
            ArrayList<Integer> res = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                if (compAdjList[compId[i]].size() == 0 && components[compId[i]].size() < min) {
                    res = components[compId[i]];
                    min = res.size();
                }
            }
            for (int i = 0; i < N; i++) {
                if (edge[i].size() == 0) {
                    out.println(1);
                    out.println(i + 1);
                    return;
                }
            }
            print(out, res);
        }

        void print(PrintWriter out, ArrayList<Integer> arr) {
            out.println(arr.size());
            for (int j : arr) {
                out.println(j + 1);
            }
        }

        public void dfs1(int v) {
            if (!visited[v]) {
                visited[v] = true;
                for (int next : adjList[v]) {
                    dfs1(next);
                }
                topSort.add(v);
            }
        }

        public void dfs2(int v, int comp) {
            if (!visited[v]) {
                visited[v] = true;
                compId[v] = comp;
                components[comp].add(v);
                for (int c : adjListR[v]) {
                    dfs2(c, comp);
                }
            } else if (compId[v] != comp) {
                compAdjList[compId[v]].add(comp); // since we traversing reverse graph, if comp leads to compId[v], then in real graph it is the other way around
            }
        }

        void init(HashSet<Integer>[] edges) {
            int N = edges.length;
            adjList = new ArrayList[N];
            adjListR = new ArrayList[N];
            components = new ArrayList[N];
            compAdjList = new ArrayList[N];
            compId = new int[N];
            for (int i = 0; i < N; i++) {
                components[i] = new ArrayList<>();
                adjListR[i] = new ArrayList<>();
                adjList[i] = new ArrayList<>();
                compAdjList[i] = new ArrayList<>();
            }
            for (int i = 0; i < N; i++) {
                for (int e : edges[i]) {
                    adjList[i].add(e);
                    adjListR[e].add(i);
                }
            }
            for (int i = 0; i < N; i++) {
                dfs1(i);
            }
            visited = new boolean[N];
            int comp = 0;
            for (int j = N - 1; j >= 0; j--) {
                if (!visited[topSort.get(j)]) {
                    dfs2(topSort.get(j), comp++);
                }
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

