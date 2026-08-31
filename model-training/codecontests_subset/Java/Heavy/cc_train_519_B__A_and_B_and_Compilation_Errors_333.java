import java.io.*;
import java.util.*;

public class B
{

	FastScanner in;
	PrintWriter out;
	int i = 0, j = 0;


	void solve() {
		/**************START**************/
		int n = in.nextInt();
		long sum1 = 0, sum2 = 0, sum3 = 0;
		int cur = 0;
		for (i = 0; i < n; i++)
		{
			cur = in.nextInt();
			sum1 += cur;
		}
		for (i = 1; i < n; i++)
		{
			cur = in.nextInt();
			sum2 += cur;
		}
		out.println((sum1 - sum2));
		for (i = 2; i < n; i++)
		{
			cur = in.nextInt();
			sum3 += cur;
		}
		out.println((sum2 - sum3));
		












		/***************END***************/
	}

	public static void main(String[] args) {
		new B().runIO();
	}

	void runIO() {
		in = new FastScanner(System.in);
		out = new PrintWriter(System.out);

		solve();

		out.close();
	}

	class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		public FastScanner(File f) {
			try {
				br = new BufferedReader(new FileReader(f));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

		public FastScanner(InputStream f) {
			br = new BufferedReader(new InputStreamReader(f));
		}

		String next() {
			while (st == null || !st.hasMoreTokens()) {
				String s = null;
				try {
					s = br.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
				if (s == null)
					return null;
				st = new StringTokenizer(s);
			}
			return st.nextToken();
		}

		//This will empty out the current line (if non-empty) and return the next line down. If the next line is empty, will return the empty string.
		String nextLine() {
				st = null;
				String s = null;
				try {
					s = br.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
				return s;
		}

		boolean hasMoreTokens() {
			while (st == null || !st.hasMoreTokens()) {
				String s = null;
				try {
					s = br.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
				if (s == null)
					return false;
				st = new StringTokenizer(s);
			}
			return true;
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}
	}
}