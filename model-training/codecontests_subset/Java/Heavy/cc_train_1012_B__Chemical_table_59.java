import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
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
        TaskB solver = new TaskB();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskB {
        ArrayList<ArrayList<Integer>> neig;
        boolean[] used;

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int m = in.nextInt();
            int q = in.nextInt();
            neig = new ArrayList<>();
            used = new boolean[n + m + 1];
            for (int i = 0; i <= n + m; i++) {
                neig.add(new ArrayList<>());
            }
            for (int i = 0; i < q; i++) {
                int r = in.nextInt();
                int c = in.nextInt();
                neig.get(n + c).add(r);
                neig.get(r).add(n + c);
            }
            int ans = -1;
            for (int i = 1; i <= n + m; i++) {
                if (!used[i]) {
                    ans++;
                    dfs(i);
                }
            }
            out.println(ans);
        }

        void dfs(int node) {
            if (!used[node]) {
                used[node] = true;
                for (int next : neig.get(node)) {
                    dfs(next);
                }
            }
        }

    }

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer stt;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        public String nextLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                return null;
            }
        }

        public String next() {
            while (stt == null || !stt.hasMoreTokens()) {
                stt = new StringTokenizer(nextLine());
            }
            return stt.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

