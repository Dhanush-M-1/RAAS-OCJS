
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = sc.nextInt();
        }
        long MOD = (long) 1e9 + 7;

        long[] dp = new long[n + 2];
        dp[0] = 1;
        // dp[i] ... i段目にたどり着く数
        int currentIdx = 0;
        for (int i = 0; i < n; i++) {
            if (currentIdx < m && i == arr[currentIdx]) {
                currentIdx++;
                continue;
            }
            dp[i + 1] += dp[i] % MOD;
            dp[i + 2] += dp[i] % MOD;
        }
        System.out.println(dp[n] % MOD);
    }


    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
