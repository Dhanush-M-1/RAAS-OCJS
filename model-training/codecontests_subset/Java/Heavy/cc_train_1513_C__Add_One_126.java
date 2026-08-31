import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C {
    static long mod = (long) (1e9 + 7);

    public static void main(String[] args) {
        FastReader scn = new FastReader();
        long[] dp = new long[(int) 2e5 + 20];
        for (int i = 0; i < 2e5 + 10; i++) {
            if (i < 10) {
                dp[i] = 1;
                dp[i] = dp[i] % mod;
                continue;
            }
            dp[i] = dp[i - 10] + dp[i - 9];
            dp[i] = dp[i] % mod;

        }
        StringBuilder ans = new StringBuilder();
        int cases = scn.nextInt();
        while (cases-- > 0) {
            int n = scn.nextInt();
            int m = scn.nextInt();
            long count = 0;
            while (n > 0) {
                int digit = n % 10;
                count += dp[digit + m];
                count %= mod;
                n /= 10;
            }
            ans.append(count + "\n");
        }

        System.out.println(ans);


    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

}
