import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author P Marecki
 */
public class Main {
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
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int nk = in.nextInt();
            int p = in.nextInt();
            int[] a = new int[n];
            int[] k = new int[nk];
            for (int i = 0; i < n; i++) a[i] = in.nextInt();
            Arrays.sort(a);

            for (int i = 0; i < nk; i++) k[i] = in.nextInt();
            Arrays.sort(k);

            long[] dk = new long[nk];
            for (int i = 0; i < nk; i++) dk[i] = Math.abs(p - k[i]);

            //-------------------------------
            long[] dp = new long[nk + 1];
            //best solution for the last person
            dp[nk] = (long) 1e12;
            dp[nk - 1] = Math.abs(a[n - 1] - k[nk - 1]) + dk[nk - 1]; //last with last

            for (int i = nk - 2; i >= 0; --i) {
                dp[i] = Long.min(dp[i + 1], Math.abs(a[n - 1] - k[i]) + dk[i]); //orTake_i-th
            }
//        System.out.println(Arrays.toString(dp));

            for (int i = n - 2; i >= 0; i--) {
                long[] ndp = new long[nk + 1];
                //best sol for i'th person, assuming it has access to j...nk-1 k's
                ndp[nk] = (long) 1e12;
                for (int j = nk - 1; j >= 0; --j) { //orTake_j-th
                    ndp[j] = Long.min(ndp[j + 1], Long.max(Math.abs(a[i] - k[j]) + dk[j], dp[j + 1]));
                }
                dp = ndp;
//            System.out.println(Arrays.toString(dp));
            }
            long ans = dp[0];
            out.println(ans);
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

