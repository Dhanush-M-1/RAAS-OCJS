import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ProblemD {
	public static void main(String[] args) {
		InputReader in = new InputReader();
		PrintWriter out = new PrintWriter(System.out);

		new ProblemD().solve(in, out);

		out.close();
	}

	public void solve(InputReader in, PrintWriter out) {
		int n = in.nextInt();
		int k = in.nextInt();

		int a = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();
		int d = in.nextInt();

		if (n == 4 || k <= n) {
			out.println(-1);

			return;
		}

		if (n == 5) {
			int x = 0;
			for (int i = 1; i <= n; i++) {
				if (i != a && i != b && i != c && i != d) {
					x = i;

					break;
				}
			}

			out.println(a + " " + c + " " + x + " " + d + " " + b);
			out.println(c + " " + a + " " + x + " " + b + " " + d);

			return;
		}

		int x1 = 0;
		int x2 = 0;

		for (int i = 1; i <= n; i++) {
			if (i != a && i != b && i != c && i != d) {
				x1 = i;

				break;
			}
		}

		for (int i = 1; i <= n; i++) {
			if (i != a && i != b && i != c && i != d && i != x1) {
				x2 = i;

				break;
			}
		}

		StringBuilder other = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			if (i != a && i != b && i != c && i != d && i != x1 && i != x2) {
				other.append(i);
				other.append(" ");
			}
		}

		StringBuilder sb = new StringBuilder();
		sb.append(a);
		sb.append(" ");
		sb.append(c);
		sb.append(" ");
		sb.append(x1);
		sb.append(" ");
		sb.append(d);
		sb.append(" ");
		sb.append(x2);
		sb.append(" ");

		if (other.length() > 0) {
			sb.append(other);
		}

		sb.append(b);

		out.println(sb.toString());

		sb = new StringBuilder();
		sb.append(c);
		sb.append(" ");
		sb.append(a);
		sb.append(" ");
		sb.append(x2);
		sb.append(" ");

		if (other.length() > 0) {
			sb.append(other);
		}

		sb.append(b);
		sb.append(" ");
		sb.append(x1);
		sb.append(" ");
		sb.append(d);

		out.println(sb.toString());
	}

	static class InputReader {
		public BufferedReader br;
		public StringTokenizer st;

		public InputReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		public String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return st.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
