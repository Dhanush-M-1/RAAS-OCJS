import java.io.*;
import java.util.*;
import java.math.BigInteger;
import java.util.Map.Entry;

import static java.lang.Math.*;

public class A extends PrintWriter {

	void run() {
		int m = 1024;
		boolean[] s = new boolean[m];
		m = 0;
		boolean q = true;
		long n = 0;
		while (true) {
			String str = next();
			if (str.equals("-")) {
				q = false;
				continue;
			}
			if (str.equals("+")) {
				q = true;
				continue;
			}
			if (str.equals("?")) {
				s[m++] = q;
				continue;
			}
			if (str.equals("=")) {
				n = nextInt();
				break;
			}
		}

		long l = 0, r = 0;

		for (int i = 0; i < m; i++) {
			if (s[i]) {
				l += 1;
				r += n;
			} else {
				l -= n;
				r -= 1;
			}
			// println(l + "  " + r);
		}

		if (n < l || r < n) {
			println("Impossible");
			return;
		}

		println("Possible");

		Stack<Long> ans = new Stack<Long>();

		long sum = n;

		for (int i = m - 1; i >= 0; i--) {
			if (s[i]) {
				l -= 1;
				r -= n;

				long x = max(1, sum - r);
				long y = min(n, sum - l);
				long delta = (x + y) / 2;
				sum -= delta;
				ans.push(delta);
			} else {
				l += n;
				r += 1;

				long x = max(1, l - sum);
				long y = min(n, r - sum);
				long delta = (x + y) / 2;
				sum += delta;
				ans.push(-delta);
			}

			// println(l + "  " + sum + "   " + r);
		}

		boolean f = false;

		while (!ans.isEmpty()) {
			long cur = ans.pop();

			if (f) {
				if (cur < 0) {
					print(" - ");
				} else {
					print(" + ");
				}
			}
			f = true;

			print(abs(cur));
		}

		println(" = " + n);

	}

	boolean skip() {
		while (hasNext()) {
			next();
		}
		return true;
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

	public A(OutputStream outputStream) {
		super(outputStream);
	}

	static BufferedReader reader;
	static StringTokenizer tokenizer = new StringTokenizer("");
	static Random rnd = new Random();
	static boolean OJ;

	public static void main(String[] args) throws IOException {
		OJ = System.getProperty("ONLINE_JUDGE") != null;
		A solution = new A(System.out);
		if (OJ) {
			reader = new BufferedReader(new InputStreamReader(System.in));
			solution.run();
		} else {
			reader = new BufferedReader(new FileReader(new File(A.class.getName() + ".txt")));
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