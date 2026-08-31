import java.util.Scanner;

public class Main {
	static long mod = 1_000_000_007;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		boolean[] step = new boolean[in.nextInt()];
		int bs = in.nextInt();
		int[] bsnum = new int[bs];
		for (int i = 0; i < bs; i++) {
			bsnum[i] = in.nextInt();
		}
		in.close();
		for (int i = 0; i < step.length; i++) {
			step[i] = true;
		}
		for (int b : bsnum) {
			step[b - 1] = false;
			if (b != 1 && !step[b - 2]) {
				System.out.println(0);
				return;
			}
		}
		long[] dp = new long[step.length + 1];
		dp[0] = 1L;
		for (int i = 0; i < dp.length - 1; i++) {
			if (!step[i]) {
				dp[i + 1] = 0;
				continue;
			}
			if (i == 0) {
				dp[i + 1] = 1L;
            	continue;
			}
			dp[i + 1] = dp[i] + dp[i - 1];
			dp[i + 1] %= mod;
		}
		System.out.println(dp[step.length]);
	}
}