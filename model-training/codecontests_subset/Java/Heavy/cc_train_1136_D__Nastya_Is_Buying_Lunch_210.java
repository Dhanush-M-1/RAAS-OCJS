import java.io.*;
import java.util.*;

public class D {

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        Solver solver = new Solver();
        solver.solve(in, out);
        out.close();
    }

    private static class Solver {

        private void solve(InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int m = in.nextInt();

            int[] p = new int[n];
            for (int i = 0; i < n; i++) {
                p[i] = in.nextInt();
            }

            Set<Integer>[] s = new Set[n + 1];
            for (int i = 0; i <= n; i++) s[i] = new HashSet<>();
            for (int i = 0; i < m; i++) {
                int u = in.nextInt();
                int v = in.nextInt();
                s[v].add(u);
            }

            int ans = 0;
            for (int i = n - 2; i >= 0; i--) {
                if (s[p[n - 1]].contains(p[i])) {
                    ans++;
                } else {
                    for (Iterator<Integer> it = s[p[n - 1]].iterator(); it.hasNext();) {
                        if (!s[p[i]].contains(it.next())) {
                            it.remove();
                        }
                    }
                }
            }

            out.println(ans);
        }
    }

    private static class InputReader {
        private BufferedReader br;
        private StringTokenizer st;

        public InputReader(InputStream stream) {
            br = new BufferedReader(new InputStreamReader(stream));
        }

        private int nextInt() {
            return Integer.parseInt(next());
        }

        private long nextLong() {
            return Long.parseLong(next());
        }

        private double nextDouble() {
            return Double.parseDouble(next());
        }

        private String nextLine() {
            String s = "";
            try {
                s = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return s;
        }

        private String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
    }
}