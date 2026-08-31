import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

public class D {

	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		PrintWriter out = new PrintWriter(System.out);
		D solver = new D();
		solver.solve(1, in, out);
		out.close();

	}

	public void solve(int testNumber, InputReader in, PrintWriter out) {

		int n = in.nextInt();
		int k = in.nextInt();
		int a = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();
		int d = in.nextInt();
		
		if(n == 4 || n + 1 > k) {
			out.println(-1);
		}
		else {
			out.print(a + " " + d + " ");
			for(int i = 1; i <= n; i++) {
				if(i != a && i != b && i != c && i != d) out.print(i + " ");
				
			}
			out.print(c + " " + b);
			out.println();
			out.print(c + " " + b + " ");
			for(int i = 1; i <= n; i++) {
				if(i != a && i != b && i != c && i != d) out.print(i + " ");
				
			}
			out.print(a + " " + d);
			
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

		public long nextLong() {
			return Long.parseLong(next());
		}

	}
}
