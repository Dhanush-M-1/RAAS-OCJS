import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    private static final int MOD = 1_000_000_007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Set<Integer> a = new HashSet<>();
        for (int i = 0; i < m; i++) {
            a.add(sc.nextInt());
        }

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        if (a.contains(1)) {
            dp[1] = 0;
        }
        for (int i = 2; i <= n; i++) {
            if (a.contains(i)) {
                dp[i] = 0;
                continue;
            }
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
        }
        System.out.println(dp[n]);
    }

}
