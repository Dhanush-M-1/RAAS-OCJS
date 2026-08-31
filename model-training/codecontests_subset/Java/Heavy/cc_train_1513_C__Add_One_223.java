// package Codeforces714;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class C {
	static int dp[][] = new int[200010][10];
	static final int mod = 1000000007;

	public static void main(String[] args) {
		FastScanner in = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int T = in.nextInt();
		solve();
		for (int tt = 0; tt < T; tt++) {
			int n = in.nextInt();
			int m = in.nextInt();
			int ans = 0;
			while (n > 0) {
				int k = n % 10;
				ans = (ans + dp[m][k]) % mod;
				n = n / 10;
			}
			out.println(ans);
		}
		out.close();
	}

	public static void solve() {
		for (int i = 0; i < 200010; i++) {
			for (int j = 0; j <= 9; j++) {
				dp[i][j] = -1;
			}
		}
		for (int i = 0; i < 200010; i++) {
			for (int j = 0; j <= 9; j++) {
				fun(j, i);
			}
		}
	}

	public static int fun(int f, int m) {
		if (m == 0)
			return 1;
		if (dp[m][f] != -1)
			return dp[m][f];
		int ans = 0;
		if (f != 9) {
			ans = fun(f + 1, m - 1) % mod;
		} else {
			ans = (fun(0, m - 1) % mod + fun(1, m - 1) % mod) % mod;
		}
		dp[m][f] = ans % mod;
		return ans % mod;
	}

	static void sort(int[] a) {
		ArrayList<Integer> l = new ArrayList<>();
		for (int i : a)
			l.add(i);
		Collections.sort(l);
		for (int i = 0; i < a.length; i++)
			a[i] = l.get(i);
	}

	static class FastScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");

		String next() {
			while (!st.hasMoreTokens())
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		int[] readArray(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = nextInt();
			return a;
		}

		long nextLong() {
			return Long.parseLong(next());
		}
	}

}
