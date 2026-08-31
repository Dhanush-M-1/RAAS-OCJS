import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class FadiAndLCM {
	private static final FastReader in = new FastReader();
	private static final PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args) {
		Solver sol = new Solver();
		int tt = 1;
		sol.solve(tt);
		out.close();
	}

	private static final class Solver {
		public void solve(int testCase) {
			long x = Long.parseLong(in.next());
			long sqrt = (long) Math.max(Math.sqrt(x), 1);
//			out.println(sqrt);
			long ans = 1;
			for (long i = 1; i <= sqrt; ++i) {
				if (x % i == 0L && lcm(i, x / i) == x) {
					ans = i;
				}
			}
			out.println(ans + " " + (x / ans));
		}

		private long gcd(long a, long b) {
			return b != 0 ? gcd(b, a % b) : a;
		}

		private long lcm(long a, long b) {
			return a / gcd(a, b) * b;
		}
	}

	private static final class FastReader {
		private BufferedReader br;
		private StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
			st = null;
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
	}
}