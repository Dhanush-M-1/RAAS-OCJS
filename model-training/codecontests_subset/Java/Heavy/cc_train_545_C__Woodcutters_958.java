import java.io.*;
import java.util.*;

public class C
{

	FastScanner in;
	PrintWriter out;
	int i = 0, j = 0;


	void solve() {
		/**************START**************/
		int n = in.nextInt();
		int x = in.nextInt();
		int h = in.nextInt();
		int trees = 0;
		int nextx, nexth;
		int prevX = -2000000000;
		for (i = 1; i < n; i++)
		{
			nextx = in.nextInt();
			nexth = in.nextInt();
			if (x - h > prevX)
			{
				trees++;
				prevX = x;
				x = nextx;
				h = nexth;
			}
			else
			{
				if (x + h < nextx)
				{
					trees++;
					prevX = x+h;
					x = nextx;
					h = nexth;
				}
				else
				{
					prevX = x;
					x = nextx;
					h = nexth;
				}
			}
		}
		trees++;
		if (n == 1)
		{
			trees = 1;
		}
		else if (n == 2)
		{
			trees = 2;
		}
		out.println(trees);











		/***************END***************/
	}

	public static void main(String[] args) {
		new C().runIO();
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