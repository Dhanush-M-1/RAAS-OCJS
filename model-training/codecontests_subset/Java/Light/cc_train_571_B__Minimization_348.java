import java.util.Arrays;
import java.util.Scanner;

public class Main {
	private final int MOD = (int) 1e9 + 7;
	private final long INF = Long.MAX_VALUE / 4;

	public void solve() {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int K = scanner.nextInt();
		int[] a = new int[N];
		for (int i = 0; i < N; i++) {
			a[i] = scanner.nextInt();
		}
		Arrays.sort(a);

		int res = N % K;
		int len = N / K;

		long[] dp = new long[K + 1];
		Arrays.fill(dp, INF);
		dp[0] = 0;
		long[] dp2 = new long[K + 1];
		for (int i = 1; i <= K; ++i) {
			Arrays.fill(dp2, INF);
			for (int j = 0; j <= res; ++j) {
				dp2[j] = dp[j] + a[i * len + j - 1] - a[(i - 1) * len + j];
				if (j > 0) {
					dp2[j] = Math.min(dp2[j], dp[j - 1] + a[i * len + j - 1]
							- a[(i - 1) * len + j - 1]);
				}
			}
			for (int j = 0; j <= K; j++) {
				dp[j] = dp2[j];
			}
		}
		System.out.println(dp[res]);
	}

	public static void main(String[] args) {
		new Main().solve();
	}

}
