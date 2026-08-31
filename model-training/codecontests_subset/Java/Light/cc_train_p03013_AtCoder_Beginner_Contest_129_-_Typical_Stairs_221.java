import java.util.*;

public class Main {
    //Typical Stairs
    //DP?
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        int mod = 1000000007;
        for (int i = 1; i <= m; i++) dp[sc.nextInt()] = -1;
        for (int i = 1; i <= n; i++) {
            if (dp[i] == -1) {
                dp[i] = 0;
            } else {
                if (i == 1) {
                    dp[i] = 1;
                } else dp[i] = (dp[i - 1] + dp[i - 2]) % mod;
            }
        }
        System.out.println(dp[n]);
        sc.close();
    }
}
