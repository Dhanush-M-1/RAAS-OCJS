import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by peacefrog on 11/24/15.
 * Time : 7:54 PM
 */

public class CF20B {
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
			out = new PrintWriter(System.out);
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
		double a = Reader.nextInt(); //This Variable default in Code Template
		double b = Reader.nextInt();
		double c  = Reader.nextInt();

		double inf = b* b - 4  * a* c ;
		if(a == 0.0D && b == 0.0D && c == 0 ) {
			out.println(-1);
			return;
		}
		if(a == 0.0D && b == 0.0D && c != 0 ) {
			out.println(0);
			return;
		}
		if (inf < 0.0D){
			out.println(0);
			return;
		}
		if (inf == 0.0D)
		{
			out.printf("1\n%.10f\n", (-b + Math.sqrt(inf))/(2.0 * a));
			return;
		}

		if (a == 0 )
		{
			out.printf("1\n%.10f\n", (-c/b) );
			return;
		}

		double ans[] = new double[2];

		ans[0] = (-b + Math.sqrt(inf))/(2.0 * a);
		ans[1] = (-b - Math.sqrt(inf))/(2.0 * a);
		Arrays.sort(ans);

		out.printf("2\n%.10f\n%.10f", ans[0] ,ans[1]);
	}

	public static void main(String[] args) throws IOException {

		new CF20B().runIO();
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

		static long[] nextLongArray(int n) throws IOException {
			long[] arr = new long[n];
			for (int i = 0; i < n; i++) {
				arr[i] = nextLong();
			}

			return arr;
		}

		static int[] nextIntArray(int n) throws IOException {
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = nextInt();
			}

			return arr;
		}
	}

}

