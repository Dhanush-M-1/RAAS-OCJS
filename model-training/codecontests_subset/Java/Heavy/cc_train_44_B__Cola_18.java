import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Cola {

	static int[] cnt, m = { 1, 2, 4 };
	static long[][] dp;

	static long solve(int i, int n) {
		if (i == 3)
			return n == 0 ? 1 : 0;
		if (dp[n][i] != -1)
			return dp[n][i];
		long ans = 0;
		for (int j = 0; j <= cnt[i] && j * m[i] <= n; j++)
			ans += solve(i + 1, n - j * m[i]);
		return dp[n][i] = ans;
	}

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		sc = new StringTokenizer("");
		int n = nxtInt() * 2;
		cnt = nxtIntArr(3);
		dp = new long[n + 1][3];
		for (long[] a : dp)
			Arrays.fill(a, -1);
		out.println(solve(0, n));
		br.close();
		out.close();
	}

	static BufferedReader br;
	static StringTokenizer sc;
	static PrintWriter out;

	static String nxtTok() throws IOException {
		while (!sc.hasMoreTokens()) {
			String s = br.readLine();
			if (s == null)
				return null;
			sc = new StringTokenizer(s.trim());
		}
		return sc.nextToken();
	}

	static int nxtInt() throws IOException {
		return Integer.parseInt(nxtTok());
	}

	static long nxtLng() throws IOException {
		return Long.parseLong(nxtTok());
	}

	static double nxtDbl() throws IOException {
		return Double.parseDouble(nxtTok());
	}

	static int[] nxtIntArr(int n) throws IOException {
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = nxtInt();
		return a;
	}

	static long[] nxtLngArr(int n) throws IOException {
		long[] a = new long[n];
		for (int i = 0; i < n; i++)
			a[i] = nxtLng();
		return a;
	}

	static char[] nxtCharArr() throws IOException {
		return nxtTok().toCharArray();
	}
}