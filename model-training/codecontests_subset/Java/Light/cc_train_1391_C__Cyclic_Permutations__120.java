import java.io.*;
import java.util.*;

public class Problem_C2 {
	static final int MOD = 1000000007;

	public static void main(String[] args) {
		InputReader in = new InputReader();

		int N = in.nextInt();
		long x = 1;
		for (int i = 1; i <= N; i++) {
			x = x * i % MOD;
		}
		long y = 1;
		for (int i = 1; i < N; i++) {
			y = 2 * y % MOD;
		}
		long ans = (x - y + MOD) % MOD;

		System.out.println(ans);
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
