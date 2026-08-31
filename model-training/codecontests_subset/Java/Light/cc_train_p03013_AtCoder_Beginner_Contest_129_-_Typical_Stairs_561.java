import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());
        int m = Integer.parseInt(sc.next());
        int MOD = 1_000_000_007;
        int a[] = new int[m];
        int dp[] = new int[n + 2];
        dp[0] = 1;
        for (int i = 0; i < m; i++) {
            a[i] = Integer.parseInt(sc.next());
            dp[a[i]] = -1;
        }
        sc.close();
        for (int i = 0; i < n; i++) {
            if (dp[i] == -1) {
                continue;
            }
            if (dp[i + 1] != -1) {
                dp[i + 1] += dp[i];
                dp[i + 1] %= MOD;
            }
            if (dp[i + 2] != -1) {
                dp[i + 2] += dp[i];
                dp[i + 2] %= MOD;
            }
        }
        System.out.print(dp[n]);
    }
}