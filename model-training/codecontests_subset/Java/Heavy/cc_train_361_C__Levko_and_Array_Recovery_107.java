import java.io.*;
import java.util.*;

import java.math.*;

public class P1 {

	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int n = in.nextInt();
		int k = in.nextInt();
		m = k;
		int a[][] = new int[k][4];
		for (int i = 0; i < k; i++) {
			a[i][0] = in.nextInt();
			a[i][1] = in.nextInt() - 1;
			a[i][2] = in.nextInt() - 1;
			a[i][3] = in.nextInt();
		}
		int b[] = new int[n];
		Arrays.fill(b, Integer.MAX_VALUE / 4);
		for (int j = k - 1; j >= 0; j--) {
			if (a[j][0] == 1) {

				for (int kk = a[j][1]; kk <= a[j][2]; kk++) {
					b[kk] = b[kk] - a[j][3];
				}

			} else {
				for (int kk = a[j][1]; kk <= a[j][2]; kk++) {
					if (b[kk] > a[j][3]) {
						b[kk] = a[j][3];
					}
				}
			}

		}
		int c[] = new int[n];
		for (int i = 0; i < n; i++) {
			c[i] = b[i];
		}

		for (int j = 0; j < k; j++) {
			if (a[j][0] == 1) {

				for (int kk = a[j][1]; kk <= a[j][2]; kk++) {
					b[kk] = b[kk] + a[j][3];
				}

			} else {
				int max=Integer.MIN_VALUE;
				for (int kk = a[j][1]; kk <= a[j][2]; kk++) {
					max=Math.max(max, b[kk]);
				}
				if(max!=a[j][3])
				{
					
				System.out.println("NO");
				return ;
				}
			}
		}
		out.println("YES");
		for (int i = 0; i < n; i++) {
			out.print(c[i] + " ");
		}

		out.close();

	}

	static int m;

	static int fun(int a[][], int b[], int c[], int j) {

		if (j == m) {
			for (int i = 0; i < n; i++) {
				System.out.println(b[i] + " ");
			}
			return 0;
		}

		if (a[j][0] == 1) {

			for (int k = a[j][1]; k <= a[j][2]; k++) {
				b[k] = b[k] + a[j][3];
			}
		} else {

			for (int k = a[j][1]; k <= a[j][2]; k++) {
				if (c[k] == 1) {
					if (b[k] == a[j][3]) {
						fun(a, b, c, j + 1);
					}
					if (b[k] > a[j][3]) {
						return -1;
					}
				} else {
					c[k] = 1;
					b[k] = a[j][3] - b[k];
					fun(a, b, c, j + 1);
				}

			}

		}
		return -1;
	}

	static int a[][];
	static long fac[], ifac[], DR[] = new long[101];
	static int MOD = (int) (1e9 + 7);
	static boolean[] isPrime;
	static int minPrime[];
	static long dp[][];
	static int n;
	static int d, x, y;

	static int gcd(int a, int b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}

	static long mp(long a, long b) {
		long ans = 1;

		while (b != 0) {
			if (b % 2 == 1)
				ans = (ans * a) % MOD;

			a = (a * a) % MOD;
			b /= 2;

		}
		return ans % MOD;
	}

	static void precompute() {
		int i;
		int N = 1000005;
		fac = new long[N];
		ifac = new long[N];
		fac[0] = 1;
		for (i = 1; i < N; i++) {
			fac[i] = (i * fac[i - 1]) % MOD;
		}
		ifac[N - 1] = mp(fac[N - 1], MOD - 2);
		for (i = N - 2; i >= 0; i--) {
			ifac[i] = ((i + 1) * ifac[i + 1]) % MOD;

		}
	}

	public static long combine(int n, int k) {
		if (k > n - k) {
			k = n - k;
		}
		long result = 1;
		for (int i = 0; i < k; i++) {
			result *= (n - i);
			result /= (i + 1);
		}
		return result;
	}

	static long mInv(long A) {

		return mp(A, MOD - 2);

	}

	static long mC(int n, int k) {
		// calculates C(n,k) mod p (assuming p is prime).
		// if(k>n-k)k=n-k;
		long an; // n * (n-1) * ... * (n-k+1)
		if (k <= 0)
			return 1;
		if (n < k)
			return 0;

		an = fac[n] % MOD;
		an *= ifac[n - k];
		an %= MOD;
		an *= ifac[k];
		an %= MOD;

		// numerator / denominator mod p.
		return an;
	}

	static long div(long num) {
		long c = 0;
		for (long i = 1; i <= num; ++i)
			if (num % i == 0)
				c++;
		return c;
	}

	static int[][] segtree;

	static class InputReader {

		private InputStream stream;
		private byte[] buf = new byte[8192];
		private int curChar, snumChars;
		private SpaceCharFilter filter;

		public InputReader(InputStream stream) {
			this.stream = stream;
		}

		public int snext() {
			if (snumChars == -1)
				throw new InputMismatchException();
			if (curChar >= snumChars) {
				curChar = 0;
				try {
					snumChars = stream.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (snumChars <= 0)
					return -1;
			}
			return buf[curChar++];
		}

		public int nextInt() {
			int c = snext();
			while (isSpaceChar(c))
				c = snext();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = snext();
			}
			int res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = snext();
			} while (!isSpaceChar(c));
			return res * sgn;
		}

		public long nextLong() {
			int c = snext();
			while (isSpaceChar(c))
				c = snext();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = snext();
			}
			long res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = snext();
			} while (!isSpaceChar(c));
			return res * sgn;
		}

		public int[] nextIntArray(int n) {
			int a[] = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = nextInt();
			return a;
		}

		public String readString() {
			int c = snext();
			while (isSpaceChar(c))
				c = snext();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = snext();
			} while (!isSpaceChar(c));
			return res.toString();
		}

		public boolean isSpaceChar(int c) {
			if (filter != null)
				return filter.isSpaceChar(c);
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		public interface SpaceCharFilter {
			public boolean isSpaceChar(int ch);
		}
	}
}
