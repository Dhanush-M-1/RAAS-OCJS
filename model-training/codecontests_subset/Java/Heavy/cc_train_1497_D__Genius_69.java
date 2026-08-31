import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static void run(Reader in, PrintWriter out) throws IOException {
        int n = in.nextInt();
        int[] tag = new int[n];
        int[] s = new int[n];
        for (int i = 0; i < n; i++) {
            tag[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            s[i] = in.nextInt();
        }

        long ans = 0;
        long[][] dp = new long[n][2];
        for (int i = 1; i < n; i++) {
            int current_index = i % 2;
            int pre_index = (i + 1) % 2;
            long max_pre = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (tag[j] != tag[i]) {
                    long current_value = Math.abs(s[i] - s[j]);
                    dp[j][current_index] = Math.max(dp[j][pre_index], max_pre + current_value);
                    ans = Math.max(ans, dp[j][current_index]);

                    max_pre = Math.max(max_pre, current_value + dp[j][pre_index]);
                } else {
                    dp[j][current_index] = dp[j][pre_index];
                }
            }
            dp[i][current_index] = max_pre;
            ans = Math.max(ans, max_pre);
        }
        out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        Reader in = new Reader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            run(in, out);
        }

        out.flush();
        in.close();
        out.close();
    }

    static class Reader {
        BufferedReader reader;
        StringTokenizer st;

        Reader(InputStreamReader stream) {
            reader = new BufferedReader(stream);
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