import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str[] = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);

		int dp[] = new int[100010];

		for (int i = 0; i < m; i++) {
			int a = Integer.parseInt(br.readLine());
			dp[a] = Integer.MAX_VALUE;
		}

		dp[0] = 1;
		if (dp[1] == Integer.MAX_VALUE) {
			dp[1] = 0;
		} else {
			dp[1] = 1;
		}

		for (int i = 2; i <= n; i++) {
			if (dp[i] == Integer.MAX_VALUE) {
				dp[i] = 0;
			} else {
				dp[i] = dp[i - 1] % 1000000007 + dp[i - 2] % 1000000007;
			}
		}

		System.out.println(dp[n] % 1000000007);
	}
}