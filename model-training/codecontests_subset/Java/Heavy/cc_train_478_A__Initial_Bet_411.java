import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Locale;
import java.util.StringTokenizer;

public class A {
	static StringTokenizer st;
	static BufferedReader br;
	static PrintWriter pw;

	static class Sort implements Comparable<Sort> {
		int x, y;

		public int compareTo(Sort arg0) {
			if (this.x != arg0.x)
				return this.x - arg0.x;
			else
				return this.y - arg0.y;
		}
	}

	public static void main(String[] args) throws IOException {
		Locale.setDefault(Locale.US);
		br = new BufferedReader(new InputStreamReader(System.in));
		pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
				System.out)));
		int s = 0;
		for (int i = 0; i < 5; i++) {
			s += nextInt();
		}
		pw.print(s != 0 && s % 5 == 0 ? s / 5 : -1);
		pw.close();
	}

	private static long yuza(long x1, long y1, long x2, long y2, long x3,
			long y3) {
		long s = x1 * (y3 - y2) + x2 * (y1 - y3) + x3 * (y2 - y1);
		return Math.abs(s);
	}

	private static long gcd(long a, long b) {
		return b == 0 ? a : gcd(b, a % b);
	}

	private static int nextInt() throws IOException {
		return Integer.parseInt(next());
	}

	private static long nextLong() throws IOException {
		return Long.parseLong(next());
	}

	private static double nextDouble() throws IOException {
		return Double.parseDouble(next());
	}

	private static String next() throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine());
		return st.nextToken();
	}

}