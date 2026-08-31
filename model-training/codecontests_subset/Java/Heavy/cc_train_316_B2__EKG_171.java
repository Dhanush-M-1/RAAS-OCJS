import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.StringTokenizer;

import static java.util.Arrays.deepToString;

public class B {

	static void solve() {
		int n = nextInt(), x = nextInt() - 1;
		int[] p = new int[n];
		int[] next = new int[n];
		Arrays.fill(next, -1);
		for (int i = 0; i < n; i++) {
			p[i] = nextInt() - 1;
			if (p[i] != -1) {
				next[p[i]] = i;
			}
		}
		ArrayList<Integer> lengths = new ArrayList<>();
		int ourPos = -1;
		outer: for (int i = 0; i < n; i++) {
			if (p[i] == -1) {
				int len = 0;
				for (int cur = i; cur != -1; cur = next[cur]) {
					if (cur == x) {
						ourPos = len;
						continue outer;
					}
					len++;
				}
				lengths.add(len);
			}
		}
		boolean[] can = new boolean[n + 1];
		can[0] = true;
		for (int len : lengths) {
			for (int i = can.length - len - 1; i >= 0; i--) {
				if (can[i]) {
					can[i + len] = true;
				}
			}
		}
		for (int i = 0; i < can.length; i++) {
			if (can[i]) {
				writer.println(i + 1 + ourPos);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		reader = new BufferedReader(new InputStreamReader(System.in));
		writer = new PrintWriter(System.out);
		Locale.setDefault(Locale.US);

		setTime();
		solve();
		printTime();
		printMemory();

		writer.close();
	}

	static BufferedReader reader;
	static PrintWriter writer;
	static StringTokenizer tok = new StringTokenizer("");
	static long systemTime;

	static void debug(Object... o) {
		System.err.println(deepToString(o));
	}

	static void setTime() {
		systemTime = System.currentTimeMillis();
	}

	static void printTime() {
		System.err.println("Time consumed: " + (System.currentTimeMillis() - systemTime));
	}

	static void printMemory() {
		System.err.println("Memory consumed: "
				+ (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1000 + "kb");
	}

	static String next() {
		while (!tok.hasMoreTokens()) {
			String w = null;
			try {
				w = reader.readLine();
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (w == null)
				return null;
			tok = new StringTokenizer(w);
		}
		return tok.nextToken();
	}

	static int nextInt() {
		return Integer.parseInt(next());
	}

	static long nextLong() {
		return Long.parseLong(next());
	}

	static double nextDouble() {
		return Double.parseDouble(next());
	}

	static BigInteger nextBigInteger() {
		return new BigInteger(next());
	}
}