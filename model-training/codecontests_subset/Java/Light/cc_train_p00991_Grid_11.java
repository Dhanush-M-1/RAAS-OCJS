import static java.util.Arrays.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {

	static void tr(Object... os) {
		System.err.println(deepToString(os));
	}

	final static long MOD = 100000007;

	void solve() {
		int R = sc.nextInt();
		int C = sc.nextInt();
		int r1 = sc.nextInt();
		int c1 = sc.nextInt();
		int r2 = sc.nextInt();
		int c2 = sc.nextInt();

		int dr1 = Math.abs(r1 - r2);
		int dr2 = R - dr1;

		int dc1 = Math.abs(c1 - c2);
		int dc2 = C - dc1;
		long res = solve(Math.min(dr1, dr2), Math.min(dc1, dc2));
		if (dr1 == dr2) { res *= 2; res %= MOD; }
		if (dc1 == dc2) { res *= 2; res %= MOD; }
		out.println(res);
	}

	static final long[] fact = new long[1000 + 10];
	static final long[] fact_inv = new long[1000 + 10];
	static {
		long[] inv = new long[1000 + 10];
		inv[1] = fact[0] = fact_inv[0] = 1;
		for (int i = 2; i < inv.length; i++)
			inv[i] = inv[(int) (MOD % i)] * (MOD - MOD / i) % MOD;
		for (int i = 1; i < fact.length; i++)
			fact[i] = (fact[i - 1] * i) % MOD;
		for (int i = 1; i < fact_inv.length; i++)
			fact_inv[i] = (fact_inv[i - 1] * inv[i]) % MOD;
	}

	long C(long n, long k) {
		if (n < 0 || k < 0 || n < k) return 0;
		return fact[(int) n] * fact_inv[(int) (n - k)] % MOD * fact_inv[(int) k] % MOD;
	}

	long solve(int r, int c) {
		return C(r + c, r);
	}

	public static void main(String[] args) throws Exception {
		new Main().run();
	}

	MyScanner sc = null;
	PrintWriter out = null;
	public void run() throws Exception {
		sc = new MyScanner(System.in);
		out = new PrintWriter(System.out);
		for (;sc.hasNext();) {
			solve();
			out.flush();
		}
		out.close();
	}

	class MyScanner {
		String line;
		BufferedReader reader;
		StringTokenizer tokenizer;

		public MyScanner(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream));
			tokenizer = null;
		}
		public void eat() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					line = reader.readLine();
					if (line == null) {
						tokenizer = null;
						return;
					}
					tokenizer = new StringTokenizer(line);
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
		}
		public String next() {
			eat();
			return tokenizer.nextToken();
		}
		public String nextLine() {
			try {
				return reader.readLine();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		public boolean hasNext() {
			eat();
			return (tokenizer != null && tokenizer.hasMoreElements());
		}
		public int nextInt() {
			return Integer.parseInt(next());
		}
		public long nextLong() {
			return Long.parseLong(next());
		}
		public double nextDouble() {
			return Double.parseDouble(next());
		}
		public int[] nextIntArray(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++) a[i] = nextInt();
			return a;
		}
	}
}