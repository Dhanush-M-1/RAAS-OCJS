import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A {

	public static void main(String[] args) {

		Reader.init(System.in);

		try {
			int len = Reader.nextInt();
			int init = Reader.nextInt();
			int max = Reader.nextInt();
			int dif = Reader.nextInt();
			int prev = Reader.nextInt();

			int days = 1;
			len -= init;

			while (len > 0) {
				int prog = Math.min((init += dif), max);
				prog -= prev;
				len -= prog;
				days++;
			}

			System.out.println(days);

		} catch (Exception e) {

		}

	}

	private static class Reader {
		static BufferedReader reader;
		static StringTokenizer tokenizer;

		static void init(InputStream input) {
			reader = new BufferedReader(new InputStreamReader(input));
			tokenizer = new StringTokenizer("");
		}

		static String next() throws IOException {
			while (!tokenizer.hasMoreTokens()) {
				// TODO add check for eof if necessary
				tokenizer = new StringTokenizer(reader.readLine());
			}
			return tokenizer.nextToken();
		}

		static long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		static int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		static double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}
	}

}
