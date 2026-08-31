import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ProblemB {
	public static void main(String[] args) {
		InputReader in = new InputReader();
		PrintWriter out = new PrintWriter(System.out);

		new ProblemB().solve(in, out);

		out.close();
	}

	public void solve(InputReader in, PrintWriter out) {
		String s = in.nextLine();

		char[] str = new char[100];

		int pos = 1;
		int neg = 0;

		int k = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '+') {
				pos++;

				str[k++] = '+';
			} else if (s.charAt(i) == '-') {
				neg++;

				str[k++] = '-';
			}
		}

		int n = Integer.parseInt(s.split("=")[1].trim());

		if (pos - n * neg > n || n * pos - neg < n) {
			out.println("Impossible");

			return;
		}

		out.println("Possible");

		int sum = 0;

		for (int i = 0; i < k; i++) {
			int sgn = 1;

			if (i > 0 && str[i - 1] == '-') {
				sgn = -1;
			}

			if (sgn == 1) {
				pos--;
			}

			if (sgn == -1) {
				neg--;
			}

			for (int x = 1; x <= n; x++) {
				if (sum + x * sgn + pos - n * neg <= n && sum + x * sgn + n * pos - neg >= n) {
					out.print(x + " " + str[i] + " ");

					sum += x * sgn;

					break;
				}
			}
		}
		
		out.print(Math.abs(n - sum) + " = " + n);
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
