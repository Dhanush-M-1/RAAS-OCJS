
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int n = in.nextInt();
        final int m = in.nextInt();
        final Set<Integer> broken = new HashSet<>();
        for (int i = 0; i < m; i++) {
            broken.add(in.nextInt());
        }

        int[] dp = new int[n + 1];

        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (broken.contains(i)) {
                continue;
            }
            int count = 0;
            if (!broken.contains(i - 1)) {
                count += dp[i - 1];
            }
            if (i - 2 >= 0 && !broken.contains(i - 2)) {
                count += dp[i - 2];
            }
            count %= 1_000_000_007;
            dp[i] = count;
        }
        System.out.println(dp[n]);
    }
}
