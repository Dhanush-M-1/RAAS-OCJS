import static java.util.Arrays.deepToString;

import java.io.*;
import java.math.*;
import java.util.*;

public class Main {

	static void solve() throws IOException {
		int n = nextInt();
		String s = reader.readLine();
		int i = 0;
		int f = 0;
		int a = 0;
		for (int j = 0; j < s.length(); j++) {
			if (s.charAt(j) == 'A') {
				a++;
			} else if (s.charAt(j) == 'F') {
				f++;
			} else {
				i++;
			}
		}
		if (i != 0) {
			System.out.println((i == 1) ? "1" : "0");
		} else {
			System.out.println(a);
		}
	}

	public static void main(String[] args) throws Exception {
		reader = new BufferedReader(new InputStreamReader(System.in));
		writer = new PrintWriter(System.out);

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
		System.err.println("Time consumed: "
				+ (System.currentTimeMillis() - systemTime));
	}

	static void printMemory() {
		System.err.println("Memory consumed: "
				+ (Runtime.getRuntime().totalMemory() - Runtime.getRuntime()
						.freeMemory()) / 1000 + "kb");
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