import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		boolean clash[] = new boolean[n + 1];
		Arrays.fill(clash, true);

		for (int i = 0; i < m; i++) clash[sc.nextInt()] = false;

		int dp[] = new int[n + 1];
		dp[0] = 1;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j <= Math.min(i + 2, n); j++) {
				if (clash[j]) {
					dp[j] += dp[i];
					dp[j] %= 1000000007;
				}
			}
		}

		System.out.println(dp[n]);

		sc.close();

	}

}
