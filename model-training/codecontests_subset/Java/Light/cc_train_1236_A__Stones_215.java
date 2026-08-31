import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		Task solver = new Task();
		int n = in.nextInt();
		for (int i = 0; i < n; i++) {
			solver.solve(i + 1, in, out);
		}
		out.close();
	}

	static class Task {
		public void solve(int testNumber, InputReader in, PrintWriter out) {
			int a = in.nextInt();
			int b = in.nextInt();
			int c = in.nextInt();
			int count = 0;
			if (b == 0) {
				out.println(count);
			} else {
				while (b > 0 && c >= 2) {
					count += 3;
					b--;
					c -= 2;
				}
				while (b >= 2 && a > 0) {
					count += 3;
					a--;
					b -= 2;
				}
				out.println(count);
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

	}
}