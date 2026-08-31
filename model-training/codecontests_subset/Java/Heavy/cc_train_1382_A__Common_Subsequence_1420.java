import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class A {

	PrintWriter out;

	public static void main(String[] args) throws Exception {
		new A().run();
	}

	public void run() throws Exception {
		FastScanner file = new FastScanner();
		out = new PrintWriter(System.out);

		int times = file.nextInt();
		for (int asdf = 0; asdf < times; asdf++) {
			int n = file.nextInt(), m = file.nextInt();
			List<Integer> a = new ArrayList<Integer>();
			List<Integer> b = new ArrayList<Integer>();
			for (int i = 0; i < n; i++)
				a.add(file.nextInt());
			for (int i = 0; i < m; i++)
				b.add(file.nextInt());
			a.retainAll(b);
			b.retainAll(a);
			if (a.isEmpty() || b.isEmpty()) {
				out.println("NO");
			}
			else {
				out.println("YES");
				out.println(1 + " " + a.get(0));
			}
		}

		file.close();
		out.flush();
	}

	static class FastScanner {

		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public FastScanner() {
			reader = new BufferedReader(new InputStreamReader(System.in), 32768);
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

		public long nextLong() {
			return Long.parseLong(next());
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}

		public String nextLine() {
			try {
				return reader.readLine();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

		public void close() throws IOException {
			reader.close();
		}
	}
}