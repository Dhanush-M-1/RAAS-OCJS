import java.io.*;
import java.util.*;
import java.math.BigInteger;
import java.util.Map.Entry;

import static java.lang.Math.*;

public class C extends PrintWriter {

	public void add(long[] t, int i, long value) {
		for (; i < t.length; i |= i + 1) {
			t[i] += value;
		}
	}

	public long sum(long[] t, int i) {
		long sum = 0;
		for (; i >= 0; i = (i & (i + 1)) - 1) {
			sum += t[i];
		}
		return sum;
	}

	public long sum(long[] t, int l, int r) {
		if (r < l) {
			return 0;
		}

		if (r >= t.length) {
			r = t.length - 1;
		}

		if (l < 0) {
			l = 0;
		}

		if (l == 0) {
			return sum(t, r);
		} else {
			return sum(t, r) - sum(t, l - 1);
		}
	}

	void run() {

		int n = nextInt();
		int k = nextInt();
		int a = nextInt();
		int b = nextInt();
		int q = nextInt();

		long[] x = new long[n];
		long[] y = new long[n];

		while (--q >= 0) {
			int t = nextInt();
			if (t == 1) {
				int d = nextInt() - 1;
				int c = nextInt();
				{
					long cur = sum(x, d, d);
					long delta = a - cur;
					if (delta > 0) {
						add(x, d, min(delta, c));
					}
				}

				{
					long cur = sum(y, d, d);
					long delta = b - cur;
					if (delta > 0) {
						add(y, d, min(delta, c));
					}
				}

			} else {
				int p = nextInt() - 1;
				long u = sum(y, 0, p - 1);
				long v = sum(x, p + k, n - 1);

				println(v + u);
			}
		}

	}

	void skip() {
		while (hasNext()) {
			next();
		}
	}

	int[][] nextMatrix(int n, int m) {
		int[][] matrix = new int[n][m];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				matrix[i][j] = nextInt();
		return matrix;
	}

	String next() {
		while (!tokenizer.hasMoreTokens())
			tokenizer = new StringTokenizer(nextLine());
		return tokenizer.nextToken();
	}

	boolean hasNext() {
		while (!tokenizer.hasMoreTokens()) {
			String line = nextLine();
			if (line == null) {
				return false;
			}
			tokenizer = new StringTokenizer(line);
		}
		return true;
	}

	int[] nextArray(int n) {
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = nextInt();
		}
		return array;
	}

	int nextInt() {
		return Integer.parseInt(next());
	}

	long nextLong() {
		return Long.parseLong(next());
	}

	double nextDouble() {
		return Double.parseDouble(next());
	}

	String nextLine() {
		try {
			return reader.readLine();
		} catch (IOException err) {
			return null;
		}
	}

	public C(OutputStream outputStream) {
		super(outputStream);
	}

	static BufferedReader reader;
	static StringTokenizer tokenizer = new StringTokenizer("");
	static Random rnd = new Random();
	static boolean OJ;

	public static void main(String[] args) throws IOException {
		OJ = System.getProperty("ONLINE_JUDGE") != null;
		C solution = new C(System.out);
		if (OJ) {
			reader = new BufferedReader(new InputStreamReader(System.in));
			solution.run();
		} else {
			reader = new BufferedReader(new FileReader(new File(C.class.getName() + ".txt")));
			long timeout = System.currentTimeMillis();
			while (solution.hasNext()) {
				solution.run();
				solution.println();
				solution.println("----------------------------------");
			}
			solution.println("time: " + (System.currentTimeMillis() - timeout));
		}
		solution.close();
		reader.close();
	}
}