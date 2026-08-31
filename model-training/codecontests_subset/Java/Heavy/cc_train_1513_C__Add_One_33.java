import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


public class TaskC {

    private static int MOD = 1_000_000_007;
    private static long MULT = 2 * 100_0000;

    public static void main(String[] arg) {
        final FastScanner in = new FastScanner(System.in);
        final PrintWriter out = new PrintWriter(System.out);
        final int T = in.nextInt();
        final StringBuilder res = new StringBuilder();

        final int[][] input = new int[T][2];
        int max = 0;
        for (int t = 0; t < T; t++) {
            input[t][0] = in.nextInt();
            input[t][1] = in.nextInt();
            max = Math.max(input[t][1], max);

        }
        final long[] dp = dp(max + 20);
        for (int t = 0; t < T; t++) {
            int n = input[t][0];
            final int m = input[t][1];
            long result = 0;
            do {
                int num = n % 10;
                n /= 10;
                result += dp[num + m];
                result%=MOD;
            } while (n > 0);
            res.append(result).append('\n');
        }
        out.print(res);
        out.flush();
        out.close();
        in.close();
    }

    public static long[] dp(int m) {
        long[] dp = new long[m + 1];
        long[] acc = new long[m+1];
        for (int i = 0; i <= m; i++) {
            dp[i] = 1;
            long sums = 0;
            for (int j = i - 10; j >= 0; j -= 9) {
                if(acc[j]!=0){
                    sums+=acc[j];
                    break;
                }
                sums+=dp[j];
                sums%=MOD;
            }
            sums%=MOD;
            if(i-10>0) {
                acc[i - 10] = sums;
            }
            dp[i]+=sums;
            dp[i] %= MOD;
        }

        return dp;
    }

    public static long recursion(int n, final int m, Map<Long, Long> mem) {
        long sum = 0;
        if (m == 0) {
            return countNums(n);
        }
        final long key = n * MULT + m;
        if (mem.containsKey(key)) {
            return mem.get(key);
        }
        do {
            int num = n % 10;
            n /= 10;
            sum += recursion(num + 1, m - 1, mem);
            sum %= MOD;
        } while (n > 0);
        mem.put(key, sum);
        return sum % MOD;
    }

    private static int countNums(int n) {
        if (n == 0) {
            return 1;
        }
        int c = 0;
        while (n > 0) {
            n /= 10;
            c++;
        }
        return c;
    }

    private static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
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

        double nextDouble() {
            return Double.parseDouble(next());
        }

        int[] readIntArr(int n) {
            int[] result = new int[n];
            for (int i = 0; i < n; i++) {
                result[i] = Integer.parseInt(next());
            }
            return result;
        }

        long[] readLongArr(int n) {
            long[] result = new long[n];
            for (int i = 0; i < n; i++) {
                result[i] = Long.parseLong(next());
            }
            return result;
        }


        void close() {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        long nextLong() {
            return Long.parseLong(next());
        }

    }


}