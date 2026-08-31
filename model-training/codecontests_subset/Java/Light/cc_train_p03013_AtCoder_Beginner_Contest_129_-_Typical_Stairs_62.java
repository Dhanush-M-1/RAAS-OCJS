import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N, M;
		N = sc.nextInt();
		M = sc.nextInt();
		int[] broken = new int[N + 1];
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			broken[a] = 1;
		}

		int[] dp = new int[N + 2];
		dp[N] = 1;
		for(int i = N - 1; i >= 0; i--) {
			if (broken[i] == 1) {
				dp[i] = 0;
				continue;
			}
			dp[i] = (dp[i + 1] + dp[i + 2]) % 1000000007;
		}

		System.out.println(dp[0]);
	}
}