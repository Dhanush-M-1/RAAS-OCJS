import java.util.Scanner;

public class Main {

	static long MOD = 1000000007;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		boolean[] broken =new boolean[N+1];

		for (int i = 0; i < M; i++) {
			broken[sc.nextInt()] = true;
		}

		long[] dp=new long[N+1];
		dp[0] = 1;
		for (int i = 1; i < N +1; i++) {
			if (broken[i]) {
				continue;
			}else {
				long con = 0;
				//1段
				con = con + dp[i-1] % MOD;

				//2段
				if (i-2 >= 0) {
					con = con + dp[i-2] % MOD;
				}
				dp[i] = con;
			}
		}

		System.out.println(dp[N] % MOD);

	}

}
