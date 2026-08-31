import java.util.*;

class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        HashSet<Integer> broken = new HashSet<>();
        for (int i = 0; i < m; i++) {
            broken.add(scan.nextInt());
        }
        long[] dp = new long[n + 5];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (broken.contains(i)) continue;
            long prev = dp[i - 1];
            long prev2 = 0;
            if (i - 2 >= 0) {
                prev2 = dp[i - 2];
            }
            dp[i] = prev + prev2;
            dp[i] %= 1_000_000_007;
        }
        System.out.println(dp[n]);
    }
}