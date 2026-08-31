import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());
        int m = Integer.parseInt(sc.next());
        final int MOD = 1000000007;
        boolean[] ary = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            int a = Integer.parseInt(sc.next());
            ary[a] = true;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (!ary[i]) {
                dp[i] += dp[i - 1];
                if (i != 1) {
                    dp[i] += dp[i - 2];
                }
                dp[i] %= MOD;
            }
        }
        System.out.println(dp[n]);
    }
}