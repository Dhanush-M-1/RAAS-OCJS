import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    private static final long MOD = 1_000_000_007;

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int T = in.nextInt();

        final long[] dp = new long[2_000_000 + 1];
        dp[3] = 4;

        int computedUpTo = 4;

        for (int t = 0; t < T; t += 1) {
            final int n = in.nextInt();

            for (int i = computedUpTo; i <= n; i += 1) {
                dp[i] = (((i % 3 == 0) ? 4 : 0) + dp[i - 1] + 2 * dp[i - 2]) % MOD;
            }

            computedUpTo = Math.max(computedUpTo, n + 1);

//            System.out.printf("computedUpTo: %d\n", computedUpTo);
//            if (n <= 100) {
//                System.out.printf("dp: %s\n", Arrays.toString(Arrays.copyOf(dp, n + 1)));
//            }

            System.out.println(dp[n]);
        }
    }
}
