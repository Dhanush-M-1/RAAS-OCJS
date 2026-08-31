import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long mod = 1_000_000_007;
        int n = sc.nextInt();
        int m = sc.nextInt();
        boolean[] a = new boolean[n+1];
        a[0] = false;
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            a[x] = true;
        }
        long[] dp = new long[n+1];
        dp[0] = 1;
        if(!a[1]) dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            if(!a[i])dp[i] += dp[i-1] + dp[i-2];
            dp[i] %= mod;
        }
        System.out.println(dp[n]);
        sc.close();

    }

}
