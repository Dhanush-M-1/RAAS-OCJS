import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by peacefrog on 11/19/15.
 * Time : 11:24 PM
 */

public class CF526A {
	final boolean ONLINE_JUDGE = System.getProperty("ONLINE_JUDGE") != null;
	PrintWriter out;
	long timeBegin, timeEnd;

	public void runIO() throws IOException {
		timeBegin = System.currentTimeMillis();

		InputStream inputStream;
		OutputStream outputStream;


		if (ONLINE_JUDGE) {
			inputStream = System.in;
			Reader.init(inputStream);
			outputStream = System.out;

			out = new PrintWriter(outputStream);

		} else {
			inputStream = new FileInputStream("/home/peacefrog/Dropbox/IdeaProjects/Problem Solving/input");
			Reader.init(inputStream);
			out = new PrintWriter("output.txt");
		}

		solve();

		out.flush();
		out.close();
		timeEnd = System.currentTimeMillis();

		System.err.println("Time = " + (timeEnd - timeBegin));

	}

	/*
	 * Start Solution Here
	 */

	private void solve() throws IOException {
		int n = Reader.nextInt(); //This Variable default in Code Templete
		char []s = Reader.next().toCharArray();
		for (int i = 0; i < n; i++) {
			for (int st = 1; st < n; st++) {
				if(st >= n) break;
				int count = 0;
				for (int pos = i; pos < n; pos += st) {
					if (s[pos] != '*') {
						break;
					} else {
						count++;
					}
				}
				if (count >= 5) {
					System.out.println("yes");
					return;
				}

			}
		}
		System.out.println("no");
	}

	public static void main(String[] args) throws IOException {

		new CF526A().runIO();
	}

	static class Reader {
		static BufferedReader reader;
		static StringTokenizer tokenizer;

		/**
		 * call this method to initialize reader for InputStream
		 */
		static void init(InputStream input) {
			reader = new BufferedReader(new InputStreamReader(input));
			tokenizer = new StringTokenizer("");
		}

		/**
		 * get next word
		 */
		static String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}

		static String nextLine() {
			try {
				return reader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return "";
		}

		static int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		static long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		static double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}
	}

}

