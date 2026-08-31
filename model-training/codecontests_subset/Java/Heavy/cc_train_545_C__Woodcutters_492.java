import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;
import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.lang.Math.abs;
import static java.lang.Math.floor;
import static java.lang.Math.ceil;
import static java.lang.Math.pow;
import static java.lang.Math.log;
import static java.lang.Math.sqrt;

/* ------------ Theorems and Lemmas ------------ */

// Fermat's Little Theorem
// (1) ((a ** p) - a) % p = 0; if 'p' is prime
// (2) Further, if 'a % p != 0', then ((a ** (p - 1)) - 1) % p = 0

/* -------------- End of theorems -------------- */

public class Solution {

	// Digit DP
	private static int digit;
	private static int times;
	private static StringBuilder number;
	private static int[][][] digitDP;
	// End

	private static final String[] FACTS = new String[] { "", "", "2", "3", "322", "5", "53", "7", "7222", "7332" };

	public static void main(String[] args) {
		FastReader reader = new FastReader();
		int n = reader.nextInt();
		int[][] mat = new int[n][2];
		for (int i = 0; i < n; ++i) {
			mat[i][0] = reader.nextInt();
			mat[i][1] = reader.nextInt();
		}
		reader.close();
		int cnt = 1;
		for (int i = 1; i < n; ++i) {
			if (mat[i][0] - mat[i - 1][0] > mat[i][1])
				++cnt;
			else if ((i + 1 < n ? mat[i + 1][0] : Integer.MAX_VALUE) - mat[i][0] > mat[i][1]) {
				++cnt;
				mat[i][0] += mat[i][1];
			}
		}
		System.out.println(cnt);
	}

	private static int solve(int[][] mat, int index, int leftSpace) {
		if (index == mat.length - 1)
			return 0;
		int max = Integer.MIN_VALUE;
		if (leftSpace >= mat[index][1])
			max = max(max, 1 + solve(mat, index + 1, mat[index + 1][0] - mat[index][0]));
		if (mat[index + 1][0] - mat[index][0] >= mat[index][1])
			max = max(max, 1 + solve(mat, index + 1, mat[index + 1][0] - mat[index][0] - mat[index][1]));
		else
			max = max(max, solve(mat, index + 1, mat[index + 1][0] - mat[index][0]));
		return max;
	}

	public static int ddp(int n) {
		number = new StringBuilder(String.valueOf(n));
		digitDP = new int[12][12][2];
		for (int[][] a : digitDP)
			for (int[] b : a)
				Arrays.fill(b, -1);
		return call(0, 0, 0);
	}

	// Digit DP
	public static int call(int pos, int cnt, int f) {
		if (cnt > times)
			return 0;
		if (pos == number.length())
			return cnt == times ? 1 : 0;
		if (digitDP[pos][cnt][f] != -1)
			return digitDP[pos][cnt][f];
		int res = 0;
		int lmt = f == 0 ? number.charAt(pos) - '0' : 9;
		for (int dgt = 0; dgt <= lmt; ++dgt)
			if ((dgt == digit ? 1 + cnt : cnt) <= times)
				res += call(1 + pos, dgt == digit ? 1 + cnt : cnt, f == 0 && dgt < lmt ? 1 : f);
		digitDP[pos][cnt][f] = res;
		return res;
	}

	// Binary Exponentiation
	public static int binpow(int a, int n, int mod) {
		// Iterative approach
		a %= mod;
		int result = 1;
		while (n > 0) {
			if ((n & 1) != 0)
				result = result * a % mod;
			a = a * a % mod;
			n >>= 1;
		}
		return result;

		// Recursive approach
		/*
		 * if (n == 0l) return 1l; long res = binpow(a, n / 2, mod); if ((n & 1l) != 0l)
		 * return ((res % mod) * (res % mod) * (a % mod)) % mod; else return ((res %
		 * mod) * (res % mod)) % mod;
		 */
	}

	// GCD
	public static int gcd(int a, int b) {
		while (b > 0) {
			a %= b;
			int t = a;
			a = b;
			b = t;
		}
		return a;
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine().trim());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		float nextFloat() {
			return Float.parseFloat(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		int[] readArray(int size) {
			int[] ar = new int[size];
			for (int i = 0; i < size; ++i)
				ar[i] = nextInt();
			return ar;
		}

		void close() {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}