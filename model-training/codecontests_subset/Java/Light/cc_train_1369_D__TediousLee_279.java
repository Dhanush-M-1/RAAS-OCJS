
import java.util.*;
import java.lang.*;
import java.io.*;

public class Fourth {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = (int) (2e6);
		long[] dp = new long[n + 1];
		int mod = (int) (1e9+7);

		for (int i = 3; i <= n; i++) {
			dp[i] = (dp[i - 1] + (2 * dp[i - 2]) % mod) % mod + (i % 3 == 0 ? 1 : 0);
			dp[i] %= mod;
		}
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int num = Integer.parseInt(br.readLine());
			System.out.println((dp[num] * 4)%mod);
		}
		return;
	}
}
