import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String n = sc.next();
		int K = sc.nextInt();

		int len = n.length();

		char[] s = n.toCharArray();

		int[][][] dp = new int[105][4][2]; //dp[i][j][k]は、i桁目までの数字で、j個の非ゼロがある場合の数。k=0のとき、dpはi桁目までnと同じ数字である。
		dp[0][0][0] = 1;
		for (int i = 0; i < len; i++) {
			int maxD = s[i] - '0';
			for (int j = 0; j < 4; j++) {
				for (int k = 0; k < 2; k++) {
					for (int d = 0; d < 10; d++) {
						int nextI = i + 1;
						int nextJ = j;
						int nextK = k;

						if (d != 0) {
							nextJ++;
						}
						if (nextJ > K) {
							continue;
						}
						if (k == 0) {
							if (d > maxD) {
								continue;
							}
							if (d < maxD) {
								nextK = 1;
							}
						}
						dp[nextI][nextJ][nextK] += dp[i][j][k];
					}
				}
			}
		}
		int ans = dp[len][K][0] + dp[len][K][1];
		System.out.println(ans);
	}

}