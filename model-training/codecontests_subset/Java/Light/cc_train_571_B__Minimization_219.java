import java.util.Arrays;
import java.util.Scanner;

public class Main {
	private final long INF = Long.MAX_VALUE / 4;

	public void solve() {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int groups = scanner.nextInt();
		int[] A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = scanner.nextInt();
		}
		Arrays.sort(A);

		int member = N / groups;
		int bigGroups = N % groups;// メンバーが1人多いグループの数

		long[] dp = new long[groups + 1];
		Arrays.fill(dp, INF);
		dp[0] = 0;

		long[] dp2 = new long[groups + 1];

		// dp[groupNum][bigNum]:=groupNum個グループを作った時、bigNum個bigGroupを作った時の最小値
		for (int groupNum = 1; groupNum <= groups; ++groupNum) {
			Arrays.fill(dp2, INF);

			for (int bigNum = bigGroups; bigNum >= 0; bigNum--) {
				// bigNumは今までに作ったbigGroupの数
				int start = (groupNum - 1) * member + bigNum;
				int cost = Math.abs(A[start + member - 1] - A[start]);
				dp2[bigNum] = Math.min(dp[bigNum] + cost, dp2[bigNum]);

				if (bigNum == bigGroups) {
					continue;
				}
				int largeCost = Math.abs(A[start + member] - A[start]);
				dp2[bigNum + 1] = Math.min(dp2[bigNum + 1], dp[bigNum]
						+ largeCost);

			}

			// コピーする
			for (int j = 0; j <= groups; j++) {
				dp[j] = dp2[j];
			}
		}
		System.out.println(dp[bigGroups]);
		scanner.close();
	}

	public static void main(String[] args) {
		new Main().solve();
	}

}
