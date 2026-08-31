import java.util.*;

public class Main {
    static int MOD = 1000000007;
    
    public static void main(String[] args) throws Exception {
        // Your code here!
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        boolean[] ng = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            ng[sc.nextInt()] = true;
        }
        
        long[] dp = new long[n + 1];
        dp[0] = 1;
        if (!ng[1]) dp[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            if (!ng[i-2]) dp[i] += dp[i-2];
            dp[i] %= MOD;
            if (!ng[i-1]) dp[i] += dp[i-1];
            dp[i] %= MOD;
        }
        
        System.out.println(dp[n]);
    }
}
