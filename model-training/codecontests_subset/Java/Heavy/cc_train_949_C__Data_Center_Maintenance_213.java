import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class C {

    FastScanner scanner;
    PrintWriter writer;

    void solve() throws IOException {
        scanner = new FastScanner(System.in);
        writer = new PrintWriter(System.out);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int h = scanner.nextInt();

        int[] us = new int[n];

        for (int i = 0; i < n; i++)
            us[i] = scanner.nextInt();

        List<List<Integer>> g = new ArrayList<>(n);
        List<List<Integer>> gt = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
            gt.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int c1 = scanner.nextInt() - 1;
            int c2 = scanner.nextInt() - 1;
            if (hasEdge(c1, c2, us, h)) {
                g.get(c1).add(c2);
                gt.get(c2).add(c1);
            }
            if (hasEdge(c2, c1, us, h)) {
                g.get(c2).add(c1);
                gt.get(c1).add(c2);
            }
        }

        List<Integer> ord = new ArrayList<>(n);
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i])
                dfs(g, i, visited, ord);
        }

        visited = new boolean[n];

        List<Integer> min = null;

        for (int i = ord.size() - 1; i >= 0; i--) {
            int v = ord.get(i);
            if (!visited[v]) {
                List<Integer> comp = new ArrayList<>();
                dfs(gt, v, visited, comp);

                boolean term = true;

                compLoop: for (int cv : comp) {
                    for (int e : g.get(cv)) {
                        if (!visited[e]) {
                            term = false;
                            break compLoop;
                        }
                    }
                }

                if (term && (min == null || comp.size() < min.size()))
                    min = comp;
            }
        }

        writer.println(min.size());

        for (int v : min)
            writer.print((v + 1) + " ");

        writer.close();
    }

    void dfs(List<List<Integer>> g, int v, boolean[] visited, List<Integer> ord) {
        visited[v] = true;

        for (int e : g.get(v)) {
            if (!visited[e])
                dfs(g, e, visited, ord);
        }

        ord.add(v);
    }

    boolean hasEdge(int c1, int c2, int[] us, int h) {
        int u1 = us[c1];
        int u2 = us[c2];
        return (u1 + 1) % h == u2;
    }

    public static void main(String... args) throws IOException {
        new C().solve();
    }

    static class FastScanner {

        BufferedReader br;
        StringTokenizer tokenizer;

        FastScanner(String fileName) throws FileNotFoundException {
            this(new FileInputStream(new File(fileName)));
        }

        FastScanner(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
        }

        String nextLine() throws IOException {
            tokenizer = null;
            return br.readLine();
        }

        String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                String line = br.readLine();
                if (line == null) {
                    return null;
                }
                tokenizer = new StringTokenizer(line);
            }
            return tokenizer.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }
    }
}
