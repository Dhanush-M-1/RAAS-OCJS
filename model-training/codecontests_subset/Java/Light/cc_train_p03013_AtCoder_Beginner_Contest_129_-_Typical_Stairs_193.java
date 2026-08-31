import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[]$) {
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        Set<Integer> a = new HashSet<>();
        for (int i = 0; i < m; i++) {
            a.add(scanner.nextInt());
        }

        for (int i = 1; i <= n; i++) {
            if (!a.contains(i)) {
                dp[i] = (dp[i - 1] + (i == 1 ? 0 : dp[i - 2])) % 1000000007;
            }
        }
        System.out.println(dp[n]);
    }
}