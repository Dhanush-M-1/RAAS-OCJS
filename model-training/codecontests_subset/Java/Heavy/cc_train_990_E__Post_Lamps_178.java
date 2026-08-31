import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastScanner in = new FastScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskE solver = new TaskE();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskE {
        public void solve(int testNumber, FastScanner in, PrintWriter out) {
            int n = in.nextInt();
            int m = in.nextInt();
            int k = in.nextInt();

            boolean[] blocked = new boolean[n + 1];

            for (int i = 0; i < m; i++) {
                int x = in.nextInt();
                blocked[x] = true;
            }

            int[] wantPole = new int[n + 1];
            int[] cost = new int[k + 1];
            for (int i = 1; i <= k; i++) {
                cost[i] = in.nextInt();
            }

            if (blocked[0]) {
                out.print("-1");
                return;
            }

            for (int i = 0; i <= n; i++) {
                if (!blocked[i]) wantPole[i] = i;
                else wantPole[i] = wantPole[i - 1];
            }

            int[] required = new int[k + 1];
            for (int i = 1; i <= k; i++) {
                int cnt = 0;
                for (int j = 0; ; ) {
                    if (j + i >= n) {
                        cnt++;
                        break;
                    }

                    int x = wantPole[j + i];
                    if (x == j) {
                        cnt = -1;
                        break;
                    }
                    cnt++;
                    j = x;
                }
                required[i] = cnt;
            }

            long min = Long.MAX_VALUE;
            for (int i = 1; i <= k; i++) {
                if (required[i] == -1) continue;
                long ct = (long) required[i] * cost[i];
                min = Math.min(ct, min);
            }
            if (min == Long.MAX_VALUE) out.print("-1");
            else out.print(min);
        }

    }

    static class FastScanner {
        private BufferedReader bufferedReader;
        private StringTokenizer stringTokenizer;

        public FastScanner(InputStream inputStream) {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        }

        public String next() {
            while (stringTokenizer == null || !stringTokenizer.hasMoreElements()) {
                try {
                    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return stringTokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

