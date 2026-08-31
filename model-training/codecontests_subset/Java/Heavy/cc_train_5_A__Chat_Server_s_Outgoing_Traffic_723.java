import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.MessageFormat;
import java.util.StringTokenizer;

/**
 * http://codeforces.com/problemset/problem/5/A
 *
 */
public class ChatServerTraffic {

	/**
	 * determines if it is used as an online submission or test.
	 */
	final static boolean ONLINE_SUBMISSION = System.getProperty("ONLINE_JUDGE") != null;

	static class Run implements Runnable {

		/**
		 * determines if output should be written to a file or to console when
		 * testing locally.
		 */
		final static boolean OUTPUT_TO_FILE = false;

		// Idea:
		@Override
		public void run() {
			int noPersons = 0, ans = 0;
			String command = nextLine();
			while (command != null) {
				if (command.matches("^[^\\+|-].+")) {
					String[] nameAndCommand = command.split(":", 2);
					if (nameAndCommand.length > 1) {
						ans += nameAndCommand[1].length() * noPersons;
					}
				}
				if (command.matches("^[\\+].+")) {
					noPersons += 1;
				}
				if (command.matches("^[-].+")) {
					noPersons -= 1;
				}
				command = nextLine();
			}
			print(ans);
		}

		// ==============================================================
		// ======== Everything below is used across all problems ========
		// ==============================================================
		final String className = getClass().getEnclosingClass().getSimpleName();
		final String inputFilename = "io/input-" + className + ".txt";
		final String outputFilename = "io/output-" + className + ".txt";
		BufferedReader in;
		PrintWriter out;
		StringTokenizer strTok;

		Run() {
			if (ONLINE_SUBMISSION) {
				initConsoleIO();
			} else {
				initFileIO();
			}
		}

		/**
		 * read input from console and write output to console.
		 */
		void initConsoleIO() {
			in = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(new OutputStreamWriter(System.out));
		}

		/**
		 * read input from {@value #inputFilename} and write output to console
		 * or
		 * to {@value #outputFilename} depending on {@link #OUTPUT_TO_FILE}.
		 */
		void initFileIO() {
			try {
				in = new BufferedReader(new FileReader(inputFilename));
				if (OUTPUT_TO_FILE) {
					out = new PrintWriter(new FileWriter(outputFilename));
				} else {
					out = new PrintWriter(new OutputStreamWriter(System.out));
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		/**
		 * Close BufferedReader and PrintWriter.
		 */
		void close() {
			try {
				in.close();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		int nextInt() {
			return Integer.parseInt(nextToken());
		}

		double nextDouble() {
			return Double.parseDouble(nextToken());
		}

		float nextFloat() {
			return Float.parseFloat(nextToken());
		}

		long nextLong() {
			return Long.parseLong(nextToken());
		}

		String nextLine() {
			try {
				return in.readLine();
			} catch (IOException e) {
				return "__NULL";
			}
		}

		public int[] nextArr(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; ++i) {
				a[i] = nextInt();
			}
			return a;
		}

		String nextToken() {
			while (strTok == null || !strTok.hasMoreTokens()) {
				String line;
				try {
					line = in.readLine();
					strTok = new StringTokenizer(line);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			return strTok.nextToken();
		}

		/**
		 * output to console.
		 */
		void cout(Object o) {
			System.out.println(o);
		}

		/**
		 * writes to PrintWriter. See {@link java.io.PrintWriter#write(String)
		 * PrintWriter.write} for more details.
		 */
		void print(Object o) {
			out.write(o.toString());
		}

		/**
		 * writes to PrintWriter and add new line. See
		 * {@link java.io.PrintWriter#write(String)
		 * PrintWriter.write} for more details.
		 */
		void println(Object o) {
			out.write(o.toString() + '\n');
		}

		/**
		 * See documentation {@link java.io.PrintWriter#printf(String, Object)
		 * here}.
		 */
		void printf(String format, Object... args) {
			out.printf(format, args);
		}

		/**
		 * See documentation
		 * {@link java.text.MessageFormat#format(String, Object) here}.
		 */
		String sprintf(String format, Object... args) {
			return MessageFormat.format(format, args);
		}

		/**
		 * Print array with a seperator between elements.
		 */
		void printArray(int[] array, String seperator) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < array.length; i++) {
				if (i > 0) {
					sb.append(" ");
				}
				sb.append(array[i]);
			}
			println(sb.toString());
		}
	}

	public static void main(String[] args) throws IOException {
		Run run = new Run();
		Thread thread = new Thread(run);
		if (!ONLINE_SUBMISSION) {
			long start = System.currentTimeMillis();
			thread.run();
			System.out.println("Time elapsed: " + ((System.currentTimeMillis() - start) / 1000.0) + " sec\n");
		} else {
			thread.run();
		}
		run.close();
	}
}