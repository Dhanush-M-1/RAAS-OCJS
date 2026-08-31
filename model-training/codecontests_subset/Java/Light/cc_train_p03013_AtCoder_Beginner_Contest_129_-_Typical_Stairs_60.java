import java.util.Scanner;

public class Main {
	private final static long mod = 1_000_000_007;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		long[] dp = new long[N + 1];
		boolean[] ng = new boolean[N + 1];
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			ng[a] = true;
		}
		sc.close();

		// --test
		// System.out.print("# ");
		// for (int i = 0; i < dp.length; i++) {
		// 	System.out.print(dp[i] + " ");
		// }
		// System.out.println("");
		// --test

		// 最後の段に1を設定
		dp[N] = 1;
		// 最後の1段前が壊れていなければ1を設定
		if (!ng[N - 1]) dp[N - 1] = 1;
		// 壊れている段を飛ばして最後の段までのパターンを取得する
		for (int i = N - 2; i >= 0; i--) {
			if (ng[i]) continue;
			dp[i] = dp[i + 1] + dp[i + 2];
			dp[i] %= mod;
		}

		// --test
		// System.out.print("# ");
		// for (int i = 0; i < dp.length; i++) {
		// 	System.out.print(dp[i] + " ");
		// }
		// System.out.println("");
		// --test

		// 結果出力
		System.out.println(dp[0]);
	}
}
