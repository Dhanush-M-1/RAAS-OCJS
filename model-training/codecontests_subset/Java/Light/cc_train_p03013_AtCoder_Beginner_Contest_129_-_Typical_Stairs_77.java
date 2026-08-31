import java.util.*;

public class Main {

	static int MOD = 1_000_000_007;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		boolean[] broken = new boolean[N + 10];
		Arrays.fill(broken, false);
		for (int i = 0; i < M; i++) {
			broken[sc.nextInt()] = true;
		}
		sc.close();

		long[] dp = new long[N + 10];
		dp[0] = 0;
		dp[1] = broken[1] ? 0 : 1;
		if (broken[2]) {
			dp[2] = 0;
		} else if (broken[1]) {
			dp[2] = 1;
		} else {
			dp[2] = 2;
		}
		for (int i = 3; i <= N; i++) {
			if (broken[i]) {
				dp[i] = 0;
			} else {
				dp[i] = (dp[i - 2] + dp[i - 1]) % MOD;
			}
		}

		System.out.println(dp[N]);
	}
}
