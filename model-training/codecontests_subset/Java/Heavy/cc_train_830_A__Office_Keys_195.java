import java.io.BufferedInputStream;
import java.util.*;


public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int n = sc.nextInt();
        int k = sc.nextInt();
        int p = sc.nextInt();
        int[] a = new int[n + 1];
        int[] b = new int[k + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 1; i <= k; i++) {
            b[i] = sc.nextInt();
        }

        Arrays.sort(a, 1, n + 1);
        Arrays.sort(b, 1, k + 1);
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= k; j++) {
                if (i == j) {
                    dp[i][j] = Math.max(dp[i - 1][j - 1], Math.abs(p - b[j]) + Math.abs(a[i] - b[j]));
                    continue;
                }
                dp[i][j] = Math.min(dp[i][j - 1], Math.max(dp[i - 1][j - 1], Math.abs(p - b[j]) + Math.abs(a[i] - b[j])));

            }
        }
        long maxn = dp[n][k];
        for (int i = n; i < k; i++) {
            maxn = Math.min(maxn, dp[n][i]);
        }
        System.out.println(maxn);
    }


}