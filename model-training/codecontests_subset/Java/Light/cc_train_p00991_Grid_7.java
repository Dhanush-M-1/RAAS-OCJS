import java.util.Arrays;
import java.util.Scanner;

public class Main {

	Scanner sc = new Scanner(System.in);
	final int p = 100000007;
	int[][] dp = new int[1001][1001];

	void run() {
		init();
		int r = sc.nextInt();
		int c = sc.nextInt();
		int a1 = sc.nextInt();
		int a2 = sc.nextInt();
		int b1 = sc.nextInt();
		int b2 = sc.nextInt();
		int w1 = Math.abs(a1 - b1);
		int h1 = Math.abs(a2 - b2);
		int w2 = r - Math.abs(a1 - b1);
		int h2 = c - Math.abs(a2 - b2);

		int w = Math.min(w1, w2);
		int h = Math.min(h1, h2);
		int ans = dp[w + h][w];
		if (w1 == w2)
			ans = ans * 2 % p;
		if (h1 == h2)
			ans = ans * 2 % p;
		System.out.println(ans);
	}

	void init() {
		dp[0][0] = 1;
		for (int i = 1; i < 1001; i++) {
			dp[i][0] = 1;
			for (int j = 1; j < 1001; j++) {
				dp[i][j] = (dp[i - 1][j] + dp[i - 1][j - 1]) % p;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		new Main().run();
	}
}