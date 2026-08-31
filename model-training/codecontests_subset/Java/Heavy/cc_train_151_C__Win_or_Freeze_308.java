import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ProblemC {
	public static void main(String[] args) {
		InputReader in = new InputReader();
		PrintWriter out = new PrintWriter(System.out);

		new ProblemC().solve(in, out);

		out.close();
	}

	public void solve(InputReader in, PrintWriter out) {
		long q = in.nextLong();

		List<Long> factors = getFactors(q);

		if (q == 1 || factors.size() == 1) {
			out.println(1);
			out.println(0);

			return;
		}

		if (factors.size() == 2) {
			out.println(2);
		} else {
			out.println(1);

			out.println(factors.get(0) * factors.get(1));
		}
	}

	public static List<Long> getFactors(long n) {
		List<Long> factors = new ArrayList<Long>();

		long i = 2l;
		while (i * i <= n) {

			while (n % i == 0) {
				factors.add(i);
				n = n / i;
			}

			if (i == 2) {
				i = 3;
			} else {
				i = i + 2;
			}

		}

		if (n > 1) {
			factors.add(n);
		}

		return factors;
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
