import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), k = in.nextInt(), x = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; ++i) {
            a[i] = in.nextInt();
        }
        Arrays.sort(a);
        int[] b = new int[k];
        for (int i = 0; i < k; ++i) {
            b[i] = in.nextInt();
        }
        Arrays.sort(b);
        long[][] dp = new long[n + 1][k + 1];
        for (int i = 1; i <= n; ++i) {
            dp[i][0] = Long.MAX_VALUE;
            for (int j = 1; j <= k; ++j) {
                dp[i][j] = dp[i][j - 1];
                dp[i][j] = Math.min(dp[i][j], Math.max(Math.abs(x - b[j - 1]) + Math.abs(a[i - 1] - b[j - 1]), dp[i - 1][j - 1]));
            }
        }
        System.out.println(dp[n][k]);
    }
}