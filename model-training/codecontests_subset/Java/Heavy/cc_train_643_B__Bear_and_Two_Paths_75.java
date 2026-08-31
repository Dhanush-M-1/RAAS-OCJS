import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BearAndTwoPaths {
	public static void main(String[] args) {
		InputReader r = new InputReader(System.in);
		int n = r.nextInt();
		int k = r.nextInt();
		int a = r.nextInt();
		int b = r.nextInt();
		int c = r.nextInt();
		int d = r.nextInt();
		boolean[] vis = new boolean[n + 1];
		vis[a] = vis[b] = vis[c] = vis[d] = true;
		PrintWriter out = new PrintWriter(System.out);
		if (k < n + 1 || n == 4) {
			System.out.println(-1);
			return;
		}
		out.print(a + " ");
		out.print(c + " ");
		for (int i = 1; i <= n; i++)
			if (!vis[i])
				out.print(i + " ");
		out.print(d + " ");
		out.println(b);

		out.print(c + " ");
		out.print(a + " ");
		for (int i = 1; i <= n; i++)
			if (!vis[i])
				out.print(i + " ");
		out.print(b + " ");
		out.println(d);

		out.close();
	}

	static class InputReader {
		private BufferedReader reader;
		private StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream));
			tokenizer = null;
		}

		public InputReader(FileReader stream) {
			reader = new BufferedReader(stream);
			tokenizer = null;
		}

		public String nextLine() {
			try {
				return reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
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
	}
}
