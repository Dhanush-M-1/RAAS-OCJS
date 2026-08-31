import java.util.*;
import java.io.*;

public class Main {

	static PrintWriter out;
	static FastReader fr;
	// make it false if Multiple test case is not in the question
	static boolean multipleTC = true;
	static int TestCase = 1;

	// for pre processing if needed
	void pre() throws Exception {
	}

	public static void main(String[] args) throws Exception {

		new Main().run();
	}

	// input output handled here
	private Object solve() throws Exception {
		// code
		int n = fr.ni();
		int[] arr = fr.nextIntArray(n);

		if (arr[0] + arr[1] <= arr[n - 1])
			return "1 2 " + (n);

		return "-1";
	}

	void run() throws Exception {
		// long start_time = System.nanoTime();

		try {
			fr = new FastReader("in0.txt");
			out = new PrintWriter("out0.txt");
		} catch (Exception e) {
			fr = new FastReader();
			out = new PrintWriter(System.out);
		}
		pre();
		StringBuilder print = new StringBuilder("");

		int T = (multipleTC) ? fr.ni() : 1;
		for (int t = 1; t <= T; t++) {
			TestCase = t;
			print.append(solve()).append("\n");
		}

		p(print);
		// long end_time = System.nanoTime();
		// System.out.printf("Running Time in sec : %2.10f", (double) (end_time -
		// start_time) * (double) 1e-9);

		out.flush();
		out.close();
	}

	static void p(Object o) {
		out.print(o);
	}

	static void pln(Object o) {
		out.println(o);
	}

	static void psp(Object o) {
		out.print(o + " ");
	}

	static void pnf(Object o) {
		out.println(o);
		out.flush();
	}

	static void deb(Object... x) {
		System.out.print("#" + TestCase + " = ");
		for (int i = 0; i < x.length - 1; i++)
			System.out.print(x[i] + " , ");
		System.out.println(x[x.length - 1]);

	}

	static void in(int a) throws Exception {
		a = fr.ni();
	}

	static void in(long a) throws Exception {
		a = fr.ni();
	}

	static void in(String[] a) throws Exception {
		a = fr.nln().trim().split(" ");
	}

	static void in(String a) throws Exception {
		a = fr.next();
	}

	static void in(int a[]) throws Exception {
		for (int i = 0; i < a.length; i++) {
			a[i] = fr.ni();
		}
	}

	static void in(long a[]) throws Exception {
		for (int i = 0; i < a.length; i++) {
			a[i] = fr.nl();
		}
	}

	static void in(int a[][]) throws Exception {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				a[i][j] = fr.ni();
			}
		}
	}

	class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		public FastReader(String s) throws Exception {
			br = new BufferedReader(new FileReader(s));
		}

		String next() throws Exception {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					throw new Exception(e.toString());
				}
			}
			return st.nextToken();
		}

		String nextLine() throws Exception {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				throw new Exception(e.toString());
			}
			return str;
		}

		String n() throws Exception {
			return fr.next();
		}

		String nln() throws Exception {
			return fr.nextLine().trim();
		}

		int ni() throws Exception {
			return Integer.parseInt(fr.next());
		}

		long nl() throws Exception {
			return Long.parseLong(fr.next());
		}

		double nd() throws Exception {
			return Double.parseDouble(fr.next());
		}

		int[] nextIntArray(int n) throws Exception {
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = fr.ni();
			}
			return a;
		}

		long[] nextLongArray(int n) throws Exception {
			long[] a = new long[n];
			for (int i = 0; i < n; i++) {
				a[i] = fr.nl();
			}
			return a;
		}
	}
}