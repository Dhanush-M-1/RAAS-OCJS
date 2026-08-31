


import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] a = new int[m];

		for (int i = 0; i < m; i++) {
			a[i] = sc.nextInt();
		}

		int[] dp = new int[n + 1];

		for (int i = 0; i < n + 1; i++) {
			dp[i] = 1;
		}
		for (int i = 0; i < m; i++) {
			dp[a[i]] = 0;
		}

		for (int i = 2; i < n + 1; i++) {
			if (dp[i] == 1)
				dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
		}

		System.out.println(dp[n]);
	}

}
