import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader reader;
	static StringTokenizer tokenizer;
	static PrintWriter writer;

	static int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}

	static long nextLong() throws IOException {
		return Long.parseLong(nextToken());
	}

	static double nextDouble() throws IOException {
		return Double.parseDouble(nextToken());
	}

	static boolean eof = false;

	static String nextToken() throws IOException {
		while (tokenizer == null || !tokenizer.hasMoreTokens()) {
			tokenizer = new StringTokenizer(reader.readLine());
		}
		return tokenizer.nextToken();
	}

	public static void main(String[] args) throws IOException {
		tokenizer = null;
		// reader = new BufferedReader(new FileReader("input.txt"));
		// writer = new PrintWriter(new FileWriter("output.txt"));
		reader = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1"));
		writer = new PrintWriter(System.out);
		banana();
		reader.close();
		writer.close();
	}

	static void banana() throws IOException {
		int n = nextInt();
		boolean ok[] = new boolean[n];

		String s = nextToken();

		for (int i = 0; i < n; ++i) {
			ok[i] = (s.charAt(i) == '*');
		}

		boolean ans = false;

		for (int step = 1; step < n; ++step) {
			for (int j = 0; j < n; ++j) {
				boolean x = true;
				for (int k = 0; k < 5; ++k) {
					x = x && ((j + step * k < n) && ok[j + step * k]);
				}
				ans = ans || x;
			}
		}

		System.out.println(ans ? "yes" : "no");
	}
}

