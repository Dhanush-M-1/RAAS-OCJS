import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class a45 {
	static int n;
	static int[] x;
	static int[] h;
	static int[][] dp;

	/*
	 * last_dir: 0-->left 1-->stay 2-->right
	 */

	public static int solve(int idx, int last_dir) {
		if (idx >= n)
			return 0;
		if (dp[idx][last_dir] != -1)
			return dp[idx][last_dir];
		if (idx == n - 1)
			return 1;
		int last = x[idx - 1];

		if (last_dir == 2)
			last += h[idx - 1];

		if (x[idx] - h[idx] > last) {
			return dp[idx][last_dir] = 1 + solve(idx + 1, 0);

		}
		int sol1 = 0;
		if (x[idx] + h[idx] < x[idx + 1]) {
			sol1 = 1 + solve(idx + 1, 2);
		}
		int sol2 = solve(idx + 1, 1);
		return dp[idx][last_dir] = Math.max(sol1, sol2);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(new InputStreamReader(System.in));
		n = in.nextInt();
		x = new int[n];
		h = new int[n];

		for (int i = 0; i < n; i++) {
			x[i] = in.nextInt();
			h[i] = in.nextInt();
		}
		dp = new int[n][3];
		for (int i = 0; i < n; i++) {
			Arrays.fill(dp[i], -1);
		}

		System.out.println(1 + solve(1, 0));

	}
}
