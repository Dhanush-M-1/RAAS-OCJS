 import java.io.*;
import java.util.*;

public class Kraskevich {
	FastScanner in;
	PrintWriter out;
	void solve() {
	int n = in.nextInt();
	char[] s = in.next().toCharArray();
	boolean f;
	boolean ok = false;
	for(int step = 0; step < n; step++)
	//int j = i;
	 //f = false;
	for(int i = 1; i <= n; i++){
	 f = true;	
		for(int k = 0; k < 5; k++)
			if ( step + i * k >= n || s[step+i*k]!='*')
				f = false;
		
	   ok |= f;
	}
	  System.out.println(ok ? "yes" : "no");
		out.close();
	}
	
	

	void run() {
		try {
			in = new FastScanner(new File("B.in"));
			out = new PrintWriter(new File("B.out"));

			solve();

			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
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

	public static void main(String[] args) {
		new Kraskevich().runIO();
	}
}
