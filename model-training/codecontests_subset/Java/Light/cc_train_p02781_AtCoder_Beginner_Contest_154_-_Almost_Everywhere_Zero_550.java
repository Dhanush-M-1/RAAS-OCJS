import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int k = sc.nextInt();
		sc.close();

		int n = s.length();
		long[][][] dp = new long[n + 1][k + 1][2];
		dp[0][0][0] = 1;
//		int cnt = 0;
		for (int i = 0; i < n; i++) {
			int a = s.charAt(i) - '0';
//			if (a != 0) {
//				cnt++;
//			}
			for (int j = 0; j <= k; j++) {
				if (a == 0) {
					dp[i + 1][j][0] += dp[i][j][0];
					dp[i + 1][j][1] += dp[i][j][1];
				} else {
					dp[i + 1][j][1] += dp[i][j][0] + dp[i][j][1];
				}
				if (j < k) {
					if (a != 0) {
						dp[i + 1][j + 1][0] += dp[i][j][0];
						dp[i + 1][j + 1][1] += dp[i][j][0] * (a - 1);
					}
					dp[i + 1][j + 1][1] += dp[i][j][1] * 9;
				}
			}
		}
//		if (cnt < k) {
//			dp[n][k][0] = 0;
//		}
		System.out.println(dp[n][k][0] + dp[n][k][1]);
	}
}
