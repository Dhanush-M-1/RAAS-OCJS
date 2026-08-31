import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String N[] = br.readLine().split("");
		int K = Integer.parseInt(br.readLine());

		long dp[][][] = new long[105][2][5]; // i 桁目までで 0 以外の数を使用したのが k 個である数の個数。
		dp[0][0][0] = 1;

		for (int i = 0; i < N.length; i++) {
			for (int j = 0; j < K + 1; j++) {
				// i桁目まででNより小さいならi+1桁目は何でも良い
				dp[i + 1][1][j + 1] += dp[i][1][j] * 9; // i+1桁目が0以外なら0以外の個数jも+1
				dp[i + 1][1][j] += dp[i][1][j]; // i+1桁目が0なら0以外の個数jは不変

				// i桁目までNと同じで、i+1桁目はNより小さい数の時
				int ni = Integer.parseInt(N[i]); // i桁目の数
				if (ni > 0) {
					dp[i + 1][1][j + 1] += dp[i][0][j] * (ni - 1); // i+1桁目が0以外
					dp[i + 1][1][j] += dp[i][0][j]; // i+1桁目が0
				}

				// i桁目までNと同じで、i+1桁目もNと同じ数の時
				if (ni > 0) { // i+1桁目が0かどうか
					dp[i + 1][0][j + 1] = dp[i][0][j]; // i+1桁目が0以外
				} else {
					dp[i + 1][0][j] = dp[i][0][j]; // i+1桁目が0
				}
			}
		}

		long ans = dp[N.length][0][K] + dp[N.length][1][K];
		System.out.println(ans);
	}
}
