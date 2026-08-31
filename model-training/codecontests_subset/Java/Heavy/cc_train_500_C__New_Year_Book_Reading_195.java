import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class A488 {
	public static String[] thanks = { "vaporeon", "jolteon", "flareon",
			"espeon", "umbreon", "leafeon", "glaceon", "sylveon" };
	public static PrintWriter out;

	public static void main(String[] Args) throws Exception {
		FastScanner sc = new FastScanner(System.in);
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
				System.out)));
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] loc = new int[n];
		Arrays.fill(loc, n + 2);
		int[] ws = new int[n];
		for (int k = 0; k < n; k++) {
			ws[k] = sc.nextInt();
		}
		long ans = 0;
		for (int j = 0; j < m; j++) {
			int ind = sc.nextInt() - 1;
			for (int i = 0; i < n; i++) {
				if (loc[i] < loc[ind]) {
					loc[i]++;
					ans += ws[i];
				}
			}
			loc[ind] = 0;
		}
		out.println(ans);
		out.close();
	}

	public static class FastScanner {
		StringTokenizer st;
		BufferedReader br;

		FastScanner(InputStream in) throws IOException {
			br = new BufferedReader(new InputStreamReader(in));
			st = new StringTokenizer(br.readLine());
		}

		String next() throws IOException {
			if (st.hasMoreTokens())
				return st.nextToken();
			st = new StringTokenizer(br.readLine());
			return next();
		}

		int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}
	}

	public static long[][] matPowExp(long[][] mat, long exp, long mod)
			throws Exception {
		if (exp == 0) {
			return new long[][] { { 1, 0 }, { 0, 1 } };
		}
		if (exp == 1) {
			return mat;
		}
		long[][] builder = matPowExp(mat, exp / 2, mod);
		long[][] ret = matMult(builder, builder, mod);

		if (exp % 2 == 1) {
			ret = matMult(ret, mat, mod);
		}

		return ret;
	}

	public static long[][] matMult(long[][] a, long[][] b, long mod)
			throws Exception {
		if (a[0].length != b.length) {
			throw new Exception("Bad matrix dimensions");
		}

		long[][] c = new long[a.length][b[0].length];

		for (int k = 0; k < a.length; k++) {
			for (int j = 0; j < b[0].length; j++) {
				for (int i = 0; i < a[0].length; i++) {
					c[k][j] += a[k][i] * b[i][j];
					c[k][j] %= mod;
				}
			}
		}

		return c;
	}

	private static long choo(int k, int n) {
		if (k < 0 || k > n)
			return 0;
		long ret = fact(n) / (fact(k) * fact(n - k));
		return ret;
	}

	private static long fact(int n) {
		if (n == 0 || n == 1)
			return 1;
		return fact(n - 1) * n;
	}

	private static long gcd(long a, long b) {
		return (b == 0) ? a : gcd(b, a % b);
	}

	public static class Pair implements Comparable<Pair> {
		int t;
		int num;
		String team;
		int t2;

		public int compareTo(Pair o) {
			if (t != o.t)
				return t - o.t;
			return t2 - o.t2;
		}
	}

	public static long comp527A(long a, long b) {
		if (a == 0 || b == 0) {
			return 0;
		}
		if (a > b) {
			return comp527A(b, a);
		}
		return (b / a) + comp527A(b % a, a);
	}
}
