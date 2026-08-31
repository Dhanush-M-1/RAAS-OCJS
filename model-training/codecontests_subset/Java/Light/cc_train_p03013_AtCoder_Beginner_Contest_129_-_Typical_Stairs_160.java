import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < m; i++) {
			set.add(sc.nextInt());
		}
		sc.close();

		long[] dp = new long[n + 1];
		dp[0] = 1;
		if (!set.contains(1)) {
			dp[1] = 1;
		}
		for (int i = 2; i <= n; i++) {
			if (!set.contains(i)) {
				dp[i] = dp[i - 2] + dp[i - 1];
				dp[i] %= 1000000007;
			}
		}
		System.out.println(dp[n]);
	}
}
