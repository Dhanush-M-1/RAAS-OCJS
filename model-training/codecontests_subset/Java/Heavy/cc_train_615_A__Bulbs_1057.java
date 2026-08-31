import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class A {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static PrintWriter out;

	public static String next() throws IOException {
		while (st == null || !st.hasMoreTokens()) {
			st = new StringTokenizer(br.readLine());
		}
		return st.nextToken();
	}

	public static int nextInt() throws IOException {
		return Integer.parseInt(next());
	}

	public static long nextLong() throws IOException {
		return Long.parseLong(next());
	}

	public static float nextFloat() throws IOException {
		return Float.parseFloat(next());
	}

	public static double nextDouble() throws IOException {
		return Double.parseDouble(next());
	}

	public static void main(String[] args) throws IOException {

		int res = 0;
		int n = nextInt(), m = nextInt();
		boolean[] tab = new boolean[m];
		boolean ok = true;
		for (int i = 0; i < n; i++) {
			int x = nextInt();

			for (int j = 0; j < x; j++) {
				int y = nextInt();
				tab[y - 1] = true;
			}
		}

		for (int i = 0; i < m; i++) {
			ok &= tab[i];
		}

		// output
		System.out.println(ok ? "YES" : "NO");
	}
}
