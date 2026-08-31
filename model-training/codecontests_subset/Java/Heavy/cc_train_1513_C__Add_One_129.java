import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static void run() throws IOException {
        int n = in.nextInt();
        int m = in.nextInt();

        long ans = 0;
        while (n != 0) {
            int now = n % 10;
            n /= 10;
            int times = m + (now - 1);
            ans = (ans + dp[times]) % mod;
        }
        out.println(ans);
    }

    private static final int max_m = 200020;
    private static final long[] dp = new long[max_m + 1];
    private static final long[] sum_10 = new long[max_m + 1];

    private static void init() {
        dp[0] = 1;
        sum_10[0] = 1;
        for (int i = 1; i <= max_m; i++) {
            dp[i] = 1;
            if (i >= 9) {
                dp[i] = (dp[i] + dp[i - 9]) % mod;
            }
            if (i - 9 >= 10) {
                dp[i] = (dp[i] + sum_10[i - 9 - 10]) % mod;
            }

            sum_10[i] = dp[i];
            if (i >= 10) {
                sum_10[i] = (sum_10[i - 10] + sum_10[i]) % mod;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        in = new Reader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));

        init();

        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            run();
        }

        out.flush();
        in.close();
        out.close();
    }

    @SuppressWarnings("FieldCanBeLocal")
    private static Reader in;
    private static PrintWriter out;

    static final long mod = 1000000007;

    private static long times_mod(long... longs) {
        long ans = 1;
        for (long now : longs) {
            ans = (ans * now) % mod;
        }
        return ans;
    }

    private static long pow_mod(long a, long b) {
        long ans = 1;
        while (b != 0) {
            if ((b & 1) != 0) {
                ans = (ans * a) % mod;
            }
            a = (a * a) % mod;
            b >>= 1;
        }
        return ans;
    }

    private static void print_array(int[] array) {
        for (int now : array) {
            out.print(now);
            out.print(' ');
        }
        out.println();
    }

    private static void print_array(long[] array) {
        for (long now : array) {
            out.print(now);
            out.print(' ');
        }
        out.println();
    }

    static class Reader {
        BufferedReader reader;
        StringTokenizer st;

        Reader(InputStreamReader stream) {
            reader = new BufferedReader(stream, 32768);
            st = null;
        }

        void close() throws IOException {
            reader.close();
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        String nextLine() throws IOException {
            return reader.readLine();
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

    }
}