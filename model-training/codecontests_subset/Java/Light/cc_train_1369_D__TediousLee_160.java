import java.io.*;
import java.util.*;

public class Problem_D {
	static final int MOD = 1000000007;

	public static void main(String[] args) {
		InputReader in = new InputReader();
		StringBuilder out = new StringBuilder();

		int T = in.nextInt();
		long[] dp = new long[2000001];
		dp[3] = dp[4] = 4;
		for (int i = 5; i < dp.length; i++) {
			dp[i] = (2 * dp[i - 2] + dp[i - 1] + (i % 3 == 0 ? 4 : 0)) % MOD;
		}
		while (T-- > 0) {
			int N = in.nextInt();
			out.append(dp[N]).append('\n');
		}

		System.out.print(out);
	}

	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer st;

		public InputReader() {
			reader = new BufferedReader(new InputStreamReader(System.in));
		}

		public String next() {
			while (st == null || !st.hasMoreTokens()) {
				st = new StringTokenizer(nextLine());
			}
			return st.nextToken();
		}

		public String nextLine() {
			try {
				return reader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}
	}
}
