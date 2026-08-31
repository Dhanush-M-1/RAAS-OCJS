import java.util.*;
import java.io.*;

public class Div2A {

	public static void main(String[] args) throws IOException {
		new Div2A().run();
	}

	FastScanner in;
	PrintWriter out;

	void run() throws IOException {
		in = new FastScanner(System.in);
		out = new PrintWriter(System.out, true);
		solve();
		out.close();
	}

	void solve() throws IOException {
		int r1 = in.nextInt();
		int r2 = in.nextInt();
		int c1 = in.nextInt();
		int c2 = in.nextInt();
		int d1 = in.nextInt();
		int d2 = in.nextInt();
		int a = r1 + c1 - d2;
		int b = r1 + c2 - d1;
		int c = r2 + c1 - d1;
		int d = r2 + c2 - d2;
		if (a % 2 == 1 || b % 2 == 1 || c % 2 == 1 || d % 2 == 1) {
			out.println(-1);
			System.exit(0);
		}
		a /= 2;
		b /= 2;
		c /= 2;
		d /= 2;
		if (a == b || a == c || a == d || b == c || b == d || c == d) {
			out.println(-1);
			System.exit(0);
		}
		if (a > 9 || b > 9 || c > 9 || d > 9 || a == 0 || b == 0 || c == 0 || d == 0) {
			out.println(-1);
			System.exit(0);
		}
		out.println(a + " " + b);
		out.println(c + " " + d);
	}

	static class FastScanner {

		BufferedReader br;
		StringTokenizer st;

		FastScanner(InputStream in) {
			br = new BufferedReader(new InputStreamReader(in));
			st = null;
		}

		String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}
		
		String nextLine() throws IOException {
			if (st == null || !st.hasMoreTokens())
				return br.readLine();
			StringBuilder result = new StringBuilder(st.nextToken());
			while (st.hasMoreTokens()) {
				result.append(" ");
				result.append(st.nextToken());
			}
			return result.toString();
		}

		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}

	}

}
