import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author Don Li
 */
public class GameRobots {
    void solve() {
        int n = in.nextInt(), k = in.nextInt();
        int[] id = new int[n];
        for (int i = 0; i < n; i++) id[i] = in.nextInt();

        long[] sum = new long[n + 1];
        sum[0] = 0;
        for (int i = 1; i <= n; i++) sum[i] = sum[i - 1] + i;

        int lb = -1, ub = n;
        while (ub - lb > 1) {
            int m = (lb + ub) / 2;
            if (sum[m] >= k) ub = m;
            else lb = m;
        }

        int x = (int) ((k - sum[ub - 1]) % (ub + 1));
        out.println(id[x - 1]);
    }

    public static void main(String[] args) {
        in = new FastScanner(new BufferedReader(new InputStreamReader(System.in)));
        out = new PrintWriter(System.out);
        new GameRobots().solve();
        out.close();
    }

    static FastScanner in;
    static PrintWriter out;

    static class FastScanner {
        BufferedReader in;
        StringTokenizer st;

        public FastScanner(BufferedReader in) {
            this.in = in;
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
    }
}
