import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		char[] s = sc.next().toCharArray();
		int k = sc.nextInt();
		sc.close();

		int n = s.length;
		int[][] dp0 = new int[n + 1][k + 1];
		int[][] dp1 = new int[n + 1][k + 1];
		dp0[0][0] = 1;
		for (int i = 0; i < n; i++) {
			dp1[i + 1][0] = 1;
			if (s[i] == '0') {
				for (int j = 1; j <= k; j++) {
					dp0[i + 1][j] = dp0[i][j];
					dp1[i + 1][j] = dp1[i][j - 1] * 9 + dp1[i][j];
				}
			} else {
				int d = s[i] - '0' - 1;
				for (int j = 0; j < k; j++) {
					dp0[i + 1][j + 1] = dp0[i][j];
					dp1[i + 1][j + 1] = dp0[i][j] * d + dp0[i][j + 1]
							+ dp1[i][j] * 9 + dp1[i][j + 1];
				}
			}
		}
		System.out.println(dp0[n][k] + dp1[n][k]);
	}
}
