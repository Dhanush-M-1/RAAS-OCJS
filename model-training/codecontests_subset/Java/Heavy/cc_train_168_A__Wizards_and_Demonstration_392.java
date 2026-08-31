import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ProblemA {
	public static void main(String[] args) {
		InputReader in = new InputReader();
		PrintWriter out = new PrintWriter(System.out);

		new ProblemA().solve(in, out);

		out.close();
	}

	public void solve(InputReader in, PrintWriter out) {
		int n = in.nextInt();
		int x = in.nextInt();
		int y = in.nextInt();
		
		int d = n * y  / 100;
		int r = (n * y) % 100;
		
		if (r > 0) {
			d++;
		}
		
		out.println(Math.max(d - x, 0));
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
