import java.util.*;

public class Main {
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            set.add(sc.nextInt());
        }
        long[] dp = new long[n+1];
        dp[0] = 1;
        long mod = 1000000007;
        for (int i = 1; i <=n ; i++) {
            if (!set.contains(i)) {
                dp[i] = dp[i-1];
                if (i-2 >=0 ) dp[i] += dp[i-2];
                dp[i] %=  mod;
            }
        }

        System.out.println(dp[n]);
    }
}