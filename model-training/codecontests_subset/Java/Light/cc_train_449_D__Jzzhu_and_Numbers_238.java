import java.io.*;
import java.util.*;

public class D {
	static final long MOD = (long) (1e9 + 7);
	public static void main(String[] args) {
		MyScanner in = new MyScanner();
		int n = in.nextInt();
		int[] supersets = new int[1 << 20];
		for (int i = 0; i < n; i++)
			supersets[in.nextInt()]++;
		for (int i = 0; i < 20; i++) {
			for (int mask = 0; mask < supersets.length; mask++) {
				if (((1 << i) & mask) != 0) {
					supersets[mask ^ (1 << i)] += supersets[mask];
				}
			}
		}
		long[] pow2 = new long[n + 1];
		pow2[0] = 1;
		for (int i = 1; i < n + 1; i++)
			pow2[i] = (pow2[i - 1] * 2) % MOD;
		long ans = 0;
		for (int i = 0; i < supersets.length; i++) {
			ans += pow2[supersets[i]] * (Integer.bitCount(i) % 2 == 0 ? 1 : -1);
			ans = (ans + MOD) % MOD;
		}
		System.out.println(ans);
	}

	private static class MyScanner {
		BufferedReader br;
		StringTokenizer st;

		public MyScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}
	}
}