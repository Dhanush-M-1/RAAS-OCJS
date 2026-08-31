import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        boolean[] a = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            a[sc.nextInt()] = true;
        }
        long[] dp = new long[n + 1];
        dp[0] = 1;
        for (int i = 0; i < n + 1; i++) {
            if (i + 1 <= n && !a[i + 1]) {
                dp[i + 1] = (dp[i + 1] + dp[i]) % 1000000007;
            }
            if (i + 2 <= n && !a[i + 2]) {
                dp[i + 2] = (dp[i + 2] + dp[i]) % 1000000007;
            }
        }
        System.out.println(dp[n]);
    }
}