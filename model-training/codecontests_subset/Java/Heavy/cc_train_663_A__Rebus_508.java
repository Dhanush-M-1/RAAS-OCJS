import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) {
		InputStream intputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(intputStream);
		PrintWriter out = new PrintWriter(outputStream);
		Task solver = new Task();
		solver.solve(in, out);
		out.close();
	}

	static class Task {
		public void solve(InputReader in, PrintWriter out) {
			ArrayList<Integer> ops = new ArrayList<Integer>();
			int n, plus = 0, minus = 0;
			while (true) {
				String s = in.next();
				if (s.charAt(0) == '?') continue;
				if (s.charAt(0) == '+') {
					ops.add(1);
					++plus;
				} else if (s.charAt(0) == '-') {
					ops.add(-1);
					++minus;
				} else if (s.charAt(0) == '=') {
					n = in.nextInt();
					break;
				}
			}
			if (n + plus * n - minus >= n && 1 + plus - minus * n <= n) {
				out.println("Possible");
				int bound = 1 + plus - minus;
				if (bound <= n) {
					int sum = n - bound;
					int x = Math.min(1 + sum, n);
					sum -= x - 1;
					out.print(x);
					for (int i = 0; i < ops.size(); ++i) {
						if (ops.get(i) == 1) {
							x = Math.min(1 + sum, n);
							sum -= x - 1;
							out.print(" + " + x);
						} else {
							x = 1;
							out.print(" - " + x);
						}
					}
					out.println(" = " + n);
				} else {
					int sum = bound - n, x;
					out.print(1);
					for (int i = 0; i < ops.size(); ++i) {
						if (ops.get(i) == -1) {
							x = Math.min(1 + sum, n);
							sum -= x - 1;
							out.print(" - " + x);
						} else {
							x = 1;
							out.print(" + " + x);
						}
					}
					out.println(" = " + n);
				}
			} else {
				out.println("Impossible");
			}
		}
	}

	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream), 32768);
			tokenizer = null;
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}
		
		public double nextDouble() {
			return Double.parseDouble(next());
		}
		
		public long nextLong() {
			return Long.parseLong(next());
		}
		
		public String nextLine() {
			try {
				return reader.readLine();
			} catch (IOException e) {
				return null;
			}
		}
	}
}