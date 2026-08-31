import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long mod = 1_000_000_007;
        int max = 2_000_000;
        long[] dp = new long[max+1];
        Arrays.fill(dp, -1);
        dp[1] = 0;
        dp[2] = 0;
        dp[3] = 4;
        int highestCalced = 3;
        int tests = scanner.nextInt();
        for (int t = 0; t < tests; t++) {
            int n = scanner.nextInt();
            if (dp[n] == -1) {
                for (int i = highestCalced + 1; i <= n; i++) {
                    dp[i] = (dp[i - 1] + (2 * dp[i - 2]) % mod) % mod + (i % 3 == 0 ? 4 : 0);
                }
                highestCalced = n;
            }
            System.out.println(dp[n]);
        }
    }
}