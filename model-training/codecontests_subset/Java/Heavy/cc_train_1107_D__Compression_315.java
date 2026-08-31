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

        private int n;
        private int[][] a;
        private int[][] sums;

        private int max(int a, int b) {
            return a < b ? b : a;
        }

        private boolean check(int d) {
            for (int i = 0; i < n; i += d) {
                for (int j = 0; j < n; j += d) {
                    int sum = sums[i + d][j + d] - sums[i + d][j] - sums[i][j + d] + sums[i][j];
                    if (sum != 0 && sum != d * d) return false;
                }
            }
            return true;
        }

        private void solve(InputReader in, PrintWriter out) {
            n = in.nextInt();

            a = new int[n][n];
            for (int i = 0; i < n; i++) {
                String s = in.next();
                for (int j = 0; j < s.length(); j++) {
                    char ch = s.charAt(j);
                    int x;
                    if (ch >= '0' && ch <= '9') x = ch - '0';
                    else x = 10 + ch - 'A';
                    for (int k = 3; k >= 0; k--) {
                        a[i][j * 4 + k] = x & 1;
                        x >>= 1;
                    }
                }
            }

            sums = new int[n + 1][n + 1];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    sums[i + 1][j + 1] = sums[i + 1][j] + sums[i][j + 1] - sums[i][j] + a[i][j];
                }
            }

            int ans = 1;
            for (int d = 1; d * d <= n; d++) {
                if (n % d == 0) {
                    if (check(d)) ans = max(ans, d);
                    if (check(n / d)) ans = max(ans, n / d);
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