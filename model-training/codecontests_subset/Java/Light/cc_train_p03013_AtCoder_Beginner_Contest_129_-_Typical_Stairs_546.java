import java.util.*;
 
class Main {
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int mod = 1000000007;
        int[] broken = new int[n + 1];
        for (int i = 0; i < m; i++) {
            broken[scan.nextInt()] = 1;
        }
        long[] dp = new long[n + 1];
        dp[0] = 1;
        if (broken[1] == 0) {
            dp[1] = 1;
        } else {
            dp[1] = 0;
        }
        for (int i = 2; i < n + 1; i++) {
            if (broken[i] == 1) {
                continue;
            }
            dp[i] = (dp[i - 1] + dp[i - 2])%mod;
        }
        System.out.println(dp[dp.length - 1]);
    }
}