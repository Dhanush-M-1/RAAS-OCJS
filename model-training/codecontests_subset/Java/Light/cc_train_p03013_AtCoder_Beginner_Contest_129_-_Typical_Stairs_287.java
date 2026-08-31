import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		boolean[] issafe = new boolean[N + 1];
		Arrays.fill(issafe, true);
		for (int i = 0; i < M; i++) {
			issafe[in.nextInt()] = false;
		}
		int[] dp = new int[N + 1];
		dp[0] = 1;
		if (issafe[1]) {
			dp[1] = 1;
		}
		for (int i = 2; i <= N; i++) {
			if (issafe[i - 1]) {
				dp[i] += dp[i - 1];
			}
			if (issafe[i - 2]) {
				dp[i] += dp[i - 2];
			}
			dp[i] %= 1000000007;
		}
		System.out.println(dp[N]);
		in.close();
	}
}