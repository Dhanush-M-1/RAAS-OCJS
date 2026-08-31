import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] input = new int[M];
		for (int i = 0; i < M; i++) {
			input[i] = sc.nextInt();
		}
		int[] dp = new int[N + 1];
		dp[0] = 1;
		int pointer = 0;
		if (pointer < M && input[pointer] == 1) {
			dp[1] = 0;
			pointer++;
		} else {
			dp[1] = 1;
		}
		for (int i = 2; i <= N; i++) {
			if (pointer < M && input[pointer] == i) {
				dp[i] = 0;
				pointer++;
			} else {
				dp[i] = (dp[i - 2] + dp[i - 1]) % 1000000007;
			}
		}
		System.out.print(dp[N]);
	}
}
