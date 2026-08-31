import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ProblemD1 {
    static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
        }

        public String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    static class Solution {

        int n;
        List<List<Integer>> tree;

        boolean dfs(int v, int p) {
            if (tree.get(v).size() == 2) {
                return false;
            }
            for (int u : tree.get(v)) {
                if (u == p)
                    continue;
                boolean result = dfs(u, v);
                if (!result) {
                    return false;
                }
            }
            return true;
        }

        void run() throws IOException {
            FastScanner sc = new FastScanner();
            n = sc.nextInt();
            tree = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                tree.add(new ArrayList<>());
            }
            for (int i = 0; i < n - 1; i++) {
                int u = sc.nextInt() - 1;
                int v = sc.nextInt() - 1;
                tree.get(u).add(v);
                tree.get(v).add(u);
            }
            if (dfs(0, -1)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new Solution().run();
    }
}
