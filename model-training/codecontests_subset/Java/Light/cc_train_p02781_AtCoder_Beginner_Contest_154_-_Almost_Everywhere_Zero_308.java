import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws Exception {
		final Scanner sc = new Scanner(System.in);
		char[] n = sc.next().toCharArray();
		int K = sc.nextInt();
		long[][][] dp = new long[n.length + 1][K + 1][2];
		dp[0][0][0] = 1;

		for (int i = 0; i < n.length; i++) {
			int d = Integer.parseInt(String.valueOf(n[i]));

			for (int j = 0; j <= K; j++) {
				if (d == 0) {
					dp[i + 1][j][0] += dp[i][j][0];
					dp[i + 1][j][1] += dp[i][j][1];
					if (j != K) dp[i + 1][j + 1][1] += dp[i][j][1] * 9;
				} else {
					dp[i + 1][j][1] += dp[i][j][0];
					dp[i + 1][j][1] += dp[i][j][1];
					if (j != K) {
						dp[i + 1][j + 1][0] += dp[i][j][0];
						dp[i + 1][j + 1][1] += dp[i][j][0] * (d - 1);
						dp[i + 1][j + 1][1] += dp[i][j][1] * 9;
					}
				}
			}
		}

		System.out.println(dp[n.length][K][0] + dp[n.length][K][1]);
	}
}
