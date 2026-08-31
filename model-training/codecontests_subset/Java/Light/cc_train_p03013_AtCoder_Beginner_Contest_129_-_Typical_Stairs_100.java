import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next()), m = Integer.parseInt(sc.next());
        boolean[] a = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            a[Integer.parseInt(sc.next())] = true;
        }
        int mod = 1000000007;

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = a[1] ? 0 : 1;
        for (int i = 2; i <= n; i++) {
            if (a[i]) continue;
            dp[i] = dp[i - 1] + dp[i - 2];
            if (dp[i] >= mod) {
                dp[i] -= mod;
            }
        }

        System.out.println(dp[n]);
    }
}
