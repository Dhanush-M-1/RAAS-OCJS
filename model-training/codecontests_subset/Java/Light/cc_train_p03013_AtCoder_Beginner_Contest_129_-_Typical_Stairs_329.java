import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			long[] dp = new long[N + 3];
			boolean[] broken = new boolean[N + 3];
			int mul = 1000000007;
			for (int i = 0; i < M; i++) {
				int a = sc.nextInt();
				broken[a] = true;
				if (broken[a - 1] && broken[a]) {
					System.out.println(0);
					return;
				}
			}
			dp[0] = 1;
			for (int i = 1; i <= N; i++) {
				if (i == 1) {
					if (!broken[i]) dp[i]++;
				}
				else {
					if (broken[i]) dp[i] = 0;
					else dp[i] = (dp[i - 1] + dp[i - 2]) % mul;
				}
			}
			System.out.println(dp[N]);
		}
	}

}