import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int N;

	public static void main(String[] args) {
		N = sc.nextInt();
		double[] A = new double[N];
		for (int i = 0; i < N; ++i) {
			A[i] = sc.nextDouble();
		}
		final int MAX = 200001;
		double[][] dp = new double[2][MAX];
		double div = 1.0 / A[0];
		for (int i = 1; i < MAX; ++i) {
			dp[0][i] = Math.abs(A[0] - i) * div;
		}
		for (int i = 1; i < N; ++i) {
			int t = i & 1;
			Arrays.fill(dp[t], 1e9);
			div = 1.0 / A[i];
			for (int j = 1; j < MAX; ++j) {
				for (int k = j; k < MAX; k += j) {
					dp[t][k] = Math.min(dp[t][k], Math.max(dp[1 - t][j], Math.abs(A[i] - k) * div));
				}
			}
		}
		double ans = 1e9;
		for (int i = 1; i < MAX; ++i) {
			ans = Math.min(ans, dp[1 - N & 1][i]);
		}
		System.out.printf("%.9f\n", ans);
	}
}