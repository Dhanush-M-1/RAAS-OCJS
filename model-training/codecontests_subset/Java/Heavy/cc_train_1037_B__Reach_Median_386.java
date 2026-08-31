import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class B {
	public static void main(String[] args) throws FileNotFoundException {
		int toFile = 0;
		InputStream inputStream;
		OutputStream outputStream;
		if (toFile == 0) {
			inputStream = System.in;
			outputStream = System.out;
		} else {
			inputStream = new FileInputStream(new File("B.in"));
			outputStream = new FileOutputStream(new File("B.out"));
		}
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskB solver = new TaskB();
		solver.solve(in, out);
		out.close();
	}

	static class TaskB {

		public void solve(InputReader in, PrintWriter out) {
			int n = in.nextInt();
			int s = in.nextInt();

			List<Integer> a = new ArrayList<>(n);
			for (int i=0; i<n; i++)
				a.add(in.nextInt());

			Collections.sort(a);
			long ans = 0;
			if (a.get(n / 2) < s) {
				int i = n / 2;
				while ((i < n) && (a.get(i) < s)) {
					ans += s - a.get(i);
					i++;
				}
			} else {
				int i = n / 2;
				while ((i >= 0) && (a.get(i) > s)) {
					ans += a.get(i) - s;
					i--;
				}
			}

			System.out.println(ans);
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

		public Double nextDouble() {
			return Double.parseDouble(next());
		}
	}
}
