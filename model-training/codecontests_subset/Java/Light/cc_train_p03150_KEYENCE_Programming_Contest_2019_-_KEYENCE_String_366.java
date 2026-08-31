import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		FastScanner in = new FastScanner(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		B_KEYENCE_String solver = new B_KEYENCE_String();
		solver.solve(1, in, out);
		out.close();
	}

	static class B_KEYENCE_String {
		public void solve(int testNumber, FastScanner in, PrintWriter out) {
			String s = in.next();
			for (int i = 0; i <= s.length(); i++) {
				for (int j = i; j <= s.length(); j++) {
					String a = s.substring(0, i);
					String b = s.substring(j);
					if ((a + b).equals("keyence")) {
						out.println("YES");
						return;
					}
				}
			}
			out.println("NO");
		}

	}

	static class FastScanner {
		private BufferedReader in;
		private StringTokenizer st;

		public FastScanner(InputStream stream) {
			in = new BufferedReader(new InputStreamReader(stream));
		}

		public String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					String rl = in.readLine();
					if (rl == null) {
						return null;
					}
					st = new StringTokenizer(rl);
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return st.nextToken();
		}

	}
}

