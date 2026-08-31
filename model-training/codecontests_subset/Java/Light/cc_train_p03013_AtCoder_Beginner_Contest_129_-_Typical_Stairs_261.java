import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int mod = 1000000007;
        Scanner std = new Scanner(System.in);
        int n = std.nextInt();
        int m = std.nextInt();
        int[] as = new int[m];
        int[] dp = new int[n + 1];
        boolean[] none = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            int no = std.nextInt();
            none[no] = true;
        }

        dp[0] = 1;
        if (!none[1]) {
            dp[1] = 1;
        }

        for (int i = 0; i < n - 1; i++) {
            if (!none[i + 2]) {
                dp[i + 2] = dp[i + 1] + dp[i];
                dp[i + 2] %= mod;
            }
        }

        System.out.println(dp[n]);
    }
}
